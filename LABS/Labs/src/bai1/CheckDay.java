/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class CheckDay {

    public static void main(String [] args){
      int x = 1;
Integer y = 3;
ArrayList<Integer> a = new ArrayList<Integer>();
a.add(3);
a.add(9);
a.add(5);
a.remove(x);
a.remove(y);
for(int b:a){
    System.out.println(b);
}
        
    }
}
