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
    
    /**
     * @param vPaikat vapaat paikat
     * @param Paikat paikkojen kokonaismäärä
     */
    public LinjaAuto(int Paikat, int vPaikat) {
        this.vPaikat = vPaikat;
        this.kPaikat = Paikat;
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
     */
    public void lisaaMatkustaja(int lisaM) {
        int yht_P = vPaikat - lisaM;              
        if (yht_P < 0) {
            vPaikat = 0;
        } else vPaikat = yht_P;
    }
    
    /**
     * poistaa matkustajia bussista (ja täten lisää vapaita paikkoja)
     * voidaan lisätä vapaita paikkoja maksimipaikkamäärän yli (mutta laskeminen pysähtyy maksimipaikkamäärään)
     * @param vaheM vähennetyt matkustajat
     */
    public void vahennaMatkustaja(int vaheM) {
        int yht_P = vPaikat + vaheM;
        if (yht_P > kPaikat) {
            vPaikat = kPaikat;
        } else vPaikat = yht_P;
    }
    
    /**
     * Tulostuksen aliohjelma
     * @param os //
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream (os);
        out.println("Bussissa on yhteensä " + getPaikat() + " paikkaa, vapaita paikkoja on " + getVpaikat() + " kappaletta.");
        out.println(); //väli mainin tulostuksille
    }
    
    /**
     * Testipääohjelma
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        LinjaAuto isoBussi = new LinjaAuto(45,25); //tässä bussissa on oletuksena yhteensä 45 paikkaa, ja vapaita paikkoja 25
        isoBussi.lisaaMatkustaja(5);
        isoBussi.vahennaMatkustaja(10);
                
        //pientä bonus-iffittelyä testaamista varten :P
        if (isoBussi.vPaikat <= 0) {
            System.out.println("Vapaita paikkoja ei ole!");
        }
        if (isoBussi.vPaikat == isoBussi.kPaikat) {
            System.out.println("Bussi on tyhjä!");
        }        
        isoBussi.tulosta(System.out);
        
        LinjaAuto pikkuBussi = new LinjaAuto(10,5); //voidaan asettaa uusi bussi
        pikkuBussi.tulosta(System.out);
    }
}