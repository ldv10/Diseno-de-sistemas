//Universidad Del Valle de Guatemala
//Juan Carlos Tapia 14133
//Leonel Guillen 1414451
//Rodrigo Castro 14092
//Hugo Noriega 14097
//Ejercicio de jugueteria 

import java.awt.List;
import java.util.ArrayList;

public class Proveedor {
	private String nombre;
	private int numero;
	private ArrayList<Juguete> juguetes = new ArrayList<Juguete>();
	
	
	//constructor
	public Proveedor(String nombre, int numero) {
		super();
		this.nombre = nombre;
		this.numero = numero;
	}
	//sets y gets
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public ArrayList<Juguete> getJuguetes() {
		return juguetes;
	}
	public void setJuguetes(ArrayList<Juguete> juguetes) {
		this.juguetes = juguetes;
	}
	
	public void agregarJ (Juguete juguete){
		juguetes.add(juguete);
	}
	
	public void eliminarJ (Juguete juguete){
		juguetes.remove(juguete);
		
	}
	
	
}
