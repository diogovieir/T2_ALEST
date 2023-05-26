import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String mapFilename = "mapa3.txt";

        try {
            char[][] map = MapReader.readMap(mapFilename);

            // Exemplo de uso do mapa lido
            System.out.println("Mapa lido:");
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            int numPorts = 9;
            MapGraph graph = new MapGraph(numPorts);
            graph.buildGraphFromMap(map);

            List<Integer> visitedPorts = BFS.breadthFirstSearch(graph, 1);

            if (visitedPorts.size() == 9 && visitedPorts.get(0) == 1 && visitedPorts.get(8) == 9) {
                System.out.println("Portos visitados:");
                for (int port : visitedPorts) {
                    System.out.print(port + " ");
                }

                int fuelCost = FuelCalculator.calculateFuel(map, 0, 0);
                if (fuelCost != -1) {
                    System.out.println("\nCusto mínimo de combustível necessário para chegar ao destino: " + fuelCost);
                } else {
                    System.out.println("\nNão foi possível alcançar o destino.");
                }
            } else {
                System.out.println("O trajeto dos portos de 1 a 9 não foi seguido corretamente.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + mapFilename);
        }
    }
}
