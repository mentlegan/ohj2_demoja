package demo.d4;

/**
 * @author Harri Keränen
 * @version 28.1.2020
 * vertaa lukua x ja lukua eps keskenään
 */
public class Tarkkuus {
    /**
     * @param x verrattava 1
     * @param eps verrattava 2
     * @return lukujen vertaus
     * @example
     * <pre name="test">
     * etumerkki(28.3,1) === 1;
     * etumerkki(1,2.3) === 0;
     * etumerkki(1,1) === 0;
     * etumerkki(-2,-1) === -1;
     * etumerkki(8,1) === 1;
     * </pre>
     */
     public static int etumerkki(double x, double eps) {                 
        if (x < -eps)
            return -1;
        
        if (x > eps)
            return 1;
                
        return 0;       
     }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        System.out.println(etumerkki(-2,-1));
        System.out.println(etumerkki(1,2.3));
        System.out.println(etumerkki(8,1));
    }   
}