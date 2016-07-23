package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Vanessa on 21/07/2016.
 *
 */
@ManagedBean(name = "servicecar")
@SessionScoped
public class ServiceCar extends Client{
    private String idServ;
    private String desc;
    private int price;
    private String date;
    private String idClient;

    public ServiceCar(String id, String firstName,String lastName, String dir, String idServ, String desc, int price, String date){
        super(id,firstName,lastName,dir);
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

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
}
