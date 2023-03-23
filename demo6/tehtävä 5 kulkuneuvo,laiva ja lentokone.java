package demo.d6;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Harri Keränen
 * @version 11.2.2020
 *
 */
public class Kulkuneuvo {
    
    /**
     * nopeus
     */
    protected String nopeus;
    /**
     * matkustajat
     */
    protected int matkustajat;
    
    /**
     * @return nopeus
     */
    protected String getNopeus() {
        return nopeus;
    }
    
    /**
     * @return matkustajat
     */
    protected int getMatkustajat() {
        return matkustajat;
    }
    
    /**
     * muodostaja
     */
    public Kulkuneuvo() {
        //
    }
    
    /**
     * @param nopeus ""
     * @param matkustajat ""
     */
    public Kulkuneuvo(String nopeus, int matkustajat) {
        this.nopeus = nopeus;
        this.matkustajat = matkustajat;
    }
    
    @Override
    public String toString() {
        return String.format("%s ja %s", this.nopeus, this.matkustajat);
    }
    
    /**
     * tulostusaliohjelma
     * @param os stuff and thangs
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream (os);
        out.println("Ajoneuvon nopeus on " + getNopeus());
        out.println("Ajoneuvoon mahtuu " + getMatkustajat() + " matkustajaa");
        out.println(); //väli
    }
    
    /**
     * varotaan muita
     */
    public void Varo() {
        System.out.println("???");
    }

    /**
     * @param args ei käytössä
     */
    public static void main (String[] args) {
        Kulkuneuvo auto = new Kulkuneuvo ("280km/h",5);
        System.out.println(auto.toString());
        auto.tulosta(System.out);
    }
}

/////

package demo.d6;

/**
 * @author Harri Keränen
 * @version 11.2.2020
 *
 */
public class Laiva extends Kulkuneuvo {
    
    private int miehistonMaara;
    
    private int getMiehistonmaara() {
        return miehistonMaara;
    }
    
    @Override
    public void Varo() {
        System.out.println("Jäävuori vältetty!");
    }
    
    /**
     * Mitä laivat tekevät?
     */
    public void Kellu() {
        System.out.println("Laivat kelluvat!");
    }
    
    private Laiva(String nopeus, int matkustajat, int miehistonMaara) {
        super(nopeus, matkustajat);
        this.miehistonMaara = miehistonMaara;
    }
    
    public static void main (String[] args) {
        Kulkuneuvo Titanic = new Laiva("23 solmua",2435,900);
        System.out.println(Titanic.toString()); //voidaan käyttää toString-metodia
        Titanic.tulosta(System.out); //voidaan käyttää tulosta-aliohjelmaa
        System.out.println("Laivan miehistön määrä on " + ((Laiva) Titanic).getMiehistonmaara());
        Titanic.Varo();
        ((Laiva) Titanic).Kellu();
    }
    
}

/////

package demo.d6;

/**
 * @author Harri Keränen
 * @version 11.2.2020
 *
 */
public class Lentokone extends Kulkuneuvo {
    
    private int miehistonMaara;
    
    private int getMiehistonmaara() {
        return miehistonMaara;
    }
    
    /**
     * voidaan varoa muita    
     */
    @Override
    public void Varo() {
        System.out.println("Lokkiparvi vältetty!");
    }
    
    /**
     * Mitä lentokoneet tekevät?
     */
    public void Lenna() {
        System.out.println("Lentokoneet lentävät!");
    }
    
    private Lentokone(String nopeus, int matkustajat, int miehistonMaara) {
        super(nopeus, matkustajat);
        this.miehistonMaara = miehistonMaara;
    }
    
    public static void main (String[] args) {
        Kulkuneuvo finnair = new Lentokone("560mp/h",300,15);
        finnair.tulosta(System.out); //voidaan käyttää tulosta-aliohjelmaa
        System.out.println("Lentokoneen miehistön määrä on " + ((Lentokone) finnair).getMiehistonmaara());
        finnair.Varo(); //voidaan varoa lokkeja
        ((Lentokone) finnair).Lenna();
    }
    
}
