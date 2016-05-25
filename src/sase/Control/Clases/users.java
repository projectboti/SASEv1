/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sase.Control.Clases;

/**
 *
 * @author VAIO
 */
public class users {
    
    private String name, last_name, second_ln, password;
    private int phone, avalible, type;

    public users(){
        
    }

    public users(String name, String last_name, String second_ln, String password, int phone, int avalible, int type) {
        this.name = name;
        this.last_name = last_name;
        this.second_ln = second_ln;
        this.password = password;
        this.phone = phone;
        this.avalible = avalible;
        this.type = type;
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

    public String getSecond_ln() {
        return second_ln;
    }

    public void setSecond_ln(String second_ln) {
        this.second_ln = second_ln;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAvalible() {
        return avalible;
    }

    public void setAvalible(int avalible) {
        this.avalible = avalible;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
   
    
}
