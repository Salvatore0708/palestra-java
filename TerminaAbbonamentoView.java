package view;

import javax.swing.*;
import java.awt.*;

public class TerminaAbbonamentoView extends JPanel {
    public JTextField codiceField = new JTextField(20);
    public JComboBox<String> abbonamentiCombo = new JComboBox<>();
    public JButton terminaButton = new JButton("Termina Abbonamento");
    public JTextArea resultArea = new JTextArea(10, 40);

    public TerminaAbbonamentoView() {
        setLayout(new BorderLayout());

        // Panello per inserire i dati
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Codice Iscritto:"));
        inputPanel.add(codiceField);
        inputPanel.add(new JLabel("Abbonamento:"));
        inputPanel.add(abbonamentiCombo);
        inputPanel.add(terminaButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        resultArea.setEditable(false);
    }

    public void setAbbonamentiComboBox(String[] abbonamenti) {
        abbonamentiCombo.removeAllItems();
        for (String abbonamento : abbonamenti) {
            abbonamentiCombo.addItem(abbonamento);
        }
    }
}
