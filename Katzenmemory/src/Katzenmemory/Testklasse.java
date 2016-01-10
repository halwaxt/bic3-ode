package Katzenmemory;

import java.io.File;

public class Testklasse {
    
    public static void main(String[] args) {
        
        Karte Testkarte = new Karte();
        
        File[] filearray = Testkarte.getFileArray();
        
        for ( File elem : filearray ) {
            System.out.println(elem);
          }
        
        int kartenanzahl = Testkarte.getFileCount();
        System.out.println("Anzahl der Files im Array: " + kartenanzahl);
        
        for (int i=0; i <= kartenanzahl; i++) {
            File gezogeneKarte = Testkarte.getRandomKarte();
            
            if (gezogeneKarte != null) {
                System.out.println("Filename" +i+ ": " + gezogeneKarte.getName());
            }
        }
        
        String memory = Testkarte.getMemorySize();
        System.out.println("Memorysize: " + memory);
    }
}
