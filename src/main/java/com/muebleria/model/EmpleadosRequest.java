package com.muebleria.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

@Setter
public class EmpleadosRequest {
    public int codigo;
    @NotBlank
	public String nombre;
    @NotBlank
	public String apellido;
	public int puesto;
}
