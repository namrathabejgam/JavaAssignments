package Assignments;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileRegexSearch {
    public static void main(String[] args) {
        File currentDirectory = new File("/home/namratha");
        Scanner scanner=new Scanner(System.in);
        while(true)
        {
            System.out.print("Enter the pattern you want to search for..:");
            String regexPattern= scanner.nextLine();
            displayDirectoryContents(currentDirectory,regexPattern.toLowerCase());
            System.out.print("Do you want to search?(yes/no)");
            String response=scanner.nextLine();
            if(response.equalsIgnoreCase("no"))
                break;
        }
    }

    public static void displayDirectoryContents(File dir,String regex) {
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    //System.out.println("directory:" + file.getAbsolutePath());
                    //displayDirectoryContents(file,regex);
                }
                else {
                    String pattern=".*"+regex+".*";
                    if(Pattern.matches(pattern, file.getName().toLowerCase()))
                    System.out.println("file:" + file.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
