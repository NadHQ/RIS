import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static final String UNIQ = "server.factorial";
    public static void main(String[] args) throws RemoteException, NotBoundException {
        final Registry registry = LocateRegistry.getRegistry(2732);
        Factorial calculator = (Factorial) registry.lookup(UNIQ);
        int result = calculator.calculateFact(5);
        System.out.println(result);
    }
}
