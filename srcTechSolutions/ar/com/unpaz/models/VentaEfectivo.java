package ar.com.unpaz.models;

public class VentaEfectivo extends TipoVenta {
public static final double Descuento= 0.9;

	public VentaEfectivo(int idVenta, String descripcion) {
		super(idVenta, descripcion);

		
		
	}



	@Override
	public Double aplicarRecargoDescuento(Double TotalCalculado) {
		// TODO Auto-generated method stub
		return (TotalCalculado*Descuento);
	}

}
