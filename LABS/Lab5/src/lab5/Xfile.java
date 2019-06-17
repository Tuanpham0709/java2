/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 *
 * @author HP
 */
public class Xfile {
    public static String read(String path){
        try {
            FileInputStream fis = new FileInputStream(path);
            String data = "";
            int i  = 0;
            while((i=fis.read()) != -1){
                data  += (char)i;
            }
            fis.close();
            return data;
            
            
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static void write(String path, byte[] data){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(data);
            fos.close();
                  
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static Object readObject(String path){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            Object object = ois.readObject();
            ois.close();
            return object;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static void writeOject(String path, Object student){
        try {
            ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(path));
             oss.writeObject(student);
             oss.flush();
             oss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
