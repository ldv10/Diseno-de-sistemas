import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class usuarios {

public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    String username;
    String password;
	int opcion;
	String userAdmin = "";
	String passAdmin = "";
	String userNormal = "";
	String passNormal = "";
	 opcion = 0;
	int mod = 10;
	String nuevo = "";
	 
	
	 
	
	/**
	ArrayList<String> lista = new ArrayList<String>();
	int  tam = lista.size();
	lista.add("Hugo");
	lista.add("Rodrigo");
	lista.add("juan Carlos");
	lista.add("Leo");
	lista.add("");
	lista.add("");
	lista.add("");
	
	Iterator<String> it = lista.iterator();
	
	**/
	
	while (opcion == 0){
	
	System.out.println("1. Crear usuario");
	System.out.println("2. Iniciar sesion");
	System.out.println("3. Mostrar usuarios existentes");
	System.out.println("4. Modificar usuario");
	
	
	System.out.println("Escoja una opcion");
	
	
	opcion = s.nextInt();
	
	
	ArrayList<String> lista = new ArrayList<String>();
	int  tam = lista.size();
	lista.add("Hugo");
	lista.add("Rodrigo");
	lista.add("juan Carlos");
	lista.add("Leo");
	lista.add(userAdmin);
	
	//lista.set(mod,nuevo);
	
	
	//lista.set(tam,userAdmin);
	
	Iterator<String> it = lista.iterator();
	
	
	
	
	
	
	//}
	
	if (opcion == 1){
		
	System.out.println("Que clase de usuario es usted?");
	System.out.println("1.Administrador");	
	System.out.println("2.Normal");	
	
	int opcion2 = s.nextInt();
	
	if (opcion2 == 1){
	
	System.out.println("Creacion de administrador");
    System.out.println("Nombre de Usuario: ");
    userAdmin = s.next();

    System.out.println("Contraseña: ");
    passAdmin = s.next();

	//lista.set(tam,userAdmin);		
		
	System.out.println("Desea hacer algo mas? 0.Si    1.No");
	opcion = s.nextInt();
	}
	
	
	
	
	if (opcion2 == 2){
		
	System.out.println("Creacion de ausuario normal");
    System.out.println("Nombre de Usuario: ");
	
	
    userNormal = s.next();

    System.out.println("Contraseña: ");
    passNormal = s.next();	
	
	System.out.println("Desea hacer algo mas? 0.Si    1.No");
	opcion = s.nextInt();
		
		
	}
	
	
	}
	
	
	
	
	
	
	
	if (opcion == 2){
		
	System.out.println("Log in:");
    System.out.println("Nombre de Usuario: ");
    username = s.next();

    System.out.println("Contraseña: ");
    password = s.next();

    //users check = new users(username, password);

    if(username.equals(username) && password.equals(password)) 
        System.out.println("Ha iniciado sesion");
	
		
	}
	
	
	
	
	
	if (opcion == 3){
		
	
	while(it.hasNext())
	System.out.println(it.next());
	System.out.println("Desea hacer algo mas? 0.Si    1.No");
	opcion = s.nextInt();

	
		
	}
	
	
	if (opcion == 4){
		
	System.out.println("Que usuario desea modificar (0 - 4)");
	while(it.hasNext())
	System.out.println(it.next());
	mod = s.nextInt();
	
	System.out.println("Por que elemento desea cambiar?");
	
	nuevo = s.next();
	lista.set(mod,nuevo);
	
	
	
	while(it.hasNext())
	System.out.println(it.next());


	System.out.println("Desea hacer algo mas? 0.Si    1.No");
	opcion = s.nextInt();

	
		
	}
	
	

}

}

}
