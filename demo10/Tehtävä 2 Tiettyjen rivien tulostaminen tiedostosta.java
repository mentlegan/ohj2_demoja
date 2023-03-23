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
    
    /**
     * @param args nope
     * @throws IOException ei löydy
     */
    public static void main(String[] args) throws IOException {
        String file = "C:\\MyTemp\\ohj2\\demo10\\rivit.txt";
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(new File(file));
        
        ArrayList<String> lista = new ArrayList<String>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lista.add(line);         
        }
        
        for (String string : lista) {
            if (string.startsWith("**")) {
                System.out.println(string);
            }
        }
    }
}

