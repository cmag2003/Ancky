package com.muebleria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_det_boleta")
@Data
public class Boleta {
	@Id
	private String num_bol;
	private int cod_prod;
	private int cantidad;
	private double preciovta;
	@Override
	public String toString() {
		return "Boleta [num_bol=" + num_bol + ", cod_prod=" + cod_prod + ", cantidad=" + cantidad + ", preciovta="
				+ preciovta + "]";
	}


	
}
