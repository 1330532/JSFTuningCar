package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Vanessa on 21/07/2016.
 */

@ManagedBean(name = "car")
@SessionScoped
public class Car {

    private String id;
    private String brand;
    private String model;
    private String color;
    private String idClient;

    public Car(String id, String brand, String model, String color, String idClient){
        this.setId(id);
        this.setBrand(brand);
        this.setModel(model);
        this.setColor(color);
        this.setIdClient(idClient);
    }

    public Car(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
