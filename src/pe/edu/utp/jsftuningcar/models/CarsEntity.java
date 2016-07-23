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
public class CarsEntity {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Car> getCars(){
        String sql = "SELECT * FROM car";
        List<Car> cars = new ArrayList<>();
        if (connection == null){ return null; }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs == null) return null;
            while (rs.next()){
                Car car = new Car();
                car.setId(rs.getString("car_id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setColor(rs.getString("color"));
                car.setIdClient(rs.getString("client_id")); //duda
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Car> getCarsByClient(Client client){
        String sql = "SELECT * FROM car WHERE client_id = "+ client.getId();
        List<Car> cars = new ArrayList<>();
        if (connection == null){ return null; }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs == null) return null;
            while (rs.next()){
                Car car = new Car();
                car.setId(rs.getString("car_id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setColor(rs.getString("color"));
                car.setIdClient(rs.getString("client_id")); //duda
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
