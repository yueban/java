public class TestRationalClass{
	public static void main(String[] args){
		Rational r1 = new Rational(4,2);
		Rational r2 = new Rational(2,3);

		System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
		System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		System.out.println(r2 + " is " + r2.doubleValue());
		System.out.println(r1 + " compareTo " + r2 + " : " + r1.compareTo(r2));
		System.out.println(r1 + " equals " + r2 + " ? " + r1.equals(r2));
	}
}

class Rational{
	private long numerator = 0;
	private long denominator = 1;

	public Rational(){
		this(0,1);
	}

	public Rational(long numerator,long denominator){
		long gcd = gcd(numerator,denominator);
		this.numerator = (denominator > 0 ? 1 : -1) * numerator / gcd;
		this.denominator = Math.abs(denominator) / gcd;
	}

	public static long gcd(long n,long d){
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		return gcd1(n1,n2);
	}

	public static long gcd1(long m,long n){
		if(n != 0){
			return gcd1(n,m % n);
		}
		return m;
	}

	public long getNumerator(){
		return numerator;
	}

	public long getDenominator(){
		return denominator;
	}

	public Rational add(Rational secondRational){
		long n = numerator * secondRational.getDenominator() + secondRational.getNumerator() * denominator;
		long d = denominator * secondRational.getDenominator();
		return new Rational(n,d);
	}

	public Rational subtract(Rational secondRational){
		long n = numerator * secondRational.getDenominator() - secondRational.getNumerator() * denominator;
		long d = denominator * secondRational.getDenominator();
		return new Rational(n,d);
	}

	public Rational multiply(Rational secondRational){
		long n = numerator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n,d);
	}

	public Rational divide(Rational secondRational){
		long n = numerator * secondRational.getDenominator();
		long d = denominator * secondRational.getNumerator();
		return new Rational(n,d);
	}

	public String toString(){
		return denominator == 1 ? numerator + "" : numerator + "/" + denominator;
	}

	public boolean equals(Rational secondRational){
		return this.subtract(secondRational).getNumerator() == 0 ? true : false;
	}

	public int intValue(){
		return (int)doubleValue();
	}

	public float floatValue(){
		return (float)doubleValue();
	}

	public double doubleValue(){
		return numerator * 1.0 / denominator;
	}

	public long longValue(){
		return (long)doubleValue();
	}

	public int compareTo(Rational secondRational){
		long n = this.subtract(secondRational).getNumerator();
		return n > 0 ? 1 : n == 0 ? 0 : -1;
	}
}