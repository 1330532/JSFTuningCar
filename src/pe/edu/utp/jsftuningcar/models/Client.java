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
    private String lastName;
    private String firstName;
    private String dir;

    public Client(String id, String lastName, String firstName, String dir){
        this.setId(id);
        this.setLastName(lastName);
        this.setFirstName(firstName);
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
