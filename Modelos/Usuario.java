public class Usuario {
	private String nombre, usuario, contrasena;
	private boolean active;
	private int id;

	/* 
		Constructor
	*/
	public Usuario(String nombre, String usuario, String contrasena, int id) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.active = false;
	}
	/* 
		Getters - Setters
	*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setContrasena(String contrasena){
		this.contrasena = contrasena;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean validarUsuario(String usuario, String contrasena) {
		return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
	}

}
