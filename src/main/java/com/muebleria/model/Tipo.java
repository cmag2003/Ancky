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

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public String getDes_tipo() {
		return des_tipo;
	}

	public void setDes_tipo(String des_tipo) {
		this.des_tipo = des_tipo;
	}




}