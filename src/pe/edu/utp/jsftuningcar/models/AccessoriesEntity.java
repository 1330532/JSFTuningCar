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
public class AccessoriesEntity {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Accessory> getAccessories(){
        String sql = "SELECT * FROM accessory";
        List<Accessory> accessories = new ArrayList<>();
        if (connection == null){ return null; }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs == null) return null;
            while (rs.next()){
                Accessory accessory = new Accessory();
                accessory.setId(rs.getString("accessory_id"));
                accessory.setDesc(rs.getString("description_a"));
                accessory.setPrice(rs.getInt("price_a"));
                accessory.setCant(rs.getInt("quantity"));
                accessories.add(accessory);
            }
            return accessories;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
