/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FGSTORE.Entidades;

import lombok.Data;

/**
 *
 * @author Rafael
 */
@Data
public class DetallesFacturas extends Productos{
	private int idDetalles;
	private int Id_Factura;
	private double precioventa;
	private int cantidad;
	private int Id_Producto;
	private double total;
	private double ganancia; 
	
	
	public int getIdDetalles() {
		return idDetalles;
	}
	public void setIdDetalles(int idDetalles) {
		this.idDetalles = idDetalles;
	}
	public int getId_Factura() {
		return Id_Factura;
	}
	public void setId_Factura(int id_Factura) {
		Id_Factura = id_Factura;
	}
	public double getPrecioventa() {
		return precioventa;
	}
	public void setPrecioventa(double precioventa) {
		this.precioventa = precioventa;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getId_Producto() {
		return Id_Producto;
	}
	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getGanancia() {
		return ganancia;
	}
	public void setGanancia(double ganancia) {
		this.ganancia = ganancia;
	}
	

	
	
}
