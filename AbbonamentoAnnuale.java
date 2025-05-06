
package model;
import java.time.LocalDate;

public class AbbonamentoAnnuale extends Abbonamento {
    public AbbonamentoAnnuale(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
        this.dataFine = dataInizio.plusYears(1);
    }

    public void attiva() {}
    public void termina() { this.dataFine = LocalDate.now(); }
}
