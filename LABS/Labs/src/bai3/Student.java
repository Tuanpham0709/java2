/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

/**
 *
 * @author HP
 */
public class Student {
    public String name;
    public double marks;
    public String getGrade(){
        if(this.marks < 3){
            return "Kem";
        }else if(this.marks < 5){
            return "Yeu";
        }else if(this.marks < 6.5){
            return "Trung binh";
        }else if(this.marks < 7.5){
            return "Kha";
        }else if(this.marks < 9.0){
           return "Gioi";
        }else{
              return "Xuat sac"  ;
                }
    
    }
    public boolean isBonus(){
        return this.marks >=7.5;
    }
}
