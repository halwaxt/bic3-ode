
package Katzenmemory;

import java.io.*;
import java.util.*;

/*
 * Klasse für Spiellogic:
 * - bekommt zwei Integer Werte
 * - vergleicht ob in beiden Indizies im Array das selbe steht
 * - wenn ja: true, ansonsten false
 * - counter für jeden Vergleich und für jeden True
*/

public class Gameplay {
    
    private List<String> gameset = new ArrayList<String>();
    private int countMove = 0;
    private int countTrue = 0;
    
    Gameplay() {
        GameFactory gameInit = new GameFactory();
        gameset = gameInit.getMemoryset();
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
}
