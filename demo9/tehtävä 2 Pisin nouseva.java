package demo.d9;

/**
 * @author Harri Keränen
 * @version 8.3.2020
 * stuff and things
 */
public class Pnouseva {
  /**
   * Testataan pisinNouseva-aliohjelmaa
   * @param args ei käytössä
   */
  public static void main(String[] args)  {
    System.out.println(pisinNouseva("abajiuxc"));
    System.out.println(pisinNouseva("kissa"));
    System.out.println(pisinNouseva("abcdefg"));
    System.out.println(pisinNouseva("dcba"));
    System.out.println(pisinNouseva("ab"));
    System.out.println(pisinNouseva("a"));
    System.out.println(pisinNouseva(""));
    System.out.println(pisinNouseva(""));
  }
  
   /**
    * apuohjelma
    * @param s tutkittava merkkijono
    * @param alku alkuindeksi
    * @return pituus
    */
  public static int nouseva(String s, int alku) {
      int pituus = 1;
      int jPituus = s.length();
      for (int i=alku; i<jPituus-1; i++)
          if ( s.charAt(i) <= s.charAt(i+1) ) pituus++;
          else break;
      
          return pituus;
      }

    /**
     * @param s tutkittava merkkijono
     * @return pisin 
     * @example
     * <pre name="test">
     * pisinNouseva("abcdefghijklmnopqrstu") === 21;
     * pisinNouseva("123") === 3;
     * pisinNouseva("linkkijklry") === 6;
     * pisinNouseva("jyväskylä") === 2;
     * pisinNouseva("helloworld") === 5;
     * </pre>
     */
  public static int pisinNouseva(String s) {
      int jono = 0;
      int pituus = 1;
      int jPituus = s.length();
        
      for (int i=0; i<jPituus; i+=pituus) {
          pituus = nouseva(s,i);
          if ( jono < pituus ) jono = pituus;
      }
      return jono;
    }
}

