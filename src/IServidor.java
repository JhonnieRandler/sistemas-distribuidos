import java.rmi.*;
import java.util.Vector;

public interface IServidor extends Remote
{
    public int insere(String [] dados) throws RemoteException;
    public Filme seleciona(int id) throws RemoteException;
    public Vector lista() throws RemoteException;
    public int apaga(int id) throws RemoteException;
}