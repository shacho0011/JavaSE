/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment01;

/**
 *
 * @author Shadhin
 */
import java.util.*;
import java.io.*;
public class ReadFile {
    
    private Scanner scanner;
    
    public void openFile(){
        try{
            scanner = new Scanner(new File("E:\\Education\\4.1\\read.txt"));
        }catch(Exception ex){
            System.out.println("Could not find file");
        }
    }
    
    public void readFile(){
        while(scanner.hasNext()){
            String a = scanner.next();
            System.out.print(a);
        }
    }
    
    public void closeFile(){
        scanner.close();
    }
    
}
