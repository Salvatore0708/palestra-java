
package model;
import java.util.*;

public class Iscritto {
    private String nome;
    private String cognome;
    private String codiceId;
    private List<Abbonamento> abbonamentiAttivi = new ArrayList<>();
    private List<Abbonamento> storicoAbbonamenti = new ArrayList<>();

    public Iscritto(String nome, String cognome, String codiceId) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceId = codiceId;
    }

    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getCodiceId() { return codiceId; }
    public List<Abbonamento> getAbbonamentiAttivi() { return abbonamentiAttivi; }
    public List<Abbonamento> getStoricoAbbonamenti() { return storicoAbbonamenti; }
    
    public void aggiungiAbbonamento(Abbonamento abbonamento){
        abbonamentiAttivi.add(abbonamento);
    }
    
    public void terminaAbbonamento(Abbonamento abbonamento){
        abbonamentiAttivi.remove(abbonamento);
        storicoAbbonamenti.add(abbonamento);
    }
}

