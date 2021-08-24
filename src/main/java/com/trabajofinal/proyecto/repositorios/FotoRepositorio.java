package com.trabajofinal.proyecto.repositorios;

import com.trabajofinal.proyecto.entidades.Foto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface FotoRepositorio extends JpaRepository<Foto, String> {

    @Query("SELECT a from foto a WHERE a.activo = true ")
    public List<Foto> buscarFoto();
}
