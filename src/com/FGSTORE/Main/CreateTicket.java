/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FGSTORE.Main;


import com.FGSTORE.Entidades.*;
import com.FGSTORE.DAO.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.*;
import javax.print.*;
/**
 *
 * @author rafap
 */
public class CreateTicket {
     private static final DecimalFormat df = new DecimalFormat("0.00");
	public void imprimir(int id) {
	
		
		try {
			StringBuilder builder = new StringBuilder();
			
			 byte[] cutP = new byte[] { 0x1d, 'V', 1 };
			ClsFacturas f = new ClsFacturas();
                    ArrayList<Facturas> factura = f.Factura(id);
		  
		    //Definir el tamanho del papel para la impresion de dinamico y 32 columnas
		   int idFactura =0;
		                  Date fecha = null;
		                  Time hora =null;
		   String cajero = "";
		   String Cliente ="";
		   double total=0;
		   float efectivo=0;
		   float cambio=0;
		   String encabezado = "";
		   String cuerpo="";
		   String pie="";
		   // obtener los datos de la factura
		   for(Facturas i: factura) {
			  idFactura = i.getIdFactura();
			  fecha=i.getFecha();
			  hora = i.getHora();
			  cajero = i.getCajeros();
			  Cliente = i.getClientes();
			  total = i.getTotal();
			  efectivo= i.getEfectivo();
			  cambio = i.getCambio();
			  
		   }
		   
		   
		    //Imprimir = 1ra linea de la columa de 1 a 32
		   builder.append   ("                  F&G STORE" +"\n"); //Nombre establecimiento
		   builder.append   ("         3ra. Av. sur Barrio el Centro, " +"\n"); //Barrio
		   builder.append   ("         entre 6ta y 4ta calle poniente," +"\n"); //Direccion
		   builder.append   ("         Nueva Concepcion, Chalatenango" +"\n"); //Codigo Postal
		   builder.append   ("                Fecha: "+fecha.toString() +"\n"); //Aqui va la fecha de recibo
		   builder.append   ("                 Hora: "+hora.toLocalTime() +"\n"); //Aqui va la hora de recibo
		   builder.append   ("              Factura: "+idFactura +"\n"); //Numero del recibo - FACTURA O PEDIDO
		   builder.append   ("               Cajero: "+cajero +"\n"); //Nombre Cajero
		   builder.append   ("              Cliente: "+Cliente +"\n");//Nombre del Cliente
                    builder.append  ("             WhatsApp: 6308-2121" +"\n");//WhatsApp
		   builder.append   ("-----------------------------------------------" + "\n");
		   builder.append   ("                                               " + "\n");
		   
		   builder.append   ("CANT  DESCRIPCION                 VALOR  PRECIO " + "\n");
		    
		    ClsDetallesFactura det = new ClsDetallesFactura();
		    ArrayList<DetallesFacturas> detalle = det.listaDetallesFacturas(id);
		    //obtener los detalles de la factura
		    
		    for(DetallesFacturas i : detalle) {
		    //	System.out.println(i.getNombre());
		    	String cantidadProducto = String.valueOf(i.getCantidad());
		    	String nombreProducto = " "+i.getNombre().replace("ñ", "n");
		    	String precioUnidad = " "+ String.valueOf(df.format(i.getPrecioventa()));
		    	String totalProducto = " "+ String.valueOf(df.format(i.getTotal()));
		    	if (cantidadProducto.length()<4) {
		    		 while(cantidadProducto.length()<=4) {
		    			 
		    			 cantidadProducto= cantidadProducto+" ";
		    		 }
		    		
		    	}
		    	if(nombreProducto.length()<27) {
		    		while(nombreProducto.length()<=27) {
		    			nombreProducto = nombreProducto + " ";
		    		}
		  
		    	}else {
		    		nombreProducto = i.getNombre().substring(0, 26)+"  ";
		    	}
		    	
		    	if(precioUnidad.length()<6) {
		    		while(precioUnidad.length()<=6) {
		    			precioUnidad= precioUnidad+ " ";
		    		}
		    	}
		    	
		    	if(totalProducto.length()<7) {
		    		while(totalProducto.length()<+7) {
		    			totalProducto= totalProducto+ " ";
		    		}
		    	}
		    	
		    
		 	   builder.append ( cuerpo + cantidadProducto+ nombreProducto+precioUnidad+totalProducto+"\n");
		    	
		    	
		    }
		    
		builder.append  ( "\n"+ ("                            Total:  $" + String.valueOf(df.format(total)) +"\n"));
			   builder.append   ("                         Efectivo:  $"+ String.valueOf(df.format(efectivo))+"\n");
			   builder.append   ("                           Cambio:  $"+ String.valueOf(df.format(cambio)).replace("-", "")+"\n");
			   builder.append   ("-----------------------------------------------" + "\n");
			   builder.append  ("                                               " + "\n");
			   builder.append  ("            GRACIAS POR PREFERIRNOS             " + "\n");
			   builder.append  ("           ESPERAMOS TU PRONTA VISITA           " + "\n" +"\n");
			   builder.append  ("  Para efectuar cambios debe presentar ticket   "+"\n");
			   builder.append  ("           NO SE ACEPTAN DEVOLUCIONES           " +"\n");
			   builder.append  ("                                                "+ "\n");
			   builder.append  ("                                                "+"\n");
			   builder.append  ("                                                ."+"\n");
		   
		   
		    ///CREAR ARCHIVO EN CARPETA DEL PROYECTO PARA PEDIDOS
		    String path = "C:\\ticket\\impresion.txt";
		    //Guardamos es archivo en la ruta abterior
		    Files.write(Paths.get(path), builder.toString().getBytes());


		    FileInputStream inputStream = null;

		    try {
		    	//llamamos el archivo de la ruta 
		        inputStream = new FileInputStream(path);
		    } catch (FileNotFoundException ex) {
		        ex.printStackTrace();
		        System.out.println("Error al guardar");
		    }
		    if (inputStream == null) {
		        return;
		    }


		     DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;

		    Doc document = new SimpleDoc(inputStream, docFormat,null);
		    PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

		    if (defaultPrintService != null) {
		        DocPrintJob printJob = defaultPrintService.createPrintJob();
		        try {
		            printJob.print(document, null);
		            printClass printer = new printClass();

		            printer.printBytes(defaultPrintService.getName(), cutP);
		            inputStream.close();

		          //  JOptionPane.showMessageDialog(null, "imprimiendo");
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    } else {
		    	 //JOptionPane.showMessageDialog(null, "No existen impresoras instaladas");
		    	System.out.println("No existen impresoras instaladas");
		    }


		      
		   
		     } catch (Exception e) {
		    	// JOptionPane.showMessageDialog(null, "Error al imprimir "+ e);
		        System.out.println( "Error al imprimir "+ e);
		    }
        }
    
}
