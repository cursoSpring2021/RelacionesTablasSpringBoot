package com.sistemainventario.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 45, nullable = false, unique = true)
	private String nombre;

	public Categoria() {
	}

	public Categoria(Integer id) {
		this.id = id;
	}

	public Categoria(String nombre) {
		this.nombre = nombre;
	}

	public Categoria(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}