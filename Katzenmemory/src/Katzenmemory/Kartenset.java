package Katzenmemory;

/*
 * Lesen aller Files in einem DIR
 * 
 */

import java.io.File;
import java.util.Random;
import javax.activation.MimetypesFileTypeMap;

public class Kartenset {
    
    private String directory = "../bilder/";
    private File[] filenames;
    
    public Kartenset() {
        super();
    }
    
   /*
    * einlesen der filenamen in ein array
    */
    public File[] getFileArray () {
        
        filenames = new File(directory).listFiles();;
        return filenames;
    }
    
   /*
    * anzahl der elemente im array ausgeben
    */
    public int getFileCount () {
        
        return filenames.length;
    }
    
   /*
    * per zufall eine karte aus dem array zurück geben
    */
    
    public File getRandomKarte () {
        // return only if JPG or PNG
        
        File picture = filenames[new Random().nextInt(filenames.length)];
        String mimeType = new MimetypesFileTypeMap().getContentType(picture);
        
        if(mimeType.substring(0,5).equalsIgnoreCase("image")){
            return picture;
        } else {
            return null;
        }
    }
    
    public String getMemorySize () {
        
        int arraysize = this.getFileCount();
        
        if (arraysize >= 32) {
            return "8x8";
        }
        
        if (arraysize >= 18) {
            return "6x6";
        }
        
        if (arraysize >= 8) {
            return "4x4";
        }
        
        if (arraysize >= 2) {
            return "2x2";
        } else {
            return null;
        }
    }
}
