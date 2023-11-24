package com.fundamentosplatzi.spingboot.fundamentosspring.controller;

import com.fundamentosplatzi.spingboot.fundamentosspring.dao.UsuarioDao;
import com.fundamentosplatzi.spingboot.fundamentosspring.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "/usuario/{id}")
    public Usuario getUsuario( @PathVariable Long id ){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Alvaro");
        usuario.setApellido("Neira");
        usuario.setEmail("alvaroneir98@gmail.com");
        usuario.setTelefono("920153123");
        return usuario;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }
    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public void  registrarUsuario(@RequestBody Usuario usuario){
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable long id){
        usuarioDao.eliminar(id);
    }


    @RequestMapping("/usuario4")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Alvaro");
        usuario.setApellido("Neira");
        usuario.setEmail("alvaroneira@gmail.com");
        return usuario;
    }
    @RequestMapping("/usuario6")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Sanchez");
        usuario.setEmail("juansanchez@gmail.com");
        return usuario;
    }
}
