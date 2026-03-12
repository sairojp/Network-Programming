



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdderService extends UnicastRemoteObject implements Adder {
    public AdderService() throws RemoteException {
        // Constructor must declare RemoteException
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}