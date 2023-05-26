import java.util.*;

public class BFS {
    public static List<Integer> breadthFirstSearch(MapGraph graph, int startPort) {
        List<Integer> visitedPorts = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startPort);
        visitedPorts.add(startPort);

        while (!queue.isEmpty()) {
            int port = queue.poll();
            List<Integer> adjacentPorts = graph.getAdjacentPorts(port);

            for (int adjacentPort : adjacentPorts) {
                if (!visitedPorts.contains(adjacentPort)) {
                    queue.offer(adjacentPort);
                    visitedPorts.add(adjacentPort);
                }
            }
        }

        return visitedPorts;
    }

    public static void main(String[] args) {
        // Exemplo de uso da busca em largura

        // Criar o grafo
        int numPorts = 9;
        MapGraph graph = new MapGraph(numPorts);

        // Adicionar as arestas do grafo
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);

        // Realizar a busca em largura a partir do porto 1
        List<Integer> visitedPorts = BFS.breadthFirstSearch(graph, 1);

        System.out.println("Portos visitados:");
        for (int port : visitedPorts) {
            System.out.print(port + " ");
        }
    }
}
