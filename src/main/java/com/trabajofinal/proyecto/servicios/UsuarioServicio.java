/*
 
 */
package com.trabajofinal.proyecto.servicios;

import com.trabajofinal.proyecto.entidades.Usuario;
import com.trabajofinal.proyecto.enums.Rol;
import com.trabajofinal.proyecto.repositorios.UsuarioRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author VicMusic
 */
@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuariorepositorio;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Usuario guardarUsuario(String rol, String email, String clave, Date creado, Date editado, boolean activo) throws Exception {
        
        validar(rol, email, clave, creado, editado, activo);
        
        Usuario usuarioG = new Usuario();

        usuarioG.setRol(Rol.valueOf(rol));
        usuarioG.setEmail(email);
        usuarioG.setClave(clave);
        usuarioG.setClave(clave);
        usuarioG.setCreado(new Date());
        usuarioG.setEditado(new Date());
        usuarioG.setActivo(true);

        return usuariorepositorio.save(usuarioG);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Usuario altaUsuario(String id) {

        Usuario usuarioA = usuariorepositorio.getOne(id);
        usuarioA.setActivo(true);
        return usuariorepositorio.save(usuarioA);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Usuario bajaUsuario(String id) {

        Usuario usuarioB = usuariorepositorio.getOne(id);

        usuarioB.setActivo(false);
        return usuariorepositorio.save(usuarioB);
    }

    // Metodo listar
    @Transactional(readOnly = true)
    public List<Usuario> usuarioActivos() {
        return usuariorepositorio.buscarUsuario();

    }

    public List<Usuario> listarTodo() {
        return usuariorepositorio.findAll();
    }

    public void validar(String rol, String email, String clave, Date creado, Date editado, boolean activo) throws Exception {
        if (rol == null || rol.isEmpty() || rol.contains("  ")) {
            throw new Exception();
        }

        if (email == null || email.isEmpty() || email.contains("  ")) {
            throw new Exception();
        }

        if (clave == null || clave.isEmpty() || clave.contains("  ")) {
            throw new Exception();
        }

        if (creado == null) {
            throw new Exception();
        }
        if (editado == null) {
            throw new Exception();
        }

    }

}
