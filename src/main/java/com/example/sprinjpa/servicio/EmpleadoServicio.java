package com.example.sprinjpa.servicio;

import com.example.sprinjpa.interfaceServicio.IEmpleadoServicio;
import com.example.sprinjpa.interfaces.Iempleado;
import com.example.sprinjpa.modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicio implements IEmpleadoServicio {

    // Instancia crudrepository
    @Autowired
    private Iempleado repo;
    @Override
    public List<Empleado> listar() {
        return (List<Empleado>)repo.findAll();
    }

    @Override
    public Optional<Empleado> listarId(int id) {

        return repo.findById(id);
    }

    @Override
    public int guardar(Empleado p) {
        Empleado em = repo.save(p);
        if (!em.equals(null)) {
            return 1;
        }
        return 0;
    }

    @Override
    public void borrar(int id) {
        repo.deleteById(id);
    }

    public List<Empleado> buscarporNombre(String nombre) {
        return repo.findByNombreContaining(nombre);
    }
}
