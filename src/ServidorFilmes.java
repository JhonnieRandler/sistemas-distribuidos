import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;

public class ServidorFilmes extends UnicastRemoteObject implements InterfaceServidorBD
{
    public ServidorFilmes() throws RemoteException
    {
        System.out.println("Novo Servidor de Filmes instanciado...");
        filmes = new Vector();
    }

    public int insere(String nome, String duracao, String anoLancamento, int diretorId) throws RemoteException
    {
        Filme c = new Filme(nome, duracao, anoLancamento, diretorId);
        filmes.add(c);
        System.out.println("Inserido novo filme com ID: " + c.ID());
        return c.ID();
    }
    public Vector lista() throws RemoteException
    {
        return filmes;
    }
    public Filme seleciona(int id) throws RemoteException
    {
        for (int j=0; j < filmes.size(); j++)
        {
            Filme t = (Filme) filmes.get(j);
            if (t.temID(id)) return t;
        }
        return (Filme) null;
    }

    public int apaga(int id) throws RemoteException
    {
        for (int j=0; j < filmes.size(); j++)
        {
            Filme t = (Filme) filmes.get(j);
            if (t.temID(id))
            {
                filmes.remove(j);
                return 1;
            }
        }
        return 0;
    }

    Vector filmes;
}