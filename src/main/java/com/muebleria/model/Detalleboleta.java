package com.muebleria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

 @Data
 @Table(name="tb_det_boleta")
 @Entity
public class Detalleboleta {
	@Id
	private String num_bol;
	private String cod_prod;
	private int cantidad;
	private int preciovta;
	
}
