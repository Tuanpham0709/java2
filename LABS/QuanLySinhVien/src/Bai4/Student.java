/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

/**
 *
 * @author HP
 */
public class Student {
    public String name;
    public String major;
    public double mark;

    public Student(String name, String major, double mark) {
        this.name = name;
        this.major = major;
        this.mark = mark;
    }
     public String getGrade(){
        if(this.mark < 3){
            return "Kem";
        }else if(this.mark < 5){
            return "Yeu";
        }else if(this.mark < 6.5){
            return "Trung bingh";
        }else if(this.mark < 7.5){
            return "Kha";
        }else if(this.mark < 9){
            return "Gioi";
        }else {
            return "Xuat sac";
        }
    }
}
