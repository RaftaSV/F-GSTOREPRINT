/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FGSTORE.Entidades;
import lombok.Data;

/**
 *
 * @author rafap
 */

@Data
public class Productos extends Proveedor{
	
	private long idProducto;
	private String Producto;
	private double precio;
	private double costo;
	private int Cantidad;
	private double preciodoc;
	private int estado;
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto() {
		return Producto;
	}
	public void setProducto(String producto) {
		Producto = producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public double getPreciodoc() {
		return preciodoc;
	}
	public void setPreciodoc(double preciodoc) {
		this.preciodoc = preciodoc;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	

}

