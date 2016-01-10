/*
 * Lesen aller PNG Files in einem DIR
 * 
 */

import java.io.File;
import java.util.Random;

public class Karte {
    
    private String directory = "../bilder/";
    private File[] filenames;
    
    public Karte() {
        
    }
    
   /*
    * einlesen der filenamen in ein array
    */
    private File[] getFileArray (String directory) {
        
        filenames = new File(directory).listFiles();;
        return filenames;
    }
    
   /*
    * anzahl der elemente im array ausgeben
    */
    private int getFileCount (File[] filenames) {
        
        return filenames.length;
    }
    
   /*
    * per zufall eine karte aus dem array zurück geben
    */
    
    private File getRandomKarte (File[] filenames) {
        // String random = (fruits[new Random().nextInt(fruits.length)]);
        return filenames[new Random().nextInt(filenames.length)];
    }
}
