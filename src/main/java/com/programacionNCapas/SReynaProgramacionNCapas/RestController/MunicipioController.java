package com.programacionNCapas.SReynaProgramacionNCapas.RestController;

import com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA.MunicipioDAOJPAImplementation;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/municipio")
public class MunicipioController {

    @Autowired
    private MunicipioDAOJPAImplementation municipioDAOJPAImplementation;

    @GetMapping()
    public ResponseEntity GetAll() {
        Result result = municipioDAOJPAImplementation.GetAll();
        return ResponseEntity.status(result.status).body(result);
    }

    @GetMapping("/byEstado/{IdEstado}")
    public ResponseEntity GetByEstado(@PathVariable int IdEstado) {
        Result result = municipioDAOJPAImplementation.GetByIdEstado(IdEstado);
        return ResponseEntity.status(result.status).body(result);
    }
}
