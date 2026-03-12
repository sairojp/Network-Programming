




import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageService extends UnicastRemoteObject implements MessageInterface {
    public MessageService() throws RemoteException {
        // Constructor must declare RemoteException
    }

    @Override
    public String HelloMessage() throws RemoteException {
        return "Hello from the RMI Message server!";
}
    }