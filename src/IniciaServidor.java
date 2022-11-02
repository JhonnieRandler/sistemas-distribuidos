import java.rmi.*;

public class IniciaServidor
{
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
            System.out.println("Ocorreu um problema no início do servidor.\n" + e.toString());
        }
    }
}