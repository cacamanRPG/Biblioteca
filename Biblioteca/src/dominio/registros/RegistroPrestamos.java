package dominio.registros;

import dominio.entidades.Libro;
import dominio.entidades.Usuario;

public class RegistroPrestamos {

	
	private Usuario usuario;
	private Libro libro;
	private int fechaAlta;
	private int fechaBaja;
	private int codigo;
	
	public RegistroPrestamos(Usuario usuario, Libro libro, int fechaAlta, int fechaBaja) {
		this.usuario = usuario;
		this.libro = libro;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public int getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(int fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(int fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	
	@Override
	public String toString() {
		return "RegistroPrestamos [usuario=" + usuario + ", libro=" + libro + ", fechaAlta=" + fechaAlta
				+ ", fechaBaja=" + fechaBaja + ", código="+ codigo +"]";
	}

	public void setCodigo(int proximoCodigo) {
		this.codigo = proximoCodigo;
		
	}

	
	
}
