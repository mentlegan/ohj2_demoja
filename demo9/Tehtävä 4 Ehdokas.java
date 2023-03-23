package demo.d9;

/**
 * @author Harri Keränen
 * @version 8.3.2020
 * stuff and things
 */
public class Ehdokas {

    private double raha;
    private int aani;
    
    /**
     * @param rahaa rahaa
     * @param aanet ääniä
     */
    public Ehdokas(double rahaa, int aanet) {
        raha = rahaa;
        aani = aanet;
    }
    
      
    /**
     * Ostometodi
     * Jos rahaa on riittäväsi, siirrytään ostamaan ääniä annetulla kpl hinnalla
     * Käytettävä rahamäärä (double hinta) vähennetään ehdokkaan saldosta, ja äänet lisätään ehdokkaalle
     * Metodi ei tee mitään, jos raha ei riitä
     * @param aanet ostettava äänimäärä
     * @param rahaKpl rahaa menee ääniin/kpl
     * @return true, jos osto menee läpi, returns false, jos rahat ei riitä
     * @example
     * <pre name="test">
     * Ehdokas ehd1 = new Ehdokas(0,0);
     * Ehdokas ehd2 = new Ehdokas(10000,100);
     * Ehdokas ehd3 = new Ehdokas(500000,100);
     * ehd1.osta(1,100) === false;
     * ehd2.osta(10,100) === true;
     * ehd3.osta(4000,100) === true;
     * ehd3.osta(10000,100) === false;
     * </pre>
     */
    public boolean osta(int aanet, double rahaKpl) {
        double hinta = rahaKpl * aanet;
        if (this.raha >= hinta) {          
            this.raha = raha - hinta;
            this.aani = aani + aanet;
            return true;
        }
        return false;
    }
    
    

    /**
     * Vertaa kahta ehdokasta keskenään äänimäärän perusteella
     * @param v verrattava ehdokas
     * @return -1, jos verrattava voittaa, 0 jos tasapeli, 1 jos verrattava häviää
     * @example
     * <pre name="test">
     * Ehdokas ehd1 = new Ehdokas(0,0);
     * Ehdokas ehd2 = new Ehdokas(10000,100);
     * (ehd1.compareTo(ehd2)) === -1;
     * Ehdokas ehd3 = new Ehdokas(0,1000);
     * Ehdokas ehd4 = new Ehdokas(0,100);
     * (ehd3.compareTo(ehd4)) === 1;
     * Ehdokas ehd5 = new Ehdokas(0,100);
     * Ehdokas ehd6 = new Ehdokas(0,100);
     * (ehd5.compareTo(ehd6)) === -0;
     * </pre>
     */
    public int compareTo(Ehdokas v) {
        if ( getAani() < v.getAani()) return -1;
        if ( getAani() > v.getAani()) return 1;
        return 0;
    }
    
     @Override
    public String toString() {
        return "Rahaa "+ raha+"0, ääniä " + aani;      
     }
    
    
    /**
     * @return rahaa
     */
    public double getRaha() {
        return raha;
    }
    
    
    /**
     * @return ääniä
     */
    public int getAani() {
        return aani;
    }
    /**
     * @param args nope
     */
    public static void main(String[] args)  {
        Ehdokas ehd1 = new Ehdokas(100000.0, 0);
        Ehdokas ehd2 = new Ehdokas(20000.0, 300);
        System.out.println(ehd1); // Tulostaa: Rahaa 100000.00, ääniä 0
        System.out.println(ehd2); // Tulostaa: Rahaa 20000.00, ääniä 300
        ehd1.osta(200, 100.0);    // Ostaa 200 ääntä, 100 mk/kpl
        System.out.println(ehd1); // Tulostaa: Rahaa 80000.00, ääniä 200
        boolean onnistui = ehd2.osta(300, 100);
        if (!onnistui) System.out.println("Rahat ei riitä :-)");
        System.out.println(ehd2); // Tulostaa: Rahaa 20000.00, ääniä 300
        if (ehd1.compareTo(ehd2) > 0) System.out.println("Ehdokas 1 voitti!");
        if (ehd1.compareTo(ehd2) < 0) System.out.println("Ehdokas 2 voitti!");
        if (ehd1.compareTo(ehd2) == 0) System.out.println("Tasapeli!");
                                  // Vertailu tehdään äänimäärien perusteella.
                                  // Esimerkissä tulostuu : Ehdokas 2 voitti!
    }
}
