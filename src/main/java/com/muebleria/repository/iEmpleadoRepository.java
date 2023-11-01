package com.muebleria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebleria.model.Empleados;

@Repository
public interface iEmpleadoRepository extends JpaRepository<Empleados, Integer> {
	//Metodos Crud
	List<Empleados> findByNombreContaining(String nombre);
}
