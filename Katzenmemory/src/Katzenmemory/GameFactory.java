
package Katzenmemory;

import java.io.*;
import java.util.*;

// erstellt ein zufälliges Memoryset mit Filenamen
public class GameFactory {
    
    private List<String> memoryset = new ArrayList<String>();
    
    GameFactory() {
        Kartenset kartenset = new Kartenset();
        int memorysize = kartenset.getMemorySize();

        if (memorysize == 0) {
            System.out.println("nicht genügend Karten für ein Spiel!");
            // TODO: throw exception
            System.exit(1);
        }
        
        // ziehe karten und erstelle memoryset
        // TODO: wir brauchen Pärchen :)
        for (int i=1; i <=(memorysize*2); i++) {
            String gezogeneKarte = kartenset.getRandomKarte();
            if (gezogeneKarte != null) { // nur Bilder hinzufügen
                // check ob karte <=1 enthalten ist, dann add
                if (Collections.frequency(memoryset, gezogeneKarte) <=1) {
                    memoryset.add(gezogeneKarte);
                } else {
                    i--;
                }
                
            } else {
                i--;
            }
        }
    }
    
    public List<String> getMemoryset () {
        return memoryset;
    }
}
