package Information;

import java.io.Serializable;
import java.util.Date;

public abstract class Thesis implements Serializable {

    protected int Id, status1 = 0, status2 = 0, status;
    protected String topic, summary, location = "Not Set", stdName, stdId, stdField, donNmae, donId, jurorName = "Not Set", jurorId;
    protected Date date;

    public Thesis(String name, String Id, String field, String topic, String summary, String donNmae, String donId) {
        stdName = name;
        stdId = Id;
        stdField = field;
        this.topic = topic;
        this.summary = summary;
        this.donNmae = donNmae;
        this.donId = donId;
    }

    /**
     * if approved: status=1; if not checked: status=0; if not approved:
     * status=-1;
     *
     * @param i
     */
    public void authenticate1(int i) {
        status1 = i;
    }

    public void authenticate2(int i) {
        status2 = i;
    }

    //getter
    public String get_topic() {
        return topic;
    }

    public String get_summary() {
        return summary;
    }

    public String get_location() {
        return location;
    }

    public int get_Id() {
        return Id;
    }

    public Date get_date() {
        return date;
    }

    public String get_stdName() {
        return stdName;
    }

    public String get_stdId() {
        return stdId;
    }

    public String get_stdField() {
        return stdField;
    }

    public String get_donName() {
        return donNmae;
    }

    public String get_donId() {
        return donId;
    }

    public String get_jurorName() {
        return jurorName;
    }

    public String get_jurorId() {
        return jurorId;
    }

    public int get_status1() {
        return status1;
    }

    public int get_status2() {
        return status2;
    }

    public int get_status() {
        if (status1 == 1 && status2 == 1) {
            status = 1;
        } else if ((status1 == 1 && status2 == 0) || (status1 == 0 && status2 == 1) || (status1 == 0 && status2 == 0)) {
            status = 0;
        } else if ((status1 == -1 && status2 == -1) || ((status1 == -1 && status2 == 0) || (status1 == 0 && status2 == -1)) || ((status1 == 1 && status2 == -1) || (status1 == -1 && status2 == 1))) {
            status = -1;
        }
        return status;
    }

    //setter
    public void set_Id(int id){
        Id=id;
    }
    
    public void set_date(Date d) {
        date = d;
    }

    public void set_location(String location) {
        this.location = location;
    }

    public void set_jurorId(String id) {
        jurorId=id;
    }
    
    public void set_jurorName(String name) {
        jurorName=name;
    }
}
