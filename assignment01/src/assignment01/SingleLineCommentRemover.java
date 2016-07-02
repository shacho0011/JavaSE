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
public class SingleLineCommentRemover {
    
    public void cmntRemove(){
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

            while (filwInputStreme.available() > 0) {
                
                current = (char) filwInputStreme.read();
                
                if(current == '/'){
                    char first = current;
                    current = (char) filwInputStreme.read();
                    System.out.println("First is: " + first);
                    System.out.println("Current is: " + current);
                    if(current == '/'){
                        current = (char) filwInputStreme.read();
                        while(current != '\n'){
                            current = (char) filwInputStreme.read();
                            System.out.println("CMNT Removing!");
                        }
                    }
                    else {
                        bufferedWriter.write(first);
                        bufferedWriter.write(current);
                    }
                }
                else{
                    bufferedWriter.write(current);
                }
            }
            bufferedWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
}
