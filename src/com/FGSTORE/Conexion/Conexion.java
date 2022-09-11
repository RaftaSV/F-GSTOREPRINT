/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FGSTORE.Conexion;

import com.mysql.cj.protocol.Message;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author rafap
 */
public class Conexion {
    	private Connection con;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/store?serverTimezone=UTC", "root", "root");
			System.out.println("CONECTADO A LA BD");

		} catch (Exception e) {
                    JOptionPane.showMessageDialog( null , "ERROR DE CONEXION A LA BD "+ e);
			
		}
	}

	public Connection retornarConexion() {
		return con;
	}
}
