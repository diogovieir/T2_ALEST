import java.util.*;

public class FuelCalculator {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int calculateFuel(char[][] map, int startRow, int startCol) { 
        int rows = map.length;
        int cols = map[0].length;

        int[][] fuel = new int[rows][cols]; 
        for (int i = 0; i < rows; i++) {
            Arrays.fill(fuel[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol});
        fuel[startRow][startCol] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int[] direction : DIRECTIONS) {
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];

                if (isValidCell(map, newRow, newCol)) {
                    int cost = fuel[currRow][currCol] + 1;

                    if (cost < fuel[newRow][newCol]) {
                        fuel[newRow][newCol] = cost;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        int destinationFuel = fuel[rows - 1][cols - 1];
        return destinationFuel == Integer.MAX_VALUE ? -1 : destinationFuel;
    }

    private static boolean isValidCell(char[][] map, int row, int col) {
        int rows = map.length;
        int cols = map[0].length;

        return row >= 0 && row < rows && col >= 0 && col < cols && map[row][col] != '*';
    }
}