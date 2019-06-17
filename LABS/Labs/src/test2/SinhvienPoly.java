/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author HP
 */
public class SinhvienPoly {
    private String hoten, gioitinh;
    private double diem;

    public SinhvienPoly(String hoten, String gioitinh, double diem) {
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diem = diem;
    }

    public String getHoten() {
        return hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public double getDiem() {
        return diem;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "SinhvienPoly{" + "hoten=" + hoten + ", gioitinh=" + gioitinh + ", diem=" + diem + '}';
    }
    
    
}
