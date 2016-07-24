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
                serviceCar.setIdServ(rs.getString("service_id"));
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

    //Generate code for Add CLient
    public int generacode(){
        int num = (int) (Math.random()*1000+110);
        return num;
    }

    //add client

    public int addClient(Client e){
        int send=0;
        int c=generacode();
        String id = "C0"+Integer.toString(c);

        try {

            PreparedStatement stmt = getConnection().prepareStatement(
                    "INSERT INTO clients (client_id, fname, lname, address) VALUES (?, ?, ?, ?)");

            stmt.setString(1,id);
            stmt.setString(2,e.getFirstName());
            stmt.setString(3,e.getLastName());
            stmt.setString(4,e.getDir());

            int i = stmt.executeUpdate();
            send=i;

        }catch (SQLException ec){
            ec.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return send;

    }
    //add car

    public int addCar(Car e){
        int send=0;
        int c=generacode();
        String cid = "A0"+Integer.toString(c);
        String id = "C0"+Integer.toString(c);

        try {

            PreparedStatement stmt = getConnection().prepareStatement(
                    " INSERT INTO car (car_id, brand, model, color, client_id) VALUES (?,?,?,?,?)");

            stmt.setString(1,cid);
            stmt.setString(2,e.getBrand());
            stmt.setString(3,e.getModel());
            stmt.setString(4,e.getColor());
            stmt.setString(5,id);

            int i = stmt.executeUpdate();
            send=i;

        }catch (SQLException ec){
            ec.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return send;

    }

    //add service dependent - Client and car
    public int addService(ServiceCar e){
        int send=0;
        int c=generacode();
        String sid = "S0"+Integer.toString(c);
        String id = "C0"+Integer.toString(c);

        try {

            PreparedStatement stmt = getConnection().prepareStatement(
                    " INSERT INTO service (service_id, descripcion_s, price_s, date_s, client_id) VALUES (?,?,?,?,?)");

            stmt.setString(1,sid);
            stmt.setString(2,e.getDesc());
            stmt.setInt(3,e.getPrice());
            stmt.setString(4,e.getDate());
            stmt.setString(5,id);

            int i = stmt.executeUpdate();
            send=i;

        }catch (SQLException ec){
            ec.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return send;

    }

    //Delete Reservation

    public int deleteClient(Client e){
        int send=0;

        try {

            PreparedStatement stmt = getConnection().prepareStatement(
                    "DELETE FROM clients WHERE client_id = ?");
            stmt.setString(1,e.getId());

            int i = stmt.executeUpdate();
            send=i;

        }catch (SQLException ec){
            ec.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return send;
    }

    //delete Car
    public int deleteCar(Car e){
        int send=0;

        try {

            PreparedStatement stmt = getConnection().prepareStatement(
                    "DELETE FROM car WHERE client_id = ?");
            stmt.setString(1,e.getId());

            int i = stmt.executeUpdate();
            send=i;

        }catch (SQLException ec){
            ec.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return send;
    }

    //delete Service
    public int deleteService(ServiceCar e){
        int send=0;

        try {

            PreparedStatement stmt = getConnection().prepareStatement(
                    "DELETE FROM service WHERE client_id = ?");
            stmt.setString(1,e.getId());

            int i = stmt.executeUpdate();
            send=i;

        }catch (SQLException ec){
            ec.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return send;
    }

    //getService
    public List<ServiceCar> getServiceClient(){
        ServiceCar serviceCar=null;
        String sql = "select * from clients "+
                "inner join service on  clients.client_id=service.client_id "+
                " inner join car on clients.client_id=car.client_id WHERE cliente_id=";
        List<ServiceCar> serviceCars = new ArrayList<>();
        if (connection == null){ return null; }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs == null) return null;
            while (rs.next()){
                serviceCar = new ServiceCar();
                serviceCar.setId(rs.getString("client_id"));
                serviceCar.setLastName(rs.getString("fname"));
                serviceCar.setFirstName(rs.getString("lname"));
                serviceCar.setDir(rs.getString("address"));
                serviceCar.setIdServ(rs.getString("service_id"));
                serviceCar.setDesc(rs.getString("descripcion_s"));
                serviceCar.setPrice(rs.getInt("price_s"));
                serviceCar.setDate(rs.getString("date_s"));
                serviceCars.add(serviceCar);
            }
            return serviceCars;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
