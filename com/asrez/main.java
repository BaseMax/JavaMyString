package com.asrez;
import com.asrez.utils.MyString;
public class main {
	public static void main(String[] args) {
		System.out.println("Stage1"); //////////////////////////

		MyString input1 = new MyString('T');
		input1.setAt(1, 'E');
		input1.setAt(2, '!');
		input1.setAt(3, 'S');
		input1.setAt(4, 'T');
		input1.display();

		System.out.println("Stage2"); //////////////////////////

		MyString input2 = new MyString(input1);
		System.out.println(input2.charAt(0));
		input2.display();
		System.out.println(input2.length());

		System.out.println("Stage3"); //////////////////////////

		char[] array = input2.toCharArray();
		System.out.println(array);

		System.out.println("Stage4"); //////////////////////////

		input2 = input2.concat(input1);
		input2.display();
		System.out.println(input2.length());

		System.out.println("Stage5"); //////////////////////////

		MyString input3 = input2.subString(0, 3);
		input3.display();

		System.out.println("Stage6"); //////////////////////////

		input3 = input2.subString(3);
		input3.display();

		System.out.println("Stage7"); //////////////////////////

		input3 = input2.subString(-3);
		input3.display();

		System.out.println("Stage8"); //////////////////////////

		input3 = input2.subString(-5, 2);
		input3.display();

		System.out.println("Stage9"); //////////////////////////

		input3 = input2.subString(-5, 90);
		input3.display();
	}
}
