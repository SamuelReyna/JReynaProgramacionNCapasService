package com.programacionNCapas.SReynaProgramacionNCapas.RestController;

import com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA.EstadoDAOJPAImplementation;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/estado")
public class EstadoController {

    @Autowired
    private EstadoDAOJPAImplementation estadoDAOJPAImplementation;

    @GetMapping()
    public ResponseEntity GetAll() {
        Result result = estadoDAOJPAImplementation.GetAll();
        return ResponseEntity.status(result.status).body(result);
    }

    @GetMapping("/byPais/{IdPais}")
    public ResponseEntity GetByPais(@PathVariable int IdPais) {
        Result result = estadoDAOJPAImplementation.GetByIdPais(IdPais);
        return ResponseEntity.status(result.status).body(result);
    }

}
