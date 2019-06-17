/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwrite.bai2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */

public class Tienich {

    public static boolean writeFile(String data, String fileName){
              // TODO add your handling code here:
            FileWriter fv;
        try {
            fv = new FileWriter(fileName);
            fv.write(data);
              fv.flush();
                fv.close();
              return true;
            
        } catch (Exception e) {
            throw new RuntimeException();
        }

        
    }
    public static String  readFile(String fileName){
        try {
            FileReader fr =new FileReader(fileName);
            int c;
            String data ="";
            while ((c= fr.read()) != -1){
                data += (char) c;
            }
            fr.close();
            return data;
            
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
