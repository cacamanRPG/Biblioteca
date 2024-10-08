package dominio.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import dominio.entidades.Estudiante;
import dominio.entidades.Libro;
import dominio.entidades.Usuario;
import dominio.registros.RegistroPrestamos;

public class BibliotecaClaseImpl implements BibliotecaService {
	private Set<Libro> librosRegistrados = new TreeSet<Libro>();
	private List<RegistroPrestamos> registroDePrestamos = new ArrayList<RegistroPrestamos>();
	private int codigoPalRegistro = -1;


	@Override
	public Boolean registrarLibro(Libro libro1) {
		return this.librosRegistrados.add(libro1);

	}

	@Override
	public Boolean prestarLibro(Usuario usuario, Libro libro, int fechaAlta, int fechaBaja) {

		if (usuario.prestable()) {
			RegistroPrestamos registro = new RegistroPrestamos(usuario, libro, fechaAlta, fechaBaja);
			usuario.prestado();
			registro.setCodigo(this.proximoCodigo());
			this.registroDePrestamos.add(registro);
			
			return true;
		}

		return false;
	}

	private int proximoCodigo() {
		this.codigoPalRegistro++;
		return this.codigoPalRegistro;
	}

	@Override
	public Boolean consultarDisponibilidadLibro(Libro libro) {

		for (Libro libroABuscar : this.librosRegistrados) {
			if (libroABuscar.equals(libro)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public List<RegistroPrestamos> obtenerTodosLosRegistros() {

		return this.registroDePrestamos;
	}

}
