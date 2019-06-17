/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesstcalss;

/**
 *
 * @author HP
 */
public class Cat {

    /**
     * @param args the command line arguments
     */
 String name;
 int age;
 String gt;
 

    public String  getgt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }
 
    public Cat(){
        
    }
    public Cat(String name, int age, String gt) {
        this.name = name;
        this.age = age;
        this.gt = gt;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
 
}
