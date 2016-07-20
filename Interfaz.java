import java.util.Scanner;
public class Interfaz {

	public static void main(String[] args) {
		System.out.println("Bienvenido");
		
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		String nombre ="";
		String clave ="";
		int tipoUsuario = 0;
		int opcion1 = 0;
		int opcion2 = 0;
		int numero =0;
		String nuevoNombre = "";
		double valorUnitario = 0;
		double valorAdicional = 0;
		int tipoJuguete = 0;
		int complejidad = 0;
		String marca = "";
		int numProveedor = 0;
		int enExistencia = 0;
		int edadMinima = 0;
		int id=0;
		
		
		
		
		
		ControladorUsuarios conUs = new ControladorUsuarios();
		Operador inventario = new Operador();
		
		
		
		
		do{
		//imprime en pantalla el menu principal 
		System.out.println("¿Que desea hacer?");
		System.out.println("1. Ingresar");
		System.out.println("2. Crear Usuario");
		System.out.println("3. Salir");
		opcion1 = entradaEscaner.nextInt ();
		System.out.println("");
		
		
		//dependiendo del input desplega distintas opciones 
		if(opcion1 == 1){
			//Lsa opcion 1 es para ingresar 
			entradaEscaner.nextLine ();
			System.out.println("Ingrese su nombre:  ");
			nombre = entradaEscaner.nextLine ();
			
			//entradaEscaner.nextLine ();
			System.out.println("Ingrese su contraseña:  ");
			clave = entradaEscaner.nextLine ();
			int userNum  =conUs.validarUsuario(nombre, clave);
			if(userNum>=0)
			{	
				System.out.println("Inicio sesion. Bienvenido "+ nombre);
				tipoUsuario = conUs.getListaUsuarios().get(userNum).getTipo();
				//dependiendo el tipo de trabajador se desplegan distintos menus
				if(tipoUsuario == 1){
					
					do{
					System.out.println("¿Que desea hacer?");
					//menu para trabajador normal
					System.out.println("1. Listar proveedores con mas de 10 juguetes");
					System.out.println("2. Cantidad de juguetes de un proveedor");
					System.out.println("3. Mostrar Juguete con mayor precio de venta");
					System.out.println("4. Lista de juguetes mecanicos por complejidad");
					System.out.println("5. Lista de juguetes electronicos por precio de venta");
					System.out.println("6. Cantidad de juguetes electronicos y mecanicos de un proveedor");
					System.out.println("7. Cantidad de proveedores por tipo de juguete");
					System.out.println("8. Ver juguetes");
					System.out.println("9. Ver proveedores");
					System.out.println("10. Salir");
					
					opcion2 = entradaEscaner.nextInt ();
					System.out.println("");
					switch (opcion2){
						
					case 1:
						inventario.listarProveedores10();
						break;
						//se va al operador y hace la funcion de listar los proveedores con mas de 10 juguetes
					case 2:
						
						entradaEscaner.nextLine ();
						inventario.mostrarProveedores();
						if (!inventario.getListaProveedores().isEmpty())
						{
							System.out.println("Ingrese el nombre del proveedor que desea revisar:  ");
							nombre = entradaEscaner.nextLine();
							
						}
						inventario.CuantosJuguetesTieneProveedor(nombre);
						break;	
						
					case 3:
						inventario.MayorPrecioVenta();
						break;
						
					case 4:
						inventario.MecanicosPorComplejidad();
						break;
					
					case 5:
						inventario.ElectronicosPorPrecioVenta();
						break;
					case 6:
						entradaEscaner.nextLine ();
						inventario.mostrarProveedores();
						if (!inventario.getListaProveedores().isEmpty())
						{
							System.out.println("Ingrese el nombre del proveedor que desea revisar:  ");
							nombre = entradaEscaner.nextLine();
							
						}
						inventario.ElectronicosyMecanicosPorProveedor(nombre);
						break;
					case 7:
						entradaEscaner.nextLine ();
						System.out.println("Ingrese un tipo de juguete. 1 Mecanico.  2. Electronico  ");
						tipoJuguete = entradaEscaner.nextInt();
						inventario.ProveedoresPorTipo(tipoJuguete);
						break;
					
					case 8: 
						inventario.mostrarJuguetes();
						break;
					
					
					case 9: 
						inventario.mostrarProveedores();
						break;
				}
					
					
					} while (opcion2 !=10);
				}
				
				if (tipoUsuario == 2)
				{
					do {
						System.out.println("¿Que desea hacer?");
						
						System.out.println("1. Ingresar proveedor");
						System.out.println("2. Modificar proveedor");
						System.out.println("3. Eliminar proveedor");
						System.out.println("4. Ingresar juguete");
						System.out.println("5. Modificar juguete");
						System.out.println("6. Eliminar juguete");
						System.out.println("7. Listar proveedores con mas de 10 juguetes");
						System.out.println("8. Cantidad de juguetes de un proveedor");
						System.out.println("9. Mostrar Juguete con mayor precio de venta");
						System.out.println("10. Lista de juguetes mecanicos por complejidad");
						System.out.println("11. Lista de juguetes electronicos por precio de venta");
						System.out.println("12. Cantidad de juguetes electronicos y mecanicos de un proveedor");
						System.out.println("13. Cantidad de proveedores por tipo de juguete");
						System.out.println("14. Ver juguetes");
						System.out.println("15. Ver proveedores");
						System.out.println("16. Salir");
						opcion2 = entradaEscaner.nextInt ();
						System.out.println("");
						
						switch (opcion2){
						case 1: 
							entradaEscaner.nextLine ();
							System.out.println("Ingrese el nombre del proveedor:  ");
							nombre = entradaEscaner.nextLine ();
							inventario.IngresarProveedor(nombre);
							break;
							
						case 2: 
							entradaEscaner.nextLine ();
							inventario.mostrarProveedores();
							if (!inventario.getListaProveedores().isEmpty())
							{
								System.out.println("Ingrese el numero del proveedor que quiere modificar:  ");
								numero = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								System.out.println("Ingrese el nuevo nombre del proveedor que quiere modificar:  ");
								nuevoNombre = entradaEscaner.nextLine ();
							}
							inventario.ModificarProveedor(numero, nuevoNombre);
							break;
						
							
						case 3: 
							entradaEscaner.nextLine ();
							inventario.mostrarProveedores();
							if (!inventario.getListaProveedores().isEmpty())
							{
								System.out.println("Ingrese el numero del proveedor que quiere borrar:  ");
								numero = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
							}
							inventario.EliminarProveedor(numero);
							break;
						
						case 4:
							entradaEscaner.nextLine ();
							if(inventario.getListaProveedores().isEmpty())
							{
								System.out.println("No hay proveedores. Necesita proveedores para ingresar juguetes");
							}
							else
							{
								System.out.println("Ingrese el nombre del Juguete:  ");
								nombre = entradaEscaner.nextLine ();
								System.out.println("Ingrese el valor unitario del juguete:  ");
								valorUnitario = entradaEscaner.nextDouble ();
								entradaEscaner.nextLine ();
								System.out.println("Ingrese el valor adicional del juguete:  ");
								valorAdicional = entradaEscaner.nextDouble ();
								entradaEscaner.nextLine ();
								
								System.out.println("Ingrese el tipo del juguete.  1. Mecanico.  2. Electronico:   ");
								tipoJuguete = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								if (tipoJuguete==1)
								{
									System.out.println("Ingrese la complejidad del juguete:   ");
									complejidad = entradaEscaner.nextInt ();
									entradaEscaner.nextLine ();
								}
								else
									complejidad=0;
								System.out.println("Ingrese la marca del juguete:   ");
								marca = entradaEscaner.nextLine ();
								
								System.out.println("Ingrese la edad minima para usar el juguete:   ");
								edadMinima = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								
								System.out.println("Ingrese la cantidad en existencia del juguete:   ");
								complejidad = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								
								System.out.println("Ingrese el proveedor del juguete:   ");
								inventario.mostrarProveedores();
								numProveedor = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								
								inventario.IngresarJuguete(nombre, valorUnitario, valorAdicional, complejidad, tipoJuguete, marca, edadMinima, enExistencia, numProveedor);
							
							}
							break;
					
							
						case 5:
							inventario.mostrarJuguetes();
							if (!inventario.getListaJuguetes().isEmpty())
							{
								System.out.println("Ingrese el numero del codigo del juguete que quiere modificar:  ");
								numero = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								System.out.println("Ingrese el nuevo nombre del juguete que quiere modificar:  ");
								nombre = entradaEscaner.nextLine ();
								System.out.println("Ingrese el valor unitario del juguete:  ");
								valorUnitario = entradaEscaner.nextDouble ();
								entradaEscaner.nextLine ();
								System.out.println("Ingrese el valor adicional del juguete:  ");
								valorAdicional = entradaEscaner.nextDouble ();
								entradaEscaner.nextLine ();
								
								System.out.println("Ingrese el tipo del juguete.  1. Mecanico.  2. Electronico:   ");
								tipoJuguete = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								if (tipoJuguete==1)
								{
									System.out.println("Ingrese la complejidad del juguete:   ");
									complejidad = entradaEscaner.nextInt ();
									entradaEscaner.nextLine ();
								}
								else
									complejidad=0;
								System.out.println("Ingrese la marca del juguete:   ");
								marca = entradaEscaner.nextLine ();
								
								System.out.println("Ingrese la cantidad en existencia del juguete:   ");
								complejidad = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								
								System.out.println("Ingrese el proveedor del juguete:   ");
								inventario.mostrarProveedores();
								numProveedor = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								
								inventario.modificarJuguete(numero, nombre, valorUnitario, valorAdicional, complejidad, tipoJuguete, marca, edadMinima, enExistencia, numProveedor);
								
							}
							
							
							break;
						case 6:
							entradaEscaner.nextLine ();
							inventario.mostrarJuguetes();
							if (!inventario.getListaProveedores().isEmpty())
							{
								System.out.println("Ingrese el codigo del juguete que quiere borrar:  ");
								numero = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
							}
							inventario.EliminarJuguete(numero);
							break;
							
						case 7:
							inventario.listarProveedores10();
							break;
							
						case 8:
							
							entradaEscaner.nextLine ();
							inventario.mostrarProveedores();
							if (!inventario.getListaProveedores().isEmpty())
							{
								System.out.println("Ingrese el nombre del proveedor que desea revisar:  ");
								nombre = entradaEscaner.nextLine();
								
							}
							inventario.CuantosJuguetesTieneProveedor(nombre);
							break;	
							
						case 9:
							inventario.MayorPrecioVenta();
							break;
							
						case 10:
							inventario.MecanicosPorComplejidad();
							break;
						
						case 11:
							inventario.ElectronicosPorPrecioVenta();
							break;
						case 12:
							entradaEscaner.nextLine ();
							inventario.mostrarProveedores();
							if (!inventario.getListaProveedores().isEmpty())
							{
								System.out.println("Ingrese el nombre del proveedor que desea revisar:  ");
								nombre = entradaEscaner.nextLine();
								
							}
							inventario.ElectronicosyMecanicosPorProveedor(nombre);
							break;
						case 13:
							entradaEscaner.nextLine ();
							System.out.println("Ingrese un tipo de juguete. 1 Mecanico.  2. Electronico  ");
							tipoJuguete = entradaEscaner.nextInt();
							inventario.ProveedoresPorTipo(tipoJuguete);
							break;
						
						case 14: 
							inventario.mostrarJuguetes();
							break;
						
						
						case 15: 
							inventario.mostrarProveedores();
							break;
					}
						
						
						
					}while(opcion2!=16);
					
				}
				
				
				if(tipoUsuario == 3){
					do {
						System.out.println("¿Que desea hacer?");
						
						System.out.println("1. Ingresar proveedor");
						System.out.println("2. Modificar proveedor");
						System.out.println("3. Eliminar proveedor");
						System.out.println("4. Ingresar juguete");
						System.out.println("5. Modificar juguete");
						System.out.println("6. Eliminar juguete");
						System.out.println("7. Listar proveedores con mas de 10 juguetes");
						System.out.println("8. Cantidad de juguetes de un proveedor");
						System.out.println("9. Mostrar Juguete con mayor precio de venta");
						System.out.println("10. Lista de juguetes mecanicos por complejidad");
						System.out.println("11. Lista de juguetes electronicos por precio de venta");
						System.out.println("12. Cantidad de juguetes electronicos y mecanicos de un proveedor");
						System.out.println("13. Cantidad de proveedores por tipo de juguete");
						System.out.println("14. Ver juguetes");
						System.out.println("15. Ver proveedores");
						System.out.println("16. Modificar Usuarios");
						System.out.println("17. Salir");
						opcion2 = entradaEscaner.nextInt ();
						System.out.println("");
						
						switch (opcion2){
						case 1: 
							entradaEscaner.nextLine ();
							System.out.println("Ingrese el nombre del proveedor:  ");
							nombre = entradaEscaner.nextLine ();
							inventario.IngresarProveedor(nombre);
							break;
							
						case 2: 
							entradaEscaner.nextLine ();
							inventario.mostrarProveedores();
							if (!inventario.getListaProveedores().isEmpty())
							{
								System.out.println("Ingrese el numero del proveedor que quiere modificar:  ");
								numero = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								System.out.println("Ingrese el nuevo nombre del proveedor que quiere modificar:  ");
								nuevoNombre = entradaEscaner.nextLine ();
							}
							inventario.ModificarProveedor(numero, nuevoNombre);
							break;
						
							
						case 3: 
							entradaEscaner.nextLine ();
							inventario.mostrarProveedores();
							if (!inventario.getListaProveedores().isEmpty())
							{
								System.out.println("Ingrese el numero del proveedor que quiere borrar:  ");
								numero = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
							}
							inventario.EliminarProveedor(numero);
							break;
						
						case 4:
							entradaEscaner.nextLine ();
							if(inventario.getListaProveedores().isEmpty())
							{
								System.out.println("No hay proveedores. Necesita proveedores para ingresar juguetes");
							}
							else
							{
								System.out.println("Ingrese el nombre del Juguete:  ");
								nombre = entradaEscaner.nextLine ();
								System.out.println("Ingrese el valor unitario del juguete:  ");
								valorUnitario = entradaEscaner.nextDouble ();
								entradaEscaner.nextLine ();
								System.out.println("Ingrese el valor adicional del juguete:  ");
								valorAdicional = entradaEscaner.nextDouble ();
								entradaEscaner.nextLine ();
								
								System.out.println("Ingrese el tipo del juguete.  1. Mecanico.  2. Electronico:   ");
								tipoJuguete = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								if (tipoJuguete==1)
								{
									System.out.println("Ingrese la complejidad del juguete:   ");
									complejidad = entradaEscaner.nextInt ();
									entradaEscaner.nextLine ();
								}
								else
									complejidad=0;
								System.out.println("Ingrese la marca del juguete:   ");
								marca = entradaEscaner.nextLine ();
								
								System.out.println("Ingrese la edad minima para usar el juguete:   ");
								edadMinima = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								
								System.out.println("Ingrese la cantidad en existencia del juguete:   ");
								complejidad = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								
								System.out.println("Ingrese el proveedor del juguete:   ");
								inventario.mostrarProveedores();
								numProveedor = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								
								inventario.IngresarJuguete(nombre, valorUnitario, valorAdicional, complejidad, tipoJuguete, marca, edadMinima, enExistencia, numProveedor);
							
							}
							break;
					
							
						case 5:
							inventario.mostrarJuguetes();
							if (!inventario.getListaJuguetes().isEmpty())
							{
								System.out.println("Ingrese el numero del codigo del juguete que quiere modificar:  ");
								numero = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								System.out.println("Ingrese el nuevo nombre del juguete que quiere modificar:  ");
								nombre = entradaEscaner.nextLine ();
								System.out.println("Ingrese el valor unitario del juguete:  ");
								valorUnitario = entradaEscaner.nextDouble ();
								entradaEscaner.nextLine ();
								System.out.println("Ingrese el valor adicional del juguete:  ");
								valorAdicional = entradaEscaner.nextDouble ();
								entradaEscaner.nextLine ();
								
								System.out.println("Ingrese el tipo del juguete.  1. Mecanico.  2. Electronico:   ");
								tipoJuguete = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								if (tipoJuguete==1)
								{
									System.out.println("Ingrese la complejidad del juguete:   ");
									complejidad = entradaEscaner.nextInt ();
									entradaEscaner.nextLine ();
								}
								else
									complejidad=0;
								System.out.println("Ingrese la marca del juguete:   ");
								marca = entradaEscaner.nextLine ();
								
								System.out.println("Ingrese la cantidad en existencia del juguete:   ");
								complejidad = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								
								System.out.println("Ingrese el proveedor del juguete:   ");
								inventario.mostrarProveedores();
								numProveedor = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
								
								inventario.modificarJuguete(numero, nombre, valorUnitario, valorAdicional, complejidad, tipoJuguete, marca, edadMinima, enExistencia, numProveedor);
								
							}
							
							
							break;
						case 6:
							entradaEscaner.nextLine ();
							inventario.mostrarJuguetes();
							if (!inventario.getListaProveedores().isEmpty())
							{
								System.out.println("Ingrese el codigo del juguete que quiere borrar:  ");
								numero = entradaEscaner.nextInt ();
								entradaEscaner.nextLine ();
							}
							inventario.EliminarJuguete(numero);
							break;
							
						case 7:
							inventario.listarProveedores10();
							break;
							
						case 8:
							
							entradaEscaner.nextLine ();
							inventario.mostrarProveedores();
							if (!inventario.getListaProveedores().isEmpty())
							{
								System.out.println("Ingrese el nombre del proveedor que desea revisar:  ");
								nombre = entradaEscaner.nextLine();
								
							}
							inventario.CuantosJuguetesTieneProveedor(nombre);
							break;	
							
						case 9:
							inventario.MayorPrecioVenta();
							break;
							
						case 10:
							inventario.MecanicosPorComplejidad();
							break;
						
						case 11:
							inventario.ElectronicosPorPrecioVenta();
							break;
						case 12:
							entradaEscaner.nextLine ();
							inventario.mostrarProveedores();
							if (!inventario.getListaProveedores().isEmpty())
							{
								System.out.println("Ingrese el nombre del proveedor que desea revisar:  ");
								nombre = entradaEscaner.nextLine();
								
							}
							inventario.ElectronicosyMecanicosPorProveedor(nombre);
							break;
						case 13:
							entradaEscaner.nextLine ();
							System.out.println("Ingrese un tipo de juguete. 1 Mecanico.  2. Electronico  ");
							tipoJuguete = entradaEscaner.nextInt();
							inventario.ProveedoresPorTipo(tipoJuguete);
							break;
						
						case 14: 
							inventario.mostrarJuguetes();
							break;
						
						
						case 15: 
							inventario.mostrarProveedores();
							break;
						case 16: 
							entradaEscaner.nextLine ();
							conUs.mostrarUsuarios();
							System.out.println("Ingrese el numero del usuario que desea modificar:  ");
							id = entradaEscaner.nextInt ();
							
							entradaEscaner.nextLine ();
							System.out.println("Ingrese el nuevo nombre del usuario:  ");
							nombre = entradaEscaner.nextLine ();
							
							
							System.out.println("Ingrese la nueva posicion del usuario.  1. Empleado de caja.  2 Encargado de inventario.  3.  Director de tienda" );
							tipoUsuario = entradaEscaner.nextInt ();
							
							
							conUs.modificarUsuario(id, nombre, tipoUsuario);
							break;
					}
						
						
						
					}while(opcion2!=17);
					
					
				}
				
				
			}
			else
				System.out.println("Usuario o contraseña equivocada");
			
		}
		
		if (opcion1 == 2){
			entradaEscaner.nextLine ();
			System.out.println("Ingrese su nombre:  ");
			nombre = entradaEscaner.nextLine ();
			
			//entradaEscaner.nextLine ();
			System.out.println("Ingrese su contraseña:  ");
			clave = entradaEscaner.nextLine ();
			
			System.out.println("¿Cual es su posicion?  1. Empleado de caja.  2 Encargado de inventario.  3.  Director de tienda" );
			tipoUsuario = entradaEscaner.nextInt ();
			
			System.out.println("");

			conUs.nuevoUsuario(nombre, clave, tipoUsuario);
		}
		
		} while (opcion1!=3);

		
		System.out.println("Hasta pronto");
	}


}
