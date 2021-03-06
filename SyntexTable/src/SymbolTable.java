import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;


public class SymbolTable {
	public void tokenTable(){
		String[][] tokenTable = new String[10][4];
		try{
			File file = new File("E:\\Lab 02\\input.txt");
	        File file2 = new File("E:\\Lab 02\\output.txt");
	        if (!file.exists()) {
	            System.out.print("E:\\Lab 02\\input.txt" + " does not exist.");
	            return;
	        }
	        
	        if(!(file.isFile() && file.canRead())) {
	            System.out.print(file.getName() + " cannot be read from.");
	            return;
	        }
	        
	        FileInputStream filwInputStreme = new FileInputStream(file);
	        file2.delete();
	        FileWriter fileWriter = new FileWriter("E:\\Lab 02\\output.txt", true);
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	        
	        char current;
	        
	        int i = 0;
	        String keyword[] = {"int","float","double","char","string","auto","break","const","if","else","continue","default","do","while","for","enum","extern","goto","long","register","return","sizeof","static","struct","switch","signed","unsigned","typedef","union","void","volatile"};
	        String functionword[] = {"main","printf", "puts", "scanf", "gets",};
	        int keywordFlag = 0;
	        int functionFlag = 0;
	        int identifierFlag = 0;
	        int invalidFlag = 0;

	        int globalScope = 1;
	        int id = 0;
	        String str = null;
	        
	        while (filwInputStreme.available() > 0) {
	        	i = 0;
	        	keywordFlag = 0;
	        	functionFlag = 0;
	            identifierFlag = 0;
	            invalidFlag = 0;
	        	char word[] = new char[50];
	        	current = (char) filwInputStreme.read();
	        	//System.out.print(current);
	        	while( (current >= 'a' || current >= 'A') && (current <= 'z' || current <= 'Z') || current == '_'){
	        		keywordFlag = 0;
	        		functionFlag = 0;
	                identifierFlag = 0;
	        		word[i++] = current;
	            	
	            	str = new String(word).trim().replaceAll(" ", null);
	            	int j = 0;
	            	while(j<keyword.length && keywordFlag == 0){
	            		if(str.equals(keyword[j++])){
	                    	keywordFlag = 1;
	                    	functionFlag = 0;
	                    	identifierFlag = 0;
	                    }
	            		else if(str.equals("printf") || str.equals("scanf") || str.equals("main") || str.equals("puts") || str.equals("gets")){
	            			functionFlag = 1;
	            			keywordFlag = 0;
	                        identifierFlag = 0;
	            		}
	            		else {
	            			keywordFlag = 0;
	            			functionFlag = 0;
	            			identifierFlag = 1;
	            		}
	            	}
	            	current = (char) filwInputStreme.read();
	            }
	        	
	        	if(keywordFlag==1){
	        		//bufferedWriter.write("<KEYWORD>");
	        		System.out.print("<KEYWORD>");
	        		keywordFlag = 0;
	        	}
	        	
	        	else if(functionFlag == 1){
	        		//bufferedWriter.write("<FUNCTION>");
	        		System.out.print("<FUNCTION>");
	        		if(current == '('){
	        			//bufferedWriter.write("<OFB>");
	        			System.out.print("<OFB>");
	        			do{
	        				current = (char) filwInputStreme.read();
	        			}while(current != ')');
	        			//bufferedWriter.write("<EXPRESSION>");
	        			System.out.print("<EXPRESSION>");
	        		}
	        		
	        		else{
	        			//bufferedWriter.write("<INVALID>");
	        			System.out.print("<INVALID>");
	        			while(current != ')' && current != ';'){
	        				current = (char) filwInputStreme.read();
	        			}
	        		}
	        		
	        	}
	        	
	        	else if(identifierFlag==1){
	        		//bufferedWriter.write("<IDENTIFIER>");
	        		System.out.print("<IDENTIFIER>");
	        		identifierFlag = 0;
	        		tokenTable[id++][0] = str; 
	        	}
	        }
		}catch(Exception ex){
            System.out.print(ex);
        }
		
		
		int j = 0;
		while(j < 10){
			System.out.println(tokenTable[j++][0]);
		}
		
	}
        
	
}
