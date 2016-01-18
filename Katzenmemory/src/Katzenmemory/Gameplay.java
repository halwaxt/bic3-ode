
package Katzenmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Gameplay {
    
    private List<String> gameset = new ArrayList<>();
    private int memorysize = 0;
    private int countMove = 0;
    private int countTrue = 0;
    private int debugCountAllCard = 0;
    private int debugCountMemoryCards = 0;
    
    
    Gameplay() {
        GameFactory gameInit = new GameFactory();
        gameset = gameInit.getMemoryset();
        memorysize = gameInit.getMemorySize();
        debugCountAllCard = gameInit.getDebugCountAllCards();
        debugCountMemoryCards = gameInit.getDebugCountMemoryCards();
    }
    
    public List<String> getGameset () {
        return gameset;
    }
    // Index im Array startet bei 0 (Null)
    public boolean compareCards (int first, int second) {
        
        countMove++;
        if (Objects.equals(gameset.get(first), gameset.get(second))) {
            countTrue++;
            return true;
        } else {
            return false;
        }
    }
    
    public int getMoves () {
        return countMove;
    }
    
    public int getTrues () {
        return countTrue;
    }
    
    public int getMemorySize () {
        return memorysize;
    }
    
    public int getDebugCountAllCards () {
        return debugCountAllCard;
    }
    
    public int getDebugCountMemoryCards () {
        return debugCountMemoryCards;
    }
}
