package Assignments;

import java.io.*;
public class RegexSearch {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the input string:");
        String input=bufferedReader.readLine();
    /*System.out.println(inputString.toLowerCase().replaceAll("[^a-z]", ""));
    System.out.println(inputString.toLowerCase().replaceAll("[^a-z]", "").replaceAll("(.)(?=.*\\1)", ""));*/
        boolean containsAllLetters=(input.toLowerCase().replaceAll("[^a-z]", "").replaceAll("(.)(?=.*\\1)", "").length() == 26);
        if(containsAllLetters)
            System.out.println("The input string contains all the letters of the alphabet");
        else
            System.out.println("The input string doesn't contain all the letters of the alphabet");
        /***
         Big-O Time Complexity of this approach tends to O(n), where n is the length of the string.
         Space Complexity of this approach is O(1).
         ***/
        /* test-input: Farmer jack realized that big yellow quilts were expensive */
    }
}
