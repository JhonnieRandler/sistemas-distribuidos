import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ExibirLista extends JFrame{
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;

    Object [][] dados;

    String [] colunas;


    public ExibirLista(String titulo, Object [][] dados, String [] colunas) {
        super (titulo);
        this.dados = dados;
        this.colunas = colunas;
    }

    public void criaJanela(){

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);

        getContentPane().add(painelFundo);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setVisible(true);
    }
}

