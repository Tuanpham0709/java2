/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoThread2;

/**
 *
 * @author HP
 */
public class MainThread {
    public static void main(String [] args){
        Thread t1 = new Thread(new  MyRunAble());
        Thread t2 = new Thread(new  MyRunAble());
        t1.start();
        t2.start();
        
    }
    
    
}
