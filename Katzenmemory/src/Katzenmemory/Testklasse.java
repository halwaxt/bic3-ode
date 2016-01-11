package Katzenmemory;

import java.io.File;

public class Testklasse {
    
    public static void main(String[] args) {
        
        Kartenset Testkarte = new Kartenset();
        
        File[] filearray = Testkarte.getFileArray();
        
        for ( File elem : filearray ) {
            System.out.println("Bild gefunden: " + elem);
          }
        
        int kartenanzahl = Testkarte.getFileCount();
        System.out.println("Anzahl der Files im Array: " + kartenanzahl);
        
        for (int i=0; i <= kartenanzahl; i++) {
            String gezogeneKarte = Testkarte.getRandomKarte();
            
            if (gezogeneKarte != null) {
                System.out.println("Filename" +i+ ": " + gezogeneKarte);
            }
        }
        
        int memorysize = Testkarte.getMemorySize();
        System.out.println("Memorysize: " + memorysize);
        
        GameFactory gamefactory = new GameFactory();
        System.out.println("New Memoryset:");
        gamefactory.getMemoryset().forEach(System.out::println);
        
        Gameplay gameplay = new Gameplay();
        System.out.println("New Gameset:");
        gameplay.getGameset().forEach(System.out::println);
        
        for (int j=0; j <= (memorysize*2)-1; j++) {
            for (int k=0; k <= (memorysize*2)-1; k++) {
                if (! ( (int)j == (int)k )) {
                    if (gameplay.compareCards((int)j, (int)k)) {
                        System.out.println("Treffer bei j: " +j+ " und k: " +k);
                    }
                }
            }
        }
        
        System.out.println("Moves: " + gameplay.getMoves());
        System.out.println("Trues: " + gameplay.getTrues());
    }
}
