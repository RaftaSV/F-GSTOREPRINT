/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.FGSTORE.Main;

import com.FGSTORE.Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author rafap
 */
public class MainTicket {

    public static void main(String[] args) {
     
        
        Conexion con = new Conexion();
        Connection conectar = con.retornarConexion();
          CreateTicket create = new CreateTicket();
            String Idticket = "";
             CallableStatement call;
             ResultSet resultado;
              CallableStatement calla;
             
         while(true){
           
        try {
            Thread.sleep(500);
          call  = conectar.prepareCall("call SP_S_NUMTICKET()");
         resultado = call.executeQuery();
             while(resultado.next()) {
             Idticket = resultado.getString("IdFactura");
             calla  = conectar.prepareCall("call SP_U_NUMTICKET(?)");
             calla.setInt("pId", Integer.valueOf(Idticket));
             calla.executeQuery();
             }
            if(Idticket !=null){
            create.imprimir(Integer.valueOf(Idticket));
            System.out.println(Idticket);
            Idticket=null;
            }
        } catch (Exception e) {
            //System.out.println("Error data Base"+ e);   
        }
    }
    }
}
