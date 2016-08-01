import java.util.ArrayList;
import java.util.Scanner;

public class ParserG {
	
	int stk = 0;
	int parseFlag = 1;
	private String[][] parseTable = {
			{null,"id","num","+","-","*","/","(",")","$"},
			{"E","Te","Te",null,null,null,null,"Te",null,null},
			{"e",null,null,"+Te",null,null,null,null,"!","!"},
			{"T","Ft","Ft",null,null,null,null,"Ft",null,null},
			{"t",null,null,"!","-Ft",null,null,null,"!","!"},
			{"F","Gf","Gf",null,null,null,null,"Gf",null,null},
			{"f",null,null,"!","!","*Gf",null,null,"!","!"},
			{"G","Hg","Hg",null,null,null,null,"Hg",null,null},
			{"g",null,null,"!","!","!","/Hg",null,"!","!"},
			{"H","id","num",null,null,null,null,"(E)",null,null}
			
	};
	
	
	public void parser(){
		
		Scanner sc = new Scanner(System.in);
		String sentence;
		System.out.println("Input the sentence: ");
		sentence = sc.nextLine();
		System.out.println("Sentence is: "+ sentence);
		System.out.println("Parser table for the predefined grammar shown below:");
		for(int i = 0; i<10; i++){
			for(int j = 0; j<10; j++)
				System.out.print(parseTable[i][j]+"\t");
			System.out.println("");
		}
		
		char[] sent = sentence.toCharArray();
		
		for(int i = 0; i<sent.length;i++){
			System.out.print(sent[i]);
		}
		System.out.println("");
		
		//System.out.println("length of sent is : "+ sent.length);
		
		String type[] = {"int","float","double","char","string","const","long","void"};
        String keyword[] = {"auto","break","const","if","else","continue","default","do","while","for","enum","extern","goto","long","register","return","sizeof","static","struct","switch","signed","unsigned","typedef","union","volatile"};
        String functionWord[] = {"main","printf", "puts", "scanf", "gets",};
        String str = null;
		int k = 0, j = 0, s = 0;
		String[] newSentence = new String[20];
		int i = 0;
		for(i = 0; i<sent.length;i++){
	        	
	        	int typeFlag = 0;
	        	int identifierFlag = 0;
	        	int functionFlag = 0;
	        	int keywordFlag = 0;
	        	int numberFlag = 0;
	        	int dotFlag = 0;
	        	k = 0;
	        	char[] word = new char[20];

	        	while( (sent[i] >= 'a' || sent[i] >= 'A') && (sent[i] <= 'z' || sent[i] <= 'Z') || sent[i] == '_'){
	        		
	        		//System.out.println("index of i: "+i);
	        		
	        		typeFlag = 0;
	                identifierFlag = 0;
	                functionFlag = 0;
		        	keywordFlag = 0;
		        	numberFlag = 0;
		        	dotFlag = 0;
		        	
	        		word[k++] = sent[i];
	        		//System.out.println("index of k: "+k);
	            	str = new String(word).trim().replaceAll(" ", null);
	            	
	            	j = 0;
	            	while(j<type.length && typeFlag == 0 && keywordFlag == 0 && functionFlag == 0){
	            		if(str.equals(type[j++])){
	            			typeFlag = 1;
	            			keywordFlag = 0;
	            			functionFlag = 0;
	                    	identifierFlag = 0;
	                    }else{
	                    	typeFlag = 0;
	                    	keywordFlag = 0;
	            			functionFlag = 0;
	                    	identifierFlag = 1;
	            		}
	            	}

	            	j=0;
	            	while(j<keyword.length && typeFlag == 0 && keywordFlag == 0 && functionFlag == 0){
	            		if(str.equals(keyword[j++])){
	            			typeFlag = 0;
	                    	keywordFlag = 1;
	            			functionFlag = 0;
	                    	identifierFlag = 0;
	                    }else{
	                    	typeFlag = 0;
	                    	keywordFlag = 0;
	            			functionFlag = 0;
	                    	identifierFlag = 1;
	            		}
	            	}
	            	
	            	j=0;
	            	while(j<functionWord.length && typeFlag == 0 && keywordFlag == 0 && functionFlag == 0){
	            		if(str.equals(functionWord[j++])){
	            			typeFlag = 0;
	                    	keywordFlag = 0;
	            			functionFlag = 1;
	                    	identifierFlag = 0;
	                    }else{
	                    	typeFlag = 0;
	                    	keywordFlag = 0;
	            			functionFlag = 0;
	                    	identifierFlag = 1;
	            		}
	            	}
	            	
	            	if(i<sent.length-1) i++;
	            	else break;
	        	}
	        	System.out.println("Number: ");
	        	while((sent[i] >= '0'&& sent[i] <= '9')||(sent[i] == '.' && (dotFlag == 0||dotFlag == 1))){
	        		numberFlag = 1;
	        		if(sent[i] == '.' && dotFlag == 0){
	        			dotFlag = 1;
	        		}else if(sent[i] == '.' && dotFlag == 1){
	        			dotFlag = 2;
	        		}
	        		
	        		System.out.print(sent[i]);
	        		if(i<sent.length-1) i++;
	        		else break;
	        	}
	        	System.out.println("");
	        	
	        	if(identifierFlag == 1 && typeFlag == 0 && keywordFlag == 0 && functionFlag == 0){
	        		
	        		newSentence[s++] = "id";
	        		identifierFlag = 0;
	        		//System.out.println(newSentence[s++]);
	        	}
	        	
	        	if(numberFlag == 1 && dotFlag == 2){
	        		newSentence[s++] = "num";
	        		newSentence[s++] = "num";
	        		numberFlag = 0;
	        		dotFlag = 0;
	        		//System.out.println(newSentence[s++]);
	        	}else if(numberFlag == 1 && (dotFlag == 0 || dotFlag == 1)){
	        		newSentence[s++] = "num";
	        		numberFlag = 0;
	        		dotFlag = 0;
	        	}
	        	
	        	if(sent[i] == '+' || sent[i] == '-' || sent[i] == '*' || sent[i] == '/'|| sent[i] == '(' || sent[i] == ')'){
	        		newSentence[s++] = Character.toString(sent[i]);
	        		//System.out.println(newSentence[s++]);
	        	}
	        	
	        }
		
		newSentence[s] = "$";
				// eliminate null value from last
		ArrayList al = new ArrayList(); 
		for(i=0; i<newSentence.length; i++){ 
		if(newSentence[i]!=null) 
		al.add(newSentence[i]); 
		} 
		newSentence = (String[])al.toArray(new String[al.size()]); 
		System.out.print("New formed sentence: ");
		for(i = 0; i<newSentence.length; i++){
			System.out.print(newSentence[i]);
		}
		System.out.println("");
		
		stk = 0;
		//System.out.println(stk);
		int push = 0, pop = 0, counter = 0;
		String[] stack = new String[50];
		push = push(stk); // push = 0, stk = 1
		//System.out.println(stk);
		stack[push] = "$";
		push = push(stk); //push = 1, stk = 2
		//System.out.println(stk);
		stack[push] = "E";
		s = 0;
		String temp = null;
		String tempS;
		

		for(pop = pop(stk);pop>=0;pop = pop(stk)){
			counter++;
			tempS = stack[pop];
			System.out.println("pop: "+ stk+" Value: "+tempS);
			temp = newSentence[s];
			System.out.println("sentence: " + temp);
			
			if(temp.equals("$")&&tempS.equals("$")) break;
			
			if(!temp.equals("$")){
				if(tempS.equals(temp)){
					s++;
					parseFlag = 1;
					System.out.println("Change 1: parseFlag = "+parseFlag);
					System.out.println("sentence increment op");continue;
					
				}else{
					parseFlag = 0;
					System.out.println("Change 2: parseFlag = "+parseFlag);
					System.out.println("Op Cancel");
				}
			}
			
			System.out.println("parseFlag = "+parseFlag);
			

			int row = 0, col = 0;
			for(row = 1; row<10 ; row++){
				if(parseTable[row][0].equals(tempS)){
					System.out.println("Parse Table Row Value: "+parseTable[row][0]);
					for(col = 1; col<10; col++){
						if(parseTable[0][col].equals(temp)){
							str = parseTable[row][col];
							System.out.println("Parse Table Value: "+str);
							break;
						}
					}
					parseFlag = 1;
					//System.out.println("Change 3: parseFlag = "+parseFlag);
					break;
				}else{
					parseFlag = 2;
					System.out.println("Change 3: parseFlag = "+parseFlag);
				}
			}
			if(parseFlag==2){
				parseFlag = 0; break;
			}
			if(str == null){
				parseFlag = 0;
				System.out.println("Null!!! Break op.");
				break;
			}
			
			if(str.equals("!"))continue;
			
			if(str.equals("id")){
				push = push(stk); // push = 1, stk =2
				stack[push] = str;
				System.out.println("push: "+stk+" Value: "+stack[push]);
			}else if(str.equals("num")){
				push = push(stk); // push = 1, stk =2
				stack[push] = str;
				System.out.println("push: "+stk+" Value: "+stack[push]);
			}else{
				char[] snt = str.toCharArray();
					for(int pointer = snt.length - 1; pointer>=0; pointer--){
						push = push(stk); // push = 1, stk =2
						stack[push] = Character.toString(snt[pointer]);
						System.out.println("push: "+stk+" Value: "+snt[pointer]);
					}
			}   
				
		}
		if(parseFlag == 1){
			System.out.println("The given sentence can be derivable! and count = "+counter);
		}else if(parseFlag == 0){
			System.out.println("The given sentence can not be derivable! and count = "+counter);
		}
		System.out.println("Stack pointer: "+stk);
	}
	
	public int push(int i){
		int temp = i++;
		stk = i;
		return temp;
	}
	
	public int pop(int i){
		stk = --i;
		return stk;
	}

}
