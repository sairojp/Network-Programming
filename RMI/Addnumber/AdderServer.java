




import java.rmi.Naming;

public class AdderServer{
    public static void main(String[] args) {
        try {
            Adder server = new AdderService();
            Naming.rebind("Adder", server);
            System.out.println("Adder server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}