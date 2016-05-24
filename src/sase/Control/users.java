/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sase.Control;

/**
 *
 * @author VAIO
 */
public class users {
    
    private String user;
    private String name;
    private String last_name;
    private int type;

    public users(){
        
    }
    public users(String user, String name, String last_name, int type) {
        this.user = user;
        this.name = name;
        this.last_name = last_name;
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    
    
    
}
