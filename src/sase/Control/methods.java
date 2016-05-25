/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sase.Control;
import sase.Control.Clases.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sase.Connection.Connection;

/**
 *
 * @author VAIO
 */
public class methods {
    private Connection con = new Connection();
    private java.sql.Connection cn = con.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;

   public int Login(String contraseña){
       int ret = 0;
       try{
        this.ps = cn.prepareStatement("exec sp_login ?");
        this.ps.setString(1, contraseña);
        rs = ps.executeQuery();
        if(rs.next()){
            ret = Integer.parseInt(rs.getString(1));
        }
       }catch(Exception e){
           ret = 0;
           System.out.println(e.getMessage());
       }
     return ret;
    }    
   
   public users usersData(String contraseña){
       users data = new users();
       try{
           this.ps = cn.prepareStatement("EXEC USER_INFO ?");
           this.ps.setString(1, contraseña);
           rs = ps.executeQuery();
           if(rs.next()){
               data.setName(rs.getString(1));
               data.setLast_name(rs.getString(2));
               data.setSecond_ln(rs.getString(3));
               data.setPhone(rs.getInt(4));
               data.setPassword(rs.getString(5));
               data.setAvalible(rs.getInt(6));
               data.setType(rs.getInt(7));
           }
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return data;
   } 
   
   public boolean InsertStock(Product producto){
       boolean ret = true;
       try{
        this.ps = cn.prepareStatement("EXEC SP_INSERT_STOCK ?, ?, ?, ?, ?");
        this.ps.setString(1, producto.getCod_prod());
        this.ps.setString(2, producto.getNombre());
        this.ps.setInt(3, producto.getStock());
        this.ps.setInt(4, producto.getPrecio());
        this.ps.setInt(5, producto.getxMayor());
        if (ps.executeUpdate() == 0){
         ret = false;
        }
        
       }catch(Exception e){
           ret = false;
           System.out.println(e.getMessage());
       }
     return ret;
    }    
   //SP_INSERT_USER(@NOMBRE VARCHAR(50), @AP_PAT VARCHAR(50), @AP_MAT VARCHAR(50), @FONO INTEGER, @CONTRASEÑA VARCHAR(30), @VIGENTE INTEGER, @TIPO INTEGER)
   public boolean InsertUser(users usuario){
       boolean ret = true;
       try{
        this.ps = cn.prepareStatement("EXEC SP_INSERT_USER ?, ?, ?, ?, ?, ?, ?");
        this.ps.setString(1, usuario.getName());
           System.out.println(usuario.getName());
        this.ps.setString(2, usuario.getLast_name());
        System.out.println(usuario.getLast_name());
        this.ps.setString(3, usuario.getSecond_ln());
        System.out.println(usuario.getSecond_ln());
        this.ps.setInt(4, usuario.getPhone());
        System.out.println(usuario.getPhone());
        this.ps.setString(5, usuario.getPassword());
        System.out.println(usuario.getPassword());
        this.ps.setInt(6, usuario.getAvalible());
        System.out.println(usuario.getAvalible());
        this.ps.setInt(7, usuario.getType());
        System.out.println(usuario.getType());
        if (ps.executeUpdate() == 0){
         ret = false;
        }
        
       }catch(Exception e){
           ret = false;
           System.out.println(e.getMessage());
       }
     return ret;
    }    
}
