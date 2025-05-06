package presenter;

import model.*;
import view.*;

import javax.swing.*;

public class AbbonamentiAttiviPresenter {
    private AbbonamentiAttiviView view;

    public AbbonamentiAttiviPresenter(AbbonamentiAttiviView view) {
        this.view = view;
        this.view.cercaButton.addActionListener(e -> cercaAbbonamentiAttivi());
    }

    private void cercaAbbonamentiAttivi() {
        try {
            String codiceId = view.codiceField.getText();
            Iscritto iscritto = IscrittiManager.getInstance().cercaPerCodice(codiceId);
            if (iscritto == null) {
                JOptionPane.showMessageDialog(view, "Iscritto non trovato!", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String abbonamentiAttiviText = "";
            for (Abbonamento abbonamento : iscritto.getAbbonamentiAttivi()) {
                abbonamentiAttiviText += "Tipo: " + abbonamento.getClass().getSimpleName() + "\nData Inizio: " + abbonamento.getDataInizio() + "\nData Fine: " + abbonamento.getDataFine() + "\n\n";
            }

            if (abbonamentiAttiviText.isEmpty()) {
                abbonamentiAttiviText = "Nessun abbonamento attivo trovato.";
            }

            view.mostraAbbonamentiAttivi(abbonamentiAttiviText);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Errore nella ricerca degli abbonamenti: " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
