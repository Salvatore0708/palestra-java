package presenter;

import model.*;
import view.*;

import javax.swing.*;
import java.util.List;

public class TerminaAbbonamentoPresenter {
    private TerminaAbbonamentoView view;

    public TerminaAbbonamentoPresenter(TerminaAbbonamentoView view) {
        this.view = view;
        this.view.terminaButton.addActionListener(e -> terminaAbbonamento());
    }

    private void terminaAbbonamento() {
        try {
            String codiceId = view.codiceField.getText();
            Iscritto iscritto = IscrittiManager.getInstance().cercaPerCodice(codiceId);
            if (iscritto == null) {
                JOptionPane.showMessageDialog(view, "Iscritto non trovato!", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<Abbonamento> abbonamentiAttivi = iscritto.getAbbonamentiAttivi();
            if (abbonamentiAttivi.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Nessun abbonamento attivo trovato per questo iscritto.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] abbonamenti = new String[abbonamentiAttivi.size()];
            for (int i = 0; i < abbonamentiAttivi.size(); i++) {
                abbonamenti[i] = "Abbonamento " + (i + 1) + ": " + abbonamentiAttivi.get(i).getClass().getSimpleName()
                        + " (Inizio: " + abbonamentiAttivi.get(i).getDataInizio() + ", Fine: " + abbonamentiAttivi.get(i).getDataFine() + ")";
            }

            view.setAbbonamentiComboBox(abbonamenti);

            String selectedAbbonamento = (String) view.abbonamentiCombo.getSelectedItem();
            if (selectedAbbonamento == null) {
                JOptionPane.showMessageDialog(view, "Seleziona un abbonamento da terminare.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Abbonamento abbonamentoSelezionato = abbonamentiAttivi.get(view.abbonamentiCombo.getSelectedIndex());
            iscritto.terminaAbbonamento(abbonamentoSelezionato);

            IscrittiManager.getInstance().salva();

            view.resultArea.setText("Abbonamento terminato con successo!\n"
                    + "Codice Iscritto: " + iscritto.getCodiceId() + "\n"
                    + "Abbonamento terminato: " + abbonamentoSelezionato.getClass().getSimpleName()
                    + " (Inizio: " + abbonamentoSelezionato.getDataInizio() + ", Fine: " + abbonamentoSelezionato.getDataFine() + ")");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Errore nella terminazione dell'abbonamento: " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
