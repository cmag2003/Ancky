package com.muebleria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_clientes")
@Data
public class Clientes {
	@Id
	private int cod_cliente;
	private String nombre;
	private String apellido;
	@Override
	public String toString() {
		return "Clientes [cod_cliente=" + cod_cliente + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	



}
