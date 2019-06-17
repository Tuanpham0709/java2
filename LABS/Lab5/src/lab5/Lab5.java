/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.KeyCode;

/**
 *
 * @author HP
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(new Student("Tuan", 9.6, "CNTT"));
        listStudent.add(new Student("Tuan", 9.6, "CNTT"));
        listStudent.add(new Student("Tuan", 9.6, "CNTT"));
        listStudent.add(new Student("Tuan", 9.6, "CNTT"));
        listStudent.add(new Student("Tuan", 9.6, "CNTT"));
        
        Xfile.writeOject("Student.txt", listStudent);
        List<Student> list2 = (List<Student>) Xfile.readObject("Student.txt");
        for(Student st:list2){
            System.out.println(st.name + "\t" + st.major + "\t" + st.mark + "\n");
        }
        
    }
    
}
