import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;


public class Identifier {
	public void identifier(){
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
            int i = 0;
            String keyword[] = {"int","float","double","char","string","auto","break","const","if","else","continue","default","do","while","for","enum","extern","goto","long","register","return","sizeof","static","struct","switch","signed","unsigned","typedef","union","void","volatile"};
            int identifierFlag = 0;
            int numberFlag = 0;
            String str = null;
            
            while (filwInputStreme.available() > 0) {
            	i = 0;
            	char word[] = new char[50];
            	current = (char) filwInputStreme.read();
            	identifierFlag = 0;
            	numberFlag = 0;
            	
            	if( (current >= 'a' || current >= 'A') && (current <= 'z' || current <= 'Z') || current == '_'){
            		
            		identifierFlag = 1;
            		do{
            			word[i++] = current;
            			current = (char) filwInputStreme.read();
            		}while((current >= 'a' || current >= 'A') && (current <= 'z' || current <= 'Z') || current == '_');
            		str = new String(word).trim().replaceAll(" ", null);
                	int j = 0;
                	while(j<keyword.length){
                		if(str.equals(keyword[j])){
                			identifierFlag = 0;
                        }
                		j++;
                	}
                	if(identifierFlag == 1){
                		System.out.println("<IDENTIFIER>");
                	}
                	if(current == ';'){
                		System.out.println("<SEMICOLON>");
                		
                	}
                	else{
                		identifierFlag = expressionIdentifier(current);
                    	current = (char) filwInputStreme.read();
                    	if(current>='0' && current<='9'){
                    		while(current>='0' && current<='9'){
                    			current = (char) filwInputStreme.read();
                    		}
                    		if(current=='.'){
                    			do{
                        			current = (char) filwInputStreme.read();
                        		}while(current>='0' && current<='9');
                    		}
                    		if(current == ';'){
                        		System.out.println("<SEMICOLON>");
                        		
                        	}
                    		
                    	}
                	}
                	
                	
                }
            	else if(current>='0' && current<='9'){
            		System.out.println("<INVALID>");
            	}
            	else{
            		expression(current);
            	}
            }
            
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
	
	
	private int expressionIdentifier(char current){
		
		if(current == '='){
        	System.out.println("<ASSOP>");
        }
        else if(current == '+'){
        	System.out.println("<PLUSOP>");
        }
        else if(current == '-'){
        	System.out.println("<MINUSOP>");
        }
        else if(current == '*'){
        	System.out.println("<MULOP>");
        }
        else if(current == '/'){
        	System.out.println("<DIVOP>");
        }
        else if(current == '<'){
        	System.out.println("<LESSOP>");
        }
        else if(current == '>'){
        	System.out.println("<GREATEROP>");
        }
		return 0;
	}
	
	
	private void expression(char current){
		if(current == ';'){
    		System.out.println("<SEMICOLON>");
    	}
    	else if(current == '('){
    		System.out.println("<OFB>");
        }
        else if(current == '{'){
        	System.out.println("<OSB>");
        }
        else if(current == '['){
        	System.out.println("<OTB>");
        }
        else if(current == ')'){
        	System.out.println("<CFB>");
        }
        else if(current == '}'){
        	System.out.println("<CSB>");
        }
        else if(current == ']'){
        	System.out.println("<CTB>");
        }
        else if(current == '='){
        	System.out.println("<ASSOP>");
        }
        else if(current == '+'){
        	System.out.println("<PLUSOP>");
        }
        else if(current == '-'){
        	System.out.println("<MINUSOP>");
        }
        else if(current == '*'){
        	System.out.println("<MULOP>");
        }
        else if(current == '/'){
        	System.out.println("<DIVOP>");
        }
        else if(current == '<'){
        	System.out.println("<LESSOP>");
        }
        else if(current == '>'){
        	System.out.println("<GREATEROP>");
        }
	}
	
	
	
}
