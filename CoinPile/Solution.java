package CoinPile;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long inputLines = scanner.nextLong();
            StringBuilder resultBuilder = new StringBuilder(300000);
            for (long i = 0; i < inputLines; i++) {
                long y = scanner.nextLong();
                long x = scanner.nextLong();
                if (y > x) {
                    x = 2 * x - y;
                    y = x;
                } else if (x > y) {
                    y = 2 * y - x;
                    x = y;
                }

                if (x % 3 == 0 && x >= 0) {
                    resultBuilder.append("YES\n");
                } else {
                    resultBuilder.append("NO\n");
                }
                System.out.println(x);
            }

            System.out.print(resultBuilder.toString());
        }
    }
}
