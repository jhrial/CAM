/*
 
 */
package com.trabajofinal.proyecto.repositorios;

import com.trabajofinal.proyecto.entidades.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VicMusic
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    @Query("SELECT a from usuario a WHERE a.activo = true ")
    public List<Usuario> buscarUsuario();

}
