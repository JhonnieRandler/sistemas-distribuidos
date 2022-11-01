import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.rmi.*;

public class ApagaFilme{
    public ApagaFilme()
    {
        try
        {
            bd = (InterfaceServidorBD) Naming.lookup("rmi://127.0.0.1/Filmes");
        }
        catch (Exception e)
        {
            System.out.println("Falhou o início do Cliente.\n"+e);
            System.out.println("Certifique-se que tanto o Servidor de Registos como a Aplicaçãoo Servidora estão a correr correctamente.\n");
            System.exit(0);
        }
    }
    public void apaga (String[] argv)
    {
        try
        {
            int id = Integer.parseInt(argv[0]);
            Filme deletado = bd.seleciona(id);
            bd.apaga(id);
            String texto = "Filme " + deletado.getNome() + " deletado com sucesso";
            JOptionPane.showMessageDialog(null, texto, "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e)
        {
            System.out.println("Excepção durante chamada remotas:" +e);
            System.exit(0);
        }
    }

    public static void main (String[] argv)
    {
        if (argv.length!=1)
        {
            System.out.println("Sintaxe:\n\tjava ApagaFilme \"id\"");
            System.exit(0);
        }
        ApagaFilme i = new ApagaFilme();
        i.apaga(argv);
    }

    private InterfaceServidorBD bd; // A interface para o objecto remoto
}
