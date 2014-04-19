public class TestArrayList{
	public static void main(String[] args){
		java.util.ArrayList cityList = new java.util.ArrayList();
		cityList.add("北京");
		cityList.add("上海");
		cityList.add("广州");
		cityList.add("深圳");
		cityList.add("南京");
		cityList.add("南昌");
		System.out.println(cityList.toString());

		System.out.println("List size:" + cityList.size());
		System.out.println("Is 南昌 in the list?" + cityList.contains("南昌"));
		System.out.println("The Location of 北京 in the list:" + cityList.indexOf("北京"));
		System.out.println("Is the list empty?" + cityList.isEmpty());
		
		cityList.add(2,"九江");
		System.out.println(cityList.toString());

		cityList.remove(1);
		System.out.println(cityList.toString());

		cityList.remove("南昌");
		System.out.println(cityList.toString());

		cityList.add(new Person("濮志远"));
		cityList.add(new Person("余然孜"));
		System.out.println(cityList.toString());

		System.out.println(((Person)cityList.get(cityList.size() - 1)).getName());

		cityList.clear();
		System.out.println(cityList);
	}
}

class Person{
	public Person(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	private String name;
}