//Universidad Del Valle de Guatemala
//Juan Carlos Tapia 14133
//Leonel Guillen 1414451
//Rodrigo Castro 14092
//Hugo Noriega 14097
//Ejercicio de jugueteria 
public class Usuario {
	//atributos
	private String nombre, contrasena;
	//constructor
	private int tipo, id;
	public Usuario(String nombre, String contrasena, int tipo, int id) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.id = id;
		this.tipo = tipo;
	}
	//sets y gets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
}
