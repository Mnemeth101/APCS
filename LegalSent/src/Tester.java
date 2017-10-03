public class Tester {

	public Boolean legal (String s) {
		//Checks to make sure the tested string isn't empty.
		if (s.length() == 0) {
			return false;
		}
		
		//Checks if the string is a simple sentence (p or q in this case).
		else if (SimpleSentence(s)) {
			return true;
		}
		
		//Checks if the string begins with ~.
		else if (BeginsWithNot(s)) {
			s = RemoveNot(s);
			return legal(s);
		}
		//Checks if an operator is in the string, and then runs Test() 
		//on the substrings before and after the operator.
		else if (HasOperator(s)) {
			Boolean opclear = false;
			for (int i = 0; i < s.length(); i++) {
				if (s.substring(i,i+1).equals("&")) {
					opclear = (legal(s.substring(0, i)) && legal(s.substring(i+1)));
					break;
				}
				if (s.substring(i,i+1).equals("|")) {
					opclear = (legal(s.substring(0, i)) && legal(s.substring(i+1)));
					break;
				}
				if (s.substring(i,i+1).equals("=")) {
					if (s.substring(i+1,i+2).equals(">")){
						opclear = (legal(s.substring(0, i)) && legal(s.substring(i+2)));
					}
					break;
				}
				if (s.substring(i,i+1).equals("<")) {
					if (s.substring(i+1,i+3).equals("=>")){
						opclear = (legal(s.substring(0, i)) && legal(s.substring(i+3)));
						System.out.println(s.substring(0, i) + s.substring(i+3));
					}
					break;
				}
			}
			return opclear;
			
		}	
		
		else {
			return false;
		}
	
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
		Boolean has = false;
		for (int i = 0; i < s4.length(); i++) {
			if (s4.substring(i,i+1).equals("&")) {
				has = true;
			}
			if (s4.substring(i,i+1).equals("|")) {
				has = true;
			}
			if (s4.substring(i,i+1).equals("=")) {
				has = true;
			}
			if (s4.substring(i,i+1).equals("<")) {
				has = true;
			}
		}
		return has;
	}
}