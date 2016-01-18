
package Katzenmemory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.MimetypesFileTypeMap;

public final class BilderSet {
    
    private final String directory = "../bilder/";
    private File[] filenames;
    private int filecount = 0;
    
    public BilderSet() {
        super();
        this.getFileArray();
    }

    private void getFileArray () {
        
        filenames = new File(directory).listFiles();
    }

    public List<String> getBilderSet () {
        // lesbare Bilder als String-List zurück geben

        List<String> bilderset = new ArrayList<>();
        for ( File fileondisc : filenames) {
            try {
                String picture = fileondisc.getCanonicalPath();
                String mimeType = new MimetypesFileTypeMap().getContentType(picture);
                if(fileondisc.canRead()) {
                    if(mimeType.substring(0,5).equalsIgnoreCase("image")){
                        bilderset.add(picture);
                        filecount++;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(BilderSet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return bilderset;
    }
        
    public int getMemorySize () {
        // Größe des möglichen Memory zurück geben
        
        if (filecount >= 50) {
            return 10; //"10x10"
        }
        if (filecount >= 32) {
            return 8; //"8x8"
        }
        
        if (filecount >= 18) {
            return 6; //"6x6"
        }
        
        if (filecount >= 8) {
            return 4; //"4x4"
        }
        
        if (filecount >= 2) {
            return 2; //"2x2"
        } else {
            return 0;
        }
    }
}
