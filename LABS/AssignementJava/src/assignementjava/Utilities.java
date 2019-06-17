/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignementjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Utilities {

   

    public static void writeStudent(ArrayList<Employee> employee, String path){
        ObjectOutputStream oos  = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(employee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
           
        }
        
    }

    public static ArrayList<Employee> readStudent(String path)  {
        ObjectInputStream ois = null;
        ArrayList<Employee> listEMP = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            listEMP = (ArrayList<Employee>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listEMP;

        }

    }

}
