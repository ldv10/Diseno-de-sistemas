import java.util.ArrayList;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Operador {
	private ArrayList<Juguete> listaJuguetes = new ArrayList<Juguete>();
	private ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
	private int codigoProv = 0;
	private int codigoJug = 0;
	

	
	
//private ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
	
	public Operador() {
	
	}
	
	//Operadores de Juguete
	
	
	public void listarProveedores10(){ // Listar proveedores con mas de 10 juguetes.
		int validos = 0;
		if(listaProveedores.size()!=0)
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
	
	public void mostrarProveedores(){
		if(listaProveedores.size()!=0)
		for (int i=0;i<listaProveedores.size();i++)
		{		System.out.println(listaProveedores.get(i).getNumero() +". " + listaProveedores.get(i).getNombre());
				
		
		}
	}
	
	
	public void IngresarProveedor(String nombre){
		
		Proveedor nuevoProv = new Proveedor(nombre, codigoProv+1);
		listaProveedores.add(nuevoProv);
		codigoProv++;
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
	
	public void modificarJuguete(int codigo, double valorUnitario, double valorAdicional, 
			int complejidad, int tipo, String marca,
			int requesitoEdad, int enExistencia){
		Iterator<Juguete> itrJug = listaJuguetes.iterator();
		
		while (itrJug.hasNext())	{
			
			Juguete juguete = itrJug.next();
			
			if (codigo == juguete.getCodigo()){
				
				juguete.setCodigo(codigo);
				juguete.setComplejidad(complejidad);
				juguete.setEnExistencia(enExistencia);
				juguete.setMarca(marca);
				juguete.setRequesitoEdad(requesitoEdad);
				juguete.setTipo(tipo);
				juguete.setValorAdicional(valorAdicional);
				juguete.setValorUnitario(valorUnitario);
				
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
	
	
	
	
	

	
	
