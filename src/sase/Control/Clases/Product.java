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
public class Product {
    private String cod_prod, nombre;
    private int stock, precio, xMayor;

    public Product() {
    }

    public Product(String cod_prod, String nombre, int stock, int precio, int xMayor) {
        this.cod_prod = cod_prod;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.xMayor = xMayor;
    }

    public int getxMayor() {
        return xMayor;
    }

    public void setxMayor(int xMayor) {
        this.xMayor = xMayor;
    }

    public String getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(String cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
}
