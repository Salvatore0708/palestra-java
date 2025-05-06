package presenter;

import model.*;
import view.*;

import javax.swing.*;
import java.util.List;

public class MostraIscrittiPresenter {
    private MostraIscrittiView view;

    public MostraIscrittiPresenter(MostraIscrittiView view) {
        this.view = view;
        this.view.aggiornaButton.addActionListener(e -> aggiornaListaIscritti());
    }

    private void aggiornaListaIscritti() {
        List<Iscritto> iscritti = IscrittiManager.getInstance().getTutti();
        if (iscritti.isEmpty()) {
            view.resultArea.setText("Nessun iscritto trovato.");
        } else {
            String resultText = "";
            for (Iscritto iscritto : iscritti) {
                resultText += "Codice ID: " + iscritto.getCodiceId() + "\n";
                resultText += "Nome: " + iscritto.getNome() + "\n";
                resultText += "Cognome: " + iscritto.getCognome() + "\n";
                resultText += "Abbonamenti attivi:\n";

                for (Abbonamento abbonamento : iscritto.getAbbonamentiAttivi()) {
                    resultText += "  - " + abbonamento.getClass().getSimpleName()
                            + " (Inizio: " + abbonamento.getDataInizio()
                            + ", Fine: " + abbonamento.getDataFine() + ")\n";
                }

                resultText += "\n";
            }
            view.resultArea.setText(resultText);
        }
    }
}
