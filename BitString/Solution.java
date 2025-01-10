package BitString;

import java.util.Scanner;

public class Solution {
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long answer = 1;
        for (int i = 0; i < n; i++) {
            answer *= 2;
            answer %= 1000000007;
        }
        System.out.println(answer);
    }
}
