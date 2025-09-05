package com.programacionNCapas.SReynaProgramacionNCapas.DAOJPA;

import com.programacionNCapas.SReynaProgramacionNCapas.JPA.Result;

public interface IMunicipioDAOJPA {

    Result GetAll();

    Result GetByIdEstado(int IdEstado);
}
