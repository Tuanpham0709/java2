/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2test;

/**
 *
 * @author HP
 */
public class Employee {
    private String id;
    private String name;
    private int age;
    public Employee(){
        this.id="";
        this.name="";
        this.age = 0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
    public String checkStatus(){
        if(this.age < 10){
            return "adult";
        }else if(this.age < 18){
            return "childrent";
        }else if(this.age < 60){
            return "young";
        }else {
            return "old";
        }
    }
    public boolean isBonnus(){
        return this.age >=18 && this.age <=60;
    }
    
}
