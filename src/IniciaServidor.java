import java.rmi.*;

public class IniciaServidor
{
    public static void main(String argv[])
    {
        try
        {
            System.out.println("Iniciando servidor...");
            Naming.rebind("ServidorBD_1", new ServidorBD());
        }
        catch (Exception e)
        {
            System.out.println("Ocorreu um problema no início do servidor.\n" + e.toString());
        }
    }
}