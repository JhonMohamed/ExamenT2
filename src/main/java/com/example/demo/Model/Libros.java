package com.example.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long libroId;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "nombreAutor")
	private String nombreAutor;

	@Column(name = "apellidoAutor")
	private String apellidoAutor; // Renombrar a apellidoAutor

	@Column(name = "categoria")
	private String categoria;

	@Column(name = "precio")
	private String precio;

	@OneToMany(mappedBy = "libros")
	@JsonManagedReference
	private List<Ordenes> ordenes;

	public Libros() {
		super();
	}

	public Libros(long libroId, String titulo, String nombreAutor, String apellidoAutor, String categoria, String precio, List<Ordenes> ordenes) {
		super();
		this.libroId = libroId;
		this.titulo = titulo;
		this.nombreAutor = nombreAutor;
		this.apellidoAutor = apellidoAutor;
		this.categoria = categoria;
		this.precio = precio;
		this.ordenes = ordenes;
	}

	public long getLibroId() {
		return libroId;
	}

	public void setLibroId(long libroId) {
		this.libroId = libroId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getApellidoAutor() {
		return apellidoAutor;
	}

	public void setApellidoAutor(String apellidoAutor) {
		this.apellidoAutor = apellidoAutor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public List<Ordenes> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Ordenes> ordenes) {
		this.ordenes = ordenes;
	}
}
