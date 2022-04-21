import java.rmi.RemoteException;

public class RemoteCalc implements Factorial{

    @Override
    public int calculateFact(int number) throws RemoteException {
        int fact = 1;
        for (int i = 2; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
