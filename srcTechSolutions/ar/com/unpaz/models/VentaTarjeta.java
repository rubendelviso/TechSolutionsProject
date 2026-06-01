package ar.com.unpaz.models;

public class VentaTarjeta extends TipoVenta {
	public static final double Recargo= 1.08;
	public VentaTarjeta(int idVenta, String descripcion) {
		super(idVenta, descripcion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double aplicarRecargoDescuento(Double TotalCalculado) {
		// TODO Auto-generated method stub
		//System.out.println("El total calculado es:"+TotalCalculado);
		return TotalCalculado*Recargo;
	}


}
