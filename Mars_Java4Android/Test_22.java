/* 22_面向对象应用（一） */
public class Test_22{
	public static void main(String args []){
		/* test_01
		Printer p = new Printer();
		p.open();
		p.print("abc");
		p.close();
		*/
		
		/* test_02 test_03*/
		int flag = 1;
		
		if(flag == 0){
			HPPrinter hpPrinter = new HPPrinter();
			hpPrinter.open();
			hpPrinter.print("HP");
			hpPrinter.close();
		}else if(flag == 1){
			CanonPrinter canonPrinter = new CanonPrinter();
			canonPrinter.open();
			canonPrinter.print("Canon");
			canonPrinter.close();
		}
	}
}

/* test_01
class Printer{
	void open(){
		System.out.println("Open");
	}
	
	void close(){
		System.out.println("Close");
	}
	
	void print(String s){
		System.out.println("print-->" + s);
	}
}
*/

/* test_02
class HPPrinter{
	void open(){
		System.out.println("Open");
	}
	
	void close(){
		System.out.println("Close");
	}
	
	void print(String s){
		System.out.println("print-->" + s);
	}
}

class CanonPrinter{
	void open(){
		System.out.println("Open");
	}
	
	void close(){
		this.clean();
		System.out.println("Close");
	}
	
	void print(String s){
		System.out.println("print-->" + s);
	}
	
	void clean(){
		System.out.println("Clean");
	}
}
*/

/* test_03*/
class Printer{
	void open(){
		System.out.println("Open");
	}
	
	void close(){
		System.out.println("Close");
	}
	
	void print(String s){
		System.out.println("print-->" + s);
	}
}

class HPPrinter extends Printer{
	
}

class CanonPrinter extends Printer{
	void close(){
		this.clean();
		super.close();
	}
	
	void clean(){
		System.out.println("Clean");
	}
}