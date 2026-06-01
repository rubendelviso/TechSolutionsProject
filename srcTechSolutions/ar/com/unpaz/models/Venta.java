package ar.com.unpaz.models;

public class Venta {
	private String Categoria;

	private int idVenta;
	private TipoVenta objetoVenta;
	private String objetoProducto;
	private int Cantidad;
	private Double precioUnitario;
	private Double costoUnitario;
	private Vendedor Vendedor;
	private String Zona;
	private Double ImporteTotal;
	private Double Ganancia;
	private Double importeBruto;
	
	public Venta(String categoria, int idVenta, TipoVenta objetoVenta, String objetoProducto,
			int cantidad,Double precioUnitario, Double costoUnitario, Vendedor vendedor, String zona, 
			Double importeTotal,Double Ganancia,Double importeBruto) {
		super();
		Categoria = categoria;
		this.idVenta = idVenta;
		this.objetoVenta = objetoVenta;
		this.objetoProducto = objetoProducto;
		Cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.costoUnitario = costoUnitario;
		this.Vendedor = vendedor;
		Zona = zona;
		this.ImporteTotal = importeTotal;
		this.Ganancia = Ganancia;
		this.importeBruto = importeBruto;
	}
	@Override
	public String toString() {
		return "Venta [Categoria=" + Categoria + ", idVenta=" + idVenta + ", objetoVenta=" + objetoVenta
				+ ", objetoProducto=" + objetoProducto + ", Cantidad=" + Cantidad + ", precioUnitario=" + precioUnitario
				+ ", costoUnitario=" + costoUnitario + ", Vendedor=" + Vendedor + ", Zona=" + Zona + ", ImporteTotal="
				+ ImporteTotal + ", Ganancia=" + Ganancia + "Importe Bruto= "+ importeBruto+"]";
	}
	public String getCategoria() {
		return Categoria;
	}
	public int getIdVenta() {
		return idVenta;
	}
	public TipoVenta getObjetoVenta() {
		return objetoVenta;
	}
	public String getObjetoProducto() {
		return objetoProducto;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public Double getCostoUnitario() {
		return costoUnitario;
	}
	public Vendedor getVendedor() {
		return Vendedor;
	}
	public String getZona() {
		return Zona;
	}
	public Double getImporteTotal() {
		return ImporteTotal;
	}
	public Double getGanancia() {
		return Ganancia;
	}
	public Double getImporteBruto() {
		return importeBruto;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public void setObjetoVenta(TipoVenta objetoVenta) {
		this.objetoVenta = objetoVenta;
	}
	public void setObjetoProducto(String objetoProducto) {
		this.objetoProducto = objetoProducto;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public void setCostoUnitario(Double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	
	public void setZona(String zona) {
		Zona = zona;
	}
	public void setImporteTotal(Double importeTotal) {
		ImporteTotal = importeTotal;
	}
	public void setGanancia(Double ganancia) {
		Ganancia = ganancia;
	}
	public void setImporteBruto(Double importeBruto) {
		this.importeBruto = importeBruto;
	}
	public void setVendedor(Vendedor vendedor) {
		Vendedor = vendedor;
	}
}
