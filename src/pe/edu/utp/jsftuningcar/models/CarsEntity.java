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
        String sql = "SELECT * FROM dbtuning";
        List<Car> cars = new ArrayList<>();
        if (connection == null){ return null; }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs == null) return null;
            while (rs.next()){
                Car car = new Car();
                car.setId(rs.getString("codauto"));
                car.setBrand(rs.getString("marca"));
                car.setModel(rs.getString("modelo"));
                car.setColor(rs.getString("color"));
                car.setIdClient(rs.getString("codcli")); //duda
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
