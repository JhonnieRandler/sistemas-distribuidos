public class Livro implements java.io.Serializable
{
    private String nome;
    private Autor autor;
    private String anoLancamento;
    private static int idGlobal = 1;
    private int id = 1;

    public Livro(String nome, Autor autor, String anoLancamento)
    {
        this.nome = nome;
        this.autor = autor;
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
        return id+":\t"+nome+"\t"+autor.getNome()+"\t"+anoLancamento;
    }

    public int getId() { return id; }

    public String getNome() {
        return nome;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }
}