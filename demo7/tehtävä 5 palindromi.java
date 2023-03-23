package demo.d7;
/**
 * @author Harri Keränen
 * @version 21.2.2020
 * Ohjelma käsittelee sanan ja tarkistaa, että onko se palindromi
 */
public class Merkkijonot {
 /**
 * @param args nope
 */
public static void main(String[] args) {
       if (palindromi("abba") == true) {
           System.out.println("Sana on palindromi");
       } else System.out.println("Sana ei ole palindromi");
       
       if (palindromi("hello") == true) {
           System.out.println("Sana on palindromi");
       } else System.out.println("Sana ei ole palindromi");
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
}