package demo.d7;

import java.util.stream.IntStream;

/**
 * @author Harri Keränen
 * @version 21.2.2020
 *
 */
public class Taulukot {

   /**
    * @param taulukko käisteltävä taulukko
 * @return taulukon paras luku
 * @example
    * <pre name="test">
    * int[] taulukko = {25,50,75,100};
    * int[] taulukko2 = {-2,-1,0};
    * int[] taulukko3 = {1000,1001};
    * paras(taulukko) === 100;
    * paras(taulukko2) === 0;
    * paras(taulukko3) === 1001;
    * </pre>
    */
   public static int paras(int[] taulukko) {
       int pituus = taulukko.length;        
       int paras = Integer.MIN_VALUE;
       for (int i = 0; i < pituus; i++) {
           if (taulukko[i] > paras)
               paras = taulukko[i];
       }        
       return paras;
   }

   /**
    * @param taulukko käisteltävä taulukko
 * @return taulukon huonoin luku
 * @example
    * <pre name="test">
    * int[] taulukko = {25,50,75,100};
    * int[] taulukko2 = {-1,-2,-3};
    * int[] taulukko3 = {0,1,5,9};
    * huonoin(taulukko) === 25;
    * huonoin(taulukko2) === -3;
    * huonoin(taulukko3) === 0;
    * </pre>
    */
   public static int huonoin(int[] taulukko) {
       int pituus = taulukko.length;        
       int pienin = Integer.MAX_VALUE;
       for (int i = 0; i < pituus; i++) {
           if (taulukko[i] < pienin)
               pienin = taulukko[i];
       }        
       return pienin;
   }

   /**
    * @param taulukko käisteltävä taulukko 
 * @return taulukon lukujen summa
 * @example
    * <pre name="test">
    * int[] taulukko = {25,50,75,100};
    * int[] taulukko2 = {0,5,5,1000};
    * int[] taulukko3 = {10,10,7,3};
    * summa(taulukko) === 250;
    * summa(taulukko2) === 1010;
    * summa(taulukko3) === 30;
    * </pre>
    */
   public static int summa(int[] taulukko) {
       int summa = IntStream.of(taulukko).sum();
       return summa;
   }

   /**
    * @param taulukko käisteltävä taulukko
 * @return summa, kun huonoin ja paras poistetaan
 * @example
    * <pre name="test">
    * int[] taulukko = {25,50,75,100};
    * int[] taulukko2 = {0,1,2,1000};
    * int[] taulukko3 = {1,2,3,4,5,6,7,8,9,10};
    * summaHuonoinJaParasPois(taulukko) === 125;
    * summaHuonoinJaParasPois(taulukko2) === 3;
    * summaHuonoinJaParasPois(taulukko3) === 44;
    * </pre>
    */
   public static int summaHuonoinJaParasPois(int[] taulukko) {
       int summa = summa(taulukko);
       int pienin = huonoin(taulukko);
       int suurin = paras(taulukko);
       int tulos = summa - pienin - suurin;
       return tulos;
   }
   
/**
 * @param args nope
 */
public static void main(String[] args) {
       int[] taulukko = {1,2,3,4,5,6,7,8,9,10};
       System.out.println("Taulukon pienin numero on " + huonoin(taulukko));
       System.out.println("Taulukon suurin numero on " + paras(taulukko));
       System.out.println("Taulukon numeroiden summa on " + summa(taulukko));
       System.out.println("Taulukon numeroiden summa, kun isoin ja pienin numero poistetaan on " + summaHuonoinJaParasPois(taulukko));     
   }
}
