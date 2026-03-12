



import java.rmi.Naming;

public class AdderClient {
    public static void main(String[] args) {
        try {
            Adder adder = (Adder) Naming.lookup("rmi://localhost/Adder");
            int result = adder.add(10, 20);
            System.out.println("Result of Addition: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}