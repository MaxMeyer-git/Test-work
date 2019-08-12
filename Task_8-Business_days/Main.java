package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        
        //Необходимо написать функцию, которая к дате прибавит рабочие дни.
        //На вход передается переменная с датой, и количество рабочих дней, которые необходимо прибавить. 
        //На выходе результирующая дата. При этом при передаче отрицательного количества дней функция должна их отнять.
        //Под рабочими днями подразумеваются будние дни без учета праздников.

        DateTimeFormatter format_to_export = DateTimeFormatter.ofPattern("dd.MMMM.yyyy");
        DateTimeFormatter format_to_decrypt_input = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        String dateIn = "2019/08/15";
        int business_days =10;

        LocalDate localDateIn = LocalDate.parse(dateIn, format_to_decrypt_input);

        LocalDate result = business_days_counter.count(localDateIn, business_days);

        System.out.println(result.format(format_to_export));

    }
}
