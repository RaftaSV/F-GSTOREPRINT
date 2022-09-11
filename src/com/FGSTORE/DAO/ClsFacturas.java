package com.FGSTORE.DAO;


import com.FGSTORE.Entidades.Facturas;
import com.FGSTORE.Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;




/**
 *
 * @author Rafael
 */
public class ClsFacturas {
	
    Conexion con = new Conexion();
    Connection conectar = con.retornarConexion();
    public  ArrayList<Facturas> AgregarFactura(Facturas factura){
    	
    	ArrayList<Facturas> lista = new ArrayList<>();
        try {
        	CallableStatement eliminarVacios = conectar.prepareCall("call ELIMINARFACTURASVACIAS()");
        	eliminarVacios.execute();
            CallableStatement call = conectar.prepareCall("call SP_I_FACTURAS(?,?,?,?)");
            call.setInt("pIdCliente", factura.getCliente());
            call.setInt("pidCajero", factura.getCajero());
            call.setDouble("pTotal", factura.getTotal());
            call.setFloat("pEfectivo", factura.getEfectivo());
            ResultSet resultado = call.executeQuery();
            while(resultado.next()) {
            	   Facturas f = new Facturas();
            	f.setIdFactura(Integer.parseInt(resultado.getString("id"))); 
            	lista.add(f);
            }
           
            System.out.println("Factura guardada");
        } catch (Exception e) {
            System.out.println("error"+e);
        } 
        return lista;
    }
    
    
    public ArrayList<Facturas> Factura(int id) {
        ArrayList<Facturas> factura = new ArrayList<>();

        try {
            CallableStatement cs = conectar.prepareCall("call SP_DatosFactura(?)");
            cs.setInt("pId", id);
            ResultSet resultado = cs.executeQuery();
            while (resultado.next()) {
                Facturas facturas = new Facturas();
               
                facturas.setIdFactura(Integer.valueOf(resultado.getString("idfactura")));
                facturas.setFecha(java.sql.Date.valueOf(resultado.getString("fecha")));
                facturas.setTotal(Double.parseDouble(resultado.getString("Total")));
                facturas.setClientes(resultado.getString("nombre"));
                facturas.setCajeros(resultado.getString("usuario"));
                facturas.setEfectivo(Float.parseFloat(resultado.getString("efectivo")));
                facturas.setCambio(Float.parseFloat(resultado.getString("cambio")));
                facturas.setHora(java.sql.Time.valueOf(resultado.getString("hora")));
                factura.add(facturas);

            }

            

        } catch (Exception e) {
            System.out.println(e);
        }

        return factura;
    }

}
