package util;

import java.util.ArrayList;
import java.util.List;


/**
 * Erstellt Kopien bestimmter Listen.
 */
public class Kopierer {

    /**
     * Kopiert eine <code>List</code> von Talern (deep copy).
     * @param lt zu kopierende <code>List</code> von Talern
     * @return deep Copy der uebergebenen <code>List</code>
     */
    public List<Integer> copyTalerList(List<Integer> lt)
    {
        return new ArrayList<>(lt);
    }


    /**
     * Kopiert eine <code>List</code> von <code>util.Loesungsmengen</code> (deep copy).
     * @param lml kopierende <code>List</code> von <code>util.Loesungsmengen</code>.
     * @return deep Copy der uebergebenen <code>List</code>
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
