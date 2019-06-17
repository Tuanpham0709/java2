/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author HP
 */
public abstract class Employee {
    private String fullName;
    public Employee(String fullName){
        this.fullName  = fullName;
    }
    public abstract double getSalary();
    public void print(){
        System.out.println("Fullname: " + fullName);
        System.out.println("Salary: "+ getSalary());
    }
}
