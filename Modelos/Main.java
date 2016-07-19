import java.util.Scanner;

public class Main {
	public static void main(String[]args){
		Proveedor pro = new Proveedor();
		Scanner t = new Scanner(System.in);
		System.out.println("ingrese nombre del proveedor: ");
		String nombreP = t.nextLine();
		System.out.println("ingrese numero: ");
		int numeroP = t.nextInt();
		pro.setProveedor(nombreP, numeroP);
		
		
		System.out.println("el proveedor es: "+nombreP+numeroP);
	}
}
