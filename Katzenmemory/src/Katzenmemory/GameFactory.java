
package Katzenmemory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

// erstellt ein zufälliges Memoryset mit Filenamen
public class GameFactory {
    
    private String[] gameDeck;
    
    GameFactory() {
        Kartenset kartenset = new Kartenset();
        File[] filearray = kartenset.getFileArray();
        int memorysize = kartenset.getMemorySize();

        List<File> memoryset = new ArrayList<File>(); //WTF? TODO

        
        if (memorysize == 0) {
            System.out.println("nicht genügend Karten für ein Spiel!");
            System.exit(1);
        }
        
        // ziehe karten und erstelle memoryset
        for (int i=0; i <=(memorysize*2); i++) {
            File gezogeneKarte = kartenset.getRandomKarte();
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
}
