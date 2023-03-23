package demo.d9;

import java.io.*;

/**
 * @author Harri Keränen
 * @version 8.3.2020
 *
 */
public class Stuffandthings {

    /**
     * @param args nope
     * @throws Exception stuffandthings
     */
    public static void main(String[] args)throws Exception {
        String tiedNimi = "sata.txt";
        if (args.length > 0) tiedNimi = args[0];
        try (PrintStream fo = new PrintStream(new FileOutputStream(tiedNimi, true))) {
        
            int rivi = 0;
            for (int i = 0; i < 100; i++) {
                    fo.printf(rivi + " En enää turhaan kirjoita!");
        rivi++;        
        }
            } catch (FileNotFoundException ex) {
                System.err.println("Tiedosto ei aukea: " + ex.getMessage());
            }                    
    }
}
