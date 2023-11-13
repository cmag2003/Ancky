package com.muebleria.model;


import jakarta.validation.constraints.NotBlank;
import lombok.Setter;


@Setter
public class ProveedorRequest {
    
    public int cod_provee;
    @NotBlank
    public String razon;
     @NotBlank
	public String ruc;
    
}
