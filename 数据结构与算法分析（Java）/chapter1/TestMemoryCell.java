public class TestMemoryCell{
	public static void main(String[] args){
		MemoryCell m = new MemoryCell();
		
		m.write(new Integer(3));
		System.out.println("Contents are:" + ((Integer)m.read()).intValue());
	}
}

class MemoryCell{
	public Object read(){
		return storedValue;
	}
	
	public void write(Object x){
		storedValue = x;
	}
	
	private Object storedValue;
}