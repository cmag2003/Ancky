package com.muebleria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_tipo")
@Data
public class Tipo {
	@Id
	private int idtipo;
	private String des_tipo;
	
	@Override
	public String toString() {
		return "Tipo [idtipo=" + idtipo + ", des_tipo=" + des_tipo + "]";
	}




}