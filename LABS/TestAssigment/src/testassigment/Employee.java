/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testassigment;

/**
 *
 * @author HP
 */
public class Employee {
    String mnv;
    String name;
    int age;
    String ngoaingu;

    public Employee(String mnv, String name, int age, String ngoaingu) {
        this.mnv = mnv;
        this.name = name;
        this.age = age;
        this.ngoaingu = ngoaingu;
    }
    public Employee(){
        
    }

    public String getMnv() {
        return mnv;
    }

    public void setMnv(String mnv) {
        this.mnv = mnv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNgoaingu() {
        return ngoaingu;
    }

    public void setNgoaingu(String ngoaingu) {
        this.ngoaingu = ngoaingu;
    }
    public String getTuoilaodong(int tuoi){
        if(tuoi < 18){
            return "Chua truong thanh";
        }else if(tuoi < 40){
            return "Tuoi tre";
        }else if(tuoi< 60){
            return "Tuoi sap ve huu";
        }else {
            return "Tuoi gia";
        }
    }
    
    
}
