package com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA;

import com.programacionNCapas.SReynaProgramacionNCapas.JPA.UsuarioJPA;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOJPAImplementation implements IUsuarioDAOJPA {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Result GetAll() {
        Result result = new Result();
        try {
            TypedQuery<UsuarioJPA> queryUsuario
                    = entityManager.createQuery("FROM Usuario", UsuarioJPA.class);
            result.object = queryUsuario.getResultList();
            result.correct = true;
            result.status = 200;
        } catch (Exception ex) {
            result.ex = ex;
            result.status = 500;
            result.errorMessage = ex.getLocalizedMessage();
            result.correct = false;
        }
        return result;
    }

    @Override
    public Result GetOne(int IdUser) {
        Result result = new Result();
        try {
            UsuarioJPA usuarioJPA = entityManager.find(UsuarioJPA.class, IdUser);
            if (usuarioJPA != null) {
                result.object = usuarioJPA;
                result.correct = true;
                result.status = 200;
            } else {
                result.status = 400;
                result.errorMessage = "Usuario no existe";
            }

        } catch (Exception ex) {
            result.correct = false;
            result.status = 500;

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
            entityManager.persist(usuario);
            result.correct = true;
            result.status = 200;

        } catch (Exception ex) {
            result.ex = ex;
            result.status = 500;
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
            UsuarioJPA usuarioBD = entityManager.find(UsuarioJPA.class, usuario.getIdUser());
            if (usuarioBD != null) {
                usuarioBD.setNombreUsuario(usuario.getNombreUsuario());
                usuarioBD.setApellidoPaterno(usuario.getApellidoPaterno());
                usuarioBD.setApellidoMaterno(usuario.getApellidoMaterno());
                usuarioBD.setCelular(usuario.getCelular());
                usuarioBD.setTelefono(usuario.getTelefono());
                usuarioBD.setEmail(usuario.getEmail());
                usuarioBD.setCurp(usuario.getCurp());
                usuarioBD.setFechaNacimiento(usuario.getFechaNacimiento());
                usuarioBD.setSexo(usuario.getSexo());
                usuarioBD.setPassword(usuario.getPassword());
                usuarioBD.setUsername(usuario.getUsername());
                usuarioBD.Rol.setIdRol(usuario.Rol.getIdRol());

                entityManager.merge(usuarioBD);
                result.correct = true;
                result.status = 200;
            } else {
                result.status = 400;
                result.errorMessage = "Usuario no existe";
            }

        } catch (Exception ex) {
            result.correct = false;
            result.ex = ex;
            result.status = 500;
            result.errorMessage = ex.getLocalizedMessage();
        }

        return result;
    }

    @Transactional
    @Override
    public Result Delete(int IdUsuario) {
        Result result = new Result();
        try {
            UsuarioJPA usuario = entityManager.find(UsuarioJPA.class, IdUsuario);
            if (usuario != null) {
                entityManager.remove(usuario);
                result.status = 200;
                result.correct = true;
            } else {
                result.status = 400;
                result.errorMessage = "Usuario no existe";
            }

        } catch (Exception ex) {
            result.correct = false;
            result.status = 500;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    @Transactional
    @Override
    public Result LogicalDelete(int IdUsuario) {
        Result result = new Result();

        try {
            UsuarioJPA usuarioJPA = entityManager.find(UsuarioJPA.class, IdUsuario);
            if (usuarioJPA != null) {
                usuarioJPA.setEstatus(usuarioJPA.getEstatus() == 1 ? 0 : 1);
                entityManager.merge(usuarioJPA);
                result.correct = true;
                result.status = 200;
            } else {
                result.errorMessage = "Usuario no encontrado";
                result.status = 400;
            }

        } catch (Exception ex) {
            result.status = 500;
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }
}
