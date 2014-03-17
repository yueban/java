/* 26_包和访问权限（二） */
package com.bigfat;

/* test_04*/
//import com.flying.Person;
import com.flying.*;

public class Test_26{
	public static void main(String args []){
		/* test_01
		com.flying.Person p = new com.flying.Person();
		p.name = "yuranzi";
		*/
		
		/* test_02 test_03_01 test_04*/
		Person p = new Person();
		p.name = "yuranzi";
		p.introduce();
		
		/* test_03_02
		com.flying.Person p = new com.flying.Person();
		p.name = "yuranzi";
		p.introduce();
		*/
	}
}