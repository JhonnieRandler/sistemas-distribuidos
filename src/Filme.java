public class Filme implements java.io.Serializable
{
    private String nome;
    private String duracao;
    private String anoLancamento;
    private static int idGlobal = 1;
    private int id = 1;

    public Filme(String nome, String duracao, String anoLancamento)
    {
        this.nome = nome;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        gerarID();
    }

    private synchronized int gerarID()
    {
        id = idGlobal++;
        return id;
    }

    public boolean temID(int idRecebido)
    {
        return (id==idRecebido);
    }

    @Override
    public String toString() {
        return id+":\t"+nome+"\t"+duracao+"\t"+anoLancamento;
    }

    public int getId() { return id; }

    public String getNome() {
        return nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }
}