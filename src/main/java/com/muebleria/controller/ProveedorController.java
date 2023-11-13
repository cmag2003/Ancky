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

import com.muebleria.model.Proveedor;
import com.muebleria.model.ProveedorRequest;
import com.muebleria.repository.iProveedorRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("proveedores")
@AllArgsConstructor
public class ProveedorController {
    private  iProveedorRepository repoProv;

    @GetMapping
    public List<Proveedor> findAllProveedor(){
        return repoProv.findAll();
    }

    @GetMapping("{cod_provee}")
    public ResponseEntity<Proveedor> findById(@PathVariable Integer cod_provee){
        return  ResponseEntity.of(repoProv.findById(cod_provee)) ;
    }

    @GetMapping("consulta")
    public List<Proveedor> buscarProveedorPorRazonSocial(String razon){
        if (razon != null) {
                 return repoProv.findByRazonContaining(razon);       
        }
        return repoProv.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Integer registrarProveedor(@RequestBody @Valid ProveedorRequest proveedorRequest){
        Proveedor proveedor = new Proveedor();
        proveedor.cod_provee = proveedorRequest.cod_provee;
        proveedor.razon = proveedorRequest.razon;
        proveedor.ruc = proveedorRequest.ruc;

        Proveedor proveedorGuardado = repoProv.save(proveedor);
        return proveedorGuardado.getCod_provee();
    }

    @DeleteMapping("{cod_provee}")
    public void eliminarProveedor(@PathVariable Integer cod_provee){
         repoProv.deleteById(cod_provee);
    }

    @PutMapping("{cod_provee}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Integer cod_provee , @RequestBody ProveedorRequest proveedorRequest){

            return  repoProv.findById(cod_provee).map(proveedor ->{          
                proveedor.razon = proveedorRequest.razon;
                proveedor.ruc = proveedorRequest.ruc;
                repoProv.save(proveedor);
                return ResponseEntity.ok(proveedor);
            }).orElseGet(() -> ResponseEntity.notFound().build());
    }



}
