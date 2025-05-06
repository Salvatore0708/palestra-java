package presenter;

import model.*;
import view.*;
import javax.swing.*;

public class CercaIscrittoPresenter {
    private CercaIscrittoView view;

    public CercaIscrittoPresenter(CercaIscrittoView view) {
        this.view = view;
        this.view.cercaButton.addActionListener(e -> cerca());
    }

    private void cerca() {
        System.out.println("asdwads");
        String codiceId = view.codiceField.getText();
        Iscritto iscritto = IscrittiManager.getInstance().cercaPerCodice(codiceId);
        if (iscritto != null) {
            String result = "";

            result += "Nome: " + iscritto.getNome() + "\n";
            result += "Cognome: " + iscritto.getCognome() + "\n";
            result += "Abbonamenti attivi:\n";

            for (Abbonamento abbonamento : iscritto.getAbbonamentiAttivi()) {
                result += "  - " + abbonamento.getClass().getSimpleName() + " (Inizio: " + abbonamento.getDataInizio() + ", Fine: " + abbonamento.getDataFine() + ")\n";
            }

            result += "\nStorico abbonamenti:\n";
            for (Abbonamento abbonamento : iscritto.getStoricoAbbonamenti()) {
                result += "  - " + abbonamento.getClass().getSimpleName() + " (Inizio: " + abbonamento.getDataInizio() + ", Fine: " + abbonamento.getDataFine() + ")\n";
            }

            view.resultArea.setText(result);
        } else {
            JOptionPane.showMessageDialog(view, "Iscritto non trovato!", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
