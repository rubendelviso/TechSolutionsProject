package ar.com.unpaz.repo;

import java.util.List;

import ar.com.unpaz.models.Vendedor;
import ar.com.unpaz.models.Venta;

public interface ILecturaVenta {
	List<Venta> RetornarListaVentas();
	List<Vendedor>RetornarListaVendedores();
	
}
