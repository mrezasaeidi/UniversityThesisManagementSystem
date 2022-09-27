package Information;
//include teacher,head of department,...

public class Employee extends Person {

    private String post;

    public Employee(String n, String l,String ncode, String I,String level, String f,String post,String p) {
        super(n, l,ncode, I,level, f, p);
        this.post = post;
    }

    //getter
    public String get_post() {
        return post;
    }
    
}
