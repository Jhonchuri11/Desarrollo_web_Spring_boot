package com.example.sprinjpa.servicio;

import com.example.sprinjpa.interfaceServicio.ITareaServicio;
import com.example.sprinjpa.interfaces.ITarea;
import com.example.sprinjpa.modelo.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServicio implements ITareaServicio {
    //
    @Autowired
    private ITarea repo;
    @Override
    public List<Tarea> listar() {
        return (List<Tarea>)repo.findAll();
    }

    @Override
    public Optional<Tarea> listarId(int id) {

        return repo.findById(id);
    }
    @Override
    public int guardar(Tarea ta) {
        Tarea tar = repo.save(ta);
        if (!tar.equals(null)) {
            return 1;
        }
        return 0;
    }
    @Override
    public void borrar(int id) {
        repo.deleteById(id);
    }


}


