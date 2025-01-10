import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            long inputLines = scanner.nextLong();
            StringBuilder resultBuilder = new StringBuilder(5000000);
            for (long i = 0; i < inputLines; i++) {
                long y = scanner.nextLong();
                long x = scanner.nextLong();

                // Determine the larger edge of the square
                long edgeLength = Math.max(y, x);
                long edgeSquare = edgeLength * edgeLength; // Precompute for reuse

                // Handle the case where the target is at the center
                if (y == x) {
                    resultBuilder.append(edgeSquare - edgeLength + 1 + "\n");
                    resultBuilder.append("\n");
                    continue;
                }

                // Calculate the position based on the edge's parity
                long result;
                if (edgeLength % 2 == 0) { // Even edge length
                    result = (y > x) 
                        ? edgeSquare - x + 1 // Moving down
                        : edgeSquare - 2 * edgeLength + 2 + y - 1; // Moving left
                } else { // Odd edge length
                    result = (y > x) 
                        ? edgeSquare - 2 * edgeLength + 2 + x - 1 // Moving up
                        : edgeSquare - y + 1; // Moving right
                }

                resultBuilder.append(result + "\n");
            }

            System.out.print(resultBuilder.toString());
        }
    }
}
