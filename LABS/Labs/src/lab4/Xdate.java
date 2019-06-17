/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.management.RuntimeErrorException;

/**
 *
 * @author HP
 */
public class Xdate {
    private static SimpleDateFormat fomater = new SimpleDateFormat();
    public static Date parse(String text , String parten) throws RuntimeException{
        try{
            fomater.applyPattern(parten);
            return fomater.parse(text);
        }catch(java.lang.Exception e){
            throw new RuntimeException(e);
        }
    }
    public static Date parse(String text) throws RuntimeException{
        return Xdate.parse(text, "dd-MM-yyyy");
    }
    
}
