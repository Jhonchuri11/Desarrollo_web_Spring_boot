package com.example.sprinjpa.interfaces;

import com.example.sprinjpa.modelo.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Iempleado extends CrudRepository<Empleado, Integer> {

    // Buscar empleado por nombre
    List<Empleado> findByNombreContaining(String nombre);
}
