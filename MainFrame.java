package main;
import view.*;
import presenter.*;
import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cards = new JPanel(cardLayout);

    public MainFrame() {
        setTitle("Gestione Palestra");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        AggiungiIscrittoView aggiungiView = new AggiungiIscrittoView();
        new AggiungiIscrittoPresenter(aggiungiView);
        cards.add(aggiungiView, "aggiungi");

        CercaIscrittoView cercaView = new CercaIscrittoView();
        new CercaIscrittoPresenter(cercaView);
        cards.add(cercaView, "cerca");

        MostraIscrittiView mostraView = new MostraIscrittiView();
        new MostraIscrittiPresenter(mostraView);
        cards.add(mostraView, "mostra");

        AggiungiAbbonamentoView aggiungiAbbView = new AggiungiAbbonamentoView();
        new AggiungiAbbonamentoPresenter(aggiungiAbbView);
        cards.add(aggiungiAbbView, "aggiungiAbb");

        TerminaAbbonamentoView terminaAbbView = new TerminaAbbonamentoView();
        new TerminaAbbonamentoPresenter(terminaAbbView);
        cards.add(terminaAbbView, "terminaAbb");

        AbbonamentiAttiviView attiviView = new AbbonamentiAttiviView();
        new AbbonamentiAttiviPresenter(attiviView);
        cards.add(attiviView, "attivi");

        StoricoAbbonamentiView storicoView = new StoricoAbbonamentiView();
        new StoricoAbbonamentiPresenter(storicoView);
        cards.add(storicoView, "storico");

        add(cards, BorderLayout.CENTER);

        JPanel menu = new JPanel();
        menu.add(createNavButton("Aggiungi Iscritto", "aggiungi"));
        menu.add(createNavButton("Cerca Iscritto", "cerca"));
        menu.add(createNavButton("Mostra Iscritti", "mostra"));
        menu.add(createNavButton("Aggiungi Abbonamento", "aggiungiAbb"));
        menu.add(createNavButton("Termina Abbonamento", "terminaAbb"));
        menu.add(createNavButton("Abbonamenti Attivi", "attivi"));
        menu.add(createNavButton("Storico Abbonamenti", "storico"));

        add(menu, BorderLayout.NORTH);
        setVisible(true);
    }

    private JButton createNavButton(String label, String card) {
        JButton button = new JButton(label);
        button.addActionListener(e -> cardLayout.show(cards, card));
        return button;
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
