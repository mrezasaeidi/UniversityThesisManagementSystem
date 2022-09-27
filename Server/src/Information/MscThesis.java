package Information;

public class MscThesis extends Thesis {

    private String donNmae2, donId2, jurorName2 = "Not Set", jurorId2, advisorName, advisorId, observerName = "Not Set", observerId;

    public MscThesis(String name, String Id, String field, String topic, String summary, String donName, String donId, String advisorname, String advisorId) {
        super(name, Id, field, topic, summary, donName, donId);
        this.advisorName = advisorname;
        this.advisorId = advisorId;
        status2 = 1;
    }

    public MscThesis(String name, String Id, String field, String topic, String summary, String donName, String donId, String donName2, String donId2, String advisorName, String advisorId) {
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
    
    public void set_observerId(String oid) {
        observerId = oid;
    }
    
    public void set_observerName(String name) {
        observerName = name;
    }
}
