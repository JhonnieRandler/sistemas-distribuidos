import javax.swing.*;

public class Teste extends JFrame{
    private JButton testeButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel mainPanel;

    public Teste() {
        setContentPane(mainPanel);
        setTitle("Teste");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
