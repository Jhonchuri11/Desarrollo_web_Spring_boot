package com.example.sprinjpa.interfaceServicio;

import com.example.sprinjpa.modelo.Tarea;
import java.util.List;
import java.util.Optional;

public interface ITareaServicio {
    public List<Tarea> listar();
    public Optional<Tarea> listarId(int id);
    public int guardar(Tarea ta);
    public void borrar(int id);

}
