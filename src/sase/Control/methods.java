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
               data.setUser(rs.getString(1));
               data.setName(rs.getString(2));
               data.setLast_name(rs.getString(3));
               data.setType(Integer.parseInt(rs.getString(4)));
           }
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return data;
   }
   
   public DefaultComboBoxModel categoryData(){
       DefaultComboBoxModel model = new DefaultComboBoxModel();
       String[][] c = new String[this.cantidadCategorias()][2];
       int contador = 0;
       try{
           this.ps = cn.prepareStatement("SELECT id, nombre FROM dbo.categoria");
           rs = ps.executeQuery();
           while (rs.next()){
               /*c[contador][0] = rs.getString("id");
               c[contador][1] = rs.getString("id");
               contador = contador + 1;*/
               model.addElement(new Category(Integer.parseInt(rs.getString("id")), rs.getString("nombre")));
           }
       }catch(Exception e){
           System.out.println(e.getMessage());
       }      
       return model;
   }
   
   private int cantidadCategorias(){
       int ret = 0;
       try{
        this.ps = cn.prepareStatement("SELECT count(id) FROM dbo.categoria");
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
}
