public class Smartphone implements java.io.Serializable
{
    public Smartphone(String marca, String modelo, String memoria, String cor)
    {
        this.marca=marca;
        this.modelo=modelo;
        this.memoria=memoria;
        this.cor=cor;
        marcaID();
    }

    private synchronized int marcaID()
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
        return "["+mID+"]\t"+marca+"\t"+modelo+"\t"+memoria+"\t"+cor;
    }

    private static int gID=0;
    private int mID=0;

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMemoria() {
        return memoria;
    }

    public String getCor() {
        return cor;
    }

    private String marca;
    private String modelo;
    private String memoria;
    private String cor;
}