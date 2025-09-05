package com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA;

import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;
import com.programacionNCapas.SReynaProgramacionNCapas.JPA.UsuarioJPA;

public interface IDireccionDAOJPA {

    Result GetOne(int IdDireccion);

    Result Add(UsuarioJPA usuario);

    Result Update(UsuarioJPA usuario);

    Result Delete(int IdDireccion);
}
