package Information;

public class BscThesis extends Thesis {

    private String stdName2, stdId2, stdField2;

    public BscThesis(String name, String Id, String field, String topic, String summary, String donName, String donId) {
        super(name, Id, field, topic, summary, donName, donId);
        status2 = 1;
    }

    public BscThesis(String name, String Id, String field, String name2, String Id2, String field2, String topic, String summary, String donName, String donId) {
        super(name, Id, field, topic, summary, donName, donId);
        stdName2 = name2;
        stdId2 = Id2;
        stdField2 = field2;
        status2 = 1;
    }

    //getter
    public String get_stdName2() {
        return stdName2;
    }

    public String get_stdId2() {
        return stdId2;
    }

    public String get_stdField2() {
        return stdField2;
    }
}
