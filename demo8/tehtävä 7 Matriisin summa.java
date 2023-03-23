package demo.d8;

/**
 * @author Harri Keränen
 * @version 25.2.2020
 *
 */
public class Taulukot2 {

   /**
 * @param args nope
 */
public static void main(String[] args) {
       int matriisiA[][] = { { 2,3,4,5 },{6,7,8,9} };
       System.out.println("Matriisin summa on " + summa(matriisiA));
       int matriisiB[][] = { { 10,20,30,40 },{ 50,60,70,80 } };
       System.out.println("Matriisin summa on " + summa(matriisiB));
   }

   /**
 * @param matriisi tutkittava matriisi
 * @return matriisin summa
 * @example
 * <pre name="test">
 * int matriisi1[][] = { { 2,3,4,5 },{6,7,8,9} };
 * summa(matriisi1) === 44;
 * int matriisi2[][] = { { 1,2,3,4,5 },{ 6,7,8,9,10 } };
 * summa(matriisi2) === 55;
 * int matriisi3[][] = { { -1,-2,-3,-4 },{ 5,6,7,8 } };
 * summa(matriisi3) === 16;
 * int matriisi4[][] = { { 0 },{ 0 } };
 * summa(matriisi4) === 0;
 * int matriisi5[][] = { {  },{ 1 } };
 * summa(matriisi5) === 1;
 * </pre>
 */
public static int summa (int[][] matriisi) {
    int summa = 0;
    int rivi = matriisi.length;
    for (int i = 0; i < rivi; i++) {
        int sarake = matriisi[i].length;
        for (int j = 0; j < sarake; j++)
            summa += matriisi[i][j];
    }
    return summa;
   }
   
   ///VOIDAAN TEHDÄ MYÖS FOREACHILLA
   /**
     * Lasketaan matriisin alkioiden summa foreach-silmukalla
     * @param mat matriisi jonka summa lasketaan
     * @return alkioiden summa
     * @example
     * <pre name="test">
     *    double mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
     *    summa(mat) ~~~ 36; 
     *    double mat0[][] = { {  }, {  } };
     *    summa(mat0) ~~~ 0; 
     *    double mat2[][] = { { 1, 2, 3 }, { 5 } };
     *    summa(mat2) ~~~ 11; 
     * </pre>
     
    public static double summa(double mat[][]) {
        double summa = 0;
        for (double[] rivi : mat) 
            for (double luku : rivi)
                summa += luku;
        return summa;
    }
	*/
}