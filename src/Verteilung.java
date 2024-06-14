import util.Ausgangsmenge;
import util.Loesungsmenge;
import util.Kopierer;

import java.util.ArrayList;
import java.util.List;


/**
 * Beinhaltet Logik der rekursiven Verteilung der <code>util.Taler</code>.
 */
public class Verteilung {
    private final Ausgangsmenge ausgangsmenge;
    private final int anzahlLoesungsmengen;
    private int zielSum;
    private final Kopierer k;

    /**
     * Initialisierung der Startmenge und gesuchter Anzahl der Loesungsmengen.
     * @param ausgangsmenge der Klasse <code>util.Ausgangsmenge</code>, welche <code>util.Taler</code> in Listenattribut speichert.
     * @param anzahlLoesungsmengen zu testende Ganzzahl
     */
    public Verteilung(Ausgangsmenge ausgangsmenge, int anzahlLoesungsmengen)
    {
        this.ausgangsmenge = ausgangsmenge;
        this.anzahlLoesungsmengen = anzahlLoesungsmengen;
        this.k = new Kopierer();
    }

    /**
     * Ueberprueft, ob Gesamtwert der <code>util.Taler</code> auf Loesungsmengenanzahl aufteilbar ist und startet rekursive Funktion.
     * @return <code>null</code>, wenn kein Ergebnis und Liste mit <code>util.Loesungsmengen</code>, wenn moegliche Verteilung gefunden wurde.
     */
    public List<Loesungsmenge> verteileTaler()
    {
        int totalSum = ausgangsmenge.getTalerSumme();
        if (totalSum % anzahlLoesungsmengen != 0)
        {
            return null; // Es ist nicht möglich, die Münzen gleichmäßig zu verteilen
        }

        zielSum = totalSum / anzahlLoesungsmengen;
        ArrayList<Loesungsmenge> loesungsmengen = new ArrayList<>();
        for (int i = 0; i < anzahlLoesungsmengen; i++)
        {
            loesungsmengen.add(new Loesungsmenge());
        }

        return verteilungsHilfe(0, ausgangsmenge.getAusgangsmenge(), loesungsmengen);
    }


    /**
     * Findet rekursiv eine gleichwertige Verteilung der <code>util.Ausgangsmenge</code> auf die <code>util.Loesungsmengen</code>.
     * @param restliste <code>util.Ausgangsmenge</code>, die Liste der <code>util.Taler</code> der Startmenge beinhaltet.
     * @param loesungsmengen <code>List</code>, die alle Loesungsmengen beinhaltet.
     */
    private List<Loesungsmenge> verteilungsHilfe(int index, List<Integer> restliste, List<Loesungsmenge> loesungsmengen)
    {
        //Basisifall
        if (restliste.isEmpty())
        {
            for (Loesungsmenge lm : loesungsmengen)
            {
                if (lm.getTalerSumme() != zielSum)
                {
                    return null;
                }
            }
            return loesungsmengen;
        }

        Integer t = restliste.remove(0);
        for (int i = 0; i < anzahlLoesungsmengen; i++)
        {
            loesungsmengen.get(i).addTaler(t);
            List<Loesungsmenge> ergebnis = verteilungsHilfe(index+1, k.copyTalerList(restliste), k.copyLMList(loesungsmengen));
            if (ergebnis != null)
            {
                return ergebnis; //erste Lösung mit Ergebnis
            }
            else
            {
                loesungsmengen.get(i).removeTaler(t);
            }

        }
        return null; // keine Lösung mit Ergebnis auf dieser Rekursionsebene
    }
}
