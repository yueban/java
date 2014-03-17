/* 24_为什么用抽象类 */
public class Test_24{
	public static void main(String args []){
		Printer p1 = new HPPrinter();
		p1.open();
		p1.print();
		p1.close();
		
		Printer p2 = new CanonPrinter();
		p1.open();
		p1.print();
		p1.close();
	}
}

abstract class Printer{
	void open(){
		System.out.println("open");
	}
	
	void close(){
		System.out.println("close");
	}
	
	/*void print(){
	
	}*/
	
	abstract void print();
}

//该打印机为喷墨打印机
class HPPrinter extends Printer{
	void print(){
		System.out.println("使用喷墨打印机进行打印");
	}
}

//该打印机为针式打印机
class CanonPrinter extends Printer{
	void print(){
		System.out.println("使用针式打印机进行打印");
	}
}