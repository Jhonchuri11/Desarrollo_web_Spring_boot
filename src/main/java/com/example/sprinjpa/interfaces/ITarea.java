package com.example.sprinjpa.interfaces;

import com.example.sprinjpa.modelo.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITarea extends CrudRepository<Tarea, Integer> {

}
