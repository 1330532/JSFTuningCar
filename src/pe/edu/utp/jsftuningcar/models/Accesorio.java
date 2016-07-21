package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Vanessa on 21/07/2016.
 */

@ManagedBean(name = "accesorio")
@SessionScoped
public class Accesorio {

    private String id;
    private String desc;
    private int precio;
    private int cantidad;

    public Accesorio(String id, String desc, int precio, int cantidad){
        this.setId(id);
        this.setDesc(desc);
        this.setPrecio(precio);
        this.setCantidad(cantidad);
    }

    public Accesorio(){
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
