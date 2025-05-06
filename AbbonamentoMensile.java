
package model;
import java.time.LocalDate;

public class AbbonamentoMensile extends Abbonamento {
    public AbbonamentoMensile(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
        this.dataFine = dataInizio.plusMonths(1);
    }

    public void attiva() {}
    public void termina() { this.dataFine = LocalDate.now(); }
}
