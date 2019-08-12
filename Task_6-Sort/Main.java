package com.company;

class main {
    public static void main(String[] args) {
        
        
        //Написать функцию выполняющую сортировку массива строк. На вход функции передается
        //произвольный массив строк, и флаг направления сортировки.
        

        String[] list_to_sort = {"ccc", "bbb", "ewer", "aaa", "ddd"};
        boolean ascending = true;
        System.out.print("List before: ");
        for (String s : list_to_sort) {
            System.out.print(s + " ");
        }

        int count;
        do {
            count = 0;
            for (int i = 0; i < list_to_sort.length - 1; i++) {
                if (ascending) {
                    if ((list_to_sort[i].compareTo(list_to_sort[i + 1])) > 0) {
                        String damp = list_to_sort[i + 1];
                        list_to_sort[i + 1] = list_to_sort[i];
                        list_to_sort[i] = damp;
                        count++;
                    }


                } else {
                    if ((list_to_sort[i].compareTo(list_to_sort[i + 1])) < 0) {
                        String damp = list_to_sort[i + 1];
                        list_to_sort[i + 1] = list_to_sort[i];
                        list_to_sort[i] = damp;
                        count++;
                    }
                }
            }
        } while (count > 0);
        System.out.print("\n\nList after: ");
        for (String s : list_to_sort) {
            System.out.print(s + " ");
        }
    }
}
