package pe.edu.utp.jsftuningcar.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vanessa on 21/07/2016.
 */
public class ServiceCarsEntity {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<ServiceCar> getServiceCarsList(){
        String sql = "SELECT * FROM service";
        List<ServiceCar> serviceCars = new ArrayList<>();
        if (connection == null){ return null; }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs == null) return null;
            while (rs.next()){
                ServiceCar serviceCar = new ServiceCar();
                serviceCar.setId(rs.getString("service_id"));
                serviceCar.setDesc(rs.getString("descripcion_s"));
                serviceCar.setPrice(rs.getInt("price_s"));
                serviceCar.setDate(rs.getString("date_s"));
                serviceCar.setIdClient(rs.getString("client_id"));  //duda
                serviceCars.add(serviceCar);
            }
            return serviceCars;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Add CLient
    public int generacode(){
        int num = (int) (Math.random()*1000+110);
        return num;
    }

    public int addClientService(ServiceCar e){
        int send=0;
        int c=generacode();
        String id = "C0"+Integer.toString(c);
        String sid = "S0"+Integer.toString(c);

        try {

            PreparedStatement stmt = getConnection().prepareStatement(
                    "INSERT INTO clients (client_id, fname, lname, address) VALUES (?, ?, ?, ?);"+
                            " INSERT INTO service (service_id, descripcion_s, price_s, date_s, client_id) VALUES (?,?,?,?,?);");
            stmt.setString(1,id);
            stmt.setString(2,e.getFirstName());
            stmt.setString(3,e.getLastName());
            stmt.setString(4,e.getDir());
            stmt.setString(5,sid);
            stmt.setString(6,e.getDesc());
            stmt.setInt(7,e.getPrice());
            stmt.setString(8,e.getDate());
            stmt.setString(9,id);

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
