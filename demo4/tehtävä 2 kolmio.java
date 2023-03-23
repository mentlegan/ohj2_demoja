package demo.d4;

import java.lang.Math;

/**
 * @author Harri Keränen
 * @version 28.1.2020
 * tulostaa kolmion alan ja hypotenuusan
 * tehtävä 2
 */
public class Kolmio {

    /**
     * @param k1 kateetti 1
     * @param k2 kateetti 2
     * @return kolmion ala
     * Tämä funktio laskee mainissa annettujen kateettien perusteella kolmion pinta-alan
     * @example
    * <pre name="test">
    *  kolmionAla(50, 2) ~~~ 50;
    *  kolmionAla(3,4) ~~~ 6;
    *  kolmionAla(0,2) ~~~ 0;
    *  kolmionAla(9,8) ~~~ 36;
    *  kolmionAla(500,300) ~~~ 75000;
    *  kolmionAla(75,60) ~~~ 2250;
    *  kolmionAla(5,5) ~~~ 12.5;
    *  kolmionAla(9,4) ~~~ 18;
    *  kolmionAla(2,0) ~~~ 0;
    * </pre>
    */
    public static double kolmionAla(double k1, double k2) {
        double pintaala = k1 * k2 / 2; //lauseke pinta-alalle
        return pintaala;
    }

    /**
    * @param k1 kateetti 1
    * @param k2 kateetti 2
    * @return hypotenuusa
    * laskee pythagoran lauseen säännöllä suorakulmaisen kolmion hypotenuusan pituuden
    * @example
    * <pre name="test">
    * hypotenuusa(3,4) ~~~ 5.0;
    * hypotenuusa(6,8) ~~~ 10.0;
    * hypotenuusa(15,20) ~~~ 25.0;
    * hypotenuusa(10,24) ~~~ 26.0;
    * hypotenuusa(20,21) ~~~ 29.0;
    * hypotenuusa(18,24) ~~~ 30.0;
    * hypotenuusa(16,30) ~~~ 34.0;
    * hypotenuusa(21,0) ~~~ 21.0;
    * </pre>
    */
    public static double hypotenuusa(double k1, double k2) {
        double hypotenuusa = Math.sqrt(Math.pow(k1, 2) + Math.pow(k2, 2)); //lauseke hypotenuusan laskulle
        return hypotenuusa;       
    }
    
    /**
     * @param k1 kateetti 1
     * @param k2 kateetti 2
     * @param odotettuTulos "" 
     * @return palauttaa mahdollisen virheen
     */
    public static double testiHypotenuusa(double k1, double k2, double odotettuTulos) {
        double tulos = hypotenuusa(k1, k2);
        if (odotettuTulos == tulos) return 0;
        System.out.println("Testi hypotenuusalle: sqrt(" + k1+"^2 + " + k2 + "^2) = " + odotettuTulos + " on väärin, vastaukseksi piti tulla " + tulos);
        return 1;
    }
    
    /**
     * @param k1 kateetti 1
     * @param k2 kateetti 2
     * @param odotettuTulos ""
     * @return palauttaa mahdollisen virheen
     */
    public static double testiPintaala(double k1, double k2, double odotettuTulos) {
        double tulos = kolmionAla(k1, k2);
        if (odotettuTulos == tulos) return 0;
        System.out.println("Testi pinta-alalle: " + k1 + " * " + k2 + " / 2 = " + odotettuTulos + " on väärin, vastaukseksi piti tulla " + tulos);
        return 1;
    }
    
    /**
     * @param args ei käytössä
     * ohjelma ilmoittaa, jos kaikki aliohjelmakutsut saavat vastaukseksi oikean arvon
     */
    public static void main(String[] args) {
        int v = 0;
        v += testiHypotenuusa(3, 4, 5);
        v += testiHypotenuusa(10, 10, 9); //tästä tulee väärä vastaus, ohjelma ilmoittaa väärästä vastauksesta testi-aliohjelman mukaisesti
        v += testiHypotenuusa(6, 8, 10);
        v += testiHypotenuusa(5, 12, 13);
        v += testiHypotenuusa(9, 12, 15);
        v += testiHypotenuusa(8, 15, 17);
        v += testiHypotenuusa(12, 16, 20);
        v += testiPintaala(10, 10, 40); //tästä tulee väärä vastaus, ohjelma ilmoittaa tämän testi-aliohjelman mukaisesti
        v += testiPintaala(10, 10, 50);
        v += testiPintaala(10, 1, 5);
        v += testiPintaala(6, 7, 21);
        v += testiPintaala(100, 105, 5250);
        v += testiPintaala(22, 24, 264);
        v += testiPintaala(7000, 600, 2100000);
        
        if (v == 0) System.out.println("Ei virheitä! Kaikki oikein! :)");
    }   
}