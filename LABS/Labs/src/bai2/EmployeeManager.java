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
public class EmployeeManager {
    public static void main(String [] args){
        Employee obj = new Employee("Pham Mih Tuan"){
            @Override
            public double getSalary(){
                return 2000000;
            }
            
            
    };
      obj.print();
    }
}
