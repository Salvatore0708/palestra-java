
package presenter;
import javax.swing.JOptionPane;
import model.*;
import view.*;

public class AggiungiIscrittoPresenter {
    private AggiungiIscrittoView view;

    public AggiungiIscrittoPresenter(AggiungiIscrittoView view) {
        this.view = view;
        this.view.aggiungiButton.addActionListener(e -> aggiungi());
    }

    private void aggiungi() {
        String nome = view.nomeField.getText();
        String cognome = view.cognomeField.getText();
        String codice = view.codiceField.getText();
        Iscritto i = new Iscritto(nome, cognome, codice);
        IscrittiManager.getInstance().aggiungiIscritto(i);
        JOptionPane.showMessageDialog(view, "Iscritto aggiunto!");
    }
}
