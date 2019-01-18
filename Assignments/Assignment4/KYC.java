package Assignments;

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
public class KYC {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bufferedReader.readLine());
        while(n-->0)
        {
            String inputDates[]=bufferedReader.readLine().split("\\s+");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate signUpDate = LocalDate.parse(inputDates[0], formatter);
            LocalDate currentDate = LocalDate.parse(inputDates[1], formatter);
            if(currentDate.compareTo(signUpDate)<=0)
            {
                System.out.println("No range");
                continue;
            }
            String anniversaryDateString=inputDates[0].substring(0,inputDates[0].length()-4)+inputDates[1].substring(inputDates[1].length()-4,inputDates[1].length());
            LocalDate closestAnniversaryDate=LocalDate.parse(anniversaryDateString, formatter);
            LocalDate windowStartDate=closestAnniversaryDate.minusDays(30);
            LocalDate windowEndDate=closestAnniversaryDate.plusDays(30);
            if(currentDate.compareTo(signUpDate.plusYears(1).minusDays(30))<0)
            {
                System.out.println("No range");
                continue;
            }
            if(windowStartDate.compareTo(currentDate) * currentDate.compareTo(windowEndDate) >= 0)
            {
                System.out.println(windowStartDate.format(formatter)+" "+inputDates[1]);
            }
            else if(windowStartDate.compareTo(currentDate)>0)
            {
                System.out.println(windowStartDate.minusYears(1).format(formatter)+" "+windowEndDate.minusYears(1).format(formatter));
            }
            else if(currentDate.compareTo(windowEndDate)>0)
            {
                System.out.println(windowStartDate.format(formatter)+" "+windowEndDate.format(formatter));
            }
        }
    }
}
/*
5
16-07-1998 27-06-2017
04-02-2016 04-04-2017
04-05-2017 04-04-2017
04-04-2015 04-04-2016
04-04-2015 15-03-2016
*/