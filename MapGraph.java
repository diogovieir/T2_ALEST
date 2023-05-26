import java.util.ArrayList;
import java.util.List;

public class MapGraph {
    private int numPorts;
    private List<List<Integer>> adjacencyList;

    public MapGraph(int numPorts) {
        this.numPorts = numPorts;
        this.adjacencyList = new ArrayList<>(numPorts);
    
        for (int i = 0; i < numPorts; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    

    // public void addPort(int port) {
    //     if (port >= 1 && port <= numPorts) {
    //         adjacencyList.set(port - 1, new ArrayList<>()); // Adiciona uma lista vazia para o porto na posição correta
    //     } else {
    //         throw new IllegalArgumentException("Número de porta inválido: " + port);
    //     }
    // }
    

    
    

    public void addEdge(int sourcePort, int destinationPort) {
        if (sourcePort >= 1 && sourcePort <= numPorts && destinationPort >= 1 && destinationPort <= numPorts) {
            adjacencyList.get(sourcePort - 1).add(destinationPort);
        } else {
            throw new IllegalArgumentException("Número de porta inválido: " + sourcePort + " ou " + destinationPort);
        }
    }
    
    

    public List<Integer> getAdjacentPorts(int port) {
        if (port >= 1 && port <= numPorts) {
            return adjacencyList.get(port - 1);
        } else {
            throw new IllegalArgumentException("Número de porta inválido: " + port);
        }
    }
    public void buildGraphFromMap(char[][] map) {
        int rows = map.length;
        int cols = map[0].length;
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Character.isDigit(map[i][j])) {
                    int port = map[i][j] - '0'; // Converte o caractere para um número inteiro
    
                    // Verifica os vizinhos do porto na direção Norte, Sul, Leste e Oeste
                    if (i - 1 >= 0 && Character.isDigit(map[i - 1][j])) {
                        int neighbor = map[i - 1][j] - '0';
                        if (neighbor >= 1 && neighbor <= numPorts) {
                            addEdge(port, neighbor);
                        } else {
                            throw new IllegalArgumentException("Número de porta inválido: " + neighbor);
                        }
                    }
                    if (i + 1 < rows && Character.isDigit(map[i + 1][j])) {
                        int neighbor = map[i + 1][j] - '0';
                        if (neighbor >= 1 && neighbor <= numPorts) {
                            addEdge(port, neighbor);
                        } else {
                            throw new IllegalArgumentException("Número de porta inválido: " + neighbor);
                        }
                    }
                    if (j - 1 >= 0 && Character.isDigit(map[i][j - 1])) {
                        int neighbor = map[i][j - 1] - '0';
                        if (neighbor >= 1 && neighbor <= numPorts) {
                            addEdge(port, neighbor);
                        } else {
                            throw new IllegalArgumentException("Número de porta inválido: " + neighbor);
                        }
                    }
                    if (j + 1 < cols && Character.isDigit(map[i][j + 1])) {
                        int neighbor = map[i][j + 1] - '0';
                        if (neighbor >= 1 && neighbor <= numPorts) {
                            addEdge(port, neighbor);
                        } else {
                            throw new IllegalArgumentException("Número de porta inválido: " + neighbor);
                        }
                    }
                }
            }
        }
    }
    
    
    
    
    
}
