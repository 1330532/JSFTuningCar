package pe.edu.utp.jsftuningcar.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vanessa on 21/07/2016.
 */
public class ClientsEntity {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Client> getClients(){
        String sql = "SELECT * FROM clients";
        List<Client> clients = new ArrayList<>();
        if (connection == null){ return null; }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs == null) return null;
            while (rs.next()){
                Client client = new Client();
                client.setId(rs.getString("client_id"));
                client.setLastName(rs.getString("fname"));
                client.setFirstName(rs.getString("lname"));
                client.setDir(rs.getString("address"));
                clients.add(client);
            }
            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    //editClient

    public int editClient(Client e){
        int send=0;

        try {

            PreparedStatement stmt = getConnection().prepareStatement("update clients set fname=? , lname=? , address=? where client_id=?");
            stmt.setString(1,e.getFirstName());
            stmt.setString(2,e.getLastName());
            stmt.setString(3,e.getDir());
            stmt.setString(4,e.getId());

            int i = stmt.executeUpdate();
            send=i;

        }catch (SQLException ec){
            ec.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return send;
    }

}
