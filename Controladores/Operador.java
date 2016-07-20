//Universidad Del Valle de Guatemala
//Juan Carlos Tapia 14133
//Leonel Guillen 1414451
//Rodrigo Castro 14092
//Hugo Noriega 14097
//Ejercicio de jugueteria 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Operador {
	//Declaracion de arreglos de tipo objeto de las respectivas clases
	private ArrayList<Juguete> listaJuguetes = new ArrayList<Juguete>();
	private ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
	// contadores que cambian cada vez que se ingresa un juguete o proveedor, para que todos tengan un codigo diferente.
	private int codigoProv = 0;
	private int codigoJug = 0;
	
	public Operador() {
	
	}

	//Despliega todos los proveedores
	public void mostrarProveedores(){
		if(listaProveedores.size()!=0)
		for (int i=0;i<listaProveedores.size();i++)
		{		System.out.println(listaProveedores.get(i).getNumero() +". " + listaProveedores.get(i).getNombre());
				
		
		}
	}
	
	//Despliega los datos de los jueguetes
	public void mostrarJuguetes(){
		if(listaJuguetes.size()!=0) //La lista de Juguetes debe contener al menos un elemento
		for (int i=0;i<listaJuguetes.size();i++) //Se recorre la lista
		//Se imprimen los datos
		{		System.out.print(listaJuguetes.get(i).getCodigo()+ ", " + listaJuguetes.get(i).getNombre() +", "+ listaJuguetes.get(i).getMarca()+", Precio Venta: " + listaJuguetes.get(i).getPrecioVenta());
				if(listaJuguetes.get(i).getTipo()==1)
					System.out.print("  Tipo: Mecanico.  Complejidad: " +listaJuguetes.get(i).getComplejidad() );
				else
					System.out.print("  Tipo: Electronico");
				System.out.println (" , Requesito Edad: "+ listaJuguetes.get(i).getRequesitoEdad() + "Proveedor: "+ listaJuguetes.get(i).getNumProveedor() );
		}
	}
	
	// Se ingresa un nuevo proveedor
	public void IngresarProveedor(String nombre){
		
		Proveedor nuevoProv = new Proveedor(nombre, codigoProv+1);
		listaProveedores.add(nuevoProv);
		codigoProv++;
	};
	
	public void ModificarProveedor(int numero, String nombre){
		if (listaProveedores.size()==0)
			System.out.println("No hay proveedores");
		else
			for (int i=0;i<listaProveedores.size();i++)
			{
				if(listaProveedores.get(i).getNumero()== numero)
				{
					listaProveedores.get(i).setNombre(nombre);
					return;
				}
			}
	};
	
	// Se elimina un proveedor
	public void EliminarProveedor(int numero){
		if (listaProveedores.size()==0)
			System.out.println("No hay proveedores");
		else
		// Se busca el codigo en la lista al recorrerla, y se elimina cuando se encuentra el proveedor con ese codigo.
			for (int i=0;i<listaProveedores.size();i++)
			{
				if(listaProveedores.get(i).getNumero()== numero)
				{
					listaProveedores.remove(i);
					return;
				}
			}
	};

	
	public void IngresarJuguete(String nombre, double valorUnitario, double valorAdicional, int complejidad, int tipo, String marca,
			int requesitoEdad, int enExistencia, int numProveedor){
		//Se llama a el constructor de la clase Juguetes, se da sus respectivos atributos
		//Se crea el objeto de tipo Juguete
		Juguete nuevoJug = new Juguete(nombre, valorUnitario, valorAdicional, complejidad, tipo, marca, requesitoEdad, enExistencia, numProveedor, codigoJug+1);
		listaJuguetes.add(nuevoJug);
		codigoJug++;
		//Se hace la realcion entre los proovedores y los juguetes, agregando a la lista de proovedores
		// un juguete
		for (int i=0;i<listaProveedores.size();i++)
		{	if(listaProveedores.get(i).getNumero()== numProveedor)
			{
				listaProveedores.get(i).agregarJ(nuevoJug);
				return;
			}
		}
		
	};
	
	//Modificar un juguete
	public void modificarJuguete(int codigo, String nombre, double valorUnitario, double valorAdicional, 
			int complejidad, int tipo, String marca, int requesitoEdad, int enExistencia, int numProveedor){
		
		//Debe validar que exista un juguete que modificar
		if (listaJuguetes.size()==0)
			System.out.println("No hay juguetes");
		else
			for (int i=0;i<listaJuguetes.size();i++)
			{
				
			//Se hace una busqueda por medio del codigo del juguete, recorriendo todos los codigos almacenados
				if (codigo == listaJuguetes.get(i).getCodigo()){
					//Se modifica cada atributo por medio de los SETS
					listaJuguetes.get(i).setNombre(nombre);
					listaJuguetes.get(i).setCodigo(codigo);
					listaJuguetes.get(i).setComplejidad(complejidad);
					listaJuguetes.get(i).setEnExistencia(enExistencia);
					listaJuguetes.get(i).setMarca(marca);
					listaJuguetes.get(i).setRequesitoEdad(requesitoEdad);
					listaJuguetes.get(i).setTipo(tipo);
					listaJuguetes.get(i).setValorAdicional(valorAdicional);
					listaJuguetes.get(i).setValorUnitario(valorUnitario);
					listaJuguetes.get(i).setNumProveedor(numProveedor);
					listaJuguetes.get(i).setPrecioVenta(listaJuguetes.get(i).CalcularPrecioVenta());
			}
			
		}
		
	}
	
	//Eliminacion de Juguetes
	public void EliminarJuguete(int codigo){
		if (listaJuguetes.size()==0)
			System.out.println("No hay juguetes");
		else
			//Se elimina por medio del codigo
			for (int i=0;i<listaJuguetes.size();i++)
			{
				if (codigo == listaJuguetes.get(i).getCodigo()){
					
					//Se recorre y se elimina el juguete de acuerdo al codigo ingresado
					for (int j=0;j<listaProveedores.size();j++)
					{	if(listaProveedores.get(j).getNumero()== listaJuguetes.get(i).getNumProveedor())
							listaProveedores.get(j).eliminarJ(listaJuguetes.get(i));;
					}
					listaJuguetes.remove(i);
					
				}
			
			}
	}
	
	public void listarProveedores10(){ // Listar proveedores con mas de 10 juguetes.
		int validos = 0;
		if(listaProveedores.size()==0)
		{
			System.out.println("No hay proveedores");
		}
		else
		{	// Se recorre la lista de proveedores y se imprimen los que tienen mas de 10 juguetes.
			for (int i=0;i<listaProveedores.size();i++)
			{	if (listaProveedores.get(i).getJuguetes().size() >= 10)	
				{	
					validos++; // Se lleva un contador de cuantos son.
					if(validos==1)
						System.out.println("Los proveedores con mas de 10 juguetes son: ");
						
					System.out.println(listaProveedores.get(i).getNumero() +". " + listaProveedores.get(i).getNombre());
				}
			}
		if (validos == 0)
			System.out.println("No hay proveedores con mas de 10 juguetes");
		}
	}
	
	// Se cuenta cuantos juguetes tiene un proveedor
	public void CuantosJuguetesTieneProveedor(String nombre){
		if(listaProveedores.size()==0)
			System.out.println("No hay proveedores");
		else
		{	// Se recorre la lista de proveedores para buscar al proveedor que se ingreso, y luego se despliega el tamaño de su lista de juguetes.
			for (int i=0;i<listaProveedores.size();i++)
			{
				if (listaProveedores.get(i).getNombre().equals(nombre)){
					System.out.println("Este proveedor tiene " + listaProveedores.get(i).getJuguetes().size() + " juguetes" );
					return;
				}
					
			}
		System.out.println("Ese proveedor no existe");
		}
	}
	
	//Despliega el jueugete con el mayor precio 
	public void MayorPrecioVenta(){
		
		//Se ordena la lista, con el atributo del precio Venta
		ArrayList<Juguete> nuevalista = listaJuguetes;
		Collections.sort(nuevalista,Juguete.ComparadorPrecioVenta);
		System.out.println("El juguete con mayor precio de venta es: " + nuevalista.get(0).getNombre()+ "con un precio de " + nuevalista.get(0).getPrecioVenta() + "  Codigo: " + nuevalista.get(0).getCodigo());
		
		
	}
	//Se genera una lista de los jueguetes mecanicos de acuerdo a su complejidad
	public void MecanicosPorComplejidad(){
		//Se crea la lista donde se guardara
		ArrayList<Juguete> nuevalista = listaJuguetes;
		//Se hace un sort, con el filtro de complejidad
		Collections.sort(nuevalista,Juguete.ComparadorComplejidad);
		System.out.println("Lista de juguetes mecanicos por complejidad:");
		if(nuevalista.size()==0)
			System.out.println("No hay Juguetes");
		else
		{
			System.out.println("Lista de juguetes mecanicos por complejidad:");
			//Se recorre la lista para determinar cuales pertenecen a determinada categoria
			for (int i=0;i<nuevalista.size();i++)
			{
				if(nuevalista.get(i).getTipo()==1)
				{
					System.out.print(nuevalista.get(i).getCodigo()+ ", " + nuevalista.get(i).getNombre() +", "+ nuevalista.get(i).getMarca()+", Precio Venta: " + nuevalista.get(i).getPrecioVenta());
				
					System.out.print("  Tipo: Mecanico.  Complejidad: " +nuevalista.get(i).getComplejidad() );
					
					System.out.println (" , Requesito Edad: "+ nuevalista.get(i).getRequesitoEdad() + "Proveedor: "+ nuevalista.get(i).getNumProveedor() );
				}
			}
		}
	}
	//Ordena a los juguetes electronicos por su precio 
	
	public void ElectronicosPorPrecioVenta(){
		//Lista donde se guardara lo encontrado
		ArrayList<Juguete> nuevalista = listaJuguetes;
		//Se hace un sort, con el flitro del precio de venta
		Collections.sort(nuevalista,Juguete.ComparadorPrecioVenta);
		System.out.println("Lista de juguetes mecanicos por complejidad:");
		if(nuevalista.size()==0)
			System.out.println("No hay Juguetes");
		else
		{
			//Se recorre la lista para  desplegar los juguetes de acuerdo a su complejidad
			System.out.println("Lista de juguetes mecanicos por complejidad:");
			for (int i=0;i<nuevalista.size();i++)
			{
				if(nuevalista.get(i).getTipo()==2)
				{
					System.out.print(nuevalista.get(i).getCodigo()+ ", " + nuevalista.get(i).getNombre() +", "+ nuevalista.get(i).getMarca()+", Precio Venta: " + nuevalista.get(i).getPrecioVenta());
				
					System.out.print("  Tipo: Electronico");
					
					System.out.println (" , Requesito Edad: "+ nuevalista.get(i).getRequesitoEdad() + "Proveedor: "+ nuevalista.get(i).getNumProveedor() );
				}
			}
		}
	}
	
	// Es el mismo proceso cunado se conto cuantos juguetes tiene un proveedor, pero ahora se analiza cada uno de sus juguetes para separarlos por tipo.
	public void ElectronicosyMecanicosPorProveedor(String nombre)
	{
	if(listaProveedores.size()==0)
		System.out.println("No hay proveedores");
	else
	{
		for (int i=0;i<listaProveedores.size();i++)
		{
			if (listaProveedores.get(i).getNombre().equals(nombre)){
				int mecanicos=0;
				int electronicos=0;
				for (int j=0;j<listaProveedores.get(i).getJuguetes().size();j++)
				{
					if (listaProveedores.get(i).getJuguetes().get(j).getTipo()==1)
						mecanicos++;
					else
						electronicos++;
				}
					
					
				System.out.println("Este proveedor tiene " + mecanicos + " juguetes mecanicos" );
				System.out.println("Este proveedor tiene " + electronicos + " juguetes electronicos" );
				
				
				
				return;
			}
				
		}
	System.out.println("Ese proveedor no existe");
	}
		
	}
	
	public void ProveedoresPorTipo (int tipo){
		ArrayList<Integer> proveedores = new ArrayList<Integer>();
		if(listaJuguetes.size()==0)
			System.out.println("No hay proveedores");
		else
		{
			for (int i=0;i<listaJuguetes.size();i++)
			{	
				if(listaJuguetes.get(i).getTipo()==tipo){
					if (!proveedores.contains(listaJuguetes.get(i).getNumProveedor()))
						proveedores.add(listaJuguetes.get(i).getNumProveedor());
				}
					
		
			}
			
			if(proveedores.size()==0)
			{
				System.out.println("No hay proveedores que vendan ese tipo de juguete");
			}
			else
			{   System.out.println("Los proveedores que venden ese tipo de juguetes son: ");
				
				for (int i=0;i<listaProveedores.size();i++)
				{
					if(proveedores.contains(listaProveedores.get(i).getNumero()))
					{
						System.out.println(listaProveedores.get(i).getNumero() +". " + listaProveedores.get(i).getNombre());
					}
				}
			}
		}
		
	}
	
	
	// Setters y Getters
	public ArrayList<Juguete> getListaJuguetes() {
		return listaJuguetes;
	}


	public void setListaJuguetes(ArrayList<Juguete> listaJuguetes) {
		this.listaJuguetes = listaJuguetes;
	}


	public ArrayList<Proveedor> getListaProveedores() {
		return listaProveedores;
	}


	public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}
	
	
	
	
	
}
