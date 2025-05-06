package presenter;

import model.*;
import view.*;

import javax.swing.*;

public class StoricoAbbonamentiPresenter {
    private StoricoAbbonamentiView view;

    public StoricoAbbonamentiPresenter(StoricoAbbonamentiView view) {
        this.view = view;
        this.view.cercaButton.addActionListener(e -> cercaStoricoAbbonamenti());
    }

    private void cercaStoricoAbbonamenti() {
        try {
            String codiceId = view.codiceField.getText();
            Iscritto iscritto = IscrittiManager.getInstance().cercaPerCodice(codiceId);
            if (iscritto == null) {
                JOptionPane.showMessageDialog(view, "Iscritto non trovato!", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String storicoText = "";
            for (Abbonamento abbonamento : iscritto.getStoricoAbbonamenti()) {
                storicoText += "Tipo: " + abbonamento.getClass().getSimpleName() +
                        "\nData Inizio: " + abbonamento.getDataInizio() +
                        "\nData Fine: " + abbonamento.getDataFine() +
                        "\n\n";
            }

            if (storicoText.isEmpty()) {
                storicoText = "Nessun storico di abbonamenti trovato.";
            }

            view.mostraStoricoAbbonamenti(storicoText);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Errore nella ricerca dello storico degli abbonamenti: " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
