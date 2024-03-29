package com.fundamentosplatzi.spingboot.fundamentosspring.dao;

import com.fundamentosplatzi.spingboot.fundamentosspring.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(long id);

    void registrar(Usuario usuario);
}
