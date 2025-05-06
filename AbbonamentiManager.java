
package model;

public class AbbonamentiManager {
    private static AbbonamentiManager instance = null;

    private AbbonamentiManager() {}

    public static AbbonamentiManager getInstance() {
        if (instance == null) instance = new AbbonamentiManager();
        return instance;
    }

    public void aggiungiAbbonamento(Iscritto i, Abbonamento a) {
        i.getAbbonamentiAttivi().add(a);
    }

    public void terminaAbbonamento(Iscritto i, Abbonamento a) {
        i.getAbbonamentiAttivi().remove(a);
        a.termina();
        i.getStoricoAbbonamenti().add(a);
    }
}
