//Universidad Del Valle de Guatemala
//Juan Carlos Tapia 14133
//Leonel Guillen 1414451
//Rodrigo Castro 14092
//Hugo Noriega 14097
//Ejercicio de jugueteria 
import java.util.ArrayList; //Se importa la libreria con la que se creara los arrays

public class ControladorUsuarios {
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>(); //Se inicialza la lista
	private int idUsuario =0; //se inicianiliza el id de usuario
	
	public ControladorUsuarios() {
		
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	//Metodo que se encargara de mostrar los usarios
	public void mostrarUsuarios(){
		if(listaUsuarios.size()!=0)
		for (int i=0;i<listaUsuarios.size();i++)//Se crea los usuarios
		{		System.out.print(listaUsuarios.get(i).getId() +". " + listaUsuarios.get(i).getNombre() + "   Clasificacion: ");//Se imprimen los tipos de empleados
				if(listaUsuarios.get(i).getTipo() ==1)
					System.out.println( "Empleado de caja");
				if(listaUsuarios.get(i).getTipo() ==2)
					System.out.println( "Encargado de inventario");
				if(listaUsuarios.get(i).getTipo() ==3)
					System.out.println( "Director de tienda");
		
		}
	}
	//Metodo para crear nuevo usuario
	public void nuevoUsuario (String nombre, String contraseña, int tipo){
		Usuario nuevoUs = new Usuario (nombre, contraseña, tipo, idUsuario+1);
		idUsuario++;
		listaUsuarios.add(nuevoUs);
	}
	//Metodo para modificar usuario
	public void modificarUsuario (int id, String nombre, int tipo){
		if (listaUsuarios.size()==0)
			System.out.println("No hay usuarios");//Se imprime esto en caso de que no haya  usuarios en la lista
		else
			for (int i=0;i<listaUsuarios.size();i++)//Se recorre la lista
			{
				if(listaUsuarios.get(i).getId()== id)
				{
					listaUsuarios.get(i).setNombre(nombre);
					listaUsuarios.get(i).setTipo(tipo);
					return;
				}
			}
	}
	
	
	//Metodo para validar usuario
	public  int validarUsuario (String nombre, String contrasena){
		for (int i = 0; i<listaUsuarios.size();i++)//recorre la lista de usuarios
		{
			System.out.println(listaUsuarios.get(i).getNombre());//imprime el nombre
			System.out.println(listaUsuarios.get(i).getContrasena());//imprime contraseña
			if ((listaUsuarios.get(i).getNombre().equals(nombre)) && (listaUsuarios.get(i).getContrasena().equals(contrasena)) ){
				
				return i;
			}
				
				
		}
		
		return -1;
	}
	
	
}
