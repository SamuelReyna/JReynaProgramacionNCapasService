package com.programacionNCapas.SReynaProgramacionNCapas.RestController;

import com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA.DireccionDAOJPAImplementation;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.UsuarioJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/direccion")
public class DireccionController {

    @Autowired
    private DireccionDAOJPAImplementation direccionDAOJPAImplementation;

    @GetMapping("/{IdDireccion}")
    public ResponseEntity GetOne(@PathVariable int IdDireccion) {
        Result result = direccionDAOJPAImplementation.GetOne(IdDireccion);
        return ResponseEntity.status(result.status).body(result);
    }

    @PostMapping()
    public ResponseEntity Add(@RequestBody UsuarioJPA usuario) {
        Result result = direccionDAOJPAImplementation.Add(usuario);
        return ResponseEntity.status(result.status).body(result);

    }

    @PutMapping("{IdDireccion}")
    public ResponseEntity Update(@PathVariable int IdDireccion,
            @RequestBody UsuarioJPA usuario) {
        usuario.Direcciones.get(0).setIdDireccion(IdDireccion);
        Result result = direccionDAOJPAImplementation.Update(usuario);
        return ResponseEntity.status(result.status).body(result);
    }

    // @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("/{IdDireccion}")
    public ResponseEntity Delete(@PathVariable() int IdDireccion) {
        Result result = direccionDAOJPAImplementation.Delete(IdDireccion);
        return ResponseEntity.status(result.status).body(result);
    }

}
