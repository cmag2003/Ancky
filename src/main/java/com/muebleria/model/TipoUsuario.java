package com.muebleria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_tipos")
@Data
public class TipoUsuario {
	
	
	   @Id
		private int idtipo;
		private String descripcion;
		public int getIdtipo() {
			return idtipo;
		}
		public void setIdtipo(int idtipo) {
			this.idtipo = idtipo;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		
		
}
