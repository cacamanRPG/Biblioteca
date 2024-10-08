package dominio.entidades;

public class Estudiante extends Usuario{

	private String nombre;
	private int codigo;
	private boolean libroPrestado;
	
	public Estudiante(String nombre, int codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
		
	}

	@Override
	public boolean prestable() {
			
		return !libroPrestado;
	}
	
	@Override
	public void prestado() {
		this.libroPrestado = true;
	}

	
}
