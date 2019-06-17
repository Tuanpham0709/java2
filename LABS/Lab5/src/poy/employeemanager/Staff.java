/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poy.employeemanager;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Staff implements Serializable{
    public String mName;
    public double mSalary;

    public Staff(String mName, double mSalary) {
        this.mName = mName;
        this.mSalary = mSalary;
    }
    public Staff(){
        
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public double getmSalary() {
        return mSalary;
    }

    public void setmSalary(double mSalary) {
        this.mSalary = mSalary;
    }
    
    
}
