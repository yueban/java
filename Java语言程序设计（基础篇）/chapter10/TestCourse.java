public class TestCourse{
	public static void main(String[] args){
		Course course1 = new Course("dota");
		course1.addStudent("�־Զ");
		course1.addStudent("������");
		course1.addStudent("������");
		course1.displayStudents();
		System.out.println();
		course1.dropStudent("������");
		course1.displayStudents();
	}
}

class Course{
	public Course(String courseName){
		this.courseName = courseName;
		students = new String[100];
		numberOfStudents = 0;
	}

	public void addStudent(String student){
		students[numberOfStudents] = student;
		numberOfStudents++;
	}

	public void dropStudent(String student){
		if(findStudentIndex(student) == -1){
			System.out.println("No such student");
			return;
		}
		for(int i = findStudentIndex(student);i < numberOfStudents - 1;i++){
			students[i] = students[i + 1];
		}
		students[numberOfStudents - 1] = null;
		numberOfStudents--;
	}

	public int getNumberOfStudents(){
		return numberOfStudents;
	}

	public String getCourseName(){
		return courseName;
	}

	public void displayStudents(){
		System.out.println("ѡ����" + courseName + "�γ̵�ѧ���У�");
		for(String s : students){
			if(s == null){
				break;
			}
			System.out.println(s);
		}
	}

	private String courseName;
	private String[] students;
	private int numberOfStudents;

	private int findStudentIndex(String student){
		for(int i = 0;i < numberOfStudents;i++){
			if(students[i].equals(student)){
				return i;
			}
		}
		return -1;
	}
}