package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import dominio.entidades.Estudiante;
import dominio.entidades.Libro;
import dominio.entidades.Profesor;
import dominio.entidades.Usuario;
import dominio.registros.RegistroPrestamos;
import dominio.servicios.BibliotecaClaseImpl;
import dominio.servicios.BibliotecaService;

class Test_Biblioteca {
	BibliotecaService bibliotecaService = new BibliotecaClaseImpl();

	@BeforeClass
	void init() {

	}

	@Test
	void dadoQueExisteUnSistemaQueAlTenerLibrosSePuedanRegistrar() {
		String titulo = "Los perros marrones";
		String autor = "carlos";
		String ISBN = "A402";
		boolean disponibilidad = true;

		Libro libro1 = new Libro(titulo, autor, ISBN);
		Boolean registrado = bibliotecaService.registrarLibro(libro1);

		assertTrue(registrado);

	}

	@Test
	void dadoQueExisteUnSistemaQueAlTener2LibrosRepetidosQueElSegundoNoSePuedaRegistrar() {

		String titulo = "Los perros marrones";
		String autor = "carlos";
		String ISBN = "A402";
		boolean disponibilidad = true;

		Libro libro1 = new Libro(titulo, autor, ISBN);
		Boolean registrado = bibliotecaService.registrarLibro(libro1);

		assertTrue(registrado);
		assertFalse(bibliotecaService.registrarLibro(libro1));

	}

	@Test
	void dadoQueExisteUnSistemaConLibrosQueSePuedaConsultarLaDisponibilidad() {

		String titulo = "Los perros marrones";
		String autor = "carlos";
		String ISBN = "A402";

		Libro libro1 = new Libro(titulo, autor, ISBN);
		Libro libro2 = new Libro("Como pelearla", "Brandon ", "0001");
		Libro libro3 = new Libro("Como chupar", "Valenkit ", "0002");

		bibliotecaService.registrarLibro(libro1);
		bibliotecaService.registrarLibro(libro2);
		bibliotecaService.registrarLibro(libro3);

		Boolean disponible = this.bibliotecaService.consultarDisponibilidadLibro(libro3);

		assertTrue(disponible);

	}

	@Test
	void dadoQueExisteUnSistemaConLibrosQueSePuedaConsultarLaDisponibilidadDeUnLibroQueNoEstáRegistrado() {

		String titulo = "Los perros marrones";
		String autor = "carlos";
		String ISBN = "A402";

		Libro libro1 = new Libro(titulo, autor, ISBN);
		Libro libro2 = new Libro("Como pelearla", "Brandon ", "0001");
		Libro libro3 = new Libro("Como chupar", "Valenkit ", "0002");

		bibliotecaService.registrarLibro(libro1);
		bibliotecaService.registrarLibro(libro2);

		Boolean disponible = this.bibliotecaService.consultarDisponibilidadLibro(libro3);

		assertFalse(disponible);
	}

	@Test
	void dadoQueExisteUnSistemaConLibrosQueSePuedaRegistrarUnPrestamoAUnEstudiante() {

		String titulo = "Los perros marrones";
		String autor = "carlos";
		String ISBN = "A402";
		boolean disponibilidad = true;

		Libro libro1 = new Libro(titulo, autor, ISBN);
		Libro libro2 = new Libro("Como pelearla", "Brandon ", "0001");
		Libro libro3 = new Libro("Como chupar", "Valenkit ", "0002");

		bibliotecaService.registrarLibro(libro1);
		bibliotecaService.registrarLibro(libro2);
		bibliotecaService.registrarLibro(libro3);

		Usuario estudiante = new Estudiante("Brandon", 001);

		this.bibliotecaService.consultarDisponibilidadLibro(libro3);

		Boolean prestado = this.bibliotecaService.prestarLibro(estudiante, libro3, 81025, 81025);

		assertTrue(prestado);
	}

	@Test
	void dadoQueExisteUnSistemaConLibrosQueNoSePuedaRegistrarUnPrestamoAUnEstudiante2VecesSinHaberloDevueltoALAnterior() {

		String titulo = "Los perros marrones";
		String autor = "carlos";
		String ISBN = "A402";
		boolean disponibilidad = true;

		Libro libro1 = new Libro(titulo, autor, ISBN);
		Libro libro2 = new Libro("Como pelearla", "Brandon ", "0001");
		Libro libro3 = new Libro("Como chupar", "Valenkit ", "0002");

		bibliotecaService.registrarLibro(libro1);
		bibliotecaService.registrarLibro(libro2);
		bibliotecaService.registrarLibro(libro3);

		Usuario estudiante = new Estudiante("Brandon", 001);

		this.bibliotecaService.consultarDisponibilidadLibro(libro3);

		Boolean prestado = this.bibliotecaService.prestarLibro(estudiante, libro3, 81025, 81025);

		assertTrue(prestado);
		assertFalse(this.bibliotecaService.prestarLibro(estudiante, libro2, 81025, 81025));
	}

	@Test
	void dadoQueExisteUnSistemaConLibrosQueSePuedaRegistrar3PrestamosAUnProfesor() {

		String titulo = "Los perros marrones";
		String autor = "carlos";
		String ISBN = "A402";

		Libro libro1 = new Libro(titulo, autor, ISBN);
		Libro libro2 = new Libro("Como pelearla", "Brandon ", "0001");
		Libro libro3 = new Libro("Como chupar", "Valenkit ", "0002");

		bibliotecaService.registrarLibro(libro1);
		bibliotecaService.registrarLibro(libro2);
		bibliotecaService.registrarLibro(libro3);

		Usuario profe = new Profesor("Martinez", "CA04");

		this.bibliotecaService.consultarDisponibilidadLibro(libro3);

		assertTrue(this.bibliotecaService.prestarLibro(profe, libro3, 81025, 81025));
		assertTrue(this.bibliotecaService.prestarLibro(profe, libro2, 81025, 81025));
		assertTrue(this.bibliotecaService.prestarLibro(profe, libro2, 81025, 81025));
		assertFalse(this.bibliotecaService.prestarLibro(profe, libro2, 81025, 81025));
	}

	@Test
	public void queSeRegistrenLosRegistros() {
		String titulo = "Los perros marrones";
		String autor = "carlos";
		String ISBN = "A402";
		boolean disponibilidad = true;

		Libro libro1 = new Libro(titulo, autor, ISBN);
		Libro libro2 = new Libro("Como pelearla", "Brandon ", "0001");
		Libro libro3 = new Libro("Como chupar", "Valenkit ", "0002");

		bibliotecaService.registrarLibro(libro1);
		bibliotecaService.registrarLibro(libro2);
		bibliotecaService.registrarLibro(libro3);

		Usuario estudiante = new Estudiante("Brandon", 001);
		Usuario estudiante2 = new Estudiante("Brandon", 002);
		Usuario estudiante3 = new Estudiante("Brandon", 001);

		this.bibliotecaService.consultarDisponibilidadLibro(libro3);

		this.bibliotecaService.prestarLibro(estudiante, libro3, 81025, 81025);
		this.bibliotecaService.prestarLibro(estudiante2, libro1, 81025, 81025);
		this.bibliotecaService.prestarLibro(estudiante3, libro2, 81025, 81025);

		List<RegistroPrestamos> registros = bibliotecaService.obtenerTodosLosRegistros();

		System.out.println(libro1.hashCode());
		
		for (RegistroPrestamos registro : registros) {
			System.out.println(registro);

		}
	}

}
