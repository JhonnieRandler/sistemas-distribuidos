import javax.swing.*;
import java.rmi.*;
import java.util.Vector;

public class GerenciarLivros
{
    public GerenciarLivros()
    {
        try
        {
            bd = (IServidor) Naming.lookup("rmi://127.0.0.1/Livros");
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
            String nome, autor, anoLancamento;

            nome = JOptionPane.showInputDialog(null, "Digite o nome do Livro", "Inserir Livro", JOptionPane.INFORMATION_MESSAGE);
            autor = JOptionPane.showInputDialog(null, "Digite o nome do Autor do Livro", "Inserir Livro", JOptionPane.INFORMATION_MESSAGE);
            anoLancamento = JOptionPane.showInputDialog(null, "Digite o ano de lançamento do Livro", "Inserir Livro", JOptionPane.INFORMATION_MESSAGE);
            int id = bd.insere(new String[]{nome, autor, anoLancamento});
            System.out.println("Livro " + nome + " inserido com sucesso!");
        }
        catch (Exception e)
        {
            System.out.println("Exceção durante chamada remotas: " +e);
            System.exit(0);
        }
    }

    public void lista()
    {
        try
        {
            Vector livros = bd.lista();
            if (livros.size() == 1) {
                System.out.println("Há " + livros.size() + " livro na base de dados!");
            } else {
                System.out.println("Há " + livros.size() + " livros na base de dados!");
            }
            String [] colunas = {
                    "id", "Nome", "Autor", "Ano de Lançamento"
            };
            String [][] dados = new String[livros.size()][5];
            for (int j=0; j < livros.size(); j++)
            {
                Livro c = (Livro) livros.get(j);
                dados[j][0] = Integer.toString(c.getId());
                dados[j][1] = c.getNome();
                dados[j][2] = c.getAutor().getNome();
                dados[j][3] = c.getAnoLancamento();
            }
            ExibirLista lc = new ExibirLista("Lista de Livros", dados, colunas);
            lc.criaJanela();
        }
        catch (Exception e)
        {
            System.out.println("Exceção durante chamada remota: " +e);
            System.exit(0);
        }
    }

    public void apaga (int id)
    {
        try
        {
            Livro deletado = (Livro) bd.seleciona(id);
            bd.apaga(id);
            String texto = "Livro " + deletado.getNome() + " deletado com sucesso";
            System.out.println(texto);
            JOptionPane.showMessageDialog(null, texto, "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e)
        {
            System.out.println("Exceção durante chamada remota: " +e);
            System.exit(0);
        }
    }

    public static void main (String[] argv)
    {
        GerenciarLivros i = new GerenciarLivros();
        for (int j = 0; j == 0; ) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Inserir Livro\n2 - Listar Livros\n3 - Apagar Livros\n4 - Sair\nEscolha uma das opções acima: ", JOptionPane.INFORMATION_MESSAGE));
            switch (opcao) {
                case 1:
                    i.insere();
                    break;
                case 2:
                    i.lista();
                    break;
                case 3:
                    int livro = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id do livro a ser apagado: ", JOptionPane.INFORMATION_MESSAGE));
                    i.apaga(livro);
                    break;
                case 4:
                    j = 5;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida! Selecione uma das opções disponíveis!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private IServidor bd; // A interface para o objeto remoto
}