/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class IOfile {
    public void ghi(Object o, String name){
        try (FileOutputStream jos = new FileOutputStream(new File(name))){
            ObjectOutputStream oss = new ObjectOutputStream(jos);
            oss.writeObject(o);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void ghiDS(ArrayList list, String name){
       try (FileOutputStream jos = new FileOutputStream(new File(name))){
            ObjectOutputStream oss = new ObjectOutputStream(jos);
            oss.writeObject(list);
            
        } catch (Exception e) {
            System.out.println(e);
        }
      
    }
    public ArrayList docDS(String name){
        ArrayList list = new ArrayList();
        try(FileInputStream fos = new FileInputStream(new File(name))) {
            ObjectInputStream obj = new ObjectInputStream(fos);
            list =(ArrayList) obj.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
        
    }
    public static void main(String [] args){
        ArrayList lista = new ArrayList();
        lista.add(new Student(20, "Pham tuan", "haf nooi", 10));
        lista.add(new Student(19, "Pham tuan", "haf nooi", 10));
        lista.add(new Student(18, "Pham tuan", "haf nooi", 10));
        lista.add(new Student(17, "Pham tuan", "haf nooi", 10));
        IOfile io = new IOfile();
        io.ghiDS(lista, "list.txt");
        ArrayList<Student> list = new ArrayList<>();
        list = io.docDS("list.txt");
        for(Student s: list){
            System.out.println(s.getTuoi() + s.getTen()+ s.getDiemTB());
        }
    }

    
}
