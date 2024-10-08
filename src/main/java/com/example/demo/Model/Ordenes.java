package com.example.demo.Model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordenes")
public class Ordenes {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long OrdenID;
	@Column(name = "clienteID")
	private String ClienteID;
	@ManyToOne
	@JoinColumn(name = "LibroID", referencedColumnName = "LibroID")
	@JsonBackReference
	private Libros libros;
	
	@Column(name = "FechaDeOrden")
	private LocalDate FechaOrden;

	public Ordenes() {
		super();
	}

	public Ordenes(long ordenID, String clienteID, Libros libros, LocalDate fechaOrden) {
		super();
		OrdenID = ordenID;
		ClienteID = clienteID;
		this.libros = libros;
		FechaOrden = fechaOrden;
	}

	public long getOrdenID() {
		return OrdenID;
	}

	public void setOrdenID(long ordenID) {
		OrdenID = ordenID;
	}

	public String getClienteID() {
		return ClienteID;
	}

	public void setClienteID(String clienteID) {
		ClienteID = clienteID;
	}

	public Libros getLibros() {
		return libros;
	}

	public void setLibros(Libros libros) {
		this.libros = libros;
	}

	public LocalDate getFechaOrden() {
		return FechaOrden;
	}

	public void setFechaOrden(LocalDate fechaOrden) {
		FechaOrden = fechaOrden;
	}

}
