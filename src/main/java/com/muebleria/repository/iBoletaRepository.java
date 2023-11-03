package com.muebleria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebleria.model.Boleta;

@Repository
public interface iBoletaRepository extends JpaRepository<Boleta, String> {
}
