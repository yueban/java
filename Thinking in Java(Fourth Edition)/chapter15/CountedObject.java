public class CountedObject{
	private static int counter = 0;
	private long id = counter++;

	public long id(){
		return id;
	}

	public String toString(){
		return "CountedObject " + id;
	}
}