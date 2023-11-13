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
	 public int cod_prod;
	  public int cod_provee;
	public  String descripcion;
	public int idtipo;
	public int stock;
	public double precio;
	@Override
	public String toString() {
		return "Productos [cod_prod=" + cod_prod + ", cod_provee=" + cod_provee + ", descripcion=" + descripcion
				+ ", idtipo=" + idtipo + ", stock=" + stock + ", precio=" + precio + "]";
	}
	public Productos() {
		super();
	}
	



	



}