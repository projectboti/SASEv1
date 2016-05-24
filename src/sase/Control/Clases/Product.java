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
    private String cod_prod, nombre, descripcion;
    private int stock,categoria_id, precio;

    public Product() {
    }

    public Product(String cod_prod, String nombre, String descripcion, int stock, int categoria_id, int precio) {
        this.cod_prod = cod_prod;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.categoria_id = categoria_id;
        this.precio = precio;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
}
