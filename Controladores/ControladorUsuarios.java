import java.util.ArrayList;

public class ControladorUsuarios {
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

	public ControladorUsuarios() {
		
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	
	public void nuevoUsuario (String nombre, String contraseña, int tipo){
		Usuario nuevoUs = new Usuario (nombre, contraseña, tipo);
		listaUsuarios.add(nuevoUs);
	}
	
	public  boolean validarUsuario (String nombre, String contrasena){
		for (int i = 0; i<listaUsuarios.size();i++)
		{
			System.out.println(listaUsuarios.get(i).getNombre());
			System.out.println(listaUsuarios.get(i).getContrasena());
			if ((listaUsuarios.get(i).getNombre().equals(nombre)) && (listaUsuarios.get(i).getContrasena().equals(contrasena)) ){
				
				return true;
			}
				
				
		}
		
		return false;
	}
	
	
}
