package demo.d9;

/**
 * @author Harri Keränen
 * @version 7.3.2020
 *
 */
public class PoistaTaulukosta {
    
    /**
     * @param taulukko taulukko
     * @param lkm taulukon alkioiden lukumäärä
     * @param n etsittävä luku 
     * @return loput
     * @example
     * <pre name="test">
     * int t1[] = {9,9,9,1,2,3};
     * int t2[] = {1,6,7,9,3,5,5};
     * int t3[] = {4,0,9,1,2,3,2,8};
     * int t4[] = {9,1,0,1,2,3,2,5,7};
     * poista(t1,6,9) === 3;
     * poista(t2,7,5) === 5;
     * poista(t3,8,2) === 6;
     * poista(t4,9,0) === 8;
     * </pre>
     */
    public static int poista(int[] taulukko, int lkm, int n) {
        int[] t = new int[lkm];
        int apu=0;
        for (int i = 0; i < lkm; i++) {
            if(taulukko[i] != n) {
           t[apu] = taulukko[i];
           apu++;
            }
        }
        for (int i = 0; i < taulukko.length; i++) {
            if(t[i] != 0) taulukko[i] = t[i];
        }
        return apu;
    }
       
   
    /**
     * Tulostetaan taulukosta lkm kappaletta lukuja
     * @param t käsiteltävä taulukko
     * @param lkm käsitelteltävien alkioiden lkm
     */
    public static void tulosta(int t[], int lkm) {
        int tlkm = lkm;
        if (tlkm > t.length) tlkm = t.length;
        for (int i = 0; i < tlkm; i++)
            System.out.print(t[i] + " ");
        System.out.println();
    }

    
    /**
     * @param args nope
     */
    public static void main(String[] args) {
        int t[] = { 4, 7, 6, 3, 6, 2 };
        int lkm = 6;
        
        int t2[] = {9,9,9,1,2,3};
        int lkm2 = poista(t2,6,9);

        lkm = poista(t, lkm, 6); /* => t = {4,7,3,2}, lkm = 4 */
        tulosta(t, lkm);
        tulosta(t2,lkm2);
    }
}