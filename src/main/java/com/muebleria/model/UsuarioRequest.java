package com.muebleria.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

@Setter
public class UsuarioRequest {
    @NotBlank
    public String nombre;
    @NotBlank
    public String apellido;
    @NotBlank
    public String usuario;
    @NotBlank
    public String clave;
    @NotBlank
    public String fnacim;
    public int tipo;
}
