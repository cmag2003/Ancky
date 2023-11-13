package com.muebleria.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_proveedores")
@Data
public class Proveedor {
	@Id
	public int cod_provee;
	public String razon;
	public String ruc;
	
	@Override
	public String toString() {
		return "Proveedor [cod_provee=" + cod_provee + ", razon=" + razon + ", ruc=" + ruc + "]";
	}
}