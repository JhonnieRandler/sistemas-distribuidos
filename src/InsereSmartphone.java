import javax.swing.*;
import java.rmi.*;

public class InsereSmartphone
{
    public InsereSmartphone()
    {
        System.out.println("Iniciando o Cliente...");
        // Vamos tentar aceder ao Servidor de Registos para recolher a interface
        try
        {
            bd = (InterfaceServidorBD) Naming.lookup("rmi://127.0.0.1/ServidorBD_1");
        }
        catch (Exception e)
        {
            System.out.println("Falhou o início do Cliente.\n"+e);
            System.out.println("Certifique-se que tanto o Servidor de Registos como a Aplicaçãoo Servidora estão a correr correctamente.\n");
            System.exit(0);
        }
    }
    public void insere (String[] argv)
    {
        try
        {
            String marca, modelo, memoria, cor;
            marca = JOptionPane.showInputDialog("Digite a marca do Smartphone");
            modelo = JOptionPane.showInputDialog("Digite o modelo do Smartphone");
            memoria = JOptionPane.showInputDialog("Digite a quantidade de memória do Smartphone");
            cor = JOptionPane.showInputDialog("Digite a cor do Smartphone");
            int id=bd.insere(marca, modelo, memoria, cor);
            System.out.println("Inserido novo Smartphone com ID: "+id);
        }
        catch (Exception e)
        {
            System.out.println("Exceção durante chamada remotas: " +e);
            System.exit(0);
        }
    }

    public static void main (String[] argv)
    {
        InsereSmartphone i = new InsereSmartphone();
        i.insere(argv);
    }

    private InterfaceServidorBD bd; // A interface para o objeto remoto
}