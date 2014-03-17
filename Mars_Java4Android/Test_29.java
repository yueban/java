/* 29_接口的应用 */
public class Test_29{
	public static void main(String args []){
		/* test_01
		//根据用户选择，生成相应的打印机对象
		//并且向上转型为Printer类型
		//Printer getPrinter(int flag){}
		Printer printer = null;
		int flag = 0;
		if(flag == 0){
			printer = new HPPrinter();
		}else if(flag == 1){
			printer = new CanonPrinter();
		}
		*/
		
		/* test_02*/
		int flag = 1;
		Printer printer = PrinterFactory.getPrinter(flag);
		printer.open();
		printer.print("test");
		printer.close();
	}
}

class PrinterFactory{
	public static Printer getPrinter(int flag){
		Printer printer = null;
		if(flag == 0){
			printer = new HPPrinter();
		}else if(flag == 1){
			printer = new CanonPrinter();
		}else if(flag == 2){
			printer = new XXXPrinter();
		}
		return printer;
	}
}

interface Printer{
	public void open();
	
	public void close();
	
	public void print(String s);
}

class HPPrinter implements Printer{
	public void open(){
		System.out.println("HP open");
	}
	
	public void close(){
		System.out.println("HP close");
	}
	
	public void print(String s){
		System.out.println("HP print--->" + s);
	}
}

class CanonPrinter implements Printer{
	public void open(){
		System.out.println("Canon open");
	}
	
	public void close(){
		this.clean();
		System.out.println("Canon close");
	}
	
	public void print(String s){
		System.out.println("Canon print--->" + s);
	}
	
	private void clean(){
		System.out.println("Clean");
	}
}

class XXXPrinter implements Printer{
	public void open(){
		System.out.println("XXX open");
	}
	
	public void close(){
		System.out.println("XXX close");
	}
	
	public void print(String s){
		System.out.println("XXX print--->" + s);
	}
}