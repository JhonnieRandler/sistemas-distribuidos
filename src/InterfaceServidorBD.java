import java.rmi.*;
import java.util.Vector;

public interface InterfaceServidorBD extends Remote
{
    public int insere(String marca, String modelo, String memoria, String cor) throws RemoteException;
    public Smartphone seleciona(int id) throws RemoteException;
    public Vector lista() throws RemoteException;
    public int apaga(int id) throws RemoteException;
}