package com.company;

import java.time.LocalDate;


public class business_days_counter {

    public static LocalDate count (LocalDate start_date, int bizness_days ){

        if (bizness_days == 0 ){
            return start_date;
        }
        boolean is_Value_Positive = bizness_days > 0;

        int day_of_the_week = start_date.getDayOfWeek().getValue();
        boolean is_work_day = day_of_the_week<6;
        int abs_B_D = Math.abs(bizness_days);
        int total_days = 0;

        if (is_work_day){
            int shift = bizness_days > 0 ? day_of_the_week : 6- day_of_the_week;
            total_days = abs_B_D + (abs_B_D + shift - 1 ) /5 * 2;
        }else {
            int shiftedWeekend = bizness_days >0 ? day_of_the_week : 13 - day_of_the_week;
            total_days = abs_B_D + (abs_B_D -1) / 5 * 2 + (7 - shiftedWeekend);

        }
        if (is_Value_Positive){
           LocalDate result = start_date.plusDays(total_days);
           return result;
        }else  {
           LocalDate result = start_date.minusDays(total_days);
           return result;
        }
    }

}
