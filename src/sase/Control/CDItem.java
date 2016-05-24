/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sase.Control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sase.Connection.Connection;
import sase.Control.Clases.Category;

/**
 *
 * @author VAIO
 */
public class CDItem {

    private static Connection con = new Connection();
    private static java.sql.Connection cn = con.getConnection();
    private static String sql = "SELECT id, nombre FROM dbo.categoria"; 
    private static PreparedStatement ps;
    private static ResultSet rs = null;
    

    public static List listaItem() {
        try {
            setPs(cn.prepareStatement("SELECT id, nombre FROM dbo.categoria"));
            ResultSet rs = getPs().executeQuery();
            List<Category> oListItem=new ArrayList<Category>();
            while (rs.next()) {
                Category oItem = new Category();
                oItem.setId(rs.getInt("id"));
                oItem.setCategoria(rs.getString("nombre"));
                oListItem.add(oItem);
            }
            return oListItem;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static PreparedStatement getPs() {
        return ps;
    }

    public static void setPs(PreparedStatement ps) {
        CDItem.ps = ps;
    }
    
    
}
