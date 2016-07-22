package compilerassignment02;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shadhin
 */
public class TokenGenerator {
    public String line = null;
    public void writeFile(){
        try{
            File file = new File("E:\\Lab 02\\example.txt");
            
            if (!file.exists()) {
                System.out.println("E:\\Lab 02\\example.txt" + " does not exist.");
                return;
            }
            
            if(!(file.isFile() && file.canRead())) {
                System.out.println(file.getName() + " cannot be read from.");
                return;
            }
            
            FileInputStream filwInputStreme = new FileInputStream(file);
            FileWriter fileWriter = new FileWriter("E:\\Lab 02\\output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            char current;
            char word[] = new char[10];
            
            while (filwInputStreme.available() > 0) {
                current = (char) filwInputStreme.read();
                
                
                
                System.out.println();
                
                
            }
        
        }catch(Exception ex){
            System.out.println("Something wrong!!!");
        }
    }
}
