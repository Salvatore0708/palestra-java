package view;

import javax.swing.*;
import java.awt.*;

public class CercaIscrittoView extends JPanel {
    public JTextField codiceField = new JTextField(20);
    public JButton cercaButton = new JButton("Cerca");
    public JTextArea resultArea = new JTextArea(10, 40);

    public CercaIscrittoView() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Codice ID:"));
        inputPanel.add(codiceField);
        inputPanel.add(cercaButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        resultArea.setEditable(false);
    }
}
