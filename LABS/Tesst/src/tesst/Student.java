/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesst;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Student implements Serializable{
    String id;
    String name;
    double tuoi;
    public Student(){
        
    }

    public Student(String id, String name, double tuoi) {
        this.id = id;
        this.name = name;
        this.tuoi = tuoi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTuoi() {
        return tuoi;
    }

    public void setTuoi(double tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", tuoi=" + tuoi + '}';
    }
     
    
    
}
