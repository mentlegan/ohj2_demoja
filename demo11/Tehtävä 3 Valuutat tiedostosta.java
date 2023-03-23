package demo.d11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Harri Keränen
 * @version 21.3.2020
 * Ohjelma osaa muuttaa rahaa markoiksi kertoimien avulla
 * Kertoimet eivät välttämättä ole ajan tasalla
 * Tässä versiossa ohjelma osaa käsitellä dollareita, euroja ja ruotsin kruunuja
 * Testeistä: funktiolle ei ole comtestiä, mutta rivin tietojen haulle on
 */
public class Valuutat {      
    
    static private String rivi1;
    static private String rivi2;
    static private String rivi3;

    
    private static DecimalFormat d1 = new DecimalFormat("#");
    private static DecimalFormat d2 = new DecimalFormat("#.00");
    
    
    /**
     * @param args nope
     * @throws IOException jos ei toimi
     */
    public static void main (String[] args) throws IOException {        
        
        File file = new File("C:\\MyTemp\\ohj2\\demo11\\valuutat.txt");
        @SuppressWarnings("resource")
        BufferedReader br = new BufferedReader(new FileReader(file)); 

        rivi1 = br.readLine(); //luetaan rivi kerrallaan        
        rivi2 = br.readLine(); //tiedämme, että tiedostossa on kolme riviä
        rivi3 = br.readLine(); // tämän voisi tehdä silmukan avulla myös taulukoksi, ja sitten käsitellä sitä
        
        
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
            
            
            if (valuutta.matches(haeNimi(rivi1)) || valuutta.matches("dollaria")) { raha.setNimi("DOLLARIA"); }
            if (valuutta.matches(haeNimi(rivi2)) || valuutta.matches("euroa")) { raha.setNimi("EUROA"); }
            if (valuutta.matches(haeNimi(rivi3)) || valuutta.matches("skr")) { raha.setNimi("Skr"); }
            raha.setMaara(summa);
                       
            if (raha.nimi.matches(haeNimi(rivi1))) {                
                System.out.println((d1.format(raha.maara)) + " " + raha.getNimi()+" on " + vaihdaValuutta(raha));
            }
            
            if (raha.nimi.matches(haeNimi(rivi2))) {
                System.out.println((d1.format(raha.maara)) + " " + raha.getNimi()+" on " + vaihdaValuutta(raha));
            }
            
            if (raha.nimi.matches(haeNimi(rivi3))) {
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
     * @param rivi käsiteltävä rivi
     * @return rivi josta suodatettu valuutta
     * poistaa siis toisena tulevan esiintymän
     * @example
     * <pre name="test">
     * haeKerroin("EUROA 5.94573") ~~~ 5.94573;
     * haeKerroin("hello 2.0") ~~~ 2.0;
     * haeKerroin("otetaan 96.6 vai mitä") ~~~ 96.6;
     * </pre>
     */
    public static double haeKerroin(String rivi) {        
        String[] osat = rivi.split(" ");
        String osa = osat[1];
        double d = Double.parseDouble(osa);
        return d;
    }

    /**
     * @param rivi käsiteltävä rivi
     * @return rivi josta suodatettu kerroin
     * @example
     * <pre name="test">
     * haeNimi("DOLLARIA 5.7") === "DOLLARIA";
     * haeNimi("JENIÄ mitä?") === "JENIÄ";
     * haeNimi("tämä <--ottaa ekan") === "tämä";
     * </pre>
     */
    public static String haeNimi(String rivi) {
        String[] osat = rivi.split(" ");
        String osa = osat[0];
        return osa;
    }


    /**
     * tämä funktio toimisi myös voidina, 
     * tulostusta varten laitettiin string
     * @param v raha-olion tiedot jota vaihdetaan
     * @return rahamäärä markkoina
     */
    public static String vaihdaValuutta(Valuutta v) {
        double rahaMaara = v.getMaara();
        //käytetään kertoimia
        if (v.nimi.matches(haeNimi(rivi1)) || v.nimi.matches("dollaria")) { rahaMaara *= haeKerroin(rivi1); }
        if (v.nimi.matches(haeNimi(rivi2)) || v.nimi.matches("euroa")) { rahaMaara *= haeKerroin(rivi2); }
        if (v.nimi.matches(haeNimi(rivi3)) || v.nimi.matches("skr")) { rahaMaara *= haeKerroin(rivi3); }        
        
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