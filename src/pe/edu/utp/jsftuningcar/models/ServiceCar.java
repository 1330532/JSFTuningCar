package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Vanessa on 21/07/2016.
 *
 */
@ManagedBean(name = "serviceCar")
@SessionScoped
public class ServiceCar extends Car{
    private String idServ;
    private String desc;
    private int price;
    private String date;
    private String idClientCar;

    public ServiceCar(String id, String firstName,String lastName, String dir, String idCar, String brand, String model, String color, String idServ, String desc, int price, String date){
        super(id, firstName, lastName, dir, idCar, brand, model, color);
        this.setIdServ(idServ);
        this.setDesc(desc);
        this.setPrice(price);
        this.setDate(date);
        this.setIdClient(id);
    }

    public ServiceCar(){
    }


    public String getIdServ() {
        return idServ;
    }

    public void setIdServ(String idServ) {
        this.idServ = idServ;
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

    public String getIdClientCar() {
        return idClientCar;
    }

    public void setIdClientCar(String idClientCar) {
        this.idClientCar = idClientCar;
    }
}
