package ar.com.unpaz.models;

public abstract class TipoVenta {
	
	//Aplicar Superclase o 
	//un solo objeto 
		//Atributos(id,descripcion)
	protected int idVenta;
	protected String descripcion;
	private int descuento;
	private int recargo;
	public TipoVenta(int idVenta, String descripcion) {
		super();
		this.idVenta = idVenta;
		this.descripcion = descripcion;
	}

	
	
	public int getIdVenta() {
		return idVenta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public abstract Double aplicarRecargoDescuento(Double TotalCalculado);



	public int getDescuento() {
		return descuento;
	}



	public int getRecargo() {
		return recargo;
	}



	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}



	public void setRecargo(int recargo) {
		this.recargo = recargo;
	}



	@Override
	public String toString() {
		return "TipoVenta [idVenta=" + idVenta + ", descripcion=" + descripcion + "]";
	}
}
