public class TestArrayList{
	public static void main(String[] args){
		java.util.ArrayList cityList = new java.util.ArrayList();
		cityList.add("����");
		cityList.add("�Ϻ�");
		cityList.add("����");
		cityList.add("����");
		cityList.add("�Ͼ�");
		cityList.add("�ϲ�");
		System.out.println(cityList.toString());

		System.out.println("List size:" + cityList.size());
		System.out.println("Is �ϲ� in the list?" + cityList.contains("�ϲ�"));
		System.out.println("The Location of ���� in the list:" + cityList.indexOf("����"));
		System.out.println("Is the list empty?" + cityList.isEmpty());
		
		cityList.add(2,"�Ž�");
		System.out.println(cityList.toString());

		cityList.remove(1);
		System.out.println(cityList.toString());

		cityList.remove("�ϲ�");
		System.out.println(cityList.toString());

		cityList.add(new Person("�־Զ"));
		cityList.add(new Person("��Ȼ��"));
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