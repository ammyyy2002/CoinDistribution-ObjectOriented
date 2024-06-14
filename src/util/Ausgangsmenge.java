package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Speichert <code>util.Taler</code> der Start-/<code>util.Ausgangsmenge</code>.
 */
public class Ausgangsmenge {
    private final List<Integer> talerListe;

    /**
     * Initialisiert <code>util.Ausgangsmenge</code>.
     * @param talerMap <code>Map</code>, die Wert und Anzahl eines Talers speichert.
     */
    public Ausgangsmenge(Map<Integer, Integer> talerMap)
    {
        talerListe = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : talerMap.entrySet())
        {
            for (int i = 0; i < e.getValue(); i++)
            {
                talerListe.add(e.getKey());
            }
        }
        // absteigend sortieren ist effizienter
        talerListe.sort((t1, t2) -> Integer.compare(t2,t1));
    }

    /**
     * Gibt <code>util.Ausgangsmenge</code> zurueck.
     * @return <code>List</code> der <code>util.Ausgangsmenge</code>.
     */
    public List<Integer> getAusgangsmenge() {
        return talerListe;
    }

    /**
     * Gibt Summe aller <code>util.Taler</code> zurueck.
     * @return Ganzzahl, Summe aller util.Taler.
     */
    public int getTalerSumme() {
        int summe = 0;
        for (Integer t : talerListe) {
            summe += t;
        }
        return summe;
        //return coins.stream().mapToInt(Coin::getValue).sum();
    }
}

