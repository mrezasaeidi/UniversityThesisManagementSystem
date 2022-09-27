package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Client {

    protected static Socket c;
    protected static ObjectInputStream is;
    protected static ObjectOutputStream os;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Login login = new Login();
        login.setVisible(true);
        try {
            c = new Socket("localhost", 55555);
            is = new ObjectInputStream(c.getInputStream());
            os = new ObjectOutputStream(c.getOutputStream());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(login, "Server Not Find.", "ERROR", JOptionPane.ERROR_MESSAGE);
            login.dispose();
            e.printStackTrace();
        }
    }

    public static void end() {
        try {
            os.writeInt(14);
            os.flush();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
