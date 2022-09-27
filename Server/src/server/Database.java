package server;

import Information.Notification;
import Information.Person;
import Information.Thesis;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Database {

    static ArrayList<Person> person = new ArrayList<>();
    static ArrayList<Thesis> thesis = new ArrayList<>();

    public static Person searchById(String Id) {
        for (Person person1 : person) {
            if (person1.get_Id().equals(Id)) {
                return person1;
            }
        }
        return null;
    }
    
    public static Person SearchByNatcode(String n){
        for (Person person1 : person) {
            if (person1.get_natCode().equals(n)) {
                return person1;
            }
        }
        return null;
    }
    
    public static Thesis searchThesisById(int id){
        for (Thesis thesi : thesis) {
            if (thesi.get_Id() == id) {
                return thesi;
            }
        }
        return null;
    }
    
    public static void set_publicNotification(Notification not){
        for (Person person1 : person) {
            person1.set_notification(new Notification(not.get_topic(), not.get_message(), not.get_kind(), not.get_sender(), not.get_thesis()));
        }
    }

    public static void storeData() {
        try {
            Integer length1 = person.size();
            File file1 = new File("Person Data.txt");
            FileOutputStream out1 = new FileOutputStream(file1);
            ObjectOutputStream output1 = new ObjectOutputStream(out1);
            output1.writeObject(length1);
            for (int i = 0; i < length1; i++) {
                output1.writeObject(person.get(i));
            }
            output1.flush();
            out1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Integer length2 = thesis.size();
            File file2 = new File("Thesis Data.txt");
            FileOutputStream out2 = new FileOutputStream(file2);
            ObjectOutputStream output2 = new ObjectOutputStream(out2);
            output2.writeObject(length2);
            for (int i = 0; i < length2; i++) {
                output2.writeObject(thesis.get(i));
            }
            output2.flush();
            out2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadData() {
        try {
            Integer length1;
            File file1 = new File("Person Data.txt");
            FileInputStream in1 = new FileInputStream(file1);
            ObjectInputStream input1 = new ObjectInputStream(in1);
            length1 = (Integer) input1.readObject();
            for (int i = 0; i < length1; i++) {
                person.add((Person) input1.readObject());
            }
            in1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Integer length2;
            File file2 = new File("Thesis Data.txt");
            FileInputStream in2 = new FileInputStream(file2);
            ObjectInputStream input2 = new ObjectInputStream(in2);
            length2 = (Integer) input2.readObject();
            for (int i = 0; i < length2; i++) {
                thesis.add((Thesis) input2.readObject());
            }
            in2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
