
public class Rational {
	int numerator;
	int denominator;
	
	public Rational() {
		numerator = 0;
		denominator = 1;
	}
	
	public Rational(int a, int b) {
		numerator = a;
		denominator = b;
	}
	
	public void negate() {
		this.numerator = -1*numerator;
	}
	
	public void invert() {
		int denomstore = denominator;
		denominator = Math.abs(numerator);
		numerator = (numerator/Math.abs(numerator))*denomstore;
	}
	
	public double toDouble() {
		return (double) numerator/denominator;
	}
	
	public Rational reduce() {
		Rational r = new Rational();
		int gcd = gcd(Math.abs(this.numerator), this.denominator);
		r.numerator = numerator/gcd;
		r.denominator = denominator/gcd;
		return r;
	}
	
	public int gcd(int a, int b) {
		if (b == 1) {return 1;}
		else if (a == 1) {return 1;}
		else if (a == 0) {return b;}
		else if (b == 0) {return a;}
		else {
			if (a>b) {return gcd(b, a%b);}
			else if (a == b) {return a;}
			else {return gcd(b%a, a);}
		}
	}
	
	public Rational add(Rational b) {
		Rational r = new Rational();
		r.denominator = (this.denominator*b.denominator);
		r.numerator = (this.numerator*b.denominator+b.numerator*this.denominator);
		return r.reduce();
	}
	
	public void printRational() {
		System.out.println(this.numerator + "/" + this.denominator);
	}
	
	/*
	public static void main(String[] args) {
		Rational r = new Rational(6,99);
		r.printRational();
		r.negate();
		r.printRational();
		r.invert();
		r.printRational();
		r.toDouble();
		Rational n = r.reduce();
		n.printRational();
		(r.add(n)).printRational();
	}
	*/
}
