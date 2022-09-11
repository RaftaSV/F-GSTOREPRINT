/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FGSTORE.Entidades;

/**
 *
 * @author rafap
 */

import lombok.Data;

@Data
public class Proveedor {
	private long idProveedor;
	private String Nombre;
	private String Telefono;
	private int estadoproveedor;
	public long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public int getEstadoproveedor() {
		return estadoproveedor;
	}
	public void setEstadoproveedor(int estadoproveedor) {
		this.estadoproveedor = estadoproveedor;
	}
	


}
