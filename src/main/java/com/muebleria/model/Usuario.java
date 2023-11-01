package com.muebleria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_usuarios")
@Data
public class Usuario {

	@Id
	 private int codigo;
	 private String nombre;
	 private String apellido;
	
	 private String usuario;
	 private String clave;
	 private String fnacim;
	 private int tipo;
}
