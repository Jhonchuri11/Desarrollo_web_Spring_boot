package com.example.sprinjpa.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "rol")
    private String rol;

    // Genareando la relacion de uno a muchos
    // Un empleado puede tener muchas tareas

    @OneToMany
    private List<Tarea> tarea;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}


