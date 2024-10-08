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
private long LibroID;
@Column(name = "titulo")
private String Titulo;
@Column(name = "nombreAutor")
private String NombreAutor;

@Column(name = "apellidoAutor")
private String ApellidoAutor;

@Column(name = "categoria")
private String Categoria;
@Column(name = "precio")
private String Precio;

@OneToMany(mappedBy = "libros")
@JsonManagedReference
private List<Ordenes> ordenes;



public Libros() {
	super();
}
public Libros(long libroID, String titulo, String nombreAutor, String categoria, String precio, List<Ordenes> ordenes) {
	super();
	LibroID = libroID;
	Titulo = titulo;
	NombreAutor = nombreAutor;
	Categoria = categoria;
	Precio = precio;
	this.ordenes = ordenes;
}
public long getLibroID() {
	return LibroID;
}
public void setLibroID(long libroID) {
	LibroID = libroID;
}
public String getTitulo() {
	return Titulo;
}
public void setTitulo(String titulo) {
	Titulo = titulo;
}
public String getNombreAutor() {
	return NombreAutor;
}
public void setNombreAutor(String nombreAutor) {
	NombreAutor = nombreAutor;
}
public String getCategoria() {
	return Categoria;
}
public void setCategoria(String categoria) {
	Categoria = categoria;
}
public String getPrecio() {
	return Precio;
}
public void setPrecio(String precio) {
	Precio = precio;
}
public List<Ordenes> getOrdenes() {
	return ordenes;
}
public void setOrdenes(List<Ordenes> ordenes) {
	this.ordenes = ordenes;
}

}
