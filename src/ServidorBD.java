import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;

public class ServidorBD extends UnicastRemoteObject implements InterfaceServidorBD
{
    public ServidorBD() throws RemoteException
    {
        System.out.println("Novo Servidor BD instanciado...");
        celulares = new Vector();
    }

    public int insere(String marca, String modelo, String memoria, String cor) throws RemoteException
    {
        Smartphone c = new Smartphone(marca,modelo,memoria,cor);
        celulares.add(c);
        System.out.println("Inserido novo smartphone com ID: " + c.ID());
        return c.ID();
    }
    public Vector lista() throws RemoteException
    {
        return celulares;
    }
    public Smartphone seleciona(int id) throws RemoteException
    {
        for (int j=0; j < celulares.size(); j++)
        {
            Smartphone t = (Smartphone) celulares.get(j);
            if (t.temID(id)) return t;
        }
        return (Smartphone) null;
    }

    public int apaga(int id) throws RemoteException
    {
        for (int j=0; j < celulares.size(); j++)
        {
            Smartphone t = (Smartphone) celulares.get(j);
            if (t.temID(id))
            {
                celulares.remove(j);
                return 1;
            }
        }
        return 0;
    }

    Vector celulares;
}