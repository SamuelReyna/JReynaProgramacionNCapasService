package com.programacionNCapas.SReynaProgramacionNCapas.RestController;

import com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA.PaisDAOJPAImplementation;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pais")
public class PaisController {

    @Autowired
    private PaisDAOJPAImplementation paisDAOJPAImplementation;

    @GetMapping()
    public ResponseEntity GetAll() {
        Result result = paisDAOJPAImplementation.GetAll();
        return ResponseEntity.status(result.status).body(result);
    }
}
