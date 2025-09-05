package com.programacionNCapas.SReynaProgramacionNCapas.RestController;

import com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA.ColoniaDAOJPAImplementation;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/colonia")
public class ColoniaController {

    @Autowired
    private ColoniaDAOJPAImplementation coloniaDAOJPAImplementation;

    @GetMapping()
    public ResponseEntity GetAll() {
        Result result = coloniaDAOJPAImplementation.GetAll();
        return ResponseEntity.status(result.status).body(result);
    }

    @GetMapping("byMunicipio/{IdMunicipio}")
    public ResponseEntity GetByMunicipio(@PathVariable int IdMunicipio) {
        Result result = coloniaDAOJPAImplementation.GetByIdMunicipio(IdMunicipio);
        return ResponseEntity.status(result.status).body(result);
    }
}
