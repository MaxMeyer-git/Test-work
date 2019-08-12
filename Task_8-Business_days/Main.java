package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        DateTimeFormatter format_to_export = DateTimeFormatter.ofPattern("dd.MMMM.yyyy");
        DateTimeFormatter format_to_decrypt_input = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        String dateIn = "2019/08/15";
        int business_days =10;

        LocalDate localDateIn = LocalDate.parse(dateIn, format_to_decrypt_input);

        LocalDate result = business_days_counter.count(localDateIn, business_days);

        System.out.println(result.format(format_to_export));

    }
}
