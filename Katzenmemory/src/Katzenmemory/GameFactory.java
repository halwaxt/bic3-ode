
package Katzenmemory;

import java.io.*;
import java.util.*;

// erstellt ein zufälliges Memoryset mit Filenamen
public class GameFactory {
    
    private List<String> memoryset = new ArrayList<String>();
    
    GameFactory() {
        Kartenset kartenset = new Kartenset();
        int memorysize = kartenset.getMemorySize();
        List<String> tempset = new ArrayList<String>();
        Random r = new Random();

        if (memorysize == 0) {
            System.out.println("nicht genügend Karten für ein Spiel!");
            // TODO: throw exception bereits in Kartenset
            System.exit(1);
        }
        
        // ziehe karten in ein tempset
        for (int i=1; i <=memorysize; i++) {
            String gezogeneKarte = kartenset.getRandomKarte();
            if (gezogeneKarte != null) { // nur Bilder hinzufügen
                tempset.add(gezogeneKarte); // fülle tempset mit karten
            } else {
                i--;
            }
        }
        
        // fülle memoryset aus dem tempset mit Pärchen
        for (int i=1; i <=(memorysize*2); i++) {
            String memorycard = tempset.get(r.nextInt(tempset.size()));
            if (Collections.frequency(memoryset, memorycard) <=1) {
                memoryset.add(memorycard);
            } else {
                i--;
            }
        }
    }
    
    public List<String> getMemoryset () {
        return memoryset;
    }
}
