package com.muebleria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_empleados")
@Data
public class Empleados {
	@Id
	private int codigo;
	private String nombre;
	private String apellido;
	private int puesto;
	@Override
	public String toString() {
		return "Empleados [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", puesto=" + puesto
				+ "]";
	}

	



}
