package org.example;

import java.util.HashMap;

public class Part2 {

    public int execute(String input) {
        HashMap<String, Integer> numbers = new HashMap<>();
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);

        for (String key : numbers.keySet()) {

            if (input.contains(key)) {
                return numbers.get(key);
            }
        }
        return -1;
    }
}
