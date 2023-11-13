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
	public int codigo;
	public String nombre;
	public String apellido;
	public int puesto;
	@Override
	public String toString() {
		return "Empleados [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", puesto=" + puesto
				+ "]";
	}
	

}
