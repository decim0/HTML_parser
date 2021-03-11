package org.example;

import java.util.HashMap;
import java.util.Map;

public class ToMap {

    public void arrayToMap(String[] words) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
