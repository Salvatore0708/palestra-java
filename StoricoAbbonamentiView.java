package view;

import javax.swing.*;
import java.awt.*;

public class StoricoAbbonamentiView extends JPanel {
    public JTextField codiceField = new JTextField(20);
    public JButton cercaButton = new JButton("Cerca Storico Abbonamenti");
    public JTextArea resultArea = new JTextArea(10, 40);

    public StoricoAbbonamentiView() {
        setLayout(new BorderLayout());

        // Panello per inserire i dati
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Codice Iscritto:"));
        inputPanel.add(codiceField);
        inputPanel.add(cercaButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        resultArea.setEditable(false);
    }

    public void mostraStoricoAbbonamenti(String resultText) {
        resultArea.setText(resultText);
    }
}
