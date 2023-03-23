package demo.d4;

/**
 * @author Harri Keränen
 * @version 30.1.2020
 * Ohjelma palauttaa demopisteiden hyvityksen
 */
public class Demo {

    /**
    * @param pisteet //
    * @param maksimi //
    * @return demopisteet
    * @example
    * <pre name="test">
    * demohyvitys(20,56) === 0;
    * demohyvitys(25,56) === 1;
    * demohyvitys(30,56) === 3;
    * demohyvitys(35,56) === 3;
    * demohyvitys(50,56) === 5;
    * demohyvitys(56,56) === 6;
    * </pre>
    */
    public static int demohyvitys(int pisteet, int maksimi) {
        int tulos = 0;
        for (double i = maksimi*0.4; i < maksimi; i+=maksimi*0.1) {
            if (pisteet < i) return tulos;
            tulos += 1;
        }
        return tulos;
    }
    
    /**
     * @param args ei käytössä     
     */
    public static void main(String[] args) {
        System.out.println(demohyvitys(22,56));
        System.out.println(demohyvitys(24,56));
        System.out.println(demohyvitys(35,56));
        System.out.println(demohyvitys(42,56));
        System.out.println(demohyvitys(56,56));
    }
}