package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Vanessa on 21/07/2016.
 */

@ManagedBean(name = "tcservicefacade", eager = true)
@SessionScoped
public class TCServiceFacade {
    private Connection connection;


    public Connection getConnection() {
        return connection;
    }

    //public void setConnection(Connection connection) { this.connection = connection;   }

    public TCServiceFacade(){
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/MySQLDataSourceTuning");
            connection = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    //Entitys

    private AccessoriesEntity getAccessoriesEntity(){
        AccessoriesEntity accessoriesEntity = new AccessoriesEntity();
        accessoriesEntity.setConnection(connection);
        return accessoriesEntity;
    }

    private ClientsEntity getClientsEntity(){
        ClientsEntity clientsEntity = new ClientsEntity();
        clientsEntity.setConnection(connection);
        return clientsEntity;
    }

    private CarsEntity getCarsEntity(){
        CarsEntity carsEntity = new CarsEntity();
        carsEntity.setConnection(connection);
        return carsEntity;
    }

    private Client  client = new Client();
    private Car  car = new Car();
    //obtener param
    public Client getClientParam(){
        FacesContext fc = FacesContext.getCurrentInstance();

        Map<String,String> param= fc.getExternalContext().getRequestParameterMap();
        client.setId(param.get("selectClientToEditId"));
        client.setFirstName(param.get("selectClientToEditF"));
        client.setLastName(param.get("selectClientToEditL"));
        client.setDir(param.get("selectClientToEditD"));
        return client;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    //edit client

    public void editClient(){

        Client cli = new Client();
        FacesContext fc1 = FacesContext.getCurrentInstance();

        Map<String,String> param= fc1.getExternalContext().getRequestParameterMap();
        cli.setFirstName(param.get("Fn"));
        cli.setLastName(param.get("Ln"));
        cli.setDir(param.get("Dir"));
        cli.setId(param.get("Id"));

        cli.setFirstName(getClient().getFirstName());
        cli.setLastName(getClient().getLastName());
        cli.setDir(getClient().getDir());
        cli.setId(getClient().getId());

        getClientsEntity().editClient(cli);

        try {
            getClients();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/JSFTuningCarWeb/ListClients.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    //List about data from tables

    public List<Accessory> getAccesories(){
        return getAccessoriesEntity().getAccessories();
    }

    public List<Client> getClients(){
        return getClientsEntity().getClients();
    }

    public Car addCars(){
        Car car = new Car();
        Client client = new Client();
        FacesContext fc2 = FacesContext.getCurrentInstance();
        Map<String,String> param= fc2.getExternalContext().getRequestParameterMap();
        client.setId(param.get("Id"));

        client.setId(getClient().getId());

        car = getCarsEntity().getCarByIdClient(client);

        try {
            getClients();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/JSFTuningCar/ListClients");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return car;

    }
    //Cantidad de clientes y accesorios

    public int getClientsCount() { return getClientsEntity().getClients().size(); }

    public int getAcessoriesCount() { return getAccessoriesEntity().getAccessories().size(); }
}
