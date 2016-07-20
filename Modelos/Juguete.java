//Universidad Del Valle de Guatemala
//Juan Carlos Tapia 14133
//Leonel Guillen 1414451
//Rodrigo Castro 14092
//Hugo Noriega 14097
//Ejercicio de jugueteria 
import java.util.Comparator;

//Atributos requeridos para cada juguete

public class Juguete {
	private String nombre;
	private double valorUnitario;
	private double valorAdicional;
	private int complejidad;
	private int tipo; // 1 = mecanico; 2 = electronico
	private int codigo;
	private String marca;
	private int requesitoEdad;
	private double precioVenta;
	private int enExistencia;
	private int numProveedor;
	
	//Constructor de la clase
	public Juguete( String nombre, double valorUnitario, double valorAdicional, int complejidad, int tipo, String marca,
			int requesitoEdad, int enExistencia, int numProveedor, int codigo) {
		super();
		this.nombre = nombre;
		this.valorUnitario = valorUnitario;
		this.valorAdicional = valorAdicional;
		this.complejidad = complejidad;
		this.tipo = tipo;
		this.codigo = codigo;
		this.marca = marca;
		this.requesitoEdad = requesitoEdad;
		this.precioVenta = precioVenta;
		this.enExistencia = enExistencia;
		this.numProveedor = numProveedor;
		precioVenta = CalcularPrecioVenta();
		
		
	}
	
	// Implementacion del comparador por precio de venta
	public static Comparator<Juguete> ComparadorPrecioVenta = new Comparator<Juguete>() {

		public int compare(Juguete j1, Juguete j2) {
			//Se hace la comparacion entre dos objetos de jueugete
		   double Juguete1 = j1.getPrecioVenta();
		   double Juguete2 = j2.getPrecioVenta();

		   //ascending order
		   return (int)(Juguete2 - Juguete1);

		   //descending order
		   //return StudentName2.compareTo(StudentName1);
	    

		
		}};
	//Implementacion del comparador por complejidad
	public static Comparator<Juguete> ComparadorComplejidad = new Comparator<Juguete>() {
	//Se toman de parametros dos objetos de tipo juguete
			public int compare(Juguete j1, Juguete j2) {
			   int Juguete1 = j1.getComplejidad();
			   int Juguete2 = j2.getComplejidad();

			   //ascending order
			   return (Juguete2 - Juguete1);

			   //descending order
			   //return StudentName2.compareTo(StudentName1);
		    

			
			}};
	
	//CSe calcula precio de venta de acuerdo a sus especificaciones, depiendo del tipo
	public double CalcularPrecioVenta(){
		if (tipo==1)
			return valorUnitario + valorAdicional*complejidad;
		if (tipo==2)
			return valorUnitario + valorAdicional*2;		
		return 0;
	}
	
	// SETTERS & GETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumProveedor() {
		return numProveedor;
	}

	public void setNumProveedor(int numProveedor) {
		this.numProveedor = numProveedor;
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
	
	public int compareTo(Juguete c) {
        if (getPrecioVenta()<c.getPrecioVenta()){
            return -1;
        }else{
            return 1;
        }
    }
	
	
}
