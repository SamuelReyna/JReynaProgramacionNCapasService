package com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA;

import com.programacionNCapas.SReynaProgramacionNCapas.JPA.ColoniaJPA;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.DireccionJPA;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.UsuarioJPA;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DireccionDAOJPAImplementation implements IDireccionDAOJPA {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Result GetOne(int IdDireccion) {
        Result result = new Result();
        try {
            DireccionJPA direccionJPA = entityManager.find(DireccionJPA.class, IdDireccion);
            if (direccionJPA != null) {
                result.object = direccionJPA;
                result.correct = true;
                result.status = 200;
            } else {
                result.status = 400;
                result.errorMessage = "Direccion no existe";
            }
        } catch (Exception ex) {
            result.status = 500;
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    @Transactional
    @Override
    public Result Add(UsuarioJPA usuario) {

        Result result = new Result();
        try {
            DireccionJPA direccion = usuario.Direcciones.get(0);

            UsuarioJPA usuarioRef = entityManager.getReference(UsuarioJPA.class, usuario.getIdUser());
            ColoniaJPA coloniaRef = entityManager.getReference(ColoniaJPA.class, direccion.Colonia.getIdColonia());

            DireccionJPA direccionJPA = new DireccionJPA();
            direccionJPA.setCalle(direccion.getCalle());
            direccionJPA.setNumeroInterior(direccion.getNumeroInterior());
            direccionJPA.setNumeroExterior(direccion.getNumeroExterior());
            direccionJPA.setUsuario(usuarioRef);
            direccionJPA.setColonia(coloniaRef);

            entityManager.persist(direccionJPA);
            result.correct = true;
            result.status = 200;
        } catch (Exception ex) {
            result.status = 500;
            result.correct = false;
            result.ex = ex;
            result.errorMessage = ex.getLocalizedMessage();
        }
        return result;
    }

    @Transactional
    @Override
    public Result Delete(int IdDireccion) {
        Result result = new Result();
        try {
            DireccionJPA direccion = entityManager.find(DireccionJPA.class, IdDireccion);
            if (direccion != null) {
                entityManager.remove(direccion);
                result.correct = true;
                result.status = 200;
            } else {
                result.status = 400;
                result.errorMessage = "Dirección no existe";
            }

        } catch (Exception ex) {
            result.ex = ex;
            result.errorMessage = ex.getLocalizedMessage();
            result.correct = false;
        }
        return result;
    }

    @Transactional
    @Override
    public Result Update(UsuarioJPA usuario) {
        Result result = new Result();

        try {
            DireccionJPA direccionBD = entityManager.find(DireccionJPA.class, usuario.Direcciones.get(0).getIdDireccion());
            if (direccionBD != null) {
                DireccionJPA direccion = usuario.Direcciones.get(0);

                UsuarioJPA usuarioRef = entityManager.getReference(UsuarioJPA.class, usuario.getIdUser());
                ColoniaJPA coloniaRef = entityManager.getReference(ColoniaJPA.class, direccion.Colonia.getIdColonia());

                direccionBD.setCalle(direccion.getCalle());
                direccionBD.setNumeroInterior(direccion.getNumeroInterior());
                direccionBD.setNumeroExterior(direccion.getNumeroExterior());
                direccionBD.setUsuario(usuarioRef);
                direccionBD.setColonia(coloniaRef);
                entityManager.merge(direccionBD);
                result.correct = true;
                result.status = 200;
            } else {
                result.status = 400;
                result.errorMessage = "Direccion no existe";
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;

    }
}
