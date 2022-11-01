public class Filme implements java.io.Serializable
{
    public Filme(String nome, String duracao, String anoLancamento, int diretorId)
    {
        this.nome=nome;
        this.duracao=duracao;
        this.anoLancamento=anoLancamento;
        this.diretorId=diretorId;
        filmeID();
    }

    private synchronized int filmeID()
    {
        mID=gID++;
        return mID;
    }

    public boolean temID(int id)
    {
        return (mID==id);
    }

    public int ID()
    {
        return mID;
    }
    public String desc()
    {
        return "["+mID+"]\t"+nome+"\t"+duracao+"\t"+anoLancamento+"\t"+diretorId;
    }

    private static int gID=1;
    private int mID=1;

    public String getNome() {
        return nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public int getDiretorId() {
        return diretorId;
    }

    private String nome;
    private String duracao;
    private String anoLancamento;
    private int diretorId;
}