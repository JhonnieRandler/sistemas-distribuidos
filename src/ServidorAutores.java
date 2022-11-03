import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;

public class ServidorAutores extends UnicastRemoteObject implements IServidor
{
    Vector autores;

    public ServidorAutores() throws RemoteException
    {
        System.out.println("Servidor de Autores iniciado...");
        autores = new Vector();
    }

    public int insere(Object [] dados) throws RemoteException
    {
        Autor c = new Autor(dados[0].toString());
        autores.add(c);
        System.out.println("Autor (a) " + c.getNome() + " inserido (a) com sucesso!");
        return c.getId();
    }
    public Vector lista() throws RemoteException
    {
        return autores;
    }
    public Autor seleciona(int id) throws RemoteException
    {
        for (int j=0; j < autores.size(); j++)
        {
            Autor t = (Autor) autores.get(j);
            if (t.temID(id)) return t;
        }
        return (Autor) null;
    }

    public int apaga(int id) throws RemoteException
    {
        for (int j=0; j < autores.size(); j++)
        {
            Autor t = (Autor) autores.get(j);
            if (t.temID(id))
            {
                Autor deletado = (Autor) autores.remove(j);
                System.out.println("Autor " + deletado.getNome() + " deletado com sucesso!");
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
            Naming.rebind("Autores", new ServidorAutores());
        }
        catch (Exception e)
        {
            System.out.println("Ocorreu um problema o seguinte erro ao iniciar o servidor:\n" + e.toString());
        }
    }
}