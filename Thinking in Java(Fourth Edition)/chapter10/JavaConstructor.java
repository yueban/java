class FatherA{
	public FatherA(){
		System.out.println("FatherA");
	}
}

class FatherB{
	public FatherB(){
		System.out.println("FatherB");
	}
}

class FatherAther{
	public FatherAther(){
		System.out.println("Father Constructor");
	}

	private static FatherA FatherA = new FatherA();
	private FatherB FatherB = new FatherB();
}

class SonA{
	public SonA(){
		System.out.println("SonA");
	}
}

class SonB{
	public SonB(){
		System.out.println("SonB");
	}
}

class Son extends FatherAther{
	public Son(){
		System.out.println("Son Constructor");
	}

	private static SonA SonA = new SonA();
	private SonB SonB = new SonB();
}

public class JavaConstructor{
	public static void main(String[] args){
		new Son();
		System.out.println("-----------");
		new Son();
	}
}