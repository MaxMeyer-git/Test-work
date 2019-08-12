package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        //Написать функцию проверяющую наличие подстроки в массиве строк. На вход передается массив строк и строка,
        //которую необходимо найти в строках массива. Функция должна вернуть номера элементов массива,
        //в которых встретилась указанная строка, перечисленных через запятую.

        List<String> list_to_search_in = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc", "bbb", "ddd", "aaa"));
        String obj_to_find = "bbb";

        String result = Poisk.find(list_to_search_in, obj_to_find);

        System.out.println(result);




    }
}
