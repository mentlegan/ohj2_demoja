package demo.d12;

import java.util.Scanner;

/**
 * @author Harri Keränen
 * @version 26.3.2020
 * Ohjelmaan voi kirjoittaa seuraavat komennot:
     * "Ynnää (numero1) (numero2)" --> laskee yksinumeroisia kokonaislukuja
     * "Isoksi (sana)" --> muuttaa sanan kirjaimet isoiksi
     * "palindromiko (sana)" --> katsoo, että onko sana palindromi
     * "loppu" --> sulkee ohjelman
 * muut komennot hylätään
 */
public class Komentorivi {

    /**
     * @param args nope
     */
    public static void main(String[] args) {
        int i = 0; // ikuisen silmukan takia;
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        String loppu = "loppu";
        System.out.println("Anna komento");
        do {
                      
            String rivi = s.nextLine();
            String[] part = rivi.split(" ");
             
                
                if (rivi.startsWith("Ynnää") || rivi.startsWith("Yn")) {                                        
                    System.out.println("Tulos on " + Ynnaa(rivi)+".");
                    System.out.println("Anna komento");
                }
                
                
                if (rivi.startsWith("Isoksi")) {                   
                    System.out.println(part[1] + " isona on " + (part[1].toUpperCase()));
                    System.out.println("Anna komento");
                }
                
                
                if (rivi.startsWith("palindromiko")) {              
                    if (palindromi(part[1]) == true) {
                        System.out.println("Sana " +'"'+ part[1] +'"'+" on palindromi!");
                    } else System.out.println("Sana " +'"'+ part[1] +'"'+" ei ole palindromi!");   
                    System.out.println("Anna komento");
                }
                
                
                if (rivi.matches(loppu)) {
                    System.out.println("Kiitos!");
                    break;
                }
                
                if (Komento(rivi) == false) { //jos komento on tuntematon
                    System.out.println("En tunne komentoa "+part[0].toUpperCase()+"!");
                    System.out.println("Anna komento");
                }
                
            } while (i == 0); //"ikuisen" silmukan takia
    }
    
    /**
     * tähän lisätään komentoja kirjoittamalla ne trueksi
     * voidaan tehdä myös listaksi
     * @param rivi rivi
     * @return true, jos komento on oikein, false jos väärin
     * @example
     * <pre name="test">
     * Komento("Ynnää ") === true;
     * Komento("Yn ") === true;
     * Komento("Isoksi ") === true;
     * Komento("palindromiko ") === true;
     * Komento("loppu") === true;
     * Komento("Yh") === false;
     * </pre>
     */
    public static boolean Komento(String rivi) {
        if (rivi.startsWith("Ynnää")) return true;
        if (rivi.startsWith("Yn")) return true;
        if (rivi.startsWith("Isoksi")) return true;
        if (rivi.startsWith("palindromiko")) return true;
        if (rivi.matches("loppu")) return true;
        return false;        
    }
    

    /**
     * Käsittelee sanaa siltä, että onko se palindromi
     * @param sana käsiteltävä sana
     * @return true, jos sana on palindromi
     * @example
     * <pre name="test">
     * palindromi("abba") === true;
     * palindromi("hei") === false;
     * palindromi("apua") === false;
     * palindromi("tacocat") === true;
     * palindromi("wasitacaroracatisaw") === true;
     * palindromi("hello") === false;
     * </pre>
     */
    public static boolean palindromi(String sana) {
        int i = 0, j = sana.length() - 1;        
        while (i < j) { 
            if (sana.charAt(i) != sana.charAt(j)) 
                return false; 
            i++; 
            j--; 
        } 
        return true; 
    }


    /**
     * laskee kirjoitetun rivin numerot yhteen
     * @param s rivi
     * @return summa
     * @example
     * <pre name="test">
     * Ynnaa("Ynnää 1 2 3") === 6;
     * Ynnaa("Laske 3 4 5") === 12;
     * Ynnaa("HelloWorld 9 9 9 9") === 36;
     * </pre>
     */
    public static int Ynnaa(String s) {        
        int summa = 0;
        for(int i=0; i<s.length(); i++){
            char merkki = (char)(s.charAt(i) - '0');

            if (merkki >= 0 && merkki <= 9){
                summa += merkki;
            }
        }
        return summa;
    }

}
