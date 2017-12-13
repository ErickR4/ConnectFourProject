package com.company;
import java.sql.Date;                           //19) Java Library
import java.text.*;

public class gameStats {                        //18) encapsulation

    public static void totalTime(long end, long start){                         //22) Modifier
        NumberFormat SecondFormatter = new DecimalFormat("#0.00");      //23) printf
        double gametime = end-start;
        System.out.println("Total game time: "+ (SecondFormatter.format((gametime)/1000d))+" seconds");

    }

    public static void getCurrentTime(long currentTime){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date(currentTime);
        System.out.println("This game was played on: " + dateFormat.format(date));      //22 println
    }

}