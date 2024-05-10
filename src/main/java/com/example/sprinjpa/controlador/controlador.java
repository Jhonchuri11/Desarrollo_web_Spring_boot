package com.example.sprinjpa.controlador;

import com.example.sprinjpa.interfaceServicio.IEmpleadoServicio;
import com.example.sprinjpa.interfaceServicio.ITareaServicio;
import com.example.sprinjpa.modelo.Empleado;
import com.example.sprinjpa.modelo.Tarea;
import com.example.sprinjpa.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class controlador {

    // Instanciando autowired
    @Autowired
    private IEmpleadoServicio servicio;
    // Para poder usar un servicio debe instanciar la clase con un Autowired
    @Autowired
    private ITareaServicio tareaserv;

    @Autowired
    private EmpleadoServicio empleadoServicio;

    // Esta ruta permite mostrar la lista de empleados
    @GetMapping("/listarEmpleados")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = servicio.listar();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }

    // Buscar empleado por nombre
    @GetMapping("/buscarEmpleado")
    public String buscarEmpleado(@RequestParam("termino") String termino, Model model) {
        List<Empleado> empleados = empleadoServicio.buscarporNombre(termino);
        if (empleados.isEmpty()) {
            model.addAttribute("mensaje", "No se encontró ninguna coincidencia en la búsqueda: " + termino);
        } else {
            model.addAttribute("empleados", empleados);
        }
        return "listaempleados";
    }

    // Para mostrar el formulario de agregacion de nuevo empleado
    @GetMapping("/agregarEmpleado")
    public String agregarEmpleado(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "agregarEmpleado";
    }

    // Para guardar el empleado generado
    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(Empleado p) {
        servicio.guardar(p);
        return "redirect:/listarEmpleados";
    }

    // Para editar un empleado
    @GetMapping("/editarEmpleado/{id}")
    public String editarEmpleado(@PathVariable int id, RedirectAttributes atributes) {
        Optional<Empleado> empleado = servicio.listarId(id);
        atributes.addFlashAttribute("empleado", empleado);
        return "redirect:/mostrarEmpleado";
    }

    // Para poder mostrar solo un  empleado por su id
    @GetMapping("/mostrarEmpleado")
    public String mostrarEmpleado(@ModelAttribute("empleado") Empleado p, Model model) {
        model.addAttribute("empleado", p);
        return "agregarEmpleado";
    }

    // Para llevar al empleado y eliminarlo
    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable int id) {
        servicio.borrar(id);
        return "redirect:/listarEmpleados";

    }

    // Funcion que permite mostrar la lista de tareass
    @GetMapping("/listarTareas")
    public String listarTareas(Model model) {
        List<Tarea> tareas = tareaserv.listar();
        model.addAttribute("tareas", tareas);
        return "ITarea/tareas";
    }

    // Ruta que pemite crear nueva tarea
    @GetMapping("/agregarTarea")
    public String agregarTarea(Model model) {
        model.addAttribute("tarea", new Tarea());
        return "ITarea/agregarTarea";
    }
    // Para guardar la tarea generada
    @PostMapping("/guardarTarea")
    public String guardarTarea(Tarea tar) {
        tareaserv.guardar(tar);
        return "redirect:/listarTareas";
    }
    // Para editar una tarea registrada
    @GetMapping("/editarTarea/{id}")
    public String editarTarea(@PathVariable int id, RedirectAttributes attributes) {
        Optional<Tarea> tarea = tareaserv.listarId(id);
        attributes.addFlashAttribute("tarea", tarea);
        return "redirect:/mostrarTarea";
    }
    // Para mostrar una sola tarea seleccionada por su id y guarda los nuevos datos
    @GetMapping("/mostrarTarea")
    public String mostrarTarea(@ModelAttribute("tarea") Tarea tar, Model model) {
        model.addAttribute("tarea", tar);
        return "ITarea/agregarTarea";
    }

    // Para  poder eliminar una tarea seleccionada
    @GetMapping("/eliminarTarea/{id}")
    public String eliminarTarea(@PathVariable int id) {
        tareaserv.borrar(id);
        return "redirect:/listarTareas";
    }
}
