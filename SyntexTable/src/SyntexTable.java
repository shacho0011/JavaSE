import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;


public class SyntexTable {
	
	
    char currentChar;
    String str = null;
    int i = 0, j = 0, id = 0;
    String[][] syntexTable = new String[15][7];
    int localScope = 0;
    int functionFlag = 0;
	public void syntexTable(){
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
	        
	        FileInputStream fileInputStreme = new FileInputStream(file);
	        file2.delete();
	        FileWriter fileWriter = new FileWriter("E:\\Lab 02\\output.txt", true);
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	        String type[] = {"int","float","double","char","string","const","long","void"};
	        String keyword[] = {"auto","break","const","if","else","continue","default","do","while","for","enum","extern","goto","long","register","return","sizeof","static","struct","switch","signed","unsigned","typedef","union","volatile"};
	        String functionword[] = {"main","printf", "puts", "scanf", "gets",};
	        
	        while(fileInputStreme.available() > 0){
	        	
	        	int typeFlag = 0;
	        	int identifierFlag = 0;
	        	i = 0;
	        	char[] word = new char[20];
	        	currentChar = (char) fileInputStreme.read();
	        	
	        	if(currentChar == '#'){
	        		while(currentChar !='\n'){
	        			currentChar = (char) fileInputStreme.read();
	        		}
	        	}
	        	while( (currentChar >= 'a' || currentChar >= 'A') && (currentChar <= 'z' || currentChar <= 'Z') || currentChar == '_'){
	        		typeFlag = 0;
	                identifierFlag = 0;
	        		word[i++] = currentChar;
	        		
	            	str = new String(word).trim().replaceAll(" ", null);
	            	//System.out.println(str);
	            	int j = 0;
	            	while(j<type.length && typeFlag == 0){
	            		if(str.equals(type[j++])){
	            			typeFlag = 1;
	                    	identifierFlag = 0;
	                    }
	            		else {
	            			typeFlag = 0;
	            			identifierFlag = 1;
	            		}
	            		//System.out.println(identifierFlag);
	            	}
	            	
	            	j = 0;
	            	while(j<keyword.length){
	            		if(str.equals(keyword[j++])){
	            			typeFlag = 0;
	                    	identifierFlag = 0;
	                    	do{
	                    		currentChar = (char) fileInputStreme.read();
	                    	}while(currentChar != ';');
	                    	
	                    }
	            	}
	            	
	            	j = 0;
	            	while(j<functionword.length){
	            		if(str.equals(functionword[j++])){
	            			typeFlag = 0;
	            			identifierFlag = 0;
	            			do{
	                    		currentChar = (char) fileInputStreme.read();
	                    	}while(currentChar != ')');
	                    	
	            		}
	            	}
	            	
	            	
	            	if(str.equals("main")){
	            		localScope = 1;
	            		functionFlag++;
	            	}
	            	
	            	
	            	currentChar = (char) fileInputStreme.read();
	            	
	            }
	        	
	        	/*
	        	if(currentChar == '('){
    				//syntexTable[id][4] = "function";
    				//functionFlag = 1;
    				localScope = 1;
    				//break;
    			}
	        	*/
	        	if(currentChar == '}') {
    				localScope = 0;
    				functionFlag++;  // here to detect the same function scope
    				//break;
    			}
	        	
	        	if(currentChar == '[' || currentChar == ']'|| currentChar == '"') continue;
	        	
	        	if(typeFlag == 1){
	        		syntexTable[id][1] = str;
	        		bufferedWriter.write("Hello");
	        	}else if(identifierFlag == 1){
	        		//System.out.println(str + identifierFlag);
	        		syntexTable[id][5] = str;
	        		syntexTable[id][4] = "variable";
	        		syntexTable[id][6] = ""+functionFlag;
	        		str = null;
	        		char[] value = new char[30];
	        		int k = 0;
	        		
	        		while(currentChar != ';'){
	        			if(currentChar == '('){
	        				syntexTable[id][4] = "function";
	        				//functionFlag = 1;
	        				localScope = 1;
	        				//functionFlag++;
	        				break;
	        			}
	        			
	        			if(currentChar == '{' ||currentChar == '[' || currentChar == ']') break;
	        			
	        			if(currentChar != '=' && currentChar != ' ' && currentChar != '(' && currentChar != ')') {
	        				if(currentChar != '"') {
	        					value[k++] = currentChar;
		        				str = new String(value).trim().replaceAll(" ", null);
	        				}
	        			}
	        			currentChar = (char) fileInputStreme.read();
	        			
	        		}
	        		if(localScope == 1){
	        			syntexTable[id][3] = "local";
	        		}else{
	        			syntexTable[id][3] = "global";
	        		}
	        		syntexTable[id][2] = str;
	        		id++;
	        	}
	        	
	        }
		}catch(Exception e){
			System.out.println(e);
		}
		
		// for Redecleration
		int k;
		for(i=0;i<15;i++){
			for(j=i+1;j<15;j++){
				if(syntexTable[i][5].equals(syntexTable[j][5]) && syntexTable[i][6].equals(syntexTable[j][6])){
					if(syntexTable[j][1] != null){
						syntexTable[i][0] = "error";
						syntexTable[j][0] = "error";
						for(k=i;k<15;k++){
							if(syntexTable[i][5].equals(syntexTable[k][5]) && syntexTable[i][6].equals(syntexTable[k][6])){
								syntexTable[k][0] = "error";
							}
						}
						//System.out.println("Redecleration Found!!! "+ i + " " + j);
					}
				}
			}	
		}
		
		//for id and function generation
		id = 0;
		int fn = 0;
		for(i=0;i<15;i++){
			if(syntexTable[i][0] == null){
				if(syntexTable[i][4].equals("variable")  && syntexTable[i][1] != "error"){
					syntexTable[i][0] = "id,"+id;
					for(j=i+1;j<15;j++){
						if(syntexTable[i][5].equals(syntexTable[j][5]) && syntexTable[i][6].equals(syntexTable[j][6])){
							syntexTable[j][0] = "id,"+id;
						}
					}
					id++;
				}else if(syntexTable[i][4].equals("function")){
					syntexTable[i][0] = "func,"+fn;
					fn++;
				}
			}
		}
		
		/*
		for(i=0;i<15;i++){
			for(j=0;j<7;j++){
				System.out.print(syntexTable[i][j] + "\t");
			}
			System.out.print("\n");
		}
		*/
		// for assignint type for same id
		/*
		for(i=0;i<14;i++){
				if(syntexTable[i+1][1]==null && syntexTable[i][5].equals(syntexTable[i+1][5]) && syntexTable[i][6].equals(syntexTable[i+1][6])){
					//System.out.println(syntexTable[i][0]);
					syntexTable[i+1][1] = syntexTable[i][1];
				//System.out.println(syntexTable[i][0]);
			}
			
		}
		*/
		
		for(i=0;i<15;i++){
			for(j=0;j<7;j++){
				System.out.print(syntexTable[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		try{
			
			File file2 = new File("E:\\Lab 02\\output.txt");
			file2.deleteOnExit();
			FileWriter fileWriter = new FileWriter("E:\\Lab 02\\output.txt", true);
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			
			System.out.println("\n\nOutput Table\n");
			for(i=0;i<15;i++){
				for(j=0;j<4;j++){
					bufferedWriter.write("Hello");
					System.out.print(syntexTable[i][j] + "\t");
					
				}
				bufferedWriter.write("\n");
				System.out.print("\n");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
