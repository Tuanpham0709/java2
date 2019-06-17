/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author HP
 */
public class NewClass {
    public static void main(String [] args){
           ArrayList<SinhvienPoly> listSv = new ArrayList<>();
         listSv.add(new SinhvienPoly("Phạm minh Tuấn", "Nam", 10));
        listSv.add(new SinhvienPoly("Hoàng hải nam", "Nam", 8));
        listSv.add(new SinhvienPoly("Nguyễn văn Hải", "Nam", 7));
        listSv.add(new SinhvienPoly("Trâm anh", " Nữ", 6));
        listSv.add(new SinhvienPoly("Nguyễn ý nhi", "Nữ", 8));
        Comparator <SinhvienPoly> com = new Comparator<SinhvienPoly>() {

               @Override
               public int compare(SinhvienPoly o1, SinhvienPoly o2) {
                   return o1.getHoten().compareTo(o2.getHoten());
               } 
           };
        Collections.sort(listSv, com);
        for(SinhvienPoly x: listSv){
            System.out.println(x);
        }
            
        
    }
    
}
