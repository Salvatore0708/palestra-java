
package view;
import javax.swing.*;

public class AggiungiIscrittoView extends JPanel {
    public JTextField nomeField = new JTextField(20);
    public JTextField cognomeField = new JTextField(20);
    public JTextField codiceField = new JTextField(20);
    public JButton aggiungiButton = new JButton("Aggiungi");

    public AggiungiIscrittoView() {
        add(new JLabel("Nome:")); add(nomeField);
        add(new JLabel("Cognome:")); add(cognomeField);
        add(new JLabel("Codice ID:")); add(codiceField);
        add(aggiungiButton);
    }
}
