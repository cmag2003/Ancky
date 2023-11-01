package com.muebleria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_productos")
@Data
public class Productos {
	@Id
	private int cod_prod;
	private int cod_provee;
	private String descripcion;
	private int idtipo;
	private int stock;
	private double precio;
	@Override
	public String toString() {
		return "Productos [cod_prod=" + cod_prod + ", cod_provee=" + cod_provee + ", descripcion=" + descripcion
				+ ", idtipo=" + idtipo + ", stock=" + stock + ", precio=" + precio + "]";
	}
	



}