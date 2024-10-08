package dominio.entidades;

import java.util.Objects;

public class Libro implements Comparable<Libro> {

	private String titulo;
	private String autor;
	private Object ISBN;


	public Libro(String titulo, String autor, String ISBN)  {
	this.titulo = titulo;
	this.autor = autor;
	this.ISBN = ISBN;
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Object getISBN() {
		return ISBN;
	}

	public void setISBN(Object iSBN) {
		ISBN = iSBN;
	}

	@Override
	public int compareTo(Libro libro) {
		
		return getTitulo().compareTo(libro.getTitulo());
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN, autor, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(autor, other.autor)
				&& Objects.equals(titulo, other.titulo);
	}

	
	
	
}
