/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testassignment2;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class New  implements Serializable{
    String id;
    String title;
    String date;
    String type;
    String time;

    public New(String id, String title, String date, String type, String time) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.type = type;
        this.time = time;
    }

    @Override
    public String toString() {
        return "New{" + "id=" + id + ", title=" + title + ", date=" + date + ", type=" + type + ", time=" + time + '}';
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
    
    
    
    
}
