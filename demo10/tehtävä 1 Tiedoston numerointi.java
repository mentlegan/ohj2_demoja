package demo.d10;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Harri Keränen
 * @version 16.3.2020
 */
public class Stuffandthings {
    
    private static int rivinro;
    
    /**
     * @param args nope
     * @throws IOException ei löydy
     */
    public static void main(String[] args) throws IOException {
        String file = "C:\\MyTemp\\ohj2\\demo10\\koe.txt";
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(new File(file));
        
        ArrayList<String> lista = new ArrayList<String>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lista.add(line);         
        }
        
        String[] lista2 = taulukoksi(lista);
        String tiedosto = tiedostoksi(lista2);
        
        System.out.println(tiedosto);
        
        //for (String string : lista2) {
        //    System.out.println(string);
        //}    
        
        
    }
    
    /**
     * @param rivit rivit
     * @return stuff and things
     */
    public static String tiedostoksi(String[] rivit) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < rivit.length; i++) {
            if (rivit[i] != null) {
                rivinro++;
                sb.append("/* "+ 0+ rivinro+" */ " + rivit[i]);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    private static String[] taulukoksi(ArrayList<String> lista) {
        String str[] = new String[lista.size()];
        for (int j = 0; j < lista.size(); j++) { 
            str[j] = lista.get(j); 
        } 
  
        return str;
    }
        
    
    //private static String erota(String[] lista) {
    //    StringBuffer sb = new StringBuffer();
    //    for (int i = 0; i < lista.length; i++) {            
    //        if (lista[i].length() <= 40) sb.append(lista[i]);
    //    }
    //    return sb.toString();
    //    
    //}
    
}
