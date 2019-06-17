/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author HP
 */
public class main {
    public static void main(String[] args){
        Map<String, Student> map = new HashMap<>();

        Student sv = new Student("TUan", "CNTT", 10);
        map.put(sv.name, sv);
        Set<String> keys = map.keySet();
        for(String name : keys){
        Student cc = map.get(sv.name);
        System.out.println(">Họ và tên: " + cc.name);
        System.out.println(">Học lực: " + cc.getGrade());
}
    }
}
