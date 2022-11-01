import java.rmi.*;
import java.util.Vector;

public class ListaSmartphones
{
    public ListaSmartphones()
    {
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
            String [] colunas = {
                    "id", "Marca", "Modelo", "Memória", "Cor"
            };
            String [][] dados = new String[smartphones.size()][5];
            for (int j=0; j < smartphones.size(); j++)
            {
                Smartphone c = (Smartphone) smartphones.get(j);
                dados[j][0] = Integer.toString(c.ID());
                dados[j][1] = c.getMarca();
                dados[j][2] = c.getModelo();
                dados[j][3] = c.getMemoria();
                dados[j][4] = c.getCor();

                ExibirLista lc = new ExibirLista(dados, colunas);
                lc.criaJanela();
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