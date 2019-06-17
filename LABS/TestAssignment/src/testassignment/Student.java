/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testassignment;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Student implements Serializable{
    String name;
    String nganhhoc;
    String diem;
    String ngaysinh;

    public Student(String name, String nganhhoc, String diem, String ngaysinh) {
        this.name = name;
        this.nganhhoc = nganhhoc;
        this.diem = diem;
        this.ngaysinh = ngaysinh;
    }
    public Student(){
        
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", nganhhoc=" + nganhhoc + ", diem=" + diem + ", ngaysinh=" + ngaysinh + '}';
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNganhhoc() {
        return nganhhoc;
    }

    public void setNganhhoc(String nganhhoc) {
        this.nganhhoc = nganhhoc;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    
    
    
}
