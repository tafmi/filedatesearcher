
package filedatesearcher;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileDateSearcher {

    public static void main(String[] args) throws IOException {
        
      boolean exit=false;
      while(exit==false){
        boolean validDir=false;
        File directory=new File("");
        System.out.println("Please type the directory's path and press ENTER.");
        while(validDir==false){           
            Scanner in=new Scanner(System.in);
            String inputDir=in.nextLine();
            directory=new File(inputDir);
            if(!directory.isDirectory()){
                System.out.println("The path you typed is not a directory.\nPlease type a valid direcotry and press ENTER.");
            }
            else{
                validDir=true;
            }
        }
        boolean validDate=false;
        FileDate fileDate=new FileDate("");
        System.out.println("Please type the date (dd-mm-yyyy) and press ENTER.");  
        while(validDate==false){
            Scanner in=new Scanner(System.in);
            String inputDate=in.nextLine();
            fileDate=new FileDate(inputDate);
            if(!fileDate.isValid()){
                System.out.println("The date you typed is not valid.\nPlease type a valid date (dd-mm-yyyy) and press ENTER."); 
            }
            else{
                validDate=true;
            }
        }
        boolean validField=false;
        int field=0;
        System.out.println("Please specify the file's field you want to be examined:");
        System.out.println("1. Creation date");
        System.out.println("2. Last modification date");
        System.out.println("Type 1 or 2 and press ENTER.");
        while(validField==false){
            Scanner in=new Scanner(System.in);
            String sfield=in.nextLine();
            if(sfield.length()>1 || !Character.isDigit(sfield.charAt(0)) || 
                    (Integer.parseInt(sfield)!=1 && Integer.parseInt(sfield)!=2) ){
                System.out.println("Please type only:\n1 for creation time\n2 for last modofication time\nand press ENTER.");
            }
            else{
                field=Integer.parseInt(sfield);
                validField=true;
            }
        }
        
        FileSearcher searcher=new FileSearcher(directory,fileDate,field);
        searcher.start();
        
        System.out.println("Would you like to exit?Type Y/N and press ENTER.");
        boolean validAnswer=false;
        while(validAnswer==false){
            Scanner in=new Scanner(System.in);
            String answer=in.nextLine();
            if(!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")){
                System.out.println("Please type only:\nY for yes\nN for no\nand press ENTER.");
            }
            else{
                validAnswer=true;
                if(answer.equalsIgnoreCase("y")){
                    exit=true;
                }
                else{
                    exit=false;
                }
            }
        }
    }
  }
}
