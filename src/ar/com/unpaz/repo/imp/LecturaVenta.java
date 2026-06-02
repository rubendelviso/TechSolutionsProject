package ar.com.unpaz.repo.imp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import ar.com.unpaz.models.TipoVenta;
import ar.com.unpaz.models.Vendedor;
import ar.com.unpaz.models.Venta;
import ar.com.unpaz.models.VentaEfectivo;
import ar.com.unpaz.models.VentaTarjeta;
import ar.com.unpaz.repo.ILecturaVenta;
import ar.com.unpaz.service.IGestionVendedor;
import ar.com.unpaz.service.IGestionVentas;
import ar.com.unpaz.serviceImp.GestionVendedor;


public class LecturaVenta implements ILecturaVenta {
private List<Vendedor> listaDeVendedores;
	@Override
	public List<Venta> RetornarListaVentas() {
		List<Venta> listaDeVentas = new ArrayList<Venta>();
		File sfile = new File("Ventas.txt");
		String linea ="";
		//Creacion de la lista para vendedores 
		//La creo y la paso al constructor de gestion de vendedores(al final de la lectura del archivo)
		listaDeVendedores = new ArrayList<>();
		
		
		try {
			FileReader sreader = new FileReader(sfile);
			BufferedReader sbuffer = new BufferedReader(sreader);
			sbuffer.readLine();
			while((linea=sbuffer.readLine())!=null) {
				String[]partes = linea.split(";");
				int idVenta = Integer.parseInt(partes[0]);
				String producto = partes[2];
				String categoria = partes [3];
				int cantidad = Integer.parseInt(partes[4]);
				Double precioUnitario = Double.parseDouble(partes[5]);
				Double costoUnitario = Double.parseDouble(partes[6]);
				String vendedor = partes[7];

				String zona = partes[8];
				TipoVenta ventaRecibida = null;
				Double totalVenta = 0.0;
				Double Ganancia = 0.0;
				Double importeBruto = precioUnitario * cantidad;
				//System.out.println(TotalCalculado);
				//Ahora la creacion de TipoVenta
				switch (partes[1]) {
				case "EFECTIVO": {
					//VentaEfectivo GestionVenta = new VentaEfectivo(idVenta, zona);
					ventaRecibida = new VentaEfectivo(idVenta, partes[1]);
					
					totalVenta = ventaRecibida.aplicarRecargoDescuento(importeBruto);
					
					break;
				}
				case "TARJETA": {
					ventaRecibida = new VentaTarjeta(idVenta, partes[1]);
					totalVenta =ventaRecibida.aplicarRecargoDescuento(importeBruto);
					break;
				}
				case "TRANSFERENCIA": {
					ventaRecibida = new VentaTarjeta(idVenta, partes[1]);
					totalVenta =ventaRecibida.aplicarRecargoDescuento(importeBruto);
					
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " );
				}
				Ganancia = totalVenta-(costoUnitario*cantidad);
				Vendedor vendedorNuevo = new Vendedor(idVenta, partes[7],0.0, 0.0,0);
				
				Venta ventaNueva = new Venta(categoria,idVenta,ventaRecibida,producto,cantidad,precioUnitario,
						costoUnitario,vendedorNuevo,zona,totalVenta,Ganancia,importeBruto,"");
				listaDeVentas.add(ventaNueva);
				
				if(!(listaDeVendedores.contains(vendedorNuevo)))
						{listaDeVendedores.add(vendedorNuevo);}
				
			
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//IGestionVendedor GestionVendedores = new GestionVendedor();	
		return listaDeVentas;
	}

	@Override
	public List<Vendedor> RetornarListaVendedores() {
		// TODO Auto-generated method stub
		return listaDeVendedores;
	}

}
