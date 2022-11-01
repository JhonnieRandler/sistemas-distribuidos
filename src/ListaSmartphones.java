import java.rmi.*;
import java.util.Vector;

public class ListaSmartphones
{
    public ListaSmartphones()
    {
        System.out.println("Iniciando o Cliente...");
        // Vamos tentar ir aceder ao Servidor de Registos para recolher a interface
        try
        {
            bd = (InterfaceServidorBD) Naming.lookup("rmi://127.0.0.1/ServidorBD_1");
        }
        catch (Exception e)
        {
            System.out.println("Falhou o início do Cliente.\n"+e);
            System.out.println("Certifique-se que tanto o Servidor de Registos como a Aplicação Servidora estão a correr corretamente.\n");
            System.exit(0);
        }
    }
    public void lista()
    {
        try
        {
            Vector smartphones = bd.lista();
            System.out.println("Smartphones Existentes na Base de Dados: "+smartphones.size());
            for (int j=0; j < smartphones.size(); j++)
            {
                Smartphone c = (Smartphone) smartphones.get(j);
                System.out.println(c.desc());
            }
        }
        catch (Exception e)
        {
            System.out.println("Exceção durante chamada remota: " +e);
            System.exit(0);
        }
    }

    public static void main (String[] argv)
    {
        ListaSmartphones l = new ListaSmartphones();
        l.lista();
    }

    private InterfaceServidorBD bd; // A interface para o objecto remoto
}