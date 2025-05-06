
package model;
import java.time.LocalDate;

public abstract class Abbonamento {
    protected LocalDate dataInizio;
    protected LocalDate dataFine;

    public abstract void attiva();
    public abstract void termina();

    public boolean isAttivo() {
        return dataFine.isAfter(LocalDate.now());
    }

    public LocalDate getDataInizio() { return dataInizio; }
    public LocalDate getDataFine() { return dataFine; }
}
