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

    public int Login(String contraseña) {
        int ret = 0;
        try {
            this.ps = cn.prepareStatement("exec sp_login ?");
            this.ps.setString(1, contraseña);
            rs = ps.executeQuery();
            if (rs.next()) {
                ret = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
            ret = 0;
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public users usersData(String contraseña) {
        users data = new users();
        try {
            this.ps = cn.prepareStatement("EXEC USER_INFO ?");
            this.ps.setString(1, contraseña);
            rs = ps.executeQuery();
            if (rs.next()) {
                data.setName(rs.getString(1));
                data.setLast_name(rs.getString(2));
                data.setSecond_ln(rs.getString(3));
                data.setPhone(rs.getInt(4));
                data.setPassword(rs.getString(5));
                data.setAvalible(rs.getInt(6));
                data.setType(rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public boolean InsertStock(Product producto) {
        boolean ret = true;
        try {
            this.ps = cn.prepareStatement("EXEC SP_INSERT_STOCK ?, ?, ?, ?, ?");
            this.ps.setString(1, producto.getCod_prod());
            this.ps.setString(2, producto.getNombre());
            this.ps.setInt(3, producto.getStock());
            this.ps.setInt(4, producto.getPrecio());
            this.ps.setInt(5, producto.getxMayor());
            if (ps.executeUpdate() == 0) {
                ret = false;
            }

        } catch (Exception e) {
            ret = false;
            System.out.println(e.getMessage());
        }
        return ret;
    }
    //SP_INSERT_USER(@NOMBRE VARCHAR(50), @AP_PAT VARCHAR(50), @AP_MAT VARCHAR(50), @FONO INTEGER, @CONTRASEÑA VARCHAR(30), @VIGENTE INTEGER, @TIPO INTEGER)

    public boolean InsertUser(users usuario) {
        boolean ret = true;
        try {
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
            if (ps.executeUpdate() == 0) {
                ret = false;
            }

        } catch (Exception e) {
            ret = false;
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public Product foundProduct(String codigo) {
        Product data = new Product();
        try {
            this.ps = cn.prepareStatement("EXEC FOUND_PROD ?");
            this.ps.setString(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                data.setCod_prod(rs.getString(1));
                data.setNombre(rs.getString(2));
                data.setStock(rs.getInt(3));
                data.setPrecio(rs.getInt(4));
                data.setxMayor(rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public ResultSet showSales(String fechaDesde, String fechaHasta, String nombre, String ap_pat, String ap_mat, String medioPago) {
        int fechaDesdeHab = 0;
        String condition = "";
        String and = " and ";
        String primera = "vent.fecha between convert(datetime, '" + fechaDesde + "', 103) and convert(datetime, '" + fechaHasta + "', 103) ";
        String segunda = "us.nombre like '" + nombre + "%' ";
        String tercera = "us.ap_paterno like '" + ap_pat + "%' ";
        String cuarta = "us.ap_materno like '" + ap_mat + "%' ";
        String quinta = "vent.medio_pago = " + medioPago;
        String[] envia = new String[6];
        envia[0] = fechaDesde;
        envia[1] = fechaHasta;
        envia[2] = nombre;
        envia[3] = ap_pat;
        envia[4] = ap_mat;
        envia[5] = medioPago;
        int[] retornado = new int[6];
        retornado = this.validaVariablesVacias(envia);
        System.out.println(condition);

        for (int i = 0; i < retornado.length; i++) {
            if (retornado[i] != 0 && i == 0) {
                fechaDesdeHab = 1;
            } else if (retornado[i] != 0 && i == 1) {
                if (fechaDesdeHab > 0) {
                    condition = and + primera;
                }
            } else if (retornado[i] != 0 && i == 2) {
                condition = condition + and + segunda;
            } else if (retornado[i] != 0 && i == 3) {
                condition = condition + and + tercera;
            } else if (retornado[i] != 0 && i == 4) {
                condition = condition + and + cuarta;
            } else if (retornado[i] != 0 && i == 5) {
                condition = condition + and + quinta;
            }
        }

        String sql = "select vent.cod_venta, us.nombre ,us.ap_paterno, us.ap_materno, vent.monto, replace(convert(NVARCHAR, vent.fecha, 103), ' ', '/') as fecha, med.nombre as medio from venta vent, usuario us, medio_pago med where us.contraseña = vent.usuario and med.id = vent.medio_pago " + condition;
        try {            
            System.out.println(sql);
            this.ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();         
                   
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rs = null;
        }       
        return rs;
    }

    private int countSales(String condition) {
        int ret = 0;
        try {
            String sql = "select count(*) from venta vent, usuario us, medio_pago med "
                    + "where us.contraseña = vent.usuario and "
                    + "med.id = vent.medio_pago " + condition;
            this.ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                ret = Integer.parseInt(rs.getString(1));
            }
            rs.close();
        } catch (Exception e) {
            ret = 0;
            System.out.println(e.getMessage());
        }
        return ret;
    }

    private int[] validaVariablesVacias(String[] datos) {
        int[] ret = new int[6];
        for (int i = 0; i < datos.length; i++) {
            if (datos[i].trim().length() < 1) {
                ret[i] = 0;
            } else {
                ret[i] = 1;
            }
        }
        return ret;
    }

}
