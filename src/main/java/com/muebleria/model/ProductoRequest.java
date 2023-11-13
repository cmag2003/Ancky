package com.muebleria.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

@Setter
public class ProductoRequest {
    public int cod_prod;
    public int cod_provee;
    @NotBlank
	public String descripcion;
	public int idtipo;
	public int stock;
	public double precio;
}
