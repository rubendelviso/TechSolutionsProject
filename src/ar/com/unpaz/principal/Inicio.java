package ar.com.unpaz.principal;

import java.util.List;

import ar.com.unpaz.models.Vendedor;
import ar.com.unpaz.models.Venta;
import ar.com.unpaz.repo.ILecturaVenta;
import ar.com.unpaz.service.IGestionVendedor;
import ar.com.unpaz.service.IGestionVentas;
import ar.com.unpaz.serviceImp.GestionVendedor;
import ar.com.unpaz.serviceImp.GestionVentas;

public class Inicio {

	public static void main(String[] args) {
		//Hacer toda la inyeccion de dependencias desde aca
		//Instancio Gestion Vendedores -> lo paso a ventas
		// ->Retorna la lista de ventas
		
		IGestionVentas gestion = new GestionVentas();
		
		//System.out.println("a");
		List<Venta> listaRetor = gestion.retornarListaCompleta();
		List<Vendedor> listaVenRetorn = gestion.retornarVendedores();
		
		IGestionVendedor gestionVendedor = new GestionVendedor(listaRetor,listaVenRetorn);
		List<Venta>Lista = gestion.retornarListaCompleta();
		//System.out.println(Lista);
		//System.out.println(gestion.retornarListaCompleta());
		gestionVendedor.mostrarVendedores();
		//gestionVendedor.MayorComision();
		//gestion.mostrarVentasRevisar();
	
	}

}
