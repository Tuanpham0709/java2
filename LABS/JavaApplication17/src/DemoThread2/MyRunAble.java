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
public class MyRunAble implements Runnable {

    @Override
    public void run() {
        int i =0 ;
        for(i = 0; true; i++){
            try {
                Thread.sleep(1000);
                System.out.println(i);  
            } catch (Exception e) {
                break;
            }
        }
        
    }
    
    
}
