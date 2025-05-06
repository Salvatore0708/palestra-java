package view;

import javax.swing.*;
import java.awt.*;

public class MostraIscrittiView extends JPanel {
    public JTextArea resultArea = new JTextArea(20, 50);
    public JButton aggiornaButton = new JButton("Aggiorna");

    public MostraIscrittiView() {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.add(aggiornaButton);
        add(panel, BorderLayout.NORTH);

        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }
}
