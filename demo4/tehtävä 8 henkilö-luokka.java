package demo.d4;

/**
 * @author Harri Keränen
 * @version 29.1.2020
 * Ohjelma palauttaa henkilön ja hänen syntymävuotensa
 */
public class Henkilo {
    
    private String en; //attribuutteja 4 kpl
    
    private String sn;
    
    private int vuosi;
    
    private String nimi;
    
    private Henkilo(String en, String sn, int vuosi) { //muodostetaan henkilö       
        this.en = en; //etunimi
        this.sn = sn; //sukunimi
        this.nimi = en + " " + sn; //luodaan etu- ja sukunimen yhdistelmä
        this.vuosi = vuosi; //syntymävuosi
    }
        
    private String getNimi() { //metodi nimen hankinnalle
        return this.nimi;
    }
    
    private int getSyntymavuosi() { //metodi syntymävuoden hankinnalle
        return this.vuosi;
    }
    
    @Override
    public String toString() { //luodaan henkilön tiedot erikseen käyttämällä etunimeä, sukunimeä ja syntymävuotta
        return String.format("%s|%s|%s", this.en, this.sn, this.vuosi); //palauttaa tiedot merkkijonon muodossa
    }

    /**
     * @param args ei käytössä
     */
    public static void main (String[] args) {
        Henkilo aku = new Henkilo("Aku", "Ankka", 1934);        
        System.out.println(aku.getNimi());  // tulostaa Aku Ankka
        System.out.println(aku.getSyntymavuosi());  // tulostaa 1934
        System.out.println(aku.toString()); // tulostaa Aku|Ankka|1934
        }
}