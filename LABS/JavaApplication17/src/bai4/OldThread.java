/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

/**
 *
 * @author HP
 */
public class OldThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
             try{
                 System.out.println(i);
                 Thread.sleep(1000);
             }catch(Exception e) {
                 break;
             }
                 
        }
    }

}
