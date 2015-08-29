import javax.swing.*;
import java.awt.*;

/**
 * Created by jason on 15-08-20.
 */

public class MainFrame {

    public JTextArea textArea;
    private JFrame frame;
    private JScrollPane scrollPane;
    @SuppressWarnings("deprecation")
    public MainFrame() {
        frame = new JFrame();
        textArea = new JTextArea(20, 20);
        scrollPane = new JScrollPane(textArea);
    }
    public void frameSetUp() {
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);


        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(500, 500));

        JPanel panel = new JPanel();
        panel.add(scrollPane);

        frame.getContentPane().add(panel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height
                / 2 - frame.getSize().height / 2);
        frame.show();
        textArea.show();
    }

}
