/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignementjava;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Employee implements Serializable{
    private String employeeCode, name, email;
    int age;
    long salary;

    public Employee(String employeeCode, String name, String email, int age, long salary) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.email = email;
        this.age = age;
        this.salary = salary;
    }
    public Employee(){
        
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeCode=" + employeeCode + ", name=" + name + ", email=" + email + ", age=" + age + ", salary=" + salary + '}';
    }
    
    public void getTime(){
        
    }
    
    
    
    
    
}
