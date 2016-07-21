package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Vanessa on 21/07/2016.
 */

@ManagedBean(name = "auto")
@SessionScoped
public class Auto {

    private String id;
    private String marca;
    private String modelo;
    private String color;
    private String idCliente;

    public Auto(String id, String marca, String modelo, String color, String idCliente){
        this.setId(id);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setColor(color);
        this.setIdCliente(idCliente);
    }

    public Auto(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
}
