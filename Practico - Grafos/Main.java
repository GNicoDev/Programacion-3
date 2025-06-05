
public class Main {

	public static void main(String[] args) {

		GrafoDirigido<String> grafo = new GrafoDirigido<>();

		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);

		grafo.agregarArco(1, 2, "a");
		grafo.agregarArco(1, 3, "b");
		grafo.agregarArco(2, 6, "c");
		grafo.agregarArco(3, 4, "d");
		grafo.agregarArco(4, 5, "e");
		grafo.agregarArco(5, 1, "e");

		for (Integer vertice: grafo.DFS()) {
			System.out.print(vertice + "->");
		}


		System.out.println();
		System.out.println("El grafo es ciclico? " + grafo.DFSesCiclico());

		for (Integer vertice: grafo.BFS()) {
			System.out.print(vertice + "->");
		}
	}



}
