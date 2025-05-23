
import java.util.*;



public class GrafoDirigido<T> implements Grafo<T> {

	// usar HashMap
	private Map<Integer, ArrayList<Arco<T>>> adjList;

	public GrafoDirigido() {
		adjList = new HashMap<>();
	}

	// Notacion Big O = O(1)
	@Override
	public void agregarVertice(int verticeId) {
		if (!adjList.containsKey(verticeId)) {
			adjList.put(verticeId, new ArrayList<>());
		}
	}

	// Notacion Big O = O(n)
	@Override
	public void borrarVertice(int verticeId) {

		adjList.remove(verticeId); //Esto elimina el vertice y todos sus arcos

		//Eliminar los arcos de los vertices que apuntan a al vertice eliminado
		for (List<Arco<T>> arcos: adjList.values()) {
			if (arcos.contains(verticeId)) {
				arcos.remove(verticeId);
			}
		}

	}

// Notación Big O = O(k), siendo k el número de arcos salientes desde verticeId1.
// Esto se debe a que el método contains() recorre la lista linealmente para verificar si el arco ya existe.
// Requiere que equals() y hashCode() estén bien implementados en la clase Arco<T>.

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (!adjList.containsKey(verticeId1) || !adjList.containsKey(verticeId2)) {
			System.out.println("No se puede agregar el arco");
		}
		Arco<T> arco = new Arco(verticeId1, verticeId2, etiqueta);
		if (!adjList.get(verticeId1).contains(arco)) // implementado el metodo Equals y Hashcode en Arco<T>
			adjList.get(verticeId1).add(arco);
		else
			System.out.println("El arco ya existe en la posicion " + verticeId1);
	}

	// Notación Big O = O(k), siendo k el número de arcos salientes desde verticeId1.
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Arco<T> arco = buscarArco(verticeId1, verticeId2);
		if (arco != null) {
			adjList.get(verticeId1).remove(arco);
		} else {
			System.out.println("No se puede borrar porque el arco no existe");
		}
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (buscarArco(verticeId1, verticeId2) != null) {
			return true;
		}
		else
			return false;
	}
	private Arco<T> buscarArco(int verticeId1, int verticeId2) {
		if (adjList.containsKey(verticeId1)) {
			for (Arco<T> arco : adjList.get(verticeId1)) {
				if (arco.getVerticeDestino() == verticeId2) {
					return arco;
				}
			}
		}
		return null;
	}


	// Notacion Big O = O(1)
	@Override
	public boolean contieneVertice(int verticeId) {
		return adjList.containsKey(verticeId);
	}



	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return buscarArco(verticeId1, verticeId2);
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return adjList.size();
	}

	//Complejidad O(1)
	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		int cantidad = 0;
		for (List<Arco<T>> arcos: adjList.values()) {
			cantidad += arcos.size();
		}
		return cantidad;
	}

	@Override  	//Complejidad O(1)
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return adjList.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		if (adjList.containsKey(verticeId)) {
			List<Arco<T>> arcos = adjList.get(verticeId);
			List<Integer> adyacentes = new ArrayList<>();
			for (Arco<T> arco : arcos) {
				adyacentes.add((Integer) arco.getVerticeDestino());
			}
			return adyacentes.iterator();
		}
		else {
			System.out.println("El vertice " + verticeId + " no existe");
			return Collections.emptyIterator();
		}
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		List<Arco<T>> arcosResponse = new ArrayList<>();
		for (List<Arco<T>> arcos: adjList.values()) {
			//opcion mas resumida seria
//			arcosResponse.addAll(arcos);   mas entendible
			for (Arco<T> arco : arcos) {
				arcosResponse.add(arco);
			}
		}
		return arcosResponse.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		if (adjList.containsKey(verticeId)) {
			List<Arco<T>> arcos = adjList.get(verticeId);
			return arcos.iterator();
		}
		else {
			System.out.println("El vertice " + verticeId + " no existe");
			return Collections.emptyIterator();
		}
	}

	public List<Integer> BFS(int verticeId) {
		Set<Integer> visitados = new HashSet<>();
		List<Integer> resultado = new ArrayList<>();

		DfsRecursivo(verticeId,visitados,resultado);
		return resultado;
	}

	private void DfsRecursivo(int origen, Set<Integer> visitados, List<Integer> resultado) {
			visitados.add(origen);
			resultado.add(origen);

			Iterator<Integer> it = this.obtenerVertices();
			while (it.hasNext()) {
				int vertice = it.next();
				if (!visitados.contains(vertice)) {
					DfsRecursivo(vertice,visitados,resultado);
				}
			}
	}

}
