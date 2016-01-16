
package Katzenmemory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
// if random "hang" on linux see
// https://docs.oracle.com/cd/E13209_01/wlcp/wlss30/configwlss/jvmrand.html

public class GameFactory {
    
    private final List<String> memoryset = new ArrayList<>();
    private int memorysize = 0;
    
    GameFactory() {
        super();
    }
    
    public List<String> getMemoryset () {
        List<String> allebilder = new ArrayList<>();
        List<String> tempset = new ArrayList<>();
        String gezogenekarte = null;
        String memorykarte = null;
        
        BilderSet bilderset = new BilderSet();
        allebilder = bilderset.getBilderSet();
        memorysize = bilderset.getMemorySize();

        Random r = new Random();
        
        // wenn allebilder leer oder memorysize == 0, dann gib es so weiter
        if (allebilder.isEmpty() || (memorysize == 0)) {
            return allebilder;
        }
        
        // ziehe karten in eine temporäre liste
        // damit wird dann das memory befüllt
        while (tempset.size() < memorysize) {
            // ziehe ein random bild aus allebilder
            try {
                gezogenekarte = allebilder.get(r.nextInt(allebilder.size()));
            } catch (IllegalArgumentException ex) {
                // ignore
            }
            
            // wenn es ein bild gibt
            if (gezogenekarte != null) {
                // checke ob es schon in der liste ist
                if (Collections.frequency(tempset, gezogenekarte) <1) {
                    // füge Karte in die Liste ein
                    tempset.add(gezogenekarte);
                }
            }
        }
        
        // ziehe random karten und baue das memoryset
        while (memoryset.size() < (memorysize*2)) {
            // ziehe ein random bild aus tempset
            try {
                memorykarte = tempset.get(r.nextInt(tempset.size()));
            }catch (IllegalArgumentException ex) {
                // ignore
            }
            
            // es darf maximal zwei Mal in der Liste sein
            if (Collections.frequency(memoryset, memorykarte) <= 1) {
                // füge Karte in die Liste ein
                memoryset.add(memorykarte);
            } 
        }
        
        return memoryset;
    }
    
    public int getMemorySize () {
        return memorysize;
    }
}
