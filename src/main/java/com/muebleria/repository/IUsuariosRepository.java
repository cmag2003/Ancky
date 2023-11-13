package com.muebleria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.muebleria.model.Usuario;

public interface IUsuariosRepository  extends JpaRepository<Usuario, Integer>{

	

	Usuario findByUsuario(String usuario);


	List<Usuario> findByNombreContaining(String nombre);


}
