package demo.d4.fx;

import fi.jyu.mit.ohj2.Mjonot;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * @author OMISTAJA
 * @version 27.1.2020
 *
 */
public class IkaGUIController {
      
    @FXML private TextField Syote;
    
    @FXML private TextField Tulos;
    
    @FXML void KeyReleased() {
        laske();
    }
    
    /** Tämänhetkinen vuosi */
    public static final int tamaVuosi = 2020;
    
    /**
     * @param tamaVuosi1 käyttäjän syntymävuosi
     * @param vuosi syntymävuosi
     * @return paljonko käyttäjä täyttää
     */
    public static int vuodenMuutos (int tamaVuosi1, int vuosi) {
        return tamaVuosi1 - vuosi;   
    }
    
    /**
     * Haetaan tekstikentästä luku
     * @param text kenttä josta haetaan
     * @param oletus luvun arvo jos kentästä ei saa järkevää lukua
     * @return kentästä haettu luku
     * @example
     * <pre name="test">
     * #TOLERANCE=0.01
     * #import javafx.embed.swing.JFXPanel;
     * #import javafx.scene.control.*;
     * (new JFXPanel()).toString(); 
     * haeLuku(new TextField("234.233"), 44) ~~~ 234.23;
     * haeLuku(new TextField("foobar1"), 44) ~~~ 44.00;
     * haeLuku(new TextField("1foobar"), 44) ~~~ 1.00;
     * </pre>
     */
    public static int haeLuku(TextField text, int oletus) {
        int luku = Mjonot.erotaInt(text.getText(), oletus);
        return luku;
    }
    
    /**
     * Laittaa tekstikenttään tuloksen
     * @param text kenttä johon luku laitetaan
     * @param ika joka laitetaan kenttään
     */
    public static void laitaTulos(TextField text, int ika) {
        String tulos = String.format("%d", ika);
        //tulos = tulos.replace(',', '.');
        text.setText(tulos);
    }
    
    /**
     * Laskee iän tämän hetkisen vuoden ja annetun syntymävuoden perusteella
     */
    private void laske() {
        int vuosi = haeLuku(Syote, 0);
        int ika = vuodenMuutos(tamaVuosi, vuosi);
        laitaTulos(Tulos, ika);
    }
}