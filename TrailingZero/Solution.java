package TrailingZero;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
         try (Scanner scanner = new Scanner(System.in)) {
            long n = scanner.nextLong();
            int result = 0;
            for (int i = 5; i <= n; i *= 5) {
                result += n/i;
            }
            System.out.println(result);
         }
    }
}
