import java.util.ArrayList;
import java.util.Iterator;

public class Operador {
	private ArrayList<Juguete> listaJuguetes = new ArrayList<Juguete>();
	private Juguete nuevosDatos = new Juguete(0, 0, 0, 0, 0, null, 0, 0) ;
//private ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
	
	
	
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
	
	
	
	public void ingresarJuguete(double valorUnitario, double valorAdicional, 
			int complejidad, int tipo, int codigo, String marca,
			int requesitoEdad, int enExistencia){
		
	nuevosDatos.setCodigo(codigo);
	nuevosDatos.setComplejidad(complejidad);
	nuevosDatos.setEnExistencia(enExistencia);
	nuevosDatos.setEnExistencia(enExistencia);
	nuevosDatos.setMarca(marca);
	
	nuevosDatos.setRequesitoEdad(requesitoEdad);
	nuevosDatos.setTipo(tipo);
	nuevosDatos.setValorAdicional(valorAdicional);
	nuevosDatos.setValorUnitario(valorUnitario);
			
	listaJuguetes.add(nuevosDatos);
	
	
	
	
	}
	
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
	

	public void mostrar(int codigo){
		Iterator<Juguete> itrJug = listaJuguetes.iterator();
		
	while (itrJug.hasNext())	{
		
		Juguete juguete = itrJug.next();
		
		if (codigo == juguete.getCodigo()){
			
			System.out.println("Datos del juguete seleccionado: ");
			System.out.println("Codigo: " + juguete.getCodigo());
			System.out.println("Complejidad: " + juguete.getComplejidad());
			System.out.println("Existencia:  " + juguete.getEnExistencia());
			System.out.println("Marca:  " +juguete.getMarca());
			System.out.println("Precio Venta: " +juguete.getPrecioVenta());
			System.out.println("Requisito Edad: " +juguete.getRequesitoEdad());
			System.out.println("Tipo: (0 mecanico, 1 electronico " +juguete.getTipo());
		}
		}
	}
	}
	
	
	
	
	

	
	
