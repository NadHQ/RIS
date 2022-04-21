import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static final String UNIQ = "server.factorial";
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        final RemoteCalc server = new RemoteCalc();
        final Registry registry = LocateRegistry.createRegistry(2732);
        Remote stub = UnicastRemoteObject.exportObject(server,0);
        registry.bind(UNIQ,stub);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
