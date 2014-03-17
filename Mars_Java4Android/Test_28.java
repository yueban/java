/* 28_接口的基本语法 */
public class Test_28{
	public static void main(String args []){
		Phone phone = new Phone();
		
		USB usb = phone;
		usb.read();
		usb.write();
		
		WIFI wifi = phone;
		wifi.open();
		wifi.close();
	}
}

/* test_01*/
interface USB{
	public void read();
	
	public void write();
}

interface WIFI{
	public void open();
	
	public void close();
}

class Phone implements USB,WIFI{
	public void read(){
		System.out.println("USB read");
	}
	
	public void write(){
		System.out.println("USB write");
	}
	
	public void open(){
		System.out.println("WIFI open");
	}
	
	public void close(){
		System.out.println("WIFI close");
	}
}


/* test_02*/
interface A{
	public void funA();
}

interface B{
	public void funB();
}

interface C extends A,B{
	public void funC();
}