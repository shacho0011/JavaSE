/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Shadhin
 */
public class CreateWriteFile {
    public void createWriteFile(){
        
        File file = new File("E:\\Education\\4.1\\read.txt");
        if (!file.exists()) {
            System.out.println("E:\\Education\\4.1\\read.txt" + " does not exist.");
            return;
        }
        if(!(file.isFile() && file.canRead())) {
            System.out.println(file.getName() + " cannot be read from.");
            return;
        }
        try {
            FileInputStream filwInputStreme = new FileInputStream(file);
            char current;
          
            FileWriter fileWriter = new FileWriter("E:\\Education\\4.1\\write.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            int spaceFlag = 0;
            int startLineFlag = 0;
            char[] word = new char[6]; 
            String resWord = "printf";
            while (filwInputStreme.available() > 0) {
                current = (char) filwInputStreme.read();
                if(current != ' ' && startLineFlag == 0){
                    bufferedWriter.write(' ');
                    bufferedWriter.write(current);
                    startLineFlag = 1;
                }
                else if(current == '\n'){
                    
                    bufferedWriter.write(current);
                    bufferedWriter.write(' ');
                    current = (char) filwInputStreme.read();
                    if(current == 'p'){
                        word[0] = current;
                        for(int i =1; i<6; i++){
                            current = (char) filwInputStreme.read();
                            word[i] = current;
                        }
                        if(word.equals(resWord)){
                            for(int i = 0; i<6; i++){
                                bufferedWriter.write(word[i]);
                            }
                            current = (char) filwInputStreme.read();
                            while(current != ';'){
                                bufferedWriter.write(current);
                                current = (char) filwInputStreme.read();
                            }
                            bufferedWriter.write(current);
                        }
                        else {
                            for(int i = 0; i<6; i++){
                                bufferedWriter.write(word[i]);
                            }
                        }
                    }
                    else if(current == '/'){
                        char first = current;
                        current = (char) filwInputStreme.read();
                        System.out.println("First is: " + first);
                        System.out.println("Current is: " + current);
                        if(current == '*'){
                            System.out.println("CMNT Removing! nested");
                            do{
                                current = (char) filwInputStreme.read();
                                System.out.println("Current0 is: " + current);
                                if(current == '*') {
                                    System.out.println("Current1 is: " + current);
                                    current = (char) filwInputStreme.read();
                                    System.out.println("Current2 is: " + current);
                                    if(current == '/') break;
                                }
                            }while(true);
                        }
                        else if(current == '/'){
                            System.out.println("Single CMNT Removing! nested");
                            do{
                                current = (char) filwInputStreme.read();
                                if(current == '\n') {
                                    bufferedWriter.write(current);
                                    System.out.println("putting new line nested");
                                }
                            }while(current != '\n');
                        }
                        else {
                            bufferedWriter.write(first);
                            bufferedWriter.write(current);
                        }
                    }
                    else if(current != ' ') {
                        bufferedWriter.write(' ');
                        bufferedWriter.write(current);
                    }
                    else {
                        bufferedWriter.write(current);
                    }
                    spaceFlag = 0;
                }
                else if(current == ' ' && spaceFlag == 0) {
                    bufferedWriter.write(current);
                    spaceFlag = 1;
                }
                else if(current == '/'){
                    char first = current;
                    current = (char) filwInputStreme.read();
                    System.out.println("First is: " + first);
                    System.out.println("Current is: " + current);
                    if(current == '*'){
                        System.out.println("CMNT Removing!");
                            do{
                                current = (char) filwInputStreme.read();
                                System.out.println("Current0 is: " + current);
                                if(current == '*') {
                                    System.out.println("Current1 is: " + current);
                                    current = (char) filwInputStreme.read();
                                    System.out.println("Current2 is: " + current);
                                    if(current == '/') break;
                                }
                            }while(true);
                    }
                    else if(current == '/'){
                        System.out.println("Single CMNT Removing!");
                            do{
                                current = (char) filwInputStreme.read();
                                if(current == '\n') {
                                    
                                }
                            }while(current != '\n');
                            bufferedWriter.write('\n');
                            System.out.println("putting new line");
                    }
                    else {
                        bufferedWriter.write(first);
                        bufferedWriter.write(current);
                    }
                    spaceFlag = 0;
                }
                else if(current != ' '){
                    bufferedWriter.write(current);
                    spaceFlag = 0;
                } 
            }
            bufferedWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}