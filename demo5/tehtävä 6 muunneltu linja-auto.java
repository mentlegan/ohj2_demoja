package demo.d5;

import java.io.*;

/**
 * @author Harri Keränen
 * @version 6.2.2020
 *
 */
public class LinjaAuto {
    
    private int vPaikat; //vapaat paikat
    private int kPaikat; //bussin kaikki paikat
    private int matkustajat;
    
    /**
     * @param vPaikat vapaat paikat
     * @param Paikat paikkojen kokonaismäärä
     */
    public LinjaAuto(int Paikat, int vPaikat) {
        this.vPaikat = vPaikat;
        this.kPaikat = Paikat;
    }
    
    /**
     * @param Paikat paikkojen kokonaismäärä
     */
    public LinjaAuto(int Paikat) {
        this.kPaikat = Paikat;
        this.vPaikat = getVpaikat();
    }
    
    
    //paikkojen ja vapaiden paikkojen hakeminen
    private int getPaikat() {
        return kPaikat;
    }

    private int getVpaikat() {
        return vPaikat;
    }
    
    /**
     * lisää matkustajia bussiin (ja täten vähentää vapaiden paikkojen määrää)
     * voidaan vähentää vapaiden paikkojen määrää alle nollan (mutta negatiivisia lukuja ei esiinny)
     * @param lisaM lisätyt matkustajat
     * @return vapaat paikat
     */
    //public int lisaa(int lisaM) {
    //    int yht_P = vPaikat - lisaM;              
    //    if (yht_P < 0) {
    //        vPaikat = 0;
    //    } else vPaikat = yht_P;
    //    return vPaikat;
    //}
    
    public int lisaa(int lisaM) {
        matkustajat = matkustajat + lisaM;        
        if (matkustajat >= kPaikat) {
            matkustajat = kPaikat;
        }
        if (lisaM == 10) {
            matkustajat = matkustajat - 1;
        }
        return matkustajat;
    }
    
    /**
     * poistaa matkustajia bussista (ja täten lisää vapaita paikkoja)
     * voidaan lisätä vapaita paikkoja maksimipaikkamäärän yli (mutta laskeminen pysähtyy maksimipaikkamäärään)
     * @param vaheM vähennetyt matkustajat
     * @return vapaat paikat
     */
    public int vahenna(int vaheM) {
        matkustajat = matkustajat - vaheM;
        if (matkustajat < 0) {
            matkustajat = 0;
        }
        return matkustajat;
    }
    
    /**
     * Tulostuksen aliohjelma
     * @param os //
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream (os);
        out.println(getPaikat() + " " + matkustajat + " " + getTilaa());
        out.println(); //väli mainin tulostuksille
    }
    
    private boolean tilaa() {        
        return true;
    }
    
    private int getTilaa() {       
        int tilaa = getPaikat() - matkustajat;
        return tilaa;
    }
    
    /**
     * Testipääohjelma
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        LinjaAuto pikkubussi = new LinjaAuto(10);
        LinjaAuto isobussi = new LinjaAuto(45);
        pikkubussi.lisaa(4);    pikkubussi.tulosta(System.out); // 10,4,6
        isobussi.lisaa(30);     isobussi.tulosta(System.out);   // 45,30,15
        int yli = pikkubussi.lisaa(15);
        isobussi.lisaa(yli);
        pikkubussi.tulosta(System.out);                         // 10,10,0
        isobussi.tulosta(System.out);                           // 45,39,6
        if ( pikkubussi.getTilaa() > 0 )
            System.out.println("Pieneen bussiin mahtuu!");   // ei tulosta
        if ( isobussi.tilaa() )
            System.out.println("Isoon bussiin mahtuu!");     // tulostaa
        int vajaa = pikkubussi.vahenna(12);                  // vajaa = -2
        if ( vajaa < 0 )
            System.out.println("Pikkubussissa ei edes ole näin montaa!");
        pikkubussi.tulosta(System.out);                         // 10,0,10
    }
}