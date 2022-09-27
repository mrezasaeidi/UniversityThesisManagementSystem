package Information;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Person implements Serializable{

    protected String name, lastname, Id, field, password,natCode,level;
    protected ArrayList<Notification> notification = new ArrayList();
    protected ArrayList<Thesis> thesis = new ArrayList();

    public Person(String n, String l,String ncode, String I,String level, String f, String p) {
        name = n;
        lastname = l;
        natCode=ncode;
        Id = I;
        this.level=level;
        field = f;
        password = p;
    }
    
    public void add_thesis(Thesis t){
        thesis.add(t);
    }

    //setter
    public void set_notification(Notification noti) {
        notification.add(noti);
    }

    public void set_thesis(Thesis t) {
        thesis.add(t);
    }

    //getter
    public String get_name() {
        return name;
    }

    public String get_lastname() {
        return lastname;
    }
    
    public String get_natCode(){
        return natCode;
    }

    public String get_pass() {
        return password;
    }

    public String get_Id() {
        return Id;
    }
    
    public String get_level(){
        return level;
    }

    public String get_field() {
        return field;
    }

    public ArrayList get_notification() {
        return notification;
    }

    public ArrayList get_thesis() {
        return thesis;
    }
}
