package demo.d11;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Harri Keränen
 * @version 21.3.2020
 * Ohjelma osaa muuttaa rahaa markoiksi kertoimien avulla
 * Kertoimet eivät välttämättä ole ajan tasalla
 * Tässä versiossa ohjelma osaa käsitellä dollareita, euroja ja ruotsin kruunuja
 */
public class Valuutat {      
    
    private static Valuutta alkiot[];
    private int lkm;
    
    private static DecimalFormat d1 = new DecimalFormat("#");
    private static DecimalFormat d2 = new DecimalFormat("#.00");
    
    /**
     * @param koko taulukon koko
     */
    public Valuutat(int koko) {
        alusta(koko);
    }
    
    private void alusta(int koko) {
        alkiot = (new Valuutta[koko]);
        lkm=0;
    }
    
    /**
     * @param v valuutta
     */
    public void lisaa(Valuutta v) {
        alkiot[lkm++] = v;
    }
    
    /**
     * @param args nope
     */
    public static void main (String[] args) {        
        
        Valuutat rahat = new Valuutat(3);
        rahat.lisaa(new Valuutta(5.7,"DOLLARIA"));
        rahat.lisaa(new Valuutta(5.94573,"EUROA"));
        rahat.lisaa(new Valuutta(0.6,"Skr"));
        
        Valuutta raha = new Valuutta();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);        
        
        do {
            System.out.println(); //tilaa     
            System.out.println("Anna rahamäärä ja valuutta (DOLLARIA, EUROA tai SKr)");
            System.out.println("Lopeta ohjelma kirjoittamalla loppu");
        try {
            double summa = scanner.nextDouble();
            String valuutta = new String();
            valuutta = scanner.next();
            
            
            if (valuutta.matches(alkiot[0].nimi) || valuutta.matches("dollaria")) { raha.setNimi("DOLLARIA"); }
            if (valuutta.matches(alkiot[1].nimi) || valuutta.matches("euroa")) { raha.setNimi("EUROA"); }
            if (valuutta.matches(alkiot[2].nimi) || valuutta.matches("skr")) { raha.setNimi("Skr"); }
            raha.setMaara(summa);
                       
            if (raha.nimi == alkiot[0].nimi) {                
                System.out.println((d1.format(raha.maara)) + " " + raha.getNimi()+" on " + vaihdaValuutta(raha));
            }
            
            if (raha.nimi == alkiot[1].nimi) {
                System.out.println((d1.format(raha.maara)) + " " + raha.getNimi()+" on " + vaihdaValuutta(raha));
            }
            
            if (raha.nimi == alkiot[2].nimi) {
                System.out.println((d2.format(raha.maara)) + " " + raha.getNimi()+" on " + vaihdaValuutta(raha));
            }
                       
            
        } catch (Exception e) {
            if (scanner.nextLine().matches("loppu")) {
                System.out.println("Kiitos!");
                break;
            }
            System.err.println("Virhe! Paina enter");
            
        }
            
        } while (scanner.nextLine() != "loppu"); // tämä "ikuisen silmukan" takia
        
    }
   


    /**
     * tämä funktio toimisi myös voidina, 
     * mutta testejä ja tulostusta varten laitettiin string
     * että tarkastetaan returnit oikein
     * @param v raha-olion tiedot jota vaihdetaan
     * @return rahamäärä testejä varetn
     * @example
     * <pre name="test">
     * Valuutat alkiot = new Valuutat(3);
     * alkiot.lisaa(new Valuutta(5.7,"DOLLARIA"));
     * alkiot.lisaa(new Valuutta(5.94573,"EUROA"));
     * alkiot.lisaa(new Valuutta(0.6,"Skr"));
     * Valuutta raha3 = new Valuutta(100000,"DOLLARIA");
     * Valuutta raha2 = new Valuutta(2,"EUROA");
     * Valuutta raha = new Valuutta(10.00,"Skr");
     * vaihdaValuutta(raha) === "6,00 mk."
     * vaihdaValuutta(raha2) === "11,89 mk."
     * vaihdaValuutta(raha3) === "570000,00 mk."
     * </pre>
     */
    public static String vaihdaValuutta(Valuutta v) {
        double rahaMaara = v.getMaara();
        //käytetään kertoimia
        if (v.nimi.matches(alkiot[0].nimi) || v.nimi.matches("dollaria")) { rahaMaara *= alkiot[0].maara; }
        if (v.nimi.matches(alkiot[1].nimi) || v.nimi.matches("euroa")) { rahaMaara *= alkiot[1].maara; }
        if (v.nimi.matches(alkiot[2].nimi) || v.nimi.matches("skr")) { rahaMaara *= alkiot[2].maara; }        
        
        v.setMaara(rahaMaara);
        return v.toString();
    }
    
    
    
    /**
     * @author Harri Keränen
     * @version 22.3.2020
     * pakko olla public comtestien takia
     */
    public static class Valuutta {
        private double maara;
        private String nimi;
        
        /**
         * @param maara rahamäärä
         * @param nimi annettu valuutta
         * comtestia varten
         */
        public Valuutta(double maara, String nimi) {
            this.maara = maara;
            this.nimi = nimi;
        }
        
        
        /**
         * oletusmuodostaja
         */
        public Valuutta() {
            //
        }
        
        
        /**
         * @return rahamäärä
         */
        public double getMaara() {
            return this.maara;
        }
        
        
        /**
         * @return valuutta
         */
        public String getNimi() {
            return this.nimi;
        }
        
        
        /**
         * @param maara asetettava rahamäärä
         */
        public void setMaara(double maara) {
            this.maara = maara;
        }
        
        
        /**
         * @param nimi asetettava valuutta
         */
        public void setNimi(String nimi) {
            this.nimi = nimi;
        }
        
        
        /**
         * alkutaulukon tietojen anto
         * @param valuutta stuff
         * @param kerroin thangs
         */
        public void annaTiedot(double kerroin,String valuutta) {
            this.nimi=valuutta;
            this.maara=kerroin;
        }
        

        @Override
        public String toString() {
            return d2.format(this.maara) + " mk.";
        }
    }
}