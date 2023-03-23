package demo.d6;

/**
 * @author Harri Keränen
 * @version 11.2.2020
 */
public class TaulukonKasittely {
    
    /**
     * @param a käsiteltävä taulukko
     * @return taulukko
     */
    public static int pienimmanPaikka(int[] a) {
        int pituus = a.length;        
               int p = pienin(a);               
               for (int o = 0; o < pituus; o++) {
                   if (a[o] == p)
                       return o;
               }
               return -1;
     }
    

    /**
     * @param a taulukko
     * @return alkion arvo
     * @example
     * @example
     * <pre name="test">
     * int[] t = {1,2,3,4,5,6};
     * pienin(t) === 1;
     * pienin(new int[]{31,6,5,7,890}) === 5;
     * pienin(new int[]{5,4,6,2,9,1}) === 1;
     * </pre>
     */
    public static int pienin(int[] a) {
        int pituus = a.length;        
        int pienin = Integer.MAX_VALUE;
        for (int i = 0; i < pituus; i++) {
            if (a[i] < pienin)
                pienin = a[i];
        }        
        return pienin;
     }
    /**
     * @param args ei käytössä
     */
    public static void main (String args[]) {
                        /*ta,he,ma,hu,to,ke,he,el,sy,lo,ma,jo*/
       int kPituudet[] = {31,28,31,30,31,30,31,31,30,31,30,31};
       int n = pienin(kPituudet);
       int i = pienimmanPaikka(kPituudet);
       int luvut[] = {1,7,23,7};
       int o = pienin(luvut);
       int o2 = pienimmanPaikka(luvut);
       System.out.println("Pienin on: " + n);
       System.out.println("Pienimmän paikka on: " + i);
       System.out.println(o + " " + o2);
    }
}