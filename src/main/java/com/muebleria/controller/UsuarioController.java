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

import com.muebleria.model.Usuario;
import com.muebleria.model.UsuarioRequest;
import com.muebleria.repository.IUsuariosRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("usuarios")
@AllArgsConstructor
public class UsuarioController {
    
    private IUsuariosRepository repoUsua; 

    @GetMapping
    public List<Usuario> findAllUsuarios(){
        return repoUsua.findAll();
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Usuario> findByUsuario(@PathVariable Integer codigo){
        return ResponseEntity.of(repoUsua.findById(codigo));
    }
    
    @GetMapping("consulta")
    public  List<Usuario> buscarPorNombreUsuarios(String nombre){
        if (nombre != null) {
            return repoUsua.findByNombreContaining(nombre);
        }
        return repoUsua.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Integer registrarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest){
        Usuario usuario = new Usuario();
        usuario.nombre = usuarioRequest.nombre;
        usuario.apellido = usuarioRequest.apellido;
        usuario.usuario = usuarioRequest.usuario;
        usuario.clave = usuarioRequest.clave;
        usuario.fnacim = usuarioRequest.fnacim;
        usuario.tipo = usuarioRequest.tipo;
        
        Usuario usuaruiGuardado = repoUsua.save(usuario);
        return usuaruiGuardado.getCodigo();
    }


    @DeleteMapping("{codigo}")
    public void eliminarUsuario(@PathVariable Integer codigo){
        repoUsua.deleteById(codigo);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer codigo, @RequestBody UsuarioRequest usuarioRequest){
        return repoUsua.findById(codigo).map(usuario ->{
        usuario.nombre = usuarioRequest.nombre;
        usuario.apellido = usuarioRequest.apellido;
        usuario.usuario = usuarioRequest.usuario;
        usuario.clave = usuarioRequest.clave;
        usuario.fnacim = usuarioRequest.fnacim;
        usuario.tipo = usuarioRequest.tipo;
        repoUsua.save(usuario);
        return ResponseEntity.ok(usuario);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
