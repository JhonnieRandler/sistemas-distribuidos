import javax.swing.*;
import java.rmi.*;
import java.util.Vector;

public class GerenciarFilmes
{
    public GerenciarFilmes()
    {
        try
        {
            bd = (IServidor) Naming.lookup("rmi://127.0.0.1/Filmes");
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
            String nome, duracao, anoLancamento, diretorId;

            nome = JOptionPane.showInputDialog(null, "Digite o nome do Filme", "Inserir Filme", JOptionPane.INFORMATION_MESSAGE);
            duracao = JOptionPane.showInputDialog(null, "Digite a duração do Filme", "Inserir Filme", JOptionPane.INFORMATION_MESSAGE);
            anoLancamento = JOptionPane.showInputDialog(null, "Digite o ano de lançamento do Filme", "Inserir Filme", JOptionPane.INFORMATION_MESSAGE);
            int id = bd.insere(new String[]{nome, duracao, anoLancamento});
            System.out.println("Filme " + nome + " inserido com sucesso!");
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
            Vector filmes = bd.lista();
            if (filmes.size() == 1) {
                System.out.println("Há " + filmes.size() + " filme na base de dados!");
            } else {
                System.out.println("Há " + filmes.size() + " filmes na base de dados!");
            }
            String [] colunas = {
                    "id", "Nome", "Duração", "Ano de Lançamento"
            };
            String [][] dados = new String[filmes.size()][5];
            for (int j=0; j < filmes.size(); j++)
            {
                Filme c = (Filme) filmes.get(j);
                dados[j][0] = Integer.toString(c.getId());
                dados[j][1] = c.getNome();
                dados[j][2] = c.getDuracao();
                dados[j][3] = c.getAnoLancamento();
            }
            ExibirLista lc = new ExibirLista("Lista de Filmes", dados, colunas);
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
            Filme deletado = (Filme) bd.seleciona(id);
            bd.apaga(id);
            String texto = "Filme " + deletado.getNome() + " deletado com sucesso";
            System.out.println(texto);
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
        GerenciarFilmes i = new GerenciarFilmes();
        for (int j = 0; j == 0; ) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Inserir Filme\n2 - Listar Filmes\n3 - Apagar Filmes\n4 - Sair\nEscolha uma das opções acima: ", JOptionPane.INFORMATION_MESSAGE));
            switch (opcao) {
                case 1:
                    i.insere();
                break;
                case 2:
                    i.lista();
                break;
                case 3:
                    int filme = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id do filme a ser apagado: ", JOptionPane.INFORMATION_MESSAGE));
                    i.apaga(filme);
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