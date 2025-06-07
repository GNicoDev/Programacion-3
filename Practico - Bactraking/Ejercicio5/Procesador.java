package Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Procesador {
    private String nombre;
    private List<Integer> tareas;

    public Procesador(String nombre) {
        this.nombre = nombre;
        this.tareas = new ArrayList<Integer>();
    }
    public Procesador(Procesador otro) {
        this.nombre = otro.nombre;
        this.tareas = new ArrayList<>(otro.tareas); // Copia profunda de la lista de tareas
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getTareas() {
        return new ArrayList<>(tareas);
    }
    public void addTarea(Integer tarea) {
        this.tareas.add(tarea);
    }

    public void removeTarea(Integer tarea) {
        this.tareas.remove(tarea);
    }

    public Integer devolverTiempo(){
        int tiempo = 0;
        for (Integer tarea : tareas) {
            tiempo += tarea;
        }
        return tiempo;
    }

}
