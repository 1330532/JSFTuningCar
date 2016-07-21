package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Vanessa on 21/07/2016.
 */

@ManagedBean(name = "accessory")
@SessionScoped
public class Accessory {

    private String id;
    private String desc;
    private int price;
    private int cant;

    public Accessory(String id, String desc, int price, int cant){
        this.setId(id);
        this.setDesc(desc);
        this.setPrice(price);
        this.setCant(cant);
    }

    public Accessory(){
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

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
}
