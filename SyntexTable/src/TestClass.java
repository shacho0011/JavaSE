
public class TestClass {
	public void test(){
		String[][] test = new String[10][4] ;
		int i = 0;
		String t[] = {"Hello", "World!"};
		while(i< t.length){
			test[i][0] = t[i];
			i++;
		}
		i = 0;
		while(i<test.length){
			System.out.println(test[i++][0]);
		}
		
	}
}
