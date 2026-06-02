package ar.com.unpaz.serviceImp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ar.com.unpaz.models.Vendedor;
import ar.com.unpaz.models.Venta;
import ar.com.unpaz.service.IGestionVendedor;

public class GestionVendedor implements IGestionVendedor {
	
	//private static GestionVendedor instancia;
	List<Vendedor> listaDeVendedores;
	List<Venta> listaDeVentas;
	List<String> copyListaVendedores;
	public GestionVendedor(List<Venta> listaRetor,List<Vendedor> listavend) {
		listaDeVendedores = listavend;
		listaDeVentas = listaRetor;
//		for (Venta ven : listaDeVentas) {
//			if(!(listaDeVendedores.contains(ven))) {
//				listaDeVendedores.add(ven.getVendedor());}
//		}
		listaDeVendedores= listaDeVendedores.stream()
				//.map(vend->vend.getNombre())
				.distinct()
				.collect(Collectors.toList()); //Pero con repetidos
		
		//listaDeVendedores =  listaDeVendedores.stream()
								
								
		//System.out.println(listaDeVendedores);
		
		calculoDeComisiones();
		//Hacer ticket promedio. ---> Formula: TicketPromedio = facturacion/cantidad de ventas
		
	}
	
	
	public void calculoDeComisiones() {
		//System.out.println(listaDeVendedores);
		for (Vendedor vendedor : listaDeVendedores) {
			
			for (Venta vent : listaDeVentas) {
				if((vent.getVendedor()).equals(vendedor)) {
					if(vent.getGanancia()<100000)vendedor.setComision(vent.getImporteTotal()*0.3);
					else if(vent.getGanancia()>100000 && vent.getGanancia()<500000)vendedor.setComision(vent.getImporteTotal()*0.5);
					else if(vent.getGanancia()>500000)vendedor.setComision(vent.getImporteTotal()*0.8);
					//Meto ademas la Facturacion Total de cada uno, y cantidad de ventas
					vendedor.setCantVentas(vendedor.getCantVentas()+1);
					vendedor.setFacturacion(vendedor.getFacturacion()+vent.getImporteTotal());
					vendedor.setGanancia(vendedor.getGanancia()+vent.getGanancia());
				}
			}//Hasta aca el calculo para obtener las ganancias por ventas
			
			
		}
		
	}
	@Override
	public void mostrarVendedores() {
		listaDeVendedores.stream().forEach(V-> System.out.println(V));
		
	}


	@Override
	public void MayorComision() {
		// TODO Auto-generated method stub
		Optional<Vendedor>mayorVenta =listaDeVendedores.stream().max(Comparator.comparing(Vendedor::getComision));
		System.out.println("El vendedor con la mayor comision es:"+mayorVenta);
	}
	
}
