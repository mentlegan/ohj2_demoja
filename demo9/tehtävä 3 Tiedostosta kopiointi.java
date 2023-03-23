package demo.d9;

import java.io.*;

/**
 * @author Harri Keränen
 * @version 8.3.2020
 * Lukee tiedoston ja kopioi sen sisällön uuteen suodattamalla pois rivit,
 * joiden alussa oleva ensimmäinen luku on pienempi kuin 30, tai ei ole luku ollenkaan.
 * 
 * luettavatiedosto on kopioitava tiedosto
 * uusi tiedosto on tiedosto, joka tästä syntyy
 * 
 * Testeihin voisi laittaa bufferedreadereita ja stringejä?
 * Tiedostojen nimet voisi myös tarkistaa testeillä
 * Metodille erota on tehty comtest
 */
public class Stuffandthings {

    /**
     * @param args nope
     * @throws Exception stuffandthings
     */
    public static void main(String[] args)throws Exception {
        
        File file = new File("luettavatiedosto.txt"); 
        
        @SuppressWarnings("resource")
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        String rivi1 = br.readLine(); //luetaan rivi kerrallaan        
        String rivi2 = br.readLine(); //tiedämme, että tiedostossa on viisi riviä
        String rivi3 = br.readLine();
        String rivi4 = br.readLine();
        String rivi5 = br.readLine();
        
        String[] rivit = new String[] { erota(rivi1), //tehdään taulukko, jota käsitellään
                                        erota(rivi2), //erota metodi muuttaa epäsoveliaat rivit nulleiksi
                                        erota(rivi3),
                                        erota(rivi4),
                                        erota(rivi5) };
        
        String uusiTiedosto = tiedostoksi(rivit); //nullit pois
        
        String tiedNimi = "uusitiedosto.txt";
        try {@SuppressWarnings("resource")
        PrintStream fo = new PrintStream(new FileOutputStream(tiedNimi, false));
                    fo.printf(uusiTiedosto);
        } catch (FileNotFoundException ex) {
            System.err.println("Tiedosto ei aukea: " + ex.getMessage());
        }
    }
    
    
    /**
     * @param rivit rivit taulukkona
     * @return nullit pois ja rivivälit oikein
     */
    public static String tiedostoksi(String[] rivit) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < rivit.length; i++) {
            if (rivit[i] != null) {
                sb.append(rivit[i]);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
    

    /**
     * erottaa rivin, joiden alussa oleva luku on alle 30
     * @param rivi tutkittava rivi
     * @return rivi
     * @example
     * <pre name="test">
     * erota("Hello World!") === null;
     * erota("Tämä lause ei toimi, koska ei ole numeroa alussa") === null;
     * erota("30 apinaa istuu puussa") === "30 apinaa istuu puussa";
     * erota("36 kissanpentua") === "36 kissanpentua";
     * erota("20 ei riitä") === null;
     * </pre>
     */
    public static String erota(String rivi) {
        String t[] = rivi.split(" ",2);
        String ekasana = t[0];
        char[] s = ekasana.toCharArray();
        if (s.length <= 2) {
            String sana = new String (s);
            int iLuku = Integer.parseInt(sana);
            if( iLuku >= 30 ) {
                return rivi;       
            }
        }
        return null;
    }        
}

