package com.muebleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muebleria.model.Puesto;



public interface iPuestoRepository extends JpaRepository<Puesto, Integer> {
	//Metodos Crud
}
