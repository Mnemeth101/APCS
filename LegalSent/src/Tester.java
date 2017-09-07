
public class Tester {

	public void Test (String s) {
		String modif_input = s;
		boolean GoodEnd = s.endsWith("p") || s.endsWith("q");
		
		if (SimpleSentence(s)) {
			System.out.println("u good son!");
		}
		
		else if (BeginsWithNot(s)) {
			System.out.println("beginswithnot, removing not");
			s = RemoveNot(s);
			System.out.println(s);;
			Test(s);
		}
		
		//else if (HasOperator())
			
		else {
			System.out.println("u done screwed");
		}
		
		//check if there is symbol
		
	}

	
	//functions
	public boolean SimpleSentence (String s1) {
		return s1.equals("p") || s1.equals("q");
	}
	
	public boolean BeginsWithNot (String s2) {
		return s2.substring(0, 1).equals("~");
		
	} 
	
	public String RemoveNot(String s3) {
		return s3.substring(1);
	}
	
	public boolean HasOperator(String s4) {
		boolean opexists = false;
		while (opexists == false) {
			
		}

	}
}
	
