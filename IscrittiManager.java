
package model;
import java.util.*;

public class IscrittiManager {
    private static IscrittiManager instance = null;
    private List<Iscritto> iscritti;

    private IscrittiManager() {
        iscritti = CsvManager.getInstance().caricaIscritti();
    }

    public static IscrittiManager getInstance() {
        if (instance == null) instance = new IscrittiManager();
        return instance;
    }

    public void aggiungiIscritto(Iscritto i) {
        iscritti.add(i);
        salva();
    }

    public Iscritto cercaPerCodice(String codice) {
        for (Iscritto i : iscritti) {
            if (i.getCodiceId().equals(codice)) return i;
        }
        return null;
    }

    public List<Iscritto> getTutti() {
        return iscritti;
    }

    public void salva() {
        CsvManager.getInstance().salvaIscritti(iscritti);
    }
}
