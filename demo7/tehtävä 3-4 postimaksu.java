package demo.d7;

/**
 * @author Harri Keränen
 * @version 19.2.2020
 * Funktiolle suurinKirjeenPaino voidaan antaa rahasumma.
 * Tämä funktio laskee rahasumman perusteella suurimman mahdollisen kirjeen painon,
 * jonka annetulla rahasummalla voidaan lähettää
 */
public class Postimaksu {

    /**
     * Palauttaa kirjeen painon annetun rahamäärän perusteella
     * @param raha rahamäärä
     * @return suurimman kirjeen paino
     * @example
     * <pre name="test">
     * suurinKirjeenPaino(0.00) === 0;
     * suurinKirjeenPaino(1.20) === 50;
     * suurinKirjeenPaino(1.50) === 100;
     * suurinKirjeenPaino(3.00) === 250;
     * suurinKirjeenPaino(5.00) === 500;
     * suurinKirjeenPaino(7.50) === 1000;
     * suurinKirjeenPaino(20.00) === 2000;
     * </pre>
     */
public static int suurinKirjeenPaino(double raha) {  
    int p[] = {50,100,250,500,1000,2000};
    int pituus = p.length;
    int paino = 0;
    for (int i = 0; i <= pituus; i++) {
        if (raha >= 1.00)
            paino = p[0];
        if (raha >= 1.40)
            paino = p[1];
        if (raha >= 2.00)
            paino = p[2];
        if (raha >= 4.00)
            paino = p[3];
        if (raha >= 6.00)
            paino = p[4];
        if (raha >= 10.00)
            paino = p[5];            
    }
    return paino;
}

    /**
     * @param args nope
     */
    public static void main(String[] args) {
        int kirje = suurinKirjeenPaino(11.00);
        System.out.println("Tällä rahamäärällä saa " + kirje + "-grammaa painavan kirjeen");
    }
}	
