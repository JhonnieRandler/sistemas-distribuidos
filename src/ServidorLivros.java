import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;

public class ServidorLivros extends UnicastRemoteObject implements IServidor
{
    Vector livros;

    public ServidorLivros() throws RemoteException
    {
        System.out.println("Servidor de Livros iniciado...");
        livros = new Vector();
    }

    public int insere(Object [] dados) throws RemoteException
    {
        Livro c = new Livro(dados[0].toString(), (Autor) dados[1], dados[2].toString());
        livros.add(c);
        System.out.println("Livro " + c.getNome() + " inserido com sucesso!");
        return c.getId();
    }
    public Vector lista() throws RemoteException
    {
        return livros;
    }
    public Livro seleciona(int id) throws RemoteException
    {
        for (int j=0; j < livros.size(); j++)
        {
            Livro t = (Livro) livros.get(j);
            if (t.temID(id)) return t;
        }
        return (Livro) null;
    }

    public int apaga(int id) throws RemoteException
    {
        for (int j=0; j < livros.size(); j++)
        {
            Livro t = (Livro) livros.get(j);
            if (t.temID(id))
            {
                Livro deletado = (Livro) livros.remove(j);
                System.out.println("Livro " + deletado.getNome() + " deletado com sucesso!");
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
            Naming.rebind("Livros", new ServidorLivros());
        }
        catch (Exception e)
        {
            System.out.println("Ocorreu um problema o seguinte erro ao iniciar o servidor:\n" + e.toString());
        }
    }
}