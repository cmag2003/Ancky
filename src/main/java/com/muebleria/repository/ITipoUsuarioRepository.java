package com.muebleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muebleria.model.TipoUsuario;

public interface ITipoUsuarioRepository 
			extends JpaRepository<TipoUsuario, Integer>{

}
