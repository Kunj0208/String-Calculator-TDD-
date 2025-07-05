package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
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
            List<String> delimiters = new ArrayList<>();

            if (delimiterPart.startsWith("[")) {
                Pattern pattern = Pattern.compile("\\[(.*?)]");
                Matcher matcher = pattern.matcher(delimiterPart);
                while (matcher.find()) {
                    delimiters.add(Pattern.quote(matcher.group(1)));
                }
            }
            else {
                delimiters.add(Pattern.quote(delimiterPart));
            }

            delimiter = String.join("|", delimiters);
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
