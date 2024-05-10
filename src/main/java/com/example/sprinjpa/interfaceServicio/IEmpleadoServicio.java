package com.example.sprinjpa.interfaceServicio;

import com.example.sprinjpa.modelo.Empleado;
import java.util.List;
import java.util.Optional;

public interface IEmpleadoServicio {
    public List<Empleado> listar();
    public Optional<Empleado> listarId(int id);
    public int guardar(Empleado p);
    public void borrar(int id);

}
