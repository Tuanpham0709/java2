/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17;

/**
 *
 * @author HP
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        int i = 0;
        while(true){
            System.err.println(i++);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    
    
    
}
