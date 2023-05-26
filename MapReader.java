import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapReader {
    public static char[][] readMap(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine(); // Ler o restante da linha após os números

        char[][] map = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine().trim();
            map[i] = line.toCharArray();
        }

        scanner.close();

        return map;
    }

    public static void main(String[] args) {
        String filename = "mapa3.txt";

        try {
            char[][] map = MapReader.readMap(filename);

            // Exemplo de uso do mapa lido
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + filename);
        }
    }
}
    

