package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Beinhaltet Taler einer <code>util.Loesungsmenge</code>.
 */
public class Loesungsmenge {
    private final List<Integer> talerList;

    /**
     * Initalisiert <code>ArayList</code>, welche <code>util.Taler</code> speichert.
     */
    public Loesungsmenge()
    {
        talerList = new ArrayList<>();
    }


    /**
     * Fuegt <code>util.Loesungsmenge</code> einen <code>util.Taler</code> hinzu.
     * @param taler Ganzzahl hinzuzufuegen eines Talers.
     */
    public void addTaler(Integer taler) {
        talerList.add(taler);
    }

    /**
     * Entfernt <code>util.Taler</code> aus <code>util.Loesungsmenge</code>
     */
    public void removeTaler(Integer taler)
    {
        talerList.remove(taler);
    }

    /**
     * Gibt Gesamtsumme aller <code>util.Taler</code> der Loesungmenge zurueck.
     * @return Ganzzahl Talersumme
     */
    public int getTalerSumme()
    {
        int summe = 0;
        for (Integer taler : talerList) {
            summe += taler;
        }
        return summe;
    }

    /**
     * Gibt Wert eines Talers zurueck.
     * @return gibt Liste aller Taler zurück
     */
    public int getTaler(int index)
    {
        return talerList.get(index);
    }

    /**
     * Gibt <code>ArrayList</code>, die Taler speichert zurueck.
     * @return gibt Liste aller Taler zurück
     */
    public List<Integer> getAllTaler()
    {
        return talerList;
    }

    /**
     * Gibt <code>ArrayList</code>, die <code>util.Taler</code> speichert als String zurück.
     * @return <code>String</code>
     */
    @Override
    public String toString()
    {
        return talerList.toString();
    }
}

