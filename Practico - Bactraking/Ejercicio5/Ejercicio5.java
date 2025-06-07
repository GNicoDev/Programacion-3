package Ejercicio5;

/*
* Ejercicio 5
Asignación de tareas a procesadores. Se tienen m procesadores idénticos y n tareas con un tiempo
de ejecución dado. Se requiere encontrar una asignación de tareas a procesadores de manera de
minimizar el tiempo de ejecución del total de tareas.
*
* Este ejercicio lo que sugiere es:
* - tengo M Procesadores -> M=2
* -tengo n tareas con un tiempo por tarea -> n = [2,5,8,3]
* La cantidad de tareas que se le asignara a cada procesador viene dado por n / M?, no seria la mas eficiente
* Mejor solucion en este caso con division de tareas iguales: M1 = [5,3] = 8 -  M2=[2,8] = 10
*
* pero que pasa si M=2 y n=[1,2,3,8]? ->> mejor solucion M1=[1,2,3] y M2 = [8]
* Lo que se debe hacer es particionar el conjunto en 2 buscando todas las convinaciones
*

* * Lo qe planteamos es devolver un lista de procesadores donde cada uno tendra en su estructura una lista de tareas
* Clase Procesador:
* nombre : String
* tareas : List<Integer>
-----------------------
* + asignarTarea(Integer)
* + DesasignarTarea(Integer)
* + DevolverTiempo(): Integer

* Estado -> Set<Procesador>

* BackTrack (indiceT,tareas, estado, mejorSolucion)
*   if (todasTareasAsignadas)
*      if (esMejorsolucion(estado, mejorSolucion)) // Este metodo se encargara de analizar estado es mejor que mejorSolucion
*           mejorSolucion = estado
*       else {
*           Integer tareaAasignar = tareas.asignar(indiceT)
*           foreach (p in estado){
*               p.asignar(tareaAasignar)
*               estado.add(p)
*               backTrack(indiceT +1, tareas, estado, mejorSolucion)
*               p.desasignarTarea(tareaAsignar)
*           }
*       }
* }
*
* esMejorsolucion(estado, mejorSolucion){
*   if (getTiempo(estado) < getTiempo(mejorSolucion) )
*       return true;
*   return false
* }
* */


import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {
    public List<Procesador> backTracking(List<Integer> tareas,int M) {
        List<Procesador> estado = new ArrayList<Procesador>();
        List<Procesador> mejorSolucion = new ArrayList<Procesador>();
        int indiceTarea = 0;
        for (int i = 0; i < M; i++) {
            estado.add(new Procesador("P" + (i+1)));
            mejorSolucion.add(new Procesador("P" + (i+1)));
        }
        // aca estado deberia inicializarse con una lista de M procesadores, pero tengo el inconveniente del constructor que pide el nombre
        backTrack(indiceTarea, tareas, estado, mejorSolucion);
        return mejorSolucion;
    }

    private void backTrack(int indiceTarea, List<Integer> tareas, List<Procesador> estado, List<Procesador> mejorSolucion) {
        if (indiceTarea >= tareas.size()) {
            if (esMejorSolucion(estado, mejorSolucion)){
                mejorSolucion.clear();
                mejorSolucion.addAll(copia(estado));
            }
        }
        else {
            Integer tareaAasignar = tareas.get(indiceTarea);
            for (Procesador p : estado) {
                p.addTarea(tareaAasignar);
                backTrack(indiceTarea+1, tareas, estado, mejorSolucion);
                p.removeTarea(tareaAasignar);
            }
        }
    }

    private List<Procesador> copia(List<Procesador> estado) {
        List<Procesador> mejorSolucion = new ArrayList<Procesador>();
        for (Procesador p : estado) {
            mejorSolucion.add(new Procesador(p)); // Crear una nueva instancia de Procesador con la misma información
        }
        return mejorSolucion;
    }

    private boolean esMejorSolucion(List<Procesador> estado, List<Procesador> mejorSolucion) {
        if (getTiempo(mejorSolucion) > 0)
            return getTiempo(estado) < getTiempo(mejorSolucion);
        else {
            mejorSolucion.clear();
            mejorSolucion.addAll(copia(estado));
        }
        return false;
    }

    private Integer getTiempo(List<Procesador> procesadores) {
        int tiempoActual = 0, tiempoMasAlto = 0;

        for (Procesador p : procesadores) {
            for (Integer t : p.getTareas()) {
               tiempoActual += t;
            }
            if(tiempoActual > tiempoMasAlto) {
                tiempoMasAlto = tiempoActual;
            }
            tiempoActual = 0;
        }
        return tiempoMasAlto;
    }

}


