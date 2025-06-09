package Ejercicio2;

/*
* Ejercicio 2
 Problema de la mochila: Se tienen n objetos y una mochila. Para i = 1,2,..n, el objeto i tiene un peso
 positivo pi y un valor positivo vi. La mochila puede llevar un peso que no sobrepase P. El objetivo es
 llenar la mochila de tal manera que se maximice el valor de los objetos transportados, respetando la
 limitación de capacidad impuesta. Los objetos pueden ser fraccionados, si una fracción xi (0 ≤ xi ≤ 1)
 del objeto i es ubicada en la mochila contribuye en xipi al peso total de la mochila y en xivi al valor
 de la carga.
 ¿Qué estrategia Greedy seguiría para resolver el problema? Esquematice la resolución mediante un
 pseudocódigo en Java.
 *
 *
 * LA estrategia que podemos usar es agregar los objetos que mejor valor tengan en base a valor/kg
 *
 * OjetoMochila
 * -------------
  * peso: double
  * valor: double
 * -------------
 *
 * objetos = [(5,25),(4,30),(1,20),(2,15),(3,28)]   P=10
 *
 * greedy(objetos,P)
 *      mochila = new List<ObjetoMochila>
        while (!Solucion(mochila) && objetos.size()>0) {
            ObjetoMochila seleccionado = seleccionar(objetos) // este es el metodo que seleccionara el elemento segun nuestra estrategia
            if (factible(seleccionado, mochila))
                mochila.add(seleccionado)
                P-= seleccionado.getPeso()
             else{
                if (P>0)
                    seleccionado
              }
            objetos.remove(seleccionado)
         }
         return mochila
 *
* */

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    public List<ObjetoMochila> greedy(List<ObjetoMochila> objetos, int P) {
        List<ObjetoMochila> s = new ArrayList<ObjetoMochila>();
        while (P>0 && !objetos.isEmpty()){
            ObjetoMochila obj = seleccionar(objetos,P);
            if(factible(s,obj,P)){  //si no es factible es porque debemos fraccionar el objeto seleccionado
                s.add(obj);
                P-= (int) obj.getPeso();
            }
            else{
                if (P>0){
                    obj.setValor(P* obj.getValor()/obj.getPeso());
                    obj.setPeso(P);
                    s.add(obj);
                    P-= (int) obj.getPeso();
                }
            }
            objetos.remove(obj);
        }
        return s;
    }

    // este metodo nos debol
    private boolean factible(List<ObjetoMochila> s, ObjetoMochila obj, int p) {
        return obj.getPeso() <= p;
    }

    private ObjetoMochila seleccionar(List<ObjetoMochila> objetos, int p) {
        ObjetoMochila obj = null;
        double mejoropcion = 0;
        for (ObjetoMochila o : objetos) {
            if (o.getValor()/o.getPeso() > mejoropcion) {
                mejoropcion = o.getValor()/o.getPeso();
                obj = o;
            }
        }
        return obj;
    }



    private double calcularPesoAcumulado(List<ObjetoMochila> objetos) {
        double total = 0;
        for (ObjetoMochila o : objetos) {
            total += o.getPeso();
        }
        return total;
    }
}
