package presenter;

import model.*;
import view.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AggiungiAbbonamentoPresenter {
    private AggiungiAbbonamentoView view;

    public AggiungiAbbonamentoPresenter(AggiungiAbbonamentoView view) {
        this.view = view;
        this.view.aggiungiButton.addActionListener(e -> aggiungiAbbonamento());
    }

    private void aggiungiAbbonamento() {
        try {
            String codiceId = view.codiceField.getText();
            String tipoAbbonamento = (String) view.tipoAbbonamentoCombo.getSelectedItem();
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            Iscritto iscritto = IscrittiManager.getInstance().cercaPerCodice(codiceId);
            if (iscritto == null) {
                JOptionPane.showMessageDialog(view, "Iscritto non trovato!", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Abbonamento abbonamento = null;
            LocalDate dataInizio = LocalDate.now();
            LocalDate dataFine = null;
            if (tipoAbbonamento.equals("Mensile")) {
                abbonamento = new AbbonamentoMensile(dataInizio);
                dataFine = dataInizio.plusMonths(1);
            } else if (tipoAbbonamento.equals("Annuale")) {
                abbonamento = new AbbonamentoAnnuale(dataInizio);
                dataFine = dataInizio.plusYears(1);
            }

            iscritto.aggiungiAbbonamento(abbonamento);
            IscrittiManager.getInstance().salva();

            view.resultArea.setText("Abbonamento aggiunto con successo!\n"
                    + "Codice Iscritto: " + iscritto.getCodiceId() + "\n"
                    + "Tipo Abbonamento: " + tipoAbbonamento + "\n"
                    + "Data Inizio: " + dataInizio.toString() + "\n"
                    + "Data Fine: " + dataFine.toString());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Errore nell'inserimento dell'abbonamento: " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
