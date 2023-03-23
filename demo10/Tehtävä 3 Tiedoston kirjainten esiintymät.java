package demo10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


/**
 * Laskee merkkijonosta kirjainten lukumäärän jättäen pois erikoismerkit
 * @author Harri Keränen
 * @version 15.3.2020
 * Mahdollisia testejä voisi olla tiedoston luku ja sen tarkistaminen
 */
public class Stuffandthings {
    
    static class Kirjain {
    
    private Character teksti;
    private int lkm;

    /**
     * Alustetaan teksti jonolla
     * @param c kirjain
     */
    public Kirjain(char c) {
        lkm = 0;
        teksti = c;
    }
    

    /**
     * @return teksti
     */
    public char getTeksti() {
        return teksti;
    }
    
    
    /**
     * @return lukumäärä
     */
    public int getLkm() {
        return lkm;
    }
    
    
    public void setLkm(int nolla) {
        this.lkm = nolla;       
    }
    
    
    @Override
    public String toString() {
        return teksti + ": " + lkm;
    }
    

    /**
     * @param c tutkittava kirjain
     * @return true tai false, onko kirjain oikea vai ei
     */
    public boolean oletko(char c) {
        return teksti.equals(c);
    }


    /**
     * Lisää lukumäärään kirjaimia
     */
    public void lisaa() {
        lkm++;        
    }

    }
    
    static class Kirjaimet {
        
        private Collection<Kirjain> alkiot = new ArrayList<Kirjain>();
        private int kirjaimia = 0;
        
        /**
         * Lisää kirjaimen alkioihin
         * @param c kirjain
         */
        public void lisaa(Character c) {
            kirjaimia = getKirjaimia() + 1;
            for (Kirjain kirjain : alkiot) {
                if (kirjain.oletko(c)) {
                    kirjain.lisaa();
                    return;
                }
            }
            Kirjain kirj = new Kirjain(c);
            kirj.lisaa();
            alkiot.add(kirj);
        }    
        
        /**
         * @param rivi rivi
         */
        public void kasitteleRivi(String rivi) {
            String rivi2 = erotaSanat(rivi);
            char[] palat = rivi2.toCharArray();
            for (char s: palat) {
                    lisaa(s);
            }   
        }
        
        /**
         * Tämä metodi suodattaa välilyönnit ja muut merkit pois
         * lisäksi se muuttaa isot kirjaimet pieniksi, että lasku toimii oikein
         * @param tiedosto tiedosto josta erotetaan
         * @return merkkijono, josta erotettu välilyönnit ja isot kirjaimet pieniksi
         * @example
         * <pre name="test">
         * erotaSanat("Hello World!") === "helloworld";
         * </pre>
         * ei mitään hajua miksei yllä oleva testi toimi
         */
        public static String erotaSanat(String tiedosto) {
            String[] sanat = tiedosto.split("(\\W+)");
            StringBuffer sb = new StringBuffer();
            for (String sana  : sanat) {
                sb.append(sana.toLowerCase());
            }
            return sb.toString();
        }
        

        /**
         * @param os printstream
         */
        public void tulosta(OutputStream os) {
            PrintStream out = new PrintStream(os);
            for (Kirjain kirjain : alkiot)
                out.println(kirjain);
        }
        
        public void lueTiedostoJaLaske(String tiedostonNimi) throws IOException {
            try (Scanner fi = new Scanner(new FileInputStream(new File(tiedostonNimi)))) {
                while ( fi.hasNext() ) {
                    String rivi = fi.nextLine();
                    kasitteleRivi(rivi);
                }
            }
        }

        public int getKirjaimia() {
            return kirjaimia;
        }

    }
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Kirjaimet kirjaimet = new Kirjaimet();              
        
        try {
            kirjaimet.lueTiedostoJaLaske("esiintymat.txt");
          }
          catch (IOException ex) {
            System.err.println("Virhe: " + ex);
          }
          kirjaimet.tulosta(System.out);
    }
     
}

