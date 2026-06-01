package ar.com.unpaz.models;

public class Vendedor {
	
	private int idVendedor;
	private String nombre;
	private Double ganancia;
	private Double Comision;

	public Vendedor(int idVendedor, String nombre, Double ganancia) {
		super();
		this.idVendedor = idVendedor;
		this.nombre = nombre;
		this.ganancia = ganancia;
	}
	public int getIdVendedor() {
		return idVendedor;
	}
	public String getNombre() {
		return nombre;
	}
	public Double getGanancia() {
		return ganancia;
	}
	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setGanancia(Double ganancia) {
		this.ganancia = ganancia;
	}
	public Double getComision() {
		return Comision;
	}
	public void setComision(Double comision) {
		Comision = comision;
	}
	@Override
	public String toString() {
		return "Vendedor [idVendedor=" + idVendedor + ", nombre=" + nombre + ", ganancia=" + ganancia +"Comision="+ Comision +"]";
	}
}
