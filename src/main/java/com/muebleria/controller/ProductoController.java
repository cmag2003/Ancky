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

import com.muebleria.model.ProductoRequest;
import com.muebleria.model.Productos;
import com.muebleria.repository.iProductoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("productos")
@AllArgsConstructor
public class ProductoController {
    private  iProductoRepository repoProd;

    @GetMapping
    public List<Productos> findAll(){
        return repoProd.findAll();
    }

    @GetMapping("{cod_prod}")
    public ResponseEntity<Productos> findByID(@PathVariable Integer cod_prod){
        return  ResponseEntity.of(repoProd.findById(cod_prod));
    }

    @GetMapping("buscar")
    public List<Productos> buscarPorNombreProductos(String descripcion){
        if(descripcion != null){
            return repoProd.searchByDescripcionContains(descripcion);  
        }
        return repoProd.findAll();
    }
    

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Integer registrarProducto(@RequestBody @Valid ProductoRequest productoRequest ){
        Productos productos = new Productos();
        productos.cod_prod = productoRequest.cod_prod;
        productos.cod_provee = productoRequest.cod_provee;
        productos.descripcion = productoRequest.descripcion;
        productos.idtipo = productoRequest.idtipo;
        productos.stock = productoRequest.stock;
        productos.precio = productoRequest.precio;

        Productos productoGuardado = repoProd.save(productos);
        return productoGuardado.getCod_prod();

       
    }

    @DeleteMapping("{cod_prod}")
    public void eliminarProducto(@PathVariable Integer cod_prod){
        repoProd.deleteById(cod_prod);
    }


    @PutMapping("{cod_prod}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable Integer cod_prod , @RequestBody ProductoRequest productoRequest) {
		
		return repoProd.findById(cod_prod).map(producto ->{
            producto.cod_provee = productoRequest.cod_provee;
            producto.descripcion = productoRequest.descripcion;
            producto.idtipo = productoRequest.idtipo;
            producto.stock = productoRequest.stock;
            producto.precio = productoRequest.precio;
            repoProd.save(producto);
            return ResponseEntity.ok(producto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
	}

}
