
public class scratch {
	public void Scratch() {}
	
	public int expo(int base, int exp) {
		if (exp == 0) {return 1;}
		else if (exp == 1) {return base;}
		else {
			if (exp % 2 == 0) {return expo(base*base, exp/2);}
			else {return base * expo(base*base, (exp-1)/2);}
		}
	}
	
	
}
