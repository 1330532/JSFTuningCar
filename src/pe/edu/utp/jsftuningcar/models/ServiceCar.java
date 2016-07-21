package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Vanessa on 21/07/2016.
 *
 */
@ManagedBean(name = "servicecar")
@SessionScoped
public class ServiceCar {
    private String id;
    private String desc;
    private int price;
    private String date;
    private String idAccessory;
    private String idClient;

    public ServiceCar(String id, String desc, int price, String date, String idAccessory, String idClient){
        this.setId(id);
        this.setDesc(desc);
        this.setPrice(price);
        this.setDate(date);
        this.setIdAccessory(idAccessory);
        this.setIdClient(idClient);
    }

    public ServiceCar(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdAccessory() {
        return idAccessory;
    }

    public void setIdAccessory(String idAccessory) {
        this.idAccessory = idAccessory;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
}
