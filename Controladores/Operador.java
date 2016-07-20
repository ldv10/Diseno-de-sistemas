import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Operador {
	private ArrayList<Juguete> listaJuguetes = new ArrayList<Juguete>();
	private ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
	private int codigoProv = 0;
	private int codigoJug = 0;
	
	public Operador() {
	
	}

	public void mostrarProveedores(){
		if(listaProveedores.size()!=0)
		for (int i=0;i<listaProveedores.size();i++)
		{		System.out.println(listaProveedores.get(i).getNumero() +". " + listaProveedores.get(i).getNombre());
				
		
		}
	}
	
	
	public void mostrarJuguetes(){
		if(listaJuguetes.size()!=0)
		for (int i=0;i<listaJuguetes.size();i++)
		{		System.out.print(listaJuguetes.get(i).getCodigo()+ ", " + listaJuguetes.get(i).getNombre() +", "+ listaJuguetes.get(i).getMarca()+", Precio Venta: " + listaJuguetes.get(i).getPrecioVenta());
				if(listaJuguetes.get(i).getTipo()==1)
					System.out.print("  Tipo: Mecanico.  Complejidad: " +listaJuguetes.get(i).getComplejidad() );
				else
					System.out.print("  Tipo: Electronico");
				System.out.println (" , Requesito Edad: "+ listaJuguetes.get(i).getRequesitoEdad() + "Proveedor: "+ listaJuguetes.get(i).getNumProveedor() );
		}
	}
	
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
	
	
	public void EliminarProveedor(int numero){
		if (listaProveedores.size()==0)
			System.out.println("No hay proveedores");
		else
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
		
		Juguete nuevoJug = new Juguete(nombre, valorUnitario, valorAdicional, complejidad, tipo, marca, requesitoEdad, enExistencia, numProveedor, codigoJug+1);
		listaJuguetes.add(nuevoJug);
		codigoJug++;
		for (int i=0;i<listaProveedores.size();i++)
		{	if(listaProveedores.get(i).getNumero()== numProveedor)
			{
				listaProveedores.get(i).agregarJ(nuevoJug);
				return;
			}
		}
		
	};
	
	
	public void modificarJuguete(int codigo, String nombre, double valorUnitario, double valorAdicional, 
			int complejidad, int tipo, String marca, int requesitoEdad, int enExistencia, int numProveedor){
		
		if (listaJuguetes.size()==0)
			System.out.println("No hay juguetes");
		else
			for (int i=0;i<listaJuguetes.size();i++)
			{
				
			
				if (codigo == listaJuguetes.get(i).getCodigo()){
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
	
	
	public void EliminarJuguete(int codigo){
		if (listaJuguetes.size()==0)
			System.out.println("No hay juguetes");
		else
			for (int i=0;i<listaJuguetes.size();i++)
			{
				if (codigo == listaJuguetes.get(i).getCodigo()){
					
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
		{
			for (int i=0;i<listaProveedores.size();i++)
			{	if (listaProveedores.get(i).getJuguetes().size() >= 10)	
				{	
					validos++;
					if(validos==1)
						System.out.println("Los proveedores con mas de 10 juguetes son: ");
						
					System.out.println(listaProveedores.get(i).getNumero() +". " + listaProveedores.get(i).getNombre());
				}
			}
		if (validos == 0)
			System.out.println("No hay proveedores con mas de 10 juguetes");
		}
	}
	
	public void CuantosJuguetesTieneProveedor(String nombre){
		if(listaProveedores.size()==0)
			System.out.println("No hay proveedores");
		else
		{
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
	
	
	public void MayorPrecioVenta(){
		
		
		ArrayList<Juguete> nuevalista = listaJuguetes;
		Collections.sort(nuevalista,Juguete.ComparadorPrecioVenta);
		System.out.println("El juguete con mayor precio de venta es: " + nuevalista.get(0).getNombre()+ "con un precio de " + nuevalista.get(0).getPrecioVenta() + "  Codigo: " + nuevalista.get(0).getCodigo());
		
		
	}
	
	public void MecanicosPorComplejidad(){
		ArrayList<Juguete> nuevalista = listaJuguetes;
		Collections.sort(nuevalista,Juguete.ComparadorComplejidad);
		System.out.println("Lista de juguetes mecanicos por complejidad:");
		if(nuevalista.size()==0)
			System.out.println("No hay Juguetes");
		else
		{
			System.out.println("Lista de juguetes mecanicos por complejidad:");
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
	
	public void ElectronicosPorPrecioVenta(){
		ArrayList<Juguete> nuevalista = listaJuguetes;
		Collections.sort(nuevalista,Juguete.ComparadorPrecioVenta);
		System.out.println("Lista de juguetes mecanicos por complejidad:");
		if(nuevalista.size()==0)
			System.out.println("No hay Juguetes");
		else
		{
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
