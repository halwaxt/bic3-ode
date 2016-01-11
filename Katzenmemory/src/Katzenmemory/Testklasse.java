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
        
        int memory = Testkarte.getMemorySize();
        System.out.println("Memorysize: " + memory);
        
        GameFactory gamefactory = new GameFactory();
        gamefactory.getMemoryset().forEach(System.out::println);
        
        Gameplay gameplay = new Gameplay();
        gameplay.getGameset().forEach(System.out::println);
        
        if (gameplay.compareCards(0, 1)) {
            System.out.println("Treffer");
        }
        
        if (gameplay.compareCards(0, 2)) {
            System.out.println("Treffer");
        }
        
        if (gameplay.compareCards(0, 3)) {
            System.out.println("Treffer");
        }
        
        if (gameplay.compareCards(0, 4)) {
            System.out.println("Treffer");
        }
        
        if (gameplay.compareCards(0, 5)) {
            System.out.println("Treffer");
        }
        
        if (gameplay.compareCards(0, 6)) {
            System.out.println("Treffer");
        }
        
        if (gameplay.compareCards(0, 7)) {
            System.out.println("Treffer");
        }

        System.out.println("Moves: " + gameplay.getMoves());
        System.out.println("Trues: " + gameplay.getTrues());
    }
}
