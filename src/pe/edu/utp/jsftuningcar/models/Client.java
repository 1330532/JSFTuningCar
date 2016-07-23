package pe.edu.utp.jsftuningcar.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

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
    private List<Car> cars;

    public Client(String id, String firstName,String lastName, String dir){
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
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

    public List<Car> getCars() {
        return cars;
    }

    public String getCarsBrand() {
        String result ="";
        for(Car car : cars)
            result += (result == "" ? car.getBrand() : ", "+car.getBrand());
        return result;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
