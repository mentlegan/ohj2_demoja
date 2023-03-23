package demo.d8;

/**
 * @author Harri Keränen
 * @version 25.2.2020
 *
 */
public class Taulukot {

    //attribuutit tapa2:seen
    private static int N = 4;
    private static int M = 4;
    
   /**
 * @param args nope
 */
    public static void main(String[] args) {
       int matriisiA[][] = { { 2,3,4,5 },{ 6,7,8,9 } };
       System.out.println("Matriisin suurin alkio on " + suurin(matriisiA));
       
       int matriisiB[][] = { { 2, 4, 6, 8 },
                             { 1, 3, 5, 7 },
                             { 10, 20, 30, 40},
                             { 60, 50, 35, 45} };
       System.out.println("Matriisin suurin alkio on " + suurin2(matriisiB));
       
   }

    /**
     * tapa 1
     * etsitään molemmilta riveiltä suurin,
     * ja verrataan näitä kahta
     * @param matriisi tutkittava matriisi
     * @return matriisin suurin alkio vertaamalla
     * @example
     * <pre name="test">
     * int matriisi1[][] = { { 2,3,4,5 },{6,7,8,9} };
     * suurin(matriisi1) === 9;
     * int matriisi2[][] = { { 1,2,3,4,5 },{ 6,7,8,9,10 } };
     * suurin(matriisi2) === 10;
     * int matriisi3[][] = { { -1,-2,-3,-4 },{ 5,6,7,8 } };
     * suurin(matriisi3) === 8;
     * int matriisi4[][] = { { 0 },{ 0 } };
     * suurin(matriisi4) === 0;
     * int matriisi5[][] = { {  },{ 1 } };
     * suurin(matriisi5) === 1;
     * </pre>
     */
    public static int suurin (int[][] matriisi) {
           int rivi = matriisi[0].length;
           int rivi2 = matriisi[1].length;
           
           int suurin1 = Integer.MIN_VALUE;
           for (int i=0; i<rivi; i++) {
               if (matriisi[0][i] > suurin1)
                   suurin1 = matriisi[0][i];
           }
           
           int suurin2 = Integer.MIN_VALUE;
           for (int j=0; j<rivi2; j++) {
               if (matriisi[1][j] > suurin1)
                   suurin2 = matriisi[1][j];
           }
           
           if (suurin1 < suurin2) return suurin2;
           return suurin1;
       }

    /**
     * tapa 2
     * attribuuteilla saatu rivit
     * @param matriisi tutkittava matriisi
     * @return suurin alkio
     * @example
     * <pre name="test">
     * int matriisi1[][] = { { -2, -4, -6, -8 },
                             { -1, -3, -5, -7 },
                             { -10, -20, -30, -40},
                             { -60, -50, -35, -45} };
     * suurin2(matriisi1) === -1;
     * 
     * int matriisi2[][] = { { -2, 4, 6, 8 },
                             { 1, -3, 5, 7 },
                             { 10, -20, 30, 40},
                             { -60, -50, 35, 45} };
     * suurin2(matriisi2) === 45;
     * </pre>
     */
    public static int suurin2 (int[][] matriisi) {
        int suurin = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < M; j++) { 
                if (matriisi[i][j] > suurin) { 
                    suurin = matriisi[i][j]; 
                } 
            } 
        }
        return suurin;
    }
}