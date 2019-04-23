package dataLayer;

import java.util.*;

public class HashMaps {

    public HashMap<String, Integer> sort(HashMap<String, Integer> hashMap) {

        List<Map.Entry<String, Integer> > list = new LinkedList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> one, Map.Entry<String, Integer> two) {
                return (two.getValue()).compareTo(one.getValue());
            }
        });
        HashMap<String, Integer> finalMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            finalMap.put(entry.getKey(), entry.getValue());
        }
        return finalMap;

    }

    public HashMap<String, Integer> top5 (HashMap<String, Integer> hashMap) {

        HashMap<String, Integer> fin = new HashMap<>();



        return fin;
    }

}







