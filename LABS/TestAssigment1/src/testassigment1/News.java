/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testassigment1;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class News implements Serializable{
    private String id;
    private String title;
    private String date;
    private String type;
    private String time;

    public News(String ID, String Title, String Date, String type, String time) {
        this.id = ID;
        this.title = Title;
        this.date = Date;
        this.type = type;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public News(){
        
    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    @Override
    public String toString() {
        return "News{" + "id=" + id + ", title=" + title + ", date=" + date + ", type=" + type + ", time=" + time + '}';
    }

   
    
}
