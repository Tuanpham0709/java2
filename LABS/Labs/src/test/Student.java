/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author HP
 */
public class Student {
    public String name;
    public double point;
    public Student (){
        this.name ="";
        this.point= 0;
    }
    public String getGrade(){
        if(this.point < 3){
            return "Kem";
        }else if(this.point < 5){
            return "Yeu";
        }else if (this.point < 6.5){
            return "Trung binh";
            
        }else if (this.point < 7.5){
            return "Kha";
        }else if(this.point < 9){
            return "Gioi";
        }else{
            return "Xuat sac";
        }
                
    }
    public boolean isBonus(){
        return this.point > 7.5;
    }
    
    
    
}
