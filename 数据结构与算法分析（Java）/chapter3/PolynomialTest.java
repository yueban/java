//链表实现多项式
public class PolynomialTest{
	public static void main(String[] args){
		Polynomial p1 = new Polynomial();
		p1.insertTermpublic class PolynomialTest{
	public static void main(String[] args){
		Polynomial p1 = new Polynomial();
		p1.insertTerm(3,2);
		p1.insertTerm(12,1);
		p1.insertTerm(5,8);
		Polynomial p2 = new Polynomial();
		p2.insertTerm(7,5);
		p2.insertTerm(90,12);
		p2.insertTerm(12,3);
		p2.insertTerm(4,7);
		p1 = p1.add(p2);
		p1.print();
		p2 = p2.add(p2);
		p2.print();
	}
}

class Polynomial{
	public Polynomial(){
		zeroPolynomial();
	}

	public void insertTerm(int coef,int exp){
		coeffArray[exp] += coef;
		highPower = Math.max(highPower,exp);
	}

	public void zeroPolynomial(){
		for(int i = 0;i <= MAX_DEGREE;i++){
			coeffArray[i] = 0;
		}
		highPower = 0;
	}

	public Polynomial add(Polynomial rhs){
		Polynomial sum = new Polynomial();
		sum.highPower = Math.max(highPower,rhs.highPower);
		for(int i = sum.highPower;i >= 0;i--){
			sum.coeffArray[i] = coeffArray[i] + rhs.coeffArray[i];
		}
		return sum;
	}

	public Polynomial multiply(Polynomial rhs) throws Exception{
		Polynomial product = new Polynomial();
		product.highPower = highPower + rhs.highPower;
		if(product.highPower > MAX_DEGREE){
			throw new Exception();
		}
		for(int i = 0;i <= highPower;i++){
			for(int j = 0;j <= rhs.highPower;j++){
				product.coeffArray[i + j] += coeffArray[i] * rhs.coeffArray[j];
			}
		}
		return product;
	}

	public void print(){
		for(int i = highPower;i >= 0;i--){
			if(coeffArray[i] != 0){
				System.out.print(coeffArray[i] + "x" + i + " ");
			}
		}
		System.out.println();
	}

	public static final int MAX_DEGREE = 100;
	private int coeffArray[] = new int[MAX_DEGREE + 1];
	private int highPower = 0;
}(3,2);
		p1.insertTerm(12,1);
		p1.insertTerm(5,8);
		Polynomial p2 = new Polynomial();
		p2.insertTerm(7,5);
		p2.insertTerm(90,12);
		p2.insertTerm(12,3);
		p2.insertTerm(4,7);
		p1 = p1.add(p2);
		p1.print();
		p2 = p2.add(p2);
		p2.print();
	}
}

class Polynomial{
	public Polynomial(){
		zeroPolynomial();
	}

	public void insertTerm(int coef,int exp){
		coeffArray[exp] += coef;
		highPower = Math.max(highPower,exp);
	}

	public void zeroPolynomial(){
		for(int i = 0;i <= MAX_DEGREE;i++){
			coeffArray[i] = 0;
		}
		highPower = 0;
	}

	public Polynomial add(Polynomial rhs){
		Polynomial sum = new Polynomial();
		sum.highPower = Math.max(highPower,rhs.highPower);
		for(int i = sum.highPower;i >= 0;i--){
			sum.coeffArray[i] = coeffArray[i] + rhs.coeffArray[i];
		}
		return sum;
	}

	public Polynomial multiply(Polynomial rhs) throws Exception{
		Polynomial product = new Polynomial();
		product.highPower = highPower + rhs.highPower;
		if(product.highPower > MAX_DEGREE){
			throw new Exception();
		}
		for(int i = 0;i <= highPower;i++){
			for(int j = 0;j <= rhs.highPower;j++){
				product.coeffArray[i + j] += coeffArray[i] * rhs.coeffArray[j];
			}
		}
		return product;
	}

	public void print(){
		for(int i = highPower;i >= 0;i--){
			if(coeffArray[i] != 0){
				System.out.print(coeffArray[i] + "x" + i + " ");
			}
		}
		System.out.println();
	}

	public static final int MAX_DEGREE = 100;
	private int coeffArray[] = new int[MAX_DEGREE + 1];
	private int highPower = 0;
}