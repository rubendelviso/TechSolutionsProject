package ar.com.unpaz.serviceImp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ar.com.unpaz.models.Vendedor;
import ar.com.unpaz.models.Venta;
import ar.com.unpaz.repo.ILecturaVenta;
import ar.com.unpaz.repo.imp.LecturaVenta;
import ar.com.unpaz.service.IGestionVentas;

public class GestionVentas implements IGestionVentas{
	List<Venta> listaDeVentas; //= retornarListaCompleta();
	
	List<Venta> ventasRiesgosas;
	List<Venta> ventasNormales;
	List<Venta> ventasRentables;
	ILecturaVenta lecturaService;
	
	public GestionVentas() {
		lecturaService = new LecturaVenta();
		listaDeVentas = lecturaService.RetornarListaVentas();
		//Clasificacion de Ventas segun margen
		ventasRiesgosas = new ArrayList<>();
		ventasNormales = new ArrayList<>();
		ventasRentables = new ArrayList<>();
		//Clasificar a las ventas por riesgosa o no
		for (Venta venta : listaDeVentas) {
			//Supongo que se obtiene mirando los costos
			//Teniendo en cuenta que la cuenta sea la venta-costo
			//Entonces costo = cantidades*costoUnitario
			Double costoCalculado = venta.getCostoUnitario()*venta.getCantidad();
			Double CalculoMargen = ((venta.getImporteTotal()-costoCalculado)/venta.getImporteTotal())*100;
			//System.out.println("Margen: "+CalculoMargen);
			if(CalculoMargen<10)ventasRiesgosas.add(venta);
			else if(CalculoMargen>10 && CalculoMargen<25)ventasNormales.add(venta);
			else ventasRentables.add(venta);
		
		}
		
	}
	@Override
	public List<Venta> retornarListaCompleta() {
		// TODO Auto-generated method stub
		//ILecturaVenta lecturaService = new LecturaVenta();
		return listaDeVentas;
	}

	@Override
	public void mostrarNombProductos() {
		//System.out.println(listaDeVentas);
		listaDeVentas.stream().map(n-> n.getObjetoProducto()).forEach(v -> System.out.println(v));
		
	}

	@Override
	public void mostrarImporteBruto() {
		// TODO Auto-generated method stub
		listaDeVentas.stream().filter(v->v.getImporteBruto()>500000).forEach(ven->System.out.println(ven));
		
	}

	@Override
	public void mostrarGanancia() {
		listaDeVentas.stream().filter(v-> v.getGanancia()>200000).forEach(ven->System.out.println(ven));
		
	}

	@Override
	public void productosMayuscula() {
		listaDeVentas.stream().map(v-> v.getObjetoProducto().toUpperCase()).forEach(ven->System.out.println(ven));
		
	}

	@Override
	public void contarTarjeta() {
		// TODO Auto-generated method stub
		System.out.println("Cantidad de ventas tipo tarjeta:");
		System.out.println(listaDeVentas.stream().filter(v-> v.getObjetoVenta().getDescripcion().equals("TARJETA")).count());
		
	
	}

	@Override
	public void mostrarImporte() {
		Optional<Venta> ventaMax = listaDeVentas.stream().max(Comparator.comparing(Venta::getImporteTotal));
		System.out.println(ventaMax);
	}

	@Override
	public void menorGanancia() {
		Optional<Venta> GananciaMin = listaDeVentas.stream().min(Comparator.comparing(Venta::getGanancia));
		System.out.println(GananciaMin);
	}

	@Override
	public void ventaImporteMaximo() {
		// TODO Auto-generated method stub
		System.out.println("La venta de importe mayor a 1000000"+listaDeVentas.stream().filter(v->v.getImporteTotal()>1000000).findFirst());
				
				//anyMatch(v->v.getImporteTotal()>1000000));
				
				//max(Comparator.comparing(Venta::getImporteTotal));
		
		
	}
	@Override
	public void mostrarVentasRiesgosas() {
		ventasRiesgosas.stream().forEach(v->System.out.println(v));
		
	}
	@Override
	public void mostrarVentasNormales() {
		ventasNormales.stream().forEach(v->System.out.println(v));
		
	}
	@Override
	public void contarVentasCategoria() {
		System.out.println("En la categoria de riesgosas hay -> "+ventasRiesgosas.stream().count());
		System.out.println("En la categoria de normales hay -> "+ventasNormales.stream().count());
		System.out.println("En la categoria de rentales hay hay -> "+ventasRentables.stream().count());
		
		
	}
	@Override
	public List<Vendedor> retornarVendedores() {
		// TODO Auto-generated method stub
		List<Vendedor> listaRetornar = lecturaService.RetornarListaVendedores();
		return listaRetornar;
		
	}
	


}

//Punto 1
//
//
//Mostrar todas las ventas.
//
// 
//Punto 2
// 
//
//Mostrar únicamente los nombres de los productos.
//
// 
//Punto 3
// 
//
//Mostrar las ventas cuyo importe bruto sea superior a $500.000.
//
// 
//Punto 4
// 
//
//Mostrar las ventas cuya ganancia sea superior a $200.000.
//
// 
//Punto 5
// 
//
//Obtener una lista con todos los productos en mayúscula.
//
// 
//Punto 6
// 
//
//Contar cuántas ventas fueron realizadas con tarjeta.
//
// 
//Punto 7
// 
//
//Obtener la venta con mayor importe final.
//
// 
//Punto 8
// 
//
//Obtener la venta con menor ganancia.
//
// 
//Punto 9
// 
//
//Buscar la primera venta cuyo importe final supere $1.000.000.
//
// 
//Punto 10
// 
//
//Verificar si existe alguna venta con pérdida