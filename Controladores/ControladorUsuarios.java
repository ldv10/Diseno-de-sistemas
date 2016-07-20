import java.util.ArrayList;

public class ControladorUsuarios {
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private int idUsuario =0;
	
	public ControladorUsuarios() {
		
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public void mostrarUsuarios(){
		if(listaUsuarios.size()!=0)
		for (int i=0;i<listaUsuarios.size();i++)
		{		System.out.print(listaUsuarios.get(i).getId() +". " + listaUsuarios.get(i).getNombre() + "   Clasificacion: ");
				if(listaUsuarios.get(i).getTipo() ==1)
					System.out.println( "Empleado de caja");
				if(listaUsuarios.get(i).getTipo() ==2)
					System.out.println( "Encargado de inventario");
				if(listaUsuarios.get(i).getTipo() ==3)
					System.out.println( "Director de tienda");
		
		}
	}
	
	public void nuevoUsuario (String nombre, String contraseña, int tipo){
		Usuario nuevoUs = new Usuario (nombre, contraseña, tipo, idUsuario+1);
		idUsuario++;
		listaUsuarios.add(nuevoUs);
	}
	
	public void modificarUsuario (int id, String nombre, int tipo){
		if (listaUsuarios.size()==0)
			System.out.println("No hay usuarios");
		else
			for (int i=0;i<listaUsuarios.size();i++)
			{
				if(listaUsuarios.get(i).getId()== id)
				{
					listaUsuarios.get(i).setNombre(nombre);
					listaUsuarios.get(i).setTipo(tipo);
					return;
				}
			}
	}
	
	
	
	public  int validarUsuario (String nombre, String contrasena){
		for (int i = 0; i<listaUsuarios.size();i++)
		{
			System.out.println(listaUsuarios.get(i).getNombre());
			System.out.println(listaUsuarios.get(i).getContrasena());
			if ((listaUsuarios.get(i).getNombre().equals(nombre)) && (listaUsuarios.get(i).getContrasena().equals(contrasena)) ){
				
				return i;
			}
				
				
		}
		
		return -1;
	}
	
	
}
