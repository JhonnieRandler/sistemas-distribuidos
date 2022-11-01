import java.rmi.*;
import java.util.Vector;

public class ListaFilmes
{
    public ListaFilmes()
    {
        try
        {
            bd = (InterfaceServidorBD) Naming.lookup("rmi://127.0.0.1/Filmes");
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
            Vector filmes = bd.lista();
            System.out.println("Filmes Existentes na Base de Dados: " + filmes.size());
            String [] colunas = {
                    "id", "Nome", "Duração", "Ano de Lançamento", "id do Diretor"
            };
            String [][] dados = new String[filmes.size()][5];
            for (int j=0; j < filmes.size(); j++)
            {
                Filme c = (Filme) filmes.get(j);
                dados[j][0] = Integer.toString(c.ID());
                dados[j][1] = c.getNome();
                dados[j][2] = c.getDuracao();
                dados[j][3] = c.getAnoLancamento();
                dados[j][4] = Integer.toString(c.getDiretorId());
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

    public static void main (String[] argv)
    {
        ListaFilmes l = new ListaFilmes();
        l.lista();
    }

    private InterfaceServidorBD bd; // A interface para o objecto remoto
}