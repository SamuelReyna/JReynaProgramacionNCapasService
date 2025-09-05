package com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA;

import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.UsuarioJPA;

public interface IUsuarioDAOJPA {

    Result GetAll();

    Result GetOne(int IdUser);

    Result Add(UsuarioJPA usuario);

    Result Update(UsuarioJPA usuario);

    Result Delete(int IdUsuario);
    
    Result LogicalDelete(int IdUsuario);

}
