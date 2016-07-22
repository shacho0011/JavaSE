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
import java.io.File;
public class MainClass {
    public static void main(String args[]){
        
        File file = new File("E:\\Education\\4.1\\read.txt");
        if(file.exists()){
            System.out.println(file.getName() + " exists");
        }
        else System.out.println("no existance");
        
        //ReadFile read = new ReadFile();
        //read.openFile();
        //read.readFile();
        //read.closeFile();
        
        //CreateFile createFile = new CreateFile();
        //createFile.writeFile();
        
        CreateWriteFile cwf = new CreateWriteFile();
        cwf.createWriteFile();
        
        SingleLineCommentRemover cr = new SingleLineCommentRemover();
        //cr.cmntRemove();
        
    }
    
}
