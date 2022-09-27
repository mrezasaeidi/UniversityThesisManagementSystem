package Information;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {

    private String message, topic, sender;
    private int kind, status = 0;
    private Thesis thesis;
    private Date date;

    /**
     * if has no thesis:kind=0 ;if has thesis: if owner of profile must sign
     * it:kind=1; if owner of profile must set juror:kind=2; if owner of profile
     * must set date and location:kind=3; if this notification is public:kind=4;
     *
     */
    public Notification(String to, String m, int k, String s, Thesis t) {
        topic = to;
        message = m;
        kind = k;
        sender = s;
        thesis = t;
        date = new Date();
    }

    /**
     * if has no thesis and is a normal message:kind=0 ;if has thesis: if owner
     * of profile must sign it:kind=1; if owner of profile must set
     * juror:kind=2; if owner of profile must set date and location:kind=3; if
     * this notification is public:kind=4;
     *
     */
    public Notification(String to, String m, String s) {
        topic = to;
        message = m;
        kind = 0;
        sender = s;
        date = new Date();
    }

    //setter
    public void set_status(int s) {
        status = s;
    }

    //getter
    public String get_sender() {
        return sender;
    }

    public String get_topic() {
        return topic;
    }

    public String get_message() {
        return message;
    }

    public int get_kind() {
        return kind;
    }

    public Thesis get_thesis() {
        return thesis;
    }

    public Date get_date() {
        return date;
    }

    public int get_status() {
        return status;
    }

    public boolean equals(Notification not) {
        if (not.get_topic().equals(topic) && not.get_message().equals(message) && not.get_sender().equals(sender) && not.get_kind() == kind && not.get_date().compareTo(date) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
