import java.rmi.*;
import java.util.Vector;

public interface InterfaceServidorBD extends Remote
{
    public int insere(String nome, String duracao, String anoLancamento, int diretorId) throws RemoteException;
    public Filme seleciona(int id) throws RemoteException;
    public Vector lista() throws RemoteException;
    public int apaga(int id) throws RemoteException;
}