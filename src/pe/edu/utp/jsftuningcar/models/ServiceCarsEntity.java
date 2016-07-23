package pe.edu.utp.jsftuningcar.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                serviceCar.setIdAccessory(rs.getString("accessory_id")); //duda
                serviceCar.setIdClient(rs.getString("client_id"));  //duda
                serviceCars.add(serviceCar);
            }
            return serviceCars;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
