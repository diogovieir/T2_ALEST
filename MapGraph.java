import java.util.ArrayList;
import java.util.List;

public class MapGraph {
    private int numPorts;
    private List<List<Integer>> adjacencyList;

    public MapGraph(int numPorts) {
        adjacencyList = new ArrayList<>(numPorts + 1); // +1 to accommodate port numbers starting from 0
        this.numPorts = numPorts;
        for (int i = 0; i <= numPorts; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    
    public void addEdge(int port1, int port2) {
        if (port1 >= 0 && port1 < adjacencyList.size() && port2 >= 0 && port2 < adjacencyList.size()) {
            adjacencyList.get(port1).add(port2);
            adjacencyList.get(port2).add(port1);
        } else {
            System.out.println("Número de porta inválido: " + port1 + " ou " + port2);
        }
    }
    
    public List<Integer> getAdjacentPorts(int port) {
        return adjacencyList.get(port);
    }

    public void buildGraphFromMap(char[][] map) {
        int rows = map.length;
        int cols = map[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Character.isDigit(map[i][j])) {
                    int port = map[i][j] - '0';
                    if (isValidCell(map, i - 1, j)) {
                        int adjacentPort = map[i - 1][j] - '0';
                        addEdge(port, adjacentPort);
                    }
                    if (isValidCell(map, i + 1, j)) {
                        int adjacentPort = map[i + 1][j] - '0';
                        addEdge(port, adjacentPort);
                    }
                    if (isValidCell(map, i, j - 1)) {
                        int adjacentPort = map[i][j - 1] - '0';
                        addEdge(port, adjacentPort);
                    }
                    if (isValidCell(map, i, j + 1)) {
                        int adjacentPort = map[i][j + 1] - '0';
                        addEdge(port, adjacentPort);
                    }
                }
            }
        }
    }

    private boolean isValidCell(char[][] map, int row, int col) {
        int rows = map.length;
        int cols = map[0].length;

        return row >= 0 && row < rows && col >= 0 && col < cols && map[row][col] != '*';
    }
}
