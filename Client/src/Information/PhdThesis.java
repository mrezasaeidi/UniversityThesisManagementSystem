package Information;

public class PhdThesis extends Thesis {

    private String donNmae2, donId2, jurorName2 = "Not Set", jurorId2, jurorName3 = "Not Set", jurorId3, advisorName, advisorId, observerName = "Not Set", observerId;

    public PhdThesis(String name, String Id, String field, String topic, String summary, String donName, String donId, String advisorName, String advisorId) {
        super(name, Id, field, topic, summary, donName, donId);
        status2 = 1;
        this.advisorName = advisorName;
        this.advisorId = advisorId;
    }

    public PhdThesis(String name, String Id, String field, String topic, String summary, String donName, String donId, String donName2, String donId2, String advisorName, String advisorId) {
        super(name, Id, field, topic, summary, donName, donId);
        this.advisorName = advisorName;
        this.advisorId = advisorId;
        this.donNmae2 = donName2;
        this.donId2 = donId2;
    }

    //getter
    public String get_donName2() {
        return donNmae2;
    }

    public String get_donId2() {
        return donId2;
    }

    public String get_jurorNmae2() {
        return jurorName2;
    }

    public String get_jurorId2() {
        return jurorId2;
    }

    public String get_jurorNmae3() {
        return jurorName3;
    }

    public String get_jurorId3() {
        return jurorId3;
    }

    public String get_advisorName() {
        return advisorName;
    }

    public String get_advisorId() {
        return advisorId;
    }

    public String get_observerName() {
        return observerName;
    }

    public String get_observerId() {
        return observerId;
    }

    //setter
    public void set_jurorId2(String id) {
        jurorId2 = id;
    }

    public void set_jurorName2(String name) {
        jurorName2 = name;
    }

    public void set_jurorId3(String id) {
        jurorId3 = id;
    }

    public void set_jurorName3(String name) {
        jurorName3 = name;
    }
    
    public void set_observerId(String oid) {
        observerId = oid;
    }
    
    public void set_observerName(String name) {
        observerName = name;
    }
}
