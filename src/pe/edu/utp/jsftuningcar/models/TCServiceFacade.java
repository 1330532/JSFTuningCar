package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

    //List about data from tables

    public List<Accessory> getAccesories(){
        return getAccessoriesEntity().getAccessories();
    }

    public List<Client> getClients(){
        return getClientsEntity().getClients();
    }

    //Cantidad de clientes y accesorios

    public int getClientsCount() { return getClientsEntity().getClients().size(); }

    public int getAcessoriesCount() { return getAccessoriesEntity().getAccessories().size(); }
}
