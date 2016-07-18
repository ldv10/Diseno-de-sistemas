public class Juguete {
	private double valorUnitario;
	private double valorAdicional;
	private int complejidad;
	private int tipo; // 1 = mecanico; 2 = electronico
	private int codigo;
	private String marca;
	private int requesitoEdad;
	private double precioVenta;
	private int enExistencia;
	public Juguete(double valorUnitario, double valorAdicional, int complejidad, int tipo, int codigo, String marca,
			int requesitoEdad, int enExistencia) {
		super();
		this.valorUnitario = valorUnitario;
		this.valorAdicional = valorAdicional;
		this.complejidad = complejidad;
		this.tipo = tipo;
		this.codigo = codigo;
		this.marca = marca;
		this.requesitoEdad = requesitoEdad;
		this.precioVenta = precioVenta;
		this.enExistencia = enExistencia;
		precioVenta = CalcularPrecioVenta();
		
		
	}
	
	public double CalcularPrecioVenta(){
		if (tipo==1)
			return valorUnitario + valorAdicional*complejidad;
		if (tipo==2)
			return valorUnitario + valorAdicional*2;		
		return 0;
	}
	
	
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public double getValorAdicional() {
		return valorAdicional;
	}
	public void setValorAdicional(double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}
	public int getComplejidad() {
		return complejidad;
	}
	public void setComplejidad(int complejidad) {
		this.complejidad = complejidad;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getRequesitoEdad() {
		return requesitoEdad;
	}
	public void setRequesitoEdad(int requesitoEdad) {
		this.requesitoEdad = requesitoEdad;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getEnExistencia() {
		return enExistencia;
	}
	public void setEnExistencia(int enExistencia) {
		this.enExistencia = enExistencia;
	}
	
	
	
	
}
