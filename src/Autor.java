public class Autor implements java.io.Serializable
{
    private String nome;
    private static int idGlobal = 1;
    private int id = 1;

    public Autor(String nome)
    {
        this.nome = nome;
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
        return nome;
    }

    public int getId() { return id; }

    public String getNome() {
        return nome;
    }
}