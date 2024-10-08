package dominio.servicios;

import java.util.List;

import dominio.entidades.Libro;
import dominio.entidades.Usuario;
import dominio.registros.RegistroPrestamos;

public interface BibliotecaService {

	Boolean registrarLibro(Libro libro1);

	Boolean consultarDisponibilidadLibro(Libro libro);

	Boolean prestarLibro(Usuario usuario, Libro libro, int fechaAlta, int fechaBaja);

	List<RegistroPrestamos> obtenerTodosLosRegistros();

	
	
	
}
