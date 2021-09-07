package com.trabajofinal.proyecto.repositorios;

import com.trabajofinal.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    @Query("SELECT a from Usuario a WHERE a.email LIKE :email AND a.activo = true")
    public Usuario buscarUsuario(@Param("email") String email);
    
    

}
