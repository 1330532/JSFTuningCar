package pe.edu.utp.jsftuningcar.viewController;

import pe.edu.utp.jsftuningcar.models.*;

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

    private ServiceCarsEntity getServiceCarsEntity(){
        ServiceCarsEntity serviceCarsEntity = new ServiceCarsEntity();
        serviceCarsEntity.setConnection(connection);
        return serviceCarsEntity;
    }

    //Edit and Add

    private Client client = new Client();
    private ServiceCar serviceCar = new ServiceCar();
    //catch params Edit
    public Client getClientParam(){
        FacesContext fc = FacesContext.getCurrentInstance();

        Map<String,String> param= fc.getExternalContext().getRequestParameterMap();
        client.setId(param.get("selectClientToEditId"));
        client.setFirstName(param.get("selectClientToEditF"));
        client.setLastName(param.get("selectClientToEditL"));
        client.setDir(param.get("selectClientToEditD"));
        return client;
    }

    //catch params Add

    /*public ServiceCar getAddClientServiceParam(){
        FacesContext fc = FacesContext.getCurrentInstance();

        Map<String,String> param= fc.getExternalContext().getRequestParameterMap();
        getServiceCar().setFirstName(param.get("selectServiceCarToReserveClientF"));
        getServiceCar().setLastName(param.get("selectServiceCarToReserveClientL"));
        getServiceCar().setDir(param.get("selectServiceCarToReserveClientD"));
        getServiceCar().setDesc(param.get("selectServiceCarToReserveClientDesc"));
        getServiceCar().setPrice(Integer.parseInt(param.get("selectServiceCarToReserveClientP")));
        getServiceCar().setDate(param.get("selectServiceCarToReserveClientDate"));
        return getServiceCar();
    }*/


    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public ServiceCar getServiceCar() {
        return serviceCar;
    }
    public void setServiceCar(ServiceCar serviceCar) { this.serviceCar = serviceCar; }


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

    //Add Reservation

    public void addReservClient(){

        Client cli = new Client();
        ServiceCar ser = new ServiceCar();
        FacesContext fc1 = FacesContext.getCurrentInstance();

        Map<String,String> param= fc1.getExternalContext().getRequestParameterMap();
        cli.setFirstName(param.get("Fn"));
        cli.setLastName(param.get("Ln"));
        cli.setDir(param.get("Dir"));
        ser.setDesc(param.get("Desc"));
        ser.setPrice(Integer.parseInt(param.get("Price")));
        ser.setDate(param.get("Date"));

        cli.setFirstName(getServiceCar().getFirstName());
        cli.setLastName(getServiceCar().getLastName());
        cli.setDir(getServiceCar().getDir());
        ser.setDesc(getServiceCar().getDesc());
        ser.setPrice(getServiceCar().getPrice());
        ser.setDate(getServiceCar().getDate());

        getServiceCarsEntity().addClient(cli);
        getServiceCarsEntity().addService(ser);

        try {
            getserviceCars();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/JSFTuningCarWeb/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Detele Reservation

    public void deleteReservClient(){

        Client cli = new Client();
        ServiceCar ser = new ServiceCar();
        FacesContext fc1 = FacesContext.getCurrentInstance();

        Map<String,String> param= fc1.getExternalContext().getRequestParameterMap();
        cli.setId(param.get("Id"));
        ser.setIdClient(getClient().getId());

        getServiceCarsEntity().deleteClient(cli);
        getServiceCarsEntity().deleteService(ser);

        try {
            getserviceCars();
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

    public List<ServiceCar> getserviceCars(){ return getServiceCarsEntity().getServiceCarsList(); }

    //Cantidad de clientes y accesorios

    public int getClientsCount() { return getClientsEntity().getClients().size(); }

    public int getAcessoriesCount() { return getAccessoriesEntity().getAccessories().size(); }

}
