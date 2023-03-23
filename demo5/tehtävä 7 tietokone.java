package demo.d5;

import java.io.*;

/**
 * @author Harri Keränen
 * @version 7.2.2020
 * Ohjelma tulostaa tietokoneen tiedot
 */
public class Tietokone {
    
    private String muisti;
    private int kovalevy;
    private String valmistaja;
    private String malli;
    private String kayttis;
    
    /**
     * Muodostaja
     * @param muisti tietokoneen muisti
     * @param kovalevy kovalevy
     * @param valmistaja valmistaja
     * @param malli malli
     * @param kayttis käyttöjärjestelmä
     */
    public Tietokone(String muisti, int kovalevy, String valmistaja, String malli, String kayttis) {
        this.muisti = muisti;
        this.kovalevy = kovalevy;
        this.valmistaja = valmistaja;
        this.malli = malli;
        this.kayttis = kayttis;
        
    }
    
    //getterit tiedoille
    private String GetMuisti() {
        return muisti;        
    }
    
    private int GetKv() {
        return kovalevy;
    }
    
    private String GetValmistaja() {
        return valmistaja;        
    }
    
    private String GetMalli() {
        return malli;
    }
    
    private String GetKayttis() {
        return kayttis;
    }
    
    /**
     * Tulostusaliohjelma
     * @param os ""
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream (os);
        out.println("Tietokoneen muistissa on " +  GetMuisti()); 
        out.println("Kovalevyn koko on " + GetKv());
        out.println("Valmistaja: " + GetValmistaja());
        out.println("Malli: " + GetMalli());
        out.println("Käyttöjärjestelmä: " + GetKayttis());
        out.println(); //väli mainin tulostuksille
    }
    
    //palauttaa tiedot merkkijonon muodossa
    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s", this.muisti, this.kovalevy, this.valmistaja, this.malli, this.kayttis);
    }
    
    /**
     * Testipääohjelma
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Tietokone kessu = new Tietokone("8mb", 2, "Apple", "iAbomination", "ios");
        System.out.println(kessu.toString());
        kessu.tulosta(System.out);
        
        Tietokone huonoThinkPad = new Tietokone("16mb", 3, "Lenovo", "ThinkPad 430", "Windows");
        System.out.println(huonoThinkPad.toString());
        huonoThinkPad.tulosta(System.out);
    }    
}