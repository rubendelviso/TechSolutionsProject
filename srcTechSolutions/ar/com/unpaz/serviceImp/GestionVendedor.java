package ar.com.unpaz.serviceImp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ar.com.unpaz.models.Vendedor;
import ar.com.unpaz.models.Venta;
import ar.com.unpaz.service.IGestionVendedor;

public class GestionVendedor implements IGestionVendedor {
	
	//private static GestionVendedor instancia;
	List<Vendedor> listaDeVendedores;
	List<Venta> listaDeVentas;
	
	public GestionVendedor(List<Venta> listaRetor,List<Vendedor> listavend) {
		listaDeVendedores = listavend;
		listaDeVentas = listaRetor;
		for (Venta ven : listaDeVentas) {
			listaDeVendedores.add(ven.getVendedor());
		}
		calculoDeComisiones();
	}
	
	
	public void calculoDeComisiones() {
		for (Vendedor vendedor : listaDeVendedores) {
			
			for (Venta vent : listaDeVentas) {
				if(vent.getVendedor()==vendedor) {
					if(vent.getGanancia()<100000)vendedor.setComision(vent.getImporteTotal()*0.3);
					else if(vent.getGanancia()>100000 && vent.getGanancia()<500000)vendedor.setComision(vent.getImporteTotal()*0.5);
					else if(vent.getGanancia()>500000)vendedor.setComision(vent.getImporteTotal()*0.8);
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
