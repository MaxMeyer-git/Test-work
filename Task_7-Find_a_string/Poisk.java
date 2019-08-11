package com.company;

import java.util.List;

public class Poisk {

    public static String find(List<String> list_to_search_in, String obj_to_find) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean firstEl = true;
        for (int i = 0; i < list_to_search_in.size() ; i++) {
            if (list_to_search_in.get(i).equals(obj_to_find)) {
                if (firstEl)
                    firstEl = false;
                else {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(i);
            }
        }
        if (firstEl) {
            return "can't find";
        } else return stringBuilder.toString();

    }


}
