import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;


public class Keyword {
	public void keyword(){
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
            int numberFlag = 0;
            int invalidFlag = 0;
            int semicolonFlag = 0;
            
            while (filwInputStreme.available() > 0) {
            	i = 0;
            	keywordFlag = 0;
            	functionFlag = 0;
                identifierFlag = 0;
                numberFlag = 0;
                invalidFlag = 0;
            	char word[] = new char[50];
            	current = (char) filwInputStreme.read();
            	//System.out.print(current);
            	while( (current >= 'a' || current >= 'A') && (current <= 'z' || current <= 'Z') || current == '_'){
            		keywordFlag = 0;
            		functionFlag = 0;
                    identifierFlag = 0;
            		word[i++] = current;
                	String str;
                	str = new String(word).trim().replaceAll(" ", null);
                	//System.out.print(str);
                	/*
                	BufferedReader bufferedReader = null;
                	int bytesRead = bufferedReader.read(word, 0, word.length);
                	str = new String(word, 0, bytesRead);
                	*/
                	int j = 0;
                	while(j<keyword.length && keywordFlag == 0){
                		//System.out.print(keyword[j]);
                		if(str.equals(keyword[j++])){
                        	keywordFlag = 1;
                        	functionFlag = 0;
                        	identifierFlag = 0;
                        	//System.out.print(str+" key: "+keywordFlag+" id: "+identifierFlag);
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
                			//System.out.print(str+" key: "+keywordFlag+" id: "+identifierFlag);
                		}
                	}
                	current = (char) filwInputStreme.read();
                	if(current == ';'){
            			semicolonFlag = 1;
            		}
                }
            	
            	if(keywordFlag==1){
            		bufferedWriter.write("<KEYWORD>");
            		System.out.print("<KEYWORD>");
            		keywordFlag = 0;
            	}
            	
            	else if(functionFlag == 1){
            		bufferedWriter.write("<FUNCTION>");
            		System.out.print("<FUNCTION>");
            		if(current == '('){
            			bufferedWriter.write("<OFB>");
            			System.out.print("<OFB>");
            			do{
            				//System.out.print(current);
            				current = (char) filwInputStreme.read();
            			}while(current != ')');
            			bufferedWriter.write("<EXPRESSION>");
            			System.out.print("<EXPRESSION>");
            			//System.out.print(current);
            		}
            		
            		else{
            			bufferedWriter.write("<INVALID>");
            			System.out.print("<INVALID>");
            			//System.out.print(current);
            			//current = (char) filwInputStreme.read();
            			while(current != ')' && current != ';'){
            				//System.out.print(current);
            				current = (char) filwInputStreme.read();
            			}
            			//System.out.print(current);
            		}
            		
            	}
            	
            	else if(identifierFlag==1){
            		bufferedWriter.write("<IDENTIFIER>");
            		System.out.print("<IDENTIFIER>");
            		identifierFlag = 0;
            	}
            	
            	while(current >='0' && current <= '9'){
            		keywordFlag = 0;
                    identifierFlag = 0;
                    invalidFlag = 0;
            		numberFlag = 1;
            		//System.out.print(current+" num: "+numberFlag+" inv: "+invalidFlag);
            		current = (char) filwInputStreme.read();
            		if(current == '.'){
            			current = (char) filwInputStreme.read();
                        invalidFlag = 1;
                        numberFlag = 0;
                        //System.out.print(current+" num: "+numberFlag+" inv: "+invalidFlag);
            		}
            		else if(current == ';'){
            			semicolonFlag = 1;
            			numberFlag = 1;
            			invalidFlag = 0;
            			
            		}
            		else if( (current >= 'a' || current >= 'A') && (current <= 'z' || current <= 'Z')){
                        invalidFlag = 1;
                        numberFlag = 0;
                        //System.out.print(current+" num: "+numberFlag+" inv: "+invalidFlag);
                        while((current >= 'a' || current >= 'A') && (current <= 'z' || current <= 'Z')){
                        	current = (char) filwInputStreme.read();
                        }
                        break;
            		}
            	}
            	
            	if(numberFlag==1){
            		bufferedWriter.write("<NUMBER>");
            		System.out.print("<NUMBER>");
            		numberFlag = 0;
            	}
            	else if(invalidFlag==1){
            		bufferedWriter.write("<INVALID>");
            		System.out.print("<INVALID>");
            		invalidFlag = 0;
            	}
            	
            	if(current=='\n'){
            		bufferedWriter.write('\n');
            		System.out.print("\n");
            	}
            	else if(current=='\t'){
            		bufferedWriter.write('\t');
            		System.out.print("\t");
            	}
            	else if(current == ' '){
            		//bufferedWriter.write(' ');
            		//System.out.print(" ");
            	}
            	else if(current == ';'){
        			bufferedWriter.write("<SEMICOLON>");
            		System.out.print("<SEMICOLON>");
            	}
            	else if(current == '('){
            		bufferedWriter.write("<OFB>");
            		System.out.print("<OFB>");
                }
                else if(current == '{'){
                	bufferedWriter.write("<OSB>");
                	System.out.print("<OSB>");
                }
                else if(current == '['){
                	bufferedWriter.write("<OTB>");
                	System.out.print("<OTB>");
                }
                else if(current == ')'){
                	bufferedWriter.write("<CFB>");
                	System.out.print("<CFB>");
                }
                else if(current == '}'){
                	bufferedWriter.write("<CSB>");
                	System.out.print("<CSB>");
                }
                else if(current == ']'){
                	bufferedWriter.write("<CTB>");
                	System.out.print("<CTB>");
                }
                else if(current == '='){
                	bufferedWriter.write("<EQ>");
                	System.out.print("<EQ>");
                }
                else if(current == '+'){
                	bufferedWriter.write("<PLUSOP>");
                	System.out.print("<PLUSOP>");
                }
                else if(current == '-'){
                	bufferedWriter.write("<MINUSOP>");
                	System.out.print("<MINUSOP>");
                }
                else if(current == '*'){
                	bufferedWriter.write("<MULOP>");
                	System.out.print("<MULOP>");
                }
                else if(current == '/'){
                	bufferedWriter.write("<DIVOP>");
                	System.out.print("<DIVOP>");
                }
                else if(current == '<'){
                	bufferedWriter.write("<LT>");
                	System.out.print("<LT>");
                }
                else if(current == '>'){
                	bufferedWriter.write("<GT>");
                	System.out.print("<GT>");
                }
            	
            	
            }
            
            filwInputStreme.close();
            bufferedWriter.close();
        }catch(Exception ex){
            System.out.print(ex);
        }
    }
	
}
