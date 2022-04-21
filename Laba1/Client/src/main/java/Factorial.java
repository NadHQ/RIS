import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Factorial extends Remote {
    int calculateFact(int number) throws RemoteException;
}
