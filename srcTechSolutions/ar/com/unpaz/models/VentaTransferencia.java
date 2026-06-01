package ar.com.unpaz.models;

public class VentaTransferencia extends TipoVenta {

	public VentaTransferencia(int idVenta, String descripcion) {
		super(idVenta, descripcion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double aplicarRecargoDescuento(Double TotalCalculado) {
		// TODO Auto-generated method stub
		return TotalCalculado;
	}

	
}
