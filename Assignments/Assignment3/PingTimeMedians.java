package Assignments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class PingTimeMedians {

    public static void runSystemCommand(String command,int n) {

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String input = "";
            // reading output stream of the command
            double pingtimes[]=new double[n];
            int i=1;
            while ((input = inputStream.readLine()) != null) {
                if(input.contains("time="))
                System.out.println(input);
                String array[]=input.split("\\s+");
                if(input.contains("time="))
                {
                    //System.out.println(array[array.length-2].substring(5));
                    pingtimes[i-1]=Double.parseDouble(array[array.length-2].substring(5));
                    //System.out.println("pingtimes[i]"+pingtimes[i-1]);
                    i++;


                    if(i>=2&&i<=n+1){
                        Arrays.sort(pingtimes,0,i-1);
                        int numberOfPings=i-1;
                        if(numberOfPings%2==0)
                            System.out.println("Median:"+(pingtimes[(numberOfPings/2)]+pingtimes[((numberOfPings/2)-1)])/2);
                        else
                            System.out.println("Median:"+pingtimes[((numberOfPings+1)/2)-1]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the website to be pinged(for example, google.com):");
        String ip = scanner.nextLine();
        System.out.print("Enter the number of times to ping:");
        int n=scanner.nextInt();

        runSystemCommand("ping -c "+n+" "+ ip,n);


    }
}
