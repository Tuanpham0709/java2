/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql.hocsinh;

/**
 *
 * @author HP
 */
public class Student {
    private String name,major;
    private double mark;
    public Student(){
        
    }
    public Student(String name, String major, double mark) {
        this.name = name;
        this.major = major;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public double getMark() {
        return mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", major=" + major + ", mark=" + mark + '}';
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
    public boolean isBonus(){
        return this.mark >=7.5;
    }
    
}
