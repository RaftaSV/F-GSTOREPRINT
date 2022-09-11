package com.FGSTORE.DAO;


import com.FGSTORE.Entidades.DetallesFacturas;
import com.FGSTORE.Entidades.Facturas;
import com.FGSTORE.Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Rafael
 */
public class ClsDetallesFactura {
	
	
	

    Conexion con = new Conexion();
    Connection conectar = con.retornarConexion();
    
   
   
   
   public ArrayList<DetallesFacturas> MostrarDetalles(Facturas f) {
       ArrayList<DetallesFacturas> lista = new ArrayList<>();
       try {
           CallableStatement call = conectar.prepareCall("call SP_S_DETALLES(?)");
           call.setDate("pFecha", new java.sql.Date(f.getFecha().getTime()));
           ResultSet resultado = call.executeQuery();
           while (resultado.next()) {
        		 DetallesFacturas  det = new DetallesFacturas();
        		 det.setIdDetalles(Integer.parseInt(resultado.getString("iddetallefactura")));
    			 det.setCantidad(Integer.parseInt(resultado.getString("cantidad")));
    			 det.setNombre(resultado.getString("nombre"));
    			 det.setCosto(Double.parseDouble(resultado.getString("Costo")));
    			 det.setTotal(Double.parseDouble(resultado.getString("total")));
    			 det.setGanancia(Double.parseDouble(resultado.getString("Ganancia")));
    			 lista.add(det);	
    			 
           }
       } catch (Exception e) {
           System.out.println("Error" + e);
       }

       return lista;
   }
    
    

    public void insertarDetalle(DetallesFacturas detalle) {
        try {
            CallableStatement call = conectar.prepareCall("call SP_I_DETALLEFACTURA(?,?,?,?)");
            call.setDouble("pCosto", detalle.getPrecioventa());
            call.setInt("pCantidad", detalle.getCantidad());
            call.setInt("pidProducto", detalle.getId_Producto());
            call.setInt("pidfactura", detalle.getId_Factura());
            call.executeQuery();
            conectar.close();
            System.out.println("Guardado exitoso detalle");
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }
    
    public ArrayList<DetallesFacturas> ganancias (Facturas f) {
        ArrayList<DetallesFacturas> lista = new ArrayList<>();
        try {
            CallableStatement call = conectar.prepareCall("call SP_S_TOTAL(?)");
            call.setDate("pFecha", new java.sql.Date(f.getFecha().getTime()));
            ResultSet resultado = call.executeQuery();
            while (resultado.next()) {
         		 DetallesFacturas  det = new DetallesFacturas();
     			 det.setTotal(Double.parseDouble(resultado.getString("Venta")));
     			 det.setGanancia(Double.parseDouble(resultado.getString("Ganancia")));
     			 lista.add(det);	
     			 
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        return lista;
    }
    
    public void EliminarProducto(DetallesFacturas pro) {
        try {
            CallableStatement call = conectar.prepareCall("call SP_D_DETALLE(?)");
            call.setInt("pId", (int) pro.getIdDetalles());
            call.execute();
            System.out.println("Eliminar Exitosa");     
            conectar.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<DetallesFacturas> listaDetallesFacturas(int id) {
        ArrayList<DetallesFacturas> detalles = new ArrayList<>();

        try {
            CallableStatement cs = conectar.prepareCall("call SP_DETALLES(?)");
            cs.setInt("pId", id);
            ResultSet resultado = cs.executeQuery();
            while (resultado.next()) {
                DetallesFacturas detallesfactura = new DetallesFacturas();
                detallesfactura.setCantidad(Integer.valueOf(resultado.getString("cantidad")));
                detallesfactura.setNombre(resultado.getString("nombre"));
                detallesfactura.setPrecioventa(Double.parseDouble(resultado.getString("precioventa")));
                detallesfactura.setTotal(Double.parseDouble(resultado.getString("total")));
                detalles.add(detallesfactura);

            }

            

        } catch (Exception e) {
            System.out.println(e);
        }

        return detalles;
    }
     

}
