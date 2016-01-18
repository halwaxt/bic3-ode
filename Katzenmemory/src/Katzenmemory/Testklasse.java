package Katzenmemory;

public class Testklasse {
    
    public static void main(String[] args) {
        
        /*
         * Create new Gameplay()
         *
         * Return: List<String> with canonical path of pictures
         */
        Gameplay gameplay = new Gameplay();
        System.out.println("New Gameset created");
        
        /*
         * check size of one row
         * Memoryset must be (memorysize x memorysize), eg. 4x4
         *
         * Return: integer
         */
        int memorysize = gameplay.getMemorySize();
        int allcards = gameplay.getDebugCountAllCards();
        int memorycards = gameplay.getDebugCountMemoryCards();
        System.out.println("Memorysize: " + memorysize);
        
        System.out.println("Anzahl aller Karten: " + allcards);
        System.out.println("Anzahl der Memorykarten: " + memorycards);
        
        gameplay.getGameset().forEach(System.out::println);
        for (int j=0; j <= allcards; j++) {
            for (int k=0; k <= allcards; k++) {
                if (! ( (int)j == (int)k )) {
                    
                    /*
                     * Compare Values
                     *
                     * Params: Arrayindices from filename list
                     * Return: boolean (true/false)
                     */
                    if (gameplay.compareCards((int)j, (int)k)) {
                        System.out.println("Treffer bei j: " +j+ " und k: " +k);
                    }
                }
            }
        }
        
        /*
         * Get game statistics :)
         *
         * Return: integer
         */
        System.out.println("Moves: " + gameplay.getMoves());
        System.out.println("Trues: " + gameplay.getTrues());
    }
}
