package PalindromeReorder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Map<Character, Long> charCountMap = new HashMap<>();
        boolean needMiddleChar = inputLine.length() % 2 != 0;
        char[] chars = new char[inputLine.length()];
        int currentAppendIndex = 0;

        for (int i = 0; i < inputLine.length(); i++) {
            charCountMap.put(inputLine.charAt(i), charCountMap.getOrDefault(inputLine.charAt(i), 0L) + 1);
        }
        
        for (Entry<Character, Long> charCount : charCountMap.entrySet()) {
            long count = charCount.getValue();
            char key = charCount.getKey();
            if (count != 1 && count % 2 != 0) {
                if (needMiddleChar) {
                    needMiddleChar = false;
                    chars[(inputLine.length() - 1) / 2] = key;
                } else {
                    System.out.print("NO SOLUTION");
                    return;
                }

                charCount.setValue(count - 1);
            }

            if (count == 1) {
                if (needMiddleChar) {
                    needMiddleChar = false;
                    chars[(inputLine.length() - 1) / 2] = key;
                    continue;
                } else {
                    System.out.print("NO SOLUTION");
                    return;
                }
            }

            for (long i = 0; i < charCount.getValue() / 2; i++) {
                chars[currentAppendIndex] = key;
                chars[inputLine.length() - 1 - currentAppendIndex] = key;
                currentAppendIndex++;
            }
        }

        System.out.println(new String(chars));
    }
}
