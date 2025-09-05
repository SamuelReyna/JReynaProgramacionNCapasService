package com.programacionNCapas.SReynaProgramacionNCapas.RestController;

import com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA.UsuarioDAOJPAImplementation;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.UsuarioJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioDAOJPAImplementation usuarioDAOJPAImplementation;

    @GetMapping
    public ResponseEntity GetAll() {
        Result result = usuarioDAOJPAImplementation.GetAll();
        return ResponseEntity.status(result.status).body(result);
    }

    @GetMapping("/{IdUsuario}")
    public ResponseEntity GetOne(@PathVariable int IdUsuario) {
        Result result = usuarioDAOJPAImplementation.GetOne(IdUsuario);
        return ResponseEntity.status(result.status).body(result);
    }

    @PostMapping()
    public ResponseEntity Add(@RequestBody UsuarioJPA usuario) {
        Result result = usuarioDAOJPAImplementation.Add(usuario);
        return ResponseEntity.status(result.status).body(result);
    }

    @PutMapping("/{IdUsuario}")
    public ResponseEntity Update(@PathVariable int IdUsuario,
            @RequestBody UsuarioJPA usuario) {
        usuario.setIdUser(IdUsuario);
        Result result = usuarioDAOJPAImplementation.Update(usuario);
        return ResponseEntity.status(result.status).body(result);
    }

    //@CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("/{IdUsuario}")
    public ResponseEntity Delete(@PathVariable int IdUsuario) {
        Result result = usuarioDAOJPAImplementation.Delete(IdUsuario);
        return ResponseEntity.status(result.status).body(result);
    }

    @PatchMapping("/estatus/{IdUsuario}")
    public ResponseEntity LogicalDelete(@PathVariable int IdUsuario) {
        Result result = usuarioDAOJPAImplementation.LogicalDelete(IdUsuario);
        return ResponseEntity.status(result.status).body(result);
    }
}
