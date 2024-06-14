import util.Ausgangsmenge;
import util.Loesungsmenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Beinhaltet Logik.
 */
public class Starten {
    /**
     * Startet kompletten Ablauf.
     */
    public void starten() {
        Map<Integer, Integer> talerMap = new HashMap<>();
        talerMap.put(1, 3); // (wert, anzahl)
        talerMap.put(3, 3);
        talerMap.put(5, 6);

        Ausgangsmenge ausgangsmenge = new Ausgangsmenge(talerMap);
        Verteilung verteilung = new Verteilung(ausgangsmenge, 3);
        List<Loesungsmenge> ergebnis = verteilung.verteileTaler();
        if (ergebnis != null) {
            System.out.println("\nLÖSUNG:");
            for (int j = 0; j < ergebnis.size(); j++) {
                System.out.println("Menge " + (j + 1) + ": " + ergebnis.get(j).getAllTaler());
            }
            return;
        }


        /*for (int i = 2; i < ausgangsmenge.getAusgangsmenge().size(); i++)
        {
            Verteilung verteilung = new Verteilung(ausgangsmenge, i);
            List<Loesungsmenge> ergebnis = verteilung.verteileTaler();
            if (ergebnis != null)
            {
                System.out.println("\nLÖSUNG:");
                for (int j = 0; j < ergebnis.size(); j++)
                {
                    System.out.println("Menge " + (j + 1) + ": " + ergebnis.get(j).getAllTaler());
                }
                return;
            }
        }*/

        System.out.println("\nEs konnte keine Lösung gefunden werden.");

    }
}

