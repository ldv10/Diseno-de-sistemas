import java.awt.List;
import java.util.ArrayList;

public class Proveedor {
	//atributos
	private String nombre;
	private int numero;
	ArrayList<Juguete> juguetes = new ArrayList<Juguete>();
	
	//constructores
	public Proveedor(){
		nombre="";
		numero=0;
		ArrayList<Juguete> juguetes = new ArrayList<Juguete>();
	}
	public void setProveedor(String nom, int num){
		setNombre(nom);
		setNumero(num);
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
