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
	private long ordenId;

	@Column(name = "clienteID")
	private String clienteID;

	@ManyToOne
	@JoinColumn(name = "libroId", referencedColumnName = "libroId")
	@JsonBackReference
	private Libros libros;

	@Column(name = "FechaDeOrden")
	private LocalDate fechaOrden;

	public Ordenes() {
		super();
	}

	public Ordenes(long ordenId, String clienteID, Libros libros, LocalDate fechaOrden) {
		super();
		this.ordenId = ordenId;
		this.clienteID = clienteID;
		this.libros = libros;
		this.fechaOrden = fechaOrden;
	}

	public long getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(long ordenId) {
		this.ordenId = ordenId;
	}

	public String getClienteID() {
		return clienteID;
	}

	public void setClienteID(String clienteID) {
		this.clienteID = clienteID;
	}

	public Libros getLibros() {
		return libros;
	}

	public void setLibros(Libros libros) {
		this.libros = libros;
	}

	public LocalDate getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(LocalDate fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
}