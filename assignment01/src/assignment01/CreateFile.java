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
import java.io.*;
import java.util.*;
import java.lang.*;
public class CreateFile {
    public String line = null;
    public void writeFile(){
        try{
            FileReader fileReader = new FileReader("E:\\Education\\4.1\\read.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("E:\\Education\\4.1\\write.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
         
            }
            bufferedReader.close();
            bufferedWriter.close();
        }catch(Exception ex){
            System.out.println("Something wrong!!!");
        }
    }
    
}
