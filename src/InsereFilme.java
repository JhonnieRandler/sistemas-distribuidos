import javax.swing.*;
import java.rmi.*;

public class InsereFilme
{
    public InsereFilme()
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
    public void insere ()
    {
        try
        {
            String nome, duracao, anoLancamento;
            int diretorId;
            nome = JOptionPane.showInputDialog(null, "Digite o nome do Filme", "Inserir Filme", JOptionPane.INFORMATION_MESSAGE);
            duracao = JOptionPane.showInputDialog(null, "Digite a duração do Filme", "Inserir Filme", JOptionPane.INFORMATION_MESSAGE);
            anoLancamento = JOptionPane.showInputDialog(null, "Digite o ano de lançamento do Filme", "Inserir Filme", JOptionPane.INFORMATION_MESSAGE);
            diretorId = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id do diretor do Filme", "Inserir Filme", JOptionPane.INFORMATION_MESSAGE));
            int id=bd.insere(nome, duracao, anoLancamento, diretorId);
            System.out.println("Inserido novo Filme com ID: "+id);
        }
        catch (Exception e)
        {
            System.out.println("Exceção durante chamada remotas: " +e);
            System.exit(0);
        }
    }

    public static void main (String[] argv)
    {
        InsereFilme i = new InsereFilme();
        i.insere();
    }

    private InterfaceServidorBD bd; // A interface para o objeto remoto
}