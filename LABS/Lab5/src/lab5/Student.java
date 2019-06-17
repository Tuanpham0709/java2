/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Student implements Serializable{
    public String name;
    public double mark;
    public String major;

    public Student(String name, double mark, String major) {
        this.name = name;
        this.mark = mark;
        this.major = major;
    }
    public String getGrade(){
        if(this.mark < 3){
            return "Kems";
        }else if(this.mark <5){
            return "Yeu";
        }else if(this.mark < 6.5){
            return "trung binh";
        }else if(this.mark  < 7.5){
            return "kha";
        }else if(this.mark < 9){
            return "Gioi";
        }else {
            return "Xuat sac";
        }
    }
    public boolean isBonus(){
        return this.mark > 7.5;
    }
}
