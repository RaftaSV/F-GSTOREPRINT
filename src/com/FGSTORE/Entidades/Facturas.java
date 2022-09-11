/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.FGSTORE.Entidades;
import java.sql.Time;
import java.util.Date;

import lombok.Data;

/**
 *
 * @author Rafael
 */
@Data
public class Facturas {

	private int idFactura;
	private int Cajero;
	private Date Fecha;
	private int Cliente;
	private double Total;
	private int Estado;
	private String Clientes;
	private String Cajeros;
	private float efectivo;
	private float cambio;
	private Time hora;

	public String getClientes() {
		return Clientes;
	}

	public void setClientes(String clientes) {
		Clientes = clientes;
	}

	public String getCajeros() {
		return Cajeros;
	}

	public void setCajeros(String cajeros) {
		Cajeros = cajeros;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getCajero() {
		return Cajero;
	}

	public void setCajero(int cajero) {
		Cajero = cajero;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public int getCliente() {
		return Cliente;
	}

	public void setCliente(int cliente) {
		Cliente = cliente;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public int getEstado() {
		return Estado;
	}

	
	public float getEfectivo() {
		return efectivo;
	}

	public void setEfectivo(float efectivo) {
		this.efectivo = efectivo;
	}

	public float getCambio() {
		return cambio;
	}

	public void setCambio(float cambio) {
		this.cambio = cambio;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

}
