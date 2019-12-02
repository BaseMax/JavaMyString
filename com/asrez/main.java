package com.asrez;
import com.asrez.utils.MyString;
public class main {
    public static void main(String[] args) {
		MyString str2 = new MyString('T');
		str2.setAt(1, 'E');
		str2.setAt(2, '!');
		str2.setAt(3, 'S');
		str2.setAt(4, 'T');
		str2.myLineDisplay();

		System.out.println(""); //////////////////////////

		MyString str = new MyString(str2);
		System.out.println(str.myCharAt(0));
		str.myLineDisplay();
		System.out.println(str.myLength());

		System.out.println(""); //////////////////////////

		char[] myToArray = str.myToCharArray();
		System.out.println(myToArray);

		System.out.println(""); //////////////////////////

		str = str.myConcat(str2);
		str.myLineDisplay();
		System.out.println(str.myLength());

		System.out.println(""); //////////////////////////

		MyString substr = str.mySubString(0, 3);
		substr.myLineDisplay();

		System.out.println(""); //////////////////////////

		substr = str.mySubString(3);
		substr.myLineDisplay();

		System.out.println(""); //////////////////////////

		substr = str.mySubString(-3);
		substr.myLineDisplay();

		System.out.println(""); //////////////////////////

		substr = str.mySubString(-5, 2);
		substr.myLineDisplay();

		System.out.println(""); //////////////////////////

		substr = str.mySubString(-5, 90);
		substr.myLineDisplay();

        // MyString v=new MyString("Hello!");
        // System.out.println(v.myToCharArray());
        // System.out.println(v.myLength());
        // System.out.println(v.mySubString(-3).myToCharArray());
        // System.out.println(v.mySubString(2, 5).myToCharArray());

		// System.out.println(v.getLength());
		// System.out.println(v.getValue());
		// System.out.println(v.subString(2, 4));
		// System.out.println(v.subString(2, 4).getValue());
    }
}
