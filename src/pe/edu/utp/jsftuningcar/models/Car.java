package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Vanessa on 21/07/2016.
 */

@ManagedBean(name = "car")
@SessionScoped
public class Car extends Client{

    private String idCar;
    private String brand;
    private String model;
    private String color;
    private String idClient;

    public Car(String id, String firstName, String lastName, String dir, String idCar, String brand, String model, String color){
        super(id,firstName,lastName,dir);
        this.setIdCar(idCar);
        this.setBrand(brand);
        this.setModel(model);
        this.setColor(color);
        this.setIdClient(idClient);
    }

    public Car(){
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
}
