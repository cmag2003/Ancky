package com.muebleria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_puesto")
@Data
public class Puesto {
	@Id
	private int id_puesto;
	private String des_puesto;
	@Override
	public String toString() {
		return "Puesto [id_puesto=" + id_puesto + ", des_puesto=" + des_puesto + "]";
	}

	

}