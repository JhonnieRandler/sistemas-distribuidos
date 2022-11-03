import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;

public class ServidorFilmes extends UnicastRemoteObject implements IServidor
{
    Vector filmes;

    public ServidorFilmes() throws RemoteException
    {
        System.out.println("Servidor de Filmes iniciado...");
        filmes = new Vector();
    }

    public int insere(String [] dados) throws RemoteException
    {
        Filme c = new Filme(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]));
        filmes.add(c);
        System.out.println("Filme " + c.getNome() + " inserido com sucesso!");
        return c.getId();
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
                Filme deletado = (Filme) filmes.remove(j);
                System.out.println("Filme " + deletado.getNome() + " deletado com sucesso!");
                return 1;
            }
        }
        return 0;
    }

    public static void main(String argv[])
    {
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        try
        {
            System.out.println("Iniciando servidor...");
            Naming.rebind("Filmes", new ServidorFilmes());
        }
        catch (Exception e)
        {
            System.out.println("Ocorreu um problema o seguinte erro ao iniciar o servidor:\n" + e.toString());
        }
    }
}