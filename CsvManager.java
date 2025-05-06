
package model;
import java.io.*;
import java.util.*;

public class CsvManager {
    private static CsvManager instance = null;

    private CsvManager() {}

    public static CsvManager getInstance() {
        if (instance == null) instance = new CsvManager();
        return instance;
    }

    public void salvaIscritti(List<Iscritto> iscritti) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("iscritti.csv"))) {
            for (Iscritto i : iscritti) {
                pw.println(i.getNome() + "," + i.getCognome() + "," + i.getCodiceId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Iscritto> caricaIscritti() {
        List<Iscritto> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("iscritti.csv"))) {
            String riga;
            while ((riga = br.readLine()) != null) {
                String[] dati = riga.split(",");
                if (dati.length >= 3) {
                    lista.add(new Iscritto(dati[0], dati[1], dati[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
