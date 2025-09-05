package com.programacionNCapas.SReynaProgramacionNCapas.RestController;

import com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA.RolDAOJPAImplementation;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rol")
public class RolController {

    @Autowired
    private RolDAOJPAImplementation rolDAOJPAImplementation;

    @GetMapping()
    public ResponseEntity GetAll() {
        Result result = rolDAOJPAImplementation.GetAll();
        return ResponseEntity.status(result.status).body(result);
    }
}
