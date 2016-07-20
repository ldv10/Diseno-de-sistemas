
public class Usuario {
	private String nombre, contrasena;

	private int tipo, id;
	public Usuario(String nombre, String contrasena, int tipo, int id) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.id = id;
		this.tipo = tipo;
	}
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
