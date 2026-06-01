package ar.com.unpaz.service;

import java.util.List;

import ar.com.unpaz.models.Vendedor;
import ar.com.unpaz.models.Venta;
import ar.com.unpaz.repo.ILecturaVenta;
import ar.com.unpaz.repo.imp.LecturaVenta;

public interface IGestionVentas {
	List<Venta> retornarListaCompleta();//Esto es el punto y asi en adelante con los demas puntos
	void mostrarNombProductos();
	void mostrarImporteBruto(); //superior a 500 000
	void mostrarGanancia();  //superior a 200 000
	void productosMayuscula();
	void contarTarjeta();	
	void mostrarImporte();  //La venta con mayor importe final
	void menorGanancia();
	void ventaImporteMaximo(); //Tiene que ser mayor a 1 000 000
	void mostrarVentasRiesgosas();
	void mostrarVentasNormales();
	void contarVentasCategoria();//cuantas hay en cada categoria
	//ILecturaVenta retornarInstancia();
	List<Vendedor> retornarVendedores();
}
