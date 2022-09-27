package server;

import java.net.ServerSocket;
import java.net.Socket;
import Information.*;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.Date;

public class Server {

    public static void main(String[] args) {
        Database.loadData();
        try {
            ServerSocket s = new ServerSocket(55555);
            while (true) {
                MyThread t = new MyThread(s.accept());
                t.start();
                Thread t1 = new Thread(){
                    @Override
                    public void run() {
                        
                    }
                };
                
                t1.start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class MyThread extends Thread {

    Socket c;

    public MyThread(Socket c) {
        this.c = c;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(c.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(c.getInputStream());
            boolean f = true;
            while (f) {
                switch (is.readInt()) {
                    case 1:
                        //login page
                        Person p = Database.searchById((String) is.readObject());
                        if (p != null) {
                            os.writeBoolean(true);
                            os.flush();
                            if (p.get_pass().equals((String) is.readObject())) {
                                os.writeBoolean(true);
                                os.flush();
                                os.writeObject(p);
                                os.flush();
                            } else {
                                os.writeBoolean(false);
                                os.flush();
                            }
                        } else {
                            os.writeBoolean(false);
                            os.flush();
                        }
                        break;
                    case 2:
                        //Personel register page
                        if (Database.SearchByNatcode((String) is.readObject()) == null) {
                            os.writeBoolean(true);
                            os.flush();
                            if (Database.searchById((String) is.readObject()) == null) {
                                os.writeBoolean(true);
                                os.flush();
                                if (is.readBoolean()) {
                                    if (is.readBoolean()) {
                                        Database.person.add((Employee) is.readObject());
                                    }
                                }
                            } else {
                                os.writeBoolean(false);
                                os.flush();
                            }
                        } else {
                            os.writeBoolean(false);
                            os.flush();
                        }
                        break;
                    case 3:
                        //Student register page
                        if (Database.SearchByNatcode((String) is.readObject()) == null) {
                            os.writeBoolean(true);
                            os.flush();
                            if (Database.searchById((String) is.readObject()) == null) {
                                os.writeBoolean(true);
                                os.flush();
                                if (is.readBoolean()) {
                                    if (is.readBoolean()) {
                                        Database.person.add((Student) is.readObject());
                                    }
                                }
                            } else {
                                os.writeBoolean(false);
                                os.flush();
                            }
                        } else {
                            os.writeBoolean(false);
                            os.flush();
                        }
                        break;
                    case 4:
                        //approve Bsc thesis;called from BscThesisPage
                        BscThesis t = (BscThesis) Database.searchThesisById(is.readInt());
                        switch (is.readInt()) {
                            case 1:
                                t.authenticate1(1);
                                os.writeBoolean(true);
                                os.flush();
                                ((Student) Database.searchById(t.get_stdId())).set_notification(new Notification("Dissertation approval", "Your thesis was approved by the supervisor.Your thesis was sent to the head of department to appoint a juror.", 4, "System", t));
                                if (t.get_stdName2() != null) {
                                    ((Student) Database.searchById(t.get_stdId2())).set_notification(new Notification("Dissertation approval", "Your thesis was approved by the supervisor.Your thesis was sent to the head of department to appoint a juror.", 4, "System", t));
                                    ((Employee) Database.searchById("900000000")).set_notification(new Notification("Set juror", String.format("The thesis of Mr/Mrs. %s is sent to you for determine the referee.To determine the referee, please click on the button \"see dissertation\".", t.get_stdName() + " and " + t.get_stdName2()), 2, "System", t));
                                } else {
                                    ((Employee) Database.searchById("900000000")).set_notification(new Notification("Set juror", String.format("The thesis of Mr/Mrs. %s is sent to you for determine the referee.To determine the referee, please click on the button \"see dissertation\".", t.get_stdName()), 2, "System", t));
                                }
                                ((Employee) Database.searchById("900000000")).add_thesis(t);
                                break;
                            case 2:
                                t.authenticate1(-1);
                                os.writeBoolean(true);
                                os.flush();
                                ((Student) Database.searchById(t.get_stdId())).set_notification(new Notification("Disapproval of thesis", "Your thesis was rejected by the supervisor.Unfortunately, your dissertation was removed from the review cycle.", 4, "System", t));
                                if (t.get_stdName2() != null) {
                                    ((Student) Database.searchById(t.get_stdId2())).set_notification(new Notification("Disapproval of thesis", "Your thesis was rejected by the supervisor.Unfortunately, your dissertation was removed from the review cycle.", 4, "System", t));
                                    break;
                                }
                        }
                        break;
                    case 5:
                        //set time and location;called from SetTimeAndLocation
                        BscThesis t2 = (BscThesis) Database.searchThesisById(is.readInt());
                        t2.set_location((String) is.readObject());
                        t2.set_date((Date) is.readObject());
                        if (t2.get_stdName2() == null) {
                            Database.set_publicNotification(new Notification("Dissertation defense meeting", String.format("The dissertation defense meeting of Mr/Mrs. %s with the subject (%s) will be held in date and time %s in place %s.Click on the button \"see dissertation\" to view thesis details.", t2.get_stdName(), t2.get_topic(), t2.get_date().toString(), t2.get_location()), 4, "System", t2));
                            ((Employee) Database.searchById(t2.get_donId())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t2.get_stdName()), 4, "system", t2));
                            ((Employee) Database.searchById(t2.get_jurorId())).set_notification(new Notification("You are selected", String.format("you are selected as juror of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t2.get_stdName()), 4, "system", t2));
                        } else {
                            Database.set_publicNotification(new Notification("Dissertation defense meeting", String.format("The dissertation defense meeting of Mr/Mrs. %s and %s with the subject (%s) will be held in date and time %s in place %s.Click on the button \"see dissertation\" to view thesis details.", t2.get_stdName(), t2.get_stdName2(), t2.get_topic(), t2.get_date().toString(), t2.get_location()), 4, "System", t2));
                            ((Employee) Database.searchById(t2.get_donId())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t2.get_stdName() + " and " + t2.get_stdName2()), 4, "system", t2));
                            ((Employee) Database.searchById(t2.get_jurorId())).set_notification(new Notification("You are selected", String.format("you are selected as juror of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t2.get_stdName() + " and " + t2.get_stdName2()), 4, "system", t2));
                        }
                        break;
                    case 6:
                        //recive id,sent name;called from SetJuror and SetTimeAndLocationAndObserver and RegisterThesis pages;
                        Person p1 = Database.searchById((String) is.readObject());
                        if (p1 != null && p1 instanceof Employee && !(p1.get_Id().equals("900000000")) && !(p1.get_Id().equals("963613036"))) {
                            os.writeBoolean(true);
                            os.flush();
                            os.writeObject(String.format("%s %s", p1.get_name(), p1.get_lastname()));
                            os.flush();
                        } else {
                            os.writeBoolean(false);
                            os.flush();
                        }
                        break;
                    case 7:
                        //set juror;called from setjuror;
                        int ID;
                        switch (is.readInt()) {
                            case 1:
                                //Bscthesis
                                ID = is.readInt();
                                BscThesis bs = (BscThesis) Database.searchThesisById(ID);
                                String jid1 = (String) is.readObject();
                                bs.set_jurorId(jid1);
                                bs.set_jurorName(((Employee) Database.searchById(jid1)).get_name() + " " + ((Employee) Database.searchById(jid1)).get_lastname());
                                Database.searchById(bs.get_stdId()).set_notification(new Notification("The referee was appointed", String.format("Mr/Mrs.%s was selected as the referee for your thesis.Please, click on the button \"see dissertation\" to set the time and place for your defense.", bs.get_jurorName()), 3, "System", bs));
                                if (bs.get_stdId2() != null) {
                                    Database.searchById(bs.get_stdId2()).set_notification(new Notification("The referee was appointed", String.format("Mr/Mrs.%s was selected as the referee for your thesis.Please, click on the button \"see dissertation\" to set the time and place for your defense.", bs.get_jurorName()), 3, "System", bs));
                                    Database.searchById(bs.get_jurorId()).set_notification(new Notification("You are selected", String.format("You are selected as juror of %s and %s's thesis.time and place of defense will be announced later.for more details click on button \"see dissertation\".", bs.get_stdName(), bs.get_stdName2()), 4, "system", bs));
                                } else {
                                    Database.searchById(bs.get_jurorId()).set_notification(new Notification("You are selected", String.format("You are selected as juror of %s's thesis.time and place of defense will be announced later.for more details click on button \"see dissertation\".", bs.get_stdName()), 4, "system", bs));
                                }
                                ((Employee) Database.searchById(bs.get_jurorId())).add_thesis(bs);
                                break;
                            case 2:
                                //Mscthesis
                                ID = is.readInt();
                                MscThesis ms = (MscThesis) Database.searchThesisById(ID);
                                String jid1_2 = (String) is.readObject();
                                ms.set_jurorId(jid1_2);
                                ms.set_jurorName(((Employee) Database.searchById(jid1_2)).get_name() + " " + ((Employee) Database.searchById(jid1_2)).get_lastname());
                                Database.searchById(ms.get_jurorId()).set_notification(new Notification("You are selected", String.format("You are selected as juror of %s's thesis.time and place of defense will be announced later.for more details click on button \"see dissertation\".", ms.get_stdName()), 4, "system", ms));
                                ((Employee) Database.searchById(ms.get_jurorId())).add_thesis(ms);
                                String jid2_2 = (String) is.readObject();
                                ms.set_jurorId2(jid2_2);
                                ms.set_jurorName2(((Employee) Database.searchById(jid2_2)).get_name() + " " + ((Employee) Database.searchById(jid2_2)).get_lastname());
                                Database.searchById(ms.get_jurorId2()).set_notification(new Notification("You are selected", String.format("You are selected as juror of %s's thesis.time and place of defense will be announced later.for more details click on button \"see dissertation\".", ms.get_stdName()), 4, "system", ms));
                                ((Employee) Database.searchById(ms.get_jurorId2())).add_thesis(ms);
                                Database.searchById(ms.get_stdId()).set_notification(new Notification("The referee was appointed", String.format("Mr/Mrs.%s and %s was selected as the referee for your thesis.your thesis was sent to expert of graduate for set time and place and observer.Please, click on the button \"see dissertation\" to view more details", ms.get_jurorName(), ms.get_jurorNmae2()), 4, "System", ms));
                                Database.searchById("963613036").set_notification(new Notification("Determine time and place and observer", String.format("The thesis of Mr/Mrs.%s is given to determine the time and place and the observer of the defense session.please click on button \"see dissertation\" to see more details.", ms.get_stdName()), 3, "system", ms));
                                ((Employee) Database.searchById("963613036")).add_thesis(ms);
                                break;
                            case 3:
                                //Phdthesis
                                ID = is.readInt();
                                PhdThesis ps = (PhdThesis) Database.searchThesisById(ID);
                                String jid1_3 = (String) is.readObject();
                                ps.set_jurorId(jid1_3);
                                ps.set_jurorName(((Employee) Database.searchById(jid1_3)).get_name() + " " + ((Employee) Database.searchById(jid1_3)).get_lastname());
                                Database.searchById(ps.get_jurorId()).set_notification(new Notification("You are selected", String.format("You are selected as juror of %s's thesis.time and place of defense will be announced later.for more details click on button \"see dissertation\".", ps.get_stdName()), 4, "system", ps));
                                ((Employee) Database.searchById(ps.get_jurorId())).add_thesis(ps);
                                String jid2_3 = (String) is.readObject();
                                ps.set_jurorId2(jid2_3);
                                ps.set_jurorName2(((Employee) Database.searchById(jid2_3)).get_name() + " " + ((Employee) Database.searchById(jid2_3)).get_lastname());
                                Database.searchById(ps.get_jurorId2()).set_notification(new Notification("You are selected", String.format("You are selected as juror of %s's thesis.time and place of defense will be announced later.for more details click on button \"see dissertation\".", ps.get_stdName()), 4, "system", ps));
                                ((Employee) Database.searchById(ps.get_jurorId2())).add_thesis(ps);
                                String jid3_3 = (String) is.readObject();
                                ps.set_jurorId3(jid3_3);
                                ps.set_jurorName3(((Employee) Database.searchById(jid3_3)).get_name() + " " + ((Employee) Database.searchById(jid3_3)).get_lastname());
                                Database.searchById(ps.get_jurorId3()).set_notification(new Notification("You are selected", String.format("You are selected as juror of %s's thesis.time and place of defense will be announced later.for more details click on button \"see dissertation\".", ps.get_stdName()), 4, "system", ps));
                                ((Employee) Database.searchById(ps.get_jurorId3())).add_thesis(ps);
                                Database.searchById(ps.get_stdId()).set_notification(new Notification("The referee was appointed", String.format("Mr/Mrs.%s and %s and %s was selected as the referee for your thesis.your thesis was sent to expert of graduate for set time and place and observer.Please, click on the button \"see dissertation\" to view more details", ps.get_jurorName(), ps.get_jurorNmae2(), ps.get_jurorNmae3()), 4, "System", ps));
                                Database.searchById("963613036").set_notification(new Notification("Determine time and place and observer", String.format("The thesis of Mr/Mrs.%s is given to determine the time and place and the observer of the defense session.please click on button \"see dissertation\" to see more details.", ps.get_stdName()), 3, "system", ps));
                                ((Employee) Database.searchById("963613036")).add_thesis(ps);
                                break;
                        }
                        break;
                    case 8:
                        //set time and location and observer;called from SetTimeAndLocationAndObserver;
                        switch (is.readInt()) {
                            case 1:
                                MscThesis t3 = (MscThesis) Database.searchThesisById(is.readInt());
                                t3.set_location((String) is.readObject());
                                t3.set_date((Date) is.readObject());
                                t3.set_observerId((String) is.readObject());
                                t3.set_observerName(((Employee) Database.searchById(t3.get_observerId())).get_name() + " " + ((Employee) Database.searchById(t3.get_observerId())).get_lastname());
                                Database.searchById(t3.get_observerId()).add_thesis(t3);
                                ((Student) Database.searchById(t3.get_stdId())).set_notification(new Notification("Determine the time and place", "Expert of graduate determined observer and the time and place of the defense session.To view the designated observer and the time and place of the defense session and more information, click on the button \"see dissertation\".", 4, "system", t3));
                                ((Employee) Database.searchById(t3.get_observerId())).set_notification(new Notification("You are selected", String.format("you are selected as observer of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t3.get_stdName()), 4, "system", t3));
                                ((Employee) Database.searchById(t3.get_donId())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor number one of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t3.get_stdName()), 4, "system", t3));
                                if (t3.get_donId2() != null) {
                                    ((Employee) Database.searchById(t3.get_donId2())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor number two of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t3.get_stdName()), 4, "system", t3));
                                }
                                ((Employee) Database.searchById(t3.get_jurorId())).set_notification(new Notification("You are selected", String.format("you are selected as juror number one of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t3.get_stdName()), 4, "system", t3));
                                ((Employee) Database.searchById(t3.get_jurorId2())).set_notification(new Notification("You are selected", String.format("you are selected as juror number two of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t3.get_stdName()), 4, "system", t3));
                                Database.set_publicNotification(new Notification("Dissertation defense meeting", String.format("The dissertation defense meeting of Mr/Mrs. %s with the subject (%s) will be held in date and time %s in place %s.Click on the button \"see dissertation\" to view thesis details.", t3.get_stdName(), t3.get_topic(), t3.get_date().toString(), t3.get_location()), 4, "System", t3));
                                break;
                            case 2:
                                PhdThesis t4 = (PhdThesis) Database.searchThesisById(is.readInt());
                                t4.set_location((String) is.readObject());
                                t4.set_date((Date) is.readObject());
                                t4.set_observerId((String) is.readObject());
                                t4.set_observerName(((Employee) Database.searchById(t4.get_observerId())).get_name() + " " + ((Employee) Database.searchById(t4.get_observerId())).get_lastname());
                                Database.searchById(t4.get_observerId()).add_thesis(t4);
                                ((Student) Database.searchById(t4.get_stdId())).set_notification(new Notification("Determine the time and place", "Expert of graduate determined observer and the time and place of the defense session.To view the designated observer and the time and place of the defense session and more information, click on the button \"see dissertation\".", 4, "system", t4));
                                ((Employee) Database.searchById(t4.get_observerId())).set_notification(new Notification("You are selected", String.format("you are selected as observer of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t4.get_stdName()), 4, "system", t4));
                                ((Employee) Database.searchById(t4.get_donId())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor number one of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t4.get_stdName()), 4, "system", t4));
                                if (t4.get_donId2() != null) {
                                    ((Employee) Database.searchById(t4.get_donId2())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor number two of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t4.get_stdName()), 4, "system", t4));
                                }
                                ((Employee) Database.searchById(t4.get_jurorId())).set_notification(new Notification("You are selected", String.format("you are selected as juror number one of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t4.get_stdName()), 4, "system", t4));
                                ((Employee) Database.searchById(t4.get_jurorId2())).set_notification(new Notification("You are selected", String.format("you are selected as juror number two of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t4.get_stdName()), 4, "system", t4));
                                ((Employee) Database.searchById(t4.get_jurorId3())).set_notification(new Notification("You are selected", String.format("you are selected as juror number three of %s's thesis.Please be present at the time stated in the defense location.Click on the button \"see dissertation\" to view the time and place.", t4.get_stdName()), 4, "system", t4));
                                Database.set_publicNotification(new Notification("Dissertation defense meeting", String.format("The dissertation defense meeting of Mr/Mrs. %s with the subject (%s) will be held in date and time %s in place %s.Click on the button \"see dissertation\" to view thesis details.", t4.get_stdName(), t4.get_topic(), t4.get_date().toString(), t4.get_location()), 4, "System", t4));
                                break;
                        }
                        break;
                    case 9:
                        //approve Msc and Phd thesis;called from MscAndPhdThesisPage
                        switch (is.readInt()) {
                            case 1:
                                MscThesis mst = (MscThesis) Database.searchThesisById(is.readInt());
                                switch (is.readInt()) {
                                    case 1:
                                        switch (is.readInt()) {
                                            case 1:
                                                mst.authenticate1(1);
                                                if (mst.get_donId2() != null) {
                                                    ((Student) Database.searchById(mst.get_stdId())).set_notification(new Notification("Dissertation approval", "Your thesis was approved by the supervisor number one.", 4, "System", mst));
                                                }
                                                break;
                                            case 2:
                                                mst.authenticate2(1);
                                                ((Student) Database.searchById(mst.get_stdId())).set_notification(new Notification("Dissertation approval", "Your thesis was approved by the supervisor number two.", 4, "System", mst));
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch (is.readInt()) {
                                            case 1:
                                                mst.authenticate1(-1);
                                                if (mst.get_donId2() != null) {
                                                    ((Student) Database.searchById(mst.get_stdId())).set_notification(new Notification("Disapproval of thesis", "Your thesis was rejected by the supervisor number one.Unfortunately, your dissertation was removed from the review cycle.", 4, "System", mst));
                                                } else {
                                                    ((Student) Database.searchById(mst.get_stdId())).set_notification(new Notification("Disapproval of thesis", "Your thesis was rejected by the supervisor.Unfortunately, your dissertation was removed from the review cycle.", 4, "System", mst));
                                                }
                                                break;
                                            case 2:
                                                mst.authenticate2(-1);
                                                ((Student) Database.searchById(mst.get_stdId())).set_notification(new Notification("Disapproval of thesis", "Your thesis was rejected by the supervisor number two.Unfortunately, your dissertation was removed from the review cycle.", 4, "System", mst));
                                                break;
                                        }
                                        break;
                                }
                                if (mst.get_status() == 1 && mst.get_donId2() != null) {
                                    ((Student) Database.searchById(mst.get_stdId())).set_notification(new Notification("Dissertation approval", "Your thesis was approved by both of supervisors.Your thesis was sent to the head of department to appoint jurors.", 4, "System", mst));
                                    ((Employee) Database.searchById("900000000")).set_notification(new Notification("Set juror", String.format("The thesis of Mr/Mrs. %s is sent to you for determine the referee.To determine the referee, please click on the button \"see dissertation\".", mst.get_stdName()), 2, "System", mst));
                                    ((Employee) Database.searchById("900000000")).add_thesis(mst);
                                } else if (mst.get_status() == 1) {
                                    ((Student) Database.searchById(mst.get_stdId())).set_notification(new Notification("Dissertation approval", "Your thesis was approved by the supervisor.Your thesis was sent to the head of department to appoint jurors.", 4, "System", mst));
                                    ((Employee) Database.searchById("900000000")).set_notification(new Notification("Set juror", String.format("The thesis of Mr/Mrs. %s is sent to you for determine the referee.To determine the referee, please click on the button \"see dissertation\".", mst.get_stdName()), 2, "System", mst));
                                    ((Employee) Database.searchById("900000000")).add_thesis(mst);
                                }
                                break;
                            case 2:
                                PhdThesis pst = (PhdThesis) Database.searchThesisById(is.readInt());
                                switch (is.readInt()) {
                                    case 1:
                                        switch (is.readInt()) {
                                            case 1:
                                                pst.authenticate1(1);
                                                if (pst.get_donId2() != null) {
                                                    ((Student) Database.searchById(pst.get_stdId())).set_notification(new Notification("Dissertation approval", "Your thesis was approved by the supervisor number one.", 4, "System", pst));
                                                }
                                                break;
                                            case 2:
                                                pst.authenticate2(1);
                                                ((Student) Database.searchById(pst.get_stdId())).set_notification(new Notification("Dissertation approval", "Your thesis was approved by the supervisor number two.", 4, "System", pst));
                                                break;
                                        }
                                        break;
                                    case 2:
                                        switch (is.readInt()) {
                                            case 1:
                                                pst.authenticate1(-1);
                                                if (pst.get_donId2() != null) {
                                                    ((Student) Database.searchById(pst.get_stdId())).set_notification(new Notification("Disapproval of thesis", "Your thesis was rejected by the supervisor number one.Unfortunately, your dissertation was removed from the review cycle.", 4, "System", pst));
                                                } else {
                                                    ((Student) Database.searchById(pst.get_stdId())).set_notification(new Notification("Disapproval of thesis", "Your thesis was rejected by the supervisor.Unfortunately, your dissertation was removed from the review cycle.", 4, "System", pst));
                                                }
                                            case 2:
                                                pst.authenticate2(-1);
                                                ((Student) Database.searchById(pst.get_stdId())).set_notification(new Notification("Disapproval of thesis", "Your thesis was rejected by the supervisor number two.Unfortunately, your dissertation was removed from the review cycle.", 4, "System", pst));
                                                break;
                                        }
                                        break;
                                }
                                if (pst.get_status() == 1 && pst.get_donId2() != null) {
                                    ((Student) Database.searchById(pst.get_stdId())).set_notification(new Notification("Dissertation approval", "Your thesis was approved by both of supervisors.Your thesis was sent to the head of department to appoint jurors.", 4, "System", pst));
                                    ((Employee) Database.searchById("900000000")).set_notification(new Notification("Set juror", String.format("The thesis of Mr/Mrs. %s is sent to you for determine the referee.To determine the referee, please click on the button \"see dissertation\".", pst.get_stdName()), 2, "System", pst));
                                    ((Employee) Database.searchById("900000000")).add_thesis(pst);
                                } else if (pst.get_status() == 1) {
                                    ((Student) Database.searchById(pst.get_stdId())).set_notification(new Notification("Dissertation approval", "Your thesis was approved by the supervisor.Your thesis was sent to the head of department to appoint jurors.", 4, "System", pst));
                                    ((Employee) Database.searchById("900000000")).set_notification(new Notification("Set juror", String.format("The thesis of Mr/Mrs. %s is sent to you for determine the referee.To determine the referee, please click on the button \"see dissertation\".", pst.get_stdName()), 2, "System", pst));
                                    ((Employee) Database.searchById("900000000")).add_thesis(pst);
                                }
                                break;
                        }
                        os.writeBoolean(true);
                        os.flush();
                        break;
                    case 10:
                        //recive Id and sent object
                        Person per = Database.searchById((String) is.readObject());
                        if (per != null && per instanceof Student) {
                            os.writeBoolean(true);
                            os.flush();
                            os.writeObject(per);
                            os.flush();
                        } else {
                            os.writeBoolean(false);
                            os.flush();
                        }
                        break;
                    case 11:
                        //register Bsc Thesis
                        BscThesis bst = (BscThesis) is.readObject();
                        Database.thesis.add(bst);
                        bst.set_Id(1000 + Database.thesis.size());
                        os.writeInt(bst.get_Id());
                        os.flush();
                        ((Student) Database.searchById(bst.get_stdId())).add_thesis(bst);
                        ((Employee) Database.searchById(bst.get_donId())).add_thesis(bst);
                        if (bst.get_stdId2() != null) {
                            ((Student) Database.searchById(bst.get_stdId2())).add_thesis(bst);
                            ((Student) Database.searchById(bst.get_stdId2())).set_notification(new Notification("you have a thesis", String.format("your partner %s has set a new thesis.you are the second student of this thesis. click on button\"see dissertation\" to see details of this  thesis.", bst.get_stdName()), 4, "system", bst));
                            ((Employee) Database.searchById(bst.get_donId())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor of %s and %s's thesis.Please Click on the button \"see dissertation\" to approve this thesis.", bst.get_stdName(), bst.get_stdName2()), 1, "system", bst));
                        } else {
                            ((Employee) Database.searchById(bst.get_donId())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor of %s's thesis.Please Click on the button \"see dissertation\" to approve this thesis.", bst.get_stdName()), 1, "system", bst));
                        }
                        break;
                    case 12:
                        //register Msc Thesis
                        MscThesis mst5 = (MscThesis) is.readObject();
                        Database.thesis.add(mst5);
                        mst5.set_Id(1000 + Database.thesis.size());
                        os.writeInt(mst5.get_Id());
                        os.flush();
                        ((Student) Database.searchById(mst5.get_stdId())).add_thesis(mst5);
                        ((Employee) Database.searchById(mst5.get_donId())).add_thesis(mst5);
                        ((Employee) Database.searchById(mst5.get_advisorId())).add_thesis(mst5);
                        Database.searchById(mst5.get_advisorId()).set_notification(new Notification("You are selected", String.format("You are selected as advisor of %s's thesis.time and place of defense will be announced later.for more details click on button \"see thesis\".", mst5.get_stdName()), 4, "system", mst5));
                        ((Employee) Database.searchById(mst5.get_donId())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor number one of %s's thesis.Please Click on the button \"see dissertation\" to approve this thesis.", mst5.get_stdName()), 1, "system", mst5));
                        if (mst5.get_donName2() != null) {
                            ((Employee) Database.searchById(mst5.get_donId2())).add_thesis(mst5);
                            ((Employee) Database.searchById(mst5.get_donId2())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor number two of %s's thesis.Please Click on the button \"see dissertation\" to approve this thesis.", mst5.get_stdName()), 1, "system", mst5));
                        }
                        break;
                    case 13:
                        //register Phd Thesis
                        PhdThesis pht5 = (PhdThesis) is.readObject();
                        Database.thesis.add(pht5);
                        pht5.set_Id(1000 + Database.thesis.size());
                        os.writeInt(pht5.get_Id());
                        os.flush();
                        ((Student) Database.searchById(pht5.get_stdId())).add_thesis(pht5);
                        ((Employee) Database.searchById(pht5.get_donId())).add_thesis(pht5);
                        ((Employee) Database.searchById(pht5.get_advisorId())).add_thesis(pht5);
                        Database.searchById(pht5.get_advisorId()).set_notification(new Notification("You are selected", String.format("You are selected as advisor of %s's thesis.time and place of defense will be announced later.for more details click on button \"see thesis\".", pht5.get_stdName()), 4, "system", pht5));
                        ((Employee) Database.searchById(pht5.get_donId())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor number one of %s's thesis.Please Click on the button \"see dissertation\" to approve this thesis.", pht5.get_stdName()), 1, "system", pht5));
                        if (pht5.get_donName2() != null) {
                            ((Employee) Database.searchById(pht5.get_donId2())).add_thesis(pht5);
                            ((Employee) Database.searchById(pht5.get_donId2())).set_notification(new Notification("You are selected", String.format("you are selected as supervisor number two of %s's thesis.Please Click on the button \"see dissertation\" to approve this thesis.", pht5.get_stdName()), 1, "system", pht5));
                        }
                        break;
                    case 14:
                        //logout
                        f = false;
                        c.close();
                        break;
                    case 15:
                        //convert unread notification to readed notification
                        Person per10 = (Person) Database.searchById((String) is.readObject());
                        Notification not10 = (Notification) is.readObject();
                        for (int i = 0; i < per10.get_notification().size(); i++) {
                            if (((Notification) per10.get_notification().get(i)).equals(not10)) {
                                ((Notification) per10.get_notification().get(i)).set_status(1);
                            }
                        }
                        break;
                }
                Database.storeData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
