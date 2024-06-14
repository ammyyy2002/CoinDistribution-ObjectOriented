package util;

import java.util.ArrayList;
import java.util.List;


/**
 * Erstellt Kopien bestimmter Listen.
 */
public class Kopierer {

    /**
     * Kopiert eine <code>List</code> von <code>utli.Taler</code> (deep copy).
     * @param lt kopierende <code>List</code> von <code>utli.Taler</code>.
     * @return tiefe Kopie der uebergebenen <code>List</code> -> neue Instanz, die neue Instanzen beinhaltet.
     */
    public List<Integer> copyTalerList(List<Integer> lt)
    {
        List<Integer> new_lt = new ArrayList<>();
        for (Integer taler : lt)
        {
            new_lt.add(taler);
        }
        return new_lt;
    }


    /**
     * Kopiert eine <code>List</code> von <code>utli.Loesungsmengen</code> (deep copy).
     * @param lml kopierende <code>List</code> von <code>utli.Loesungsmengen</code>.
     * @return tiefe Kopie der uebergebenen <code>List</code> -> neue Instanz, die neue Instanzen beinhaltet.
     */
    public List<Loesungsmenge> copyLMList (List<Loesungsmenge> lml)
    {
        List<Loesungsmenge> new_lml = new ArrayList<>();
        for (Loesungsmenge loesungsmenge_alt : lml)
        {
            Loesungsmenge loesungsmenge_neu = new Loesungsmenge();
            for (int i = 0; i < loesungsmenge_alt.getAllTaler().size(); i++)
            {
                loesungsmenge_neu.addTaler(loesungsmenge_alt.getTaler(i));
            }
            new_lml.add(loesungsmenge_neu);
        }
        return new_lml;
    }
}
