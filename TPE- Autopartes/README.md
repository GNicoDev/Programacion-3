# TPE-Programacion-3---Autopartes

#  Proyecto de Selección de Máquinas - **Greedy & Backtracking**

##  **Descripción General**
Este proyecto implementa **algoritmos de selección de máquinas** utilizando **Greedy** y **Backtracking**, con el objetivo de **alcanzar una producción específica de piezas** de manera eficiente.

###  **Lenguaje:**  
 **Java**  

###  **Estructura del Proyecto**
El código se organiza en **las siguientes clases**:

- **`Main.java`** → Punto de entrada del programa.
- **`Maquina.java`** → Representa una máquina con su producción.
- **`DatosMaquinas.java`** → Carga la configuración y la lista de máquinas.
- **`AlgoritmoGreedy.java`** → Estrategia basada en selección inmediata del mejor candidato disponible.
- **`AlgoritmoBacktracking.java`** → Explora combinaciones posibles para encontrar la mejor solución.
- **`Vista.java`** → Muestra los resultados en pantalla.

---

##  **Funcionamiento Interno**
###  ** 1- Proceso de Ejecución**
1. Se carga la lista de máquinas obtenida desde el archivo [`configuracion.txt`](https://github.com/GNicoDev/TPE-Programacion3-Autopartes/blob/main/configuracion.txt) en  `DatosMaquinas` para realizar los procesos corespondientes.
3. Se ejecutan los algoritmos **Greedy y Backtracking**, obteniendo sus respectivas soluciones.
4. Se comparan los resultados y se presentan con `Vista`.

###  ** 2- Algoritmo Greedy**
 - Se selecciona la máquina **de mayor producción posible** hasta alcanzar la cantidad requerida.  
 - Se guarda la métrica `candidatosEvaluados`, que indica **cuántas máquinas fueron evaluadas**.  

###  ** 3- Algoritmo Backtracking**
- Explora todas las combinaciones posibles de máquinas **de manera recursiva**.  
- Se usa **poda** para evitar explorar soluciones no óptimas innecesariamente.  
- Se guarda la métrica `estadosGenerados`, que indica **cuántos estados fueron explorados**.  

###  ** 4- Presentación de Resultados**
 Se muestran las soluciones con:  
- **Número total de piezas producidas**  
- **Cantidad de máquinas utilizadas**  
- **Costo computacional de cada estrategia**  

---

##  **Conclusión**
Este proyecto demuestra las diferencias entre **Greedy y Backtracking** en problemas de selección de máquinas.  
Se puede elegir entre **rapidez** (Greedy) o **precisión óptima** (Backtracking), dependiendo de la necesidad. 