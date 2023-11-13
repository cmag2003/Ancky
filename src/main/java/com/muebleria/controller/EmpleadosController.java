package com.muebleria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.muebleria.model.Empleados;
import com.muebleria.model.EmpleadosRequest;
import com.muebleria.repository.iEmpleadoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("empleados")
@AllArgsConstructor
public class EmpleadosController {
    private  iEmpleadoRepository repoEmp;

    @GetMapping
    public List<Empleados> findAllEmpleados(){
      return  repoEmp.findAll();
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Empleados> findByEmpleados(@PathVariable Integer codigo){
        return ResponseEntity.of(repoEmp.findById(codigo));
    }

    @GetMapping("consulta")
    public List<Empleados> buscarPorNombreEmpleados(String nombre ){
        if (nombre != null) {
            return repoEmp.findByNombreContaining(nombre);
        }
        return repoEmp.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Integer resgistrarEmpleado(@RequestBody @Valid EmpleadosRequest empleadosRequest ){
        Empleados empleados = new Empleados();
        empleados.codigo = empleadosRequest.codigo;
        empleados.nombre = empleadosRequest.nombre;
        empleados.apellido = empleadosRequest.apellido;
        empleados.puesto = empleadosRequest.puesto;

        Empleados empleadoGuardado = repoEmp.save(empleados);
        return empleadoGuardado.getCodigo();
    }

    @DeleteMapping("{codigo}")
    public void eliminarEmpleado(@PathVariable Integer codigo){
         repoEmp.deleteById(codigo);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<Empleados> actualizarEmpleados(@PathVariable Integer codigo, @RequestBody EmpleadosRequest empleadosRequest ){
        return repoEmp.findById(codigo).map(empleado ->{
            empleado.nombre = empleadosRequest.nombre;
            empleado.apellido = empleadosRequest.apellido;
            empleado.puesto = empleadosRequest.puesto;
            repoEmp.save(empleado);
             return ResponseEntity.ok(empleado);
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
