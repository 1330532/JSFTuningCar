package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Vanessa on 21/07/2016.
 */

@ManagedBean(name = "client")
@SessionScoped
public class Client {
    private String id;
    private String lastname;
    private String firstname;
    private String dir;

    public Client(String id, String lastname, String firstname, String dir){
        this.setId(id);
        this.setLastname(lastname);
        this.setFirstname(firstname);
        this.setDir(dir);
    }

    public Client(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
