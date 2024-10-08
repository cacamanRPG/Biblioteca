package dominio.entidades;

public class Profesor extends Usuario {

	private String nombre;
	private String legajo;
	private int librosPrestaos = 0;
	
	public Profesor(String nombre, String legajo) {
		this.nombre = nombre;
		this.legajo = legajo;
	}

	@Override
	public boolean prestable() {
	
		if(this.librosPrestaos >= 3) {
			return false;
		}
		return true;
	}

	@Override
	public void prestado() {
		this.librosPrestaos++;
	}

}
