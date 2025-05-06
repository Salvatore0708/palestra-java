package view;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class AggiungiAbbonamentoView extends JPanel {
    public JTextField codiceField = new JTextField(20);
    public JComboBox<String> tipoAbbonamentoCombo = new JComboBox<>(new String[]{"Mensile", "Annuale"});
    public JButton aggiungiButton = new JButton("Aggiungi Abbonamento");
    public JTextArea resultArea = new JTextArea(10, 40);

    public AggiungiAbbonamentoView() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Codice Iscritto:"));
        inputPanel.add(codiceField);
        inputPanel.add(new JLabel("Tipo Abbonamento:"));
        inputPanel.add(tipoAbbonamentoCombo);
        inputPanel.add(aggiungiButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        resultArea.setEditable(false);
    }
}
