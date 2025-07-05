package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            String delimiterPart = numbers.substring(2, delimiterEnd);

            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
                delimiter = Pattern.quote(delimiterPart.substring(1, delimiterPart.length() - 1));
            }
            else {
                delimiter = Pattern.quote(delimiterPart);
            }
            numbers = numbers.substring(delimiterEnd + 1);
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < 0) {
                negatives.add(num);
            }
            if (num <= 1000) {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                    "negatives not allowed: " + negatives.toString().replaceAll("[\\[\\] ]", "")
            );
        }

        return sum;
    }
}
