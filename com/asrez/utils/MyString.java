package com.asrez.utils;
/**
 *
 * @Name : JavaMyString
 * @File : com/asrez/utils/MyString.java
 * @Version : 1.0
 * @Programmer : Max
 * @Date : 2019-12-01
 * @Released under : https://github.com/BaseMax/JavaMyString/blob/master/LICENSE
 * @Repository : https://github.com/BaseMax/JavaMyString
 * @Reference : https://courses.cs.washington.edu/courses/cse341/98au/java/jdk1.2beta4/docs/api/java/lang/String.html
 *
 **/
public class MyString {
	private final int DEFAULT_ARRAY_SIZE = 10;
	private char[] characters;
	private int length;

	public MyString() {
		length = DEFAULT_ARRAY_SIZE;
		characters = new char[length];
	}

	public MyString(char ch) {
		length = DEFAULT_ARRAY_SIZE;
		characters = new char[length];
		characters[0] = ch;
	}

	public MyString(char ch[]) {
		length = ch.length;
		characters = new char[length];
		for(int i = 0; i < length; i++)
			characters[i] = ch[i];
	}

	public MyString(MyString otherMyString) {
		length = otherMyString.myLength();
		characters = new char[length];
		for(int i = 0; i < length; i++)
			characters[i] = otherMyString.myCharAt(i);
	}

	public MyString(String otherMyString) {
		length = otherMyString.length();
		characters = new char[length];
		for(int i = 0; i < length; i++)
			characters[i] = otherMyString.charAt(i);
	}

	public boolean equals(Object o) {
		MyString other;
		if(!(o instanceof MyString))
			return false;
		else
			other = (MyString) o;

		if(this.length != other.length)
			return false;

		int i = 0;
		while(i < this.length) {
			if(this.characters[i] != other.characters[i])
				return false;
			// same
			i++;
		}
		return true;
	}

	public char charAt(int index) {
		if((index < 0) || (index >= characters.length))
			throw new StringIndexOutOfBoundsException(index);
		return characters[index];
	}

	public MyString concat(MyString otherMyString) {
		int length = this.characters.length + otherMyString.characters.length;

		char[] temp = new char[length];

		for(int i = 0; i < this.characters.length; i++)
			temp[i] = this.characters[i];

		for(int i = 0; i < otherMyString.characters.length; i++)
			temp[this.characters.length + i] = otherMyString.characters[i];

		return new MyString(temp);
	}

	public void lineDisplay() {
		System.out.println(characters);
		// for(int i = 0; i < this.characters.length; i++) {
		//	if(characters[i] == '\n') {
		//		break;
		//	} else {
		//		System.out.format("%c", characters[i]);
		//	}
		// }
		// System.out.println("");
	}

	public int indexOf(char ch) {
		int fromIndex = 0;
		if(fromIndex < 0)
			fromIndex = 0;
		else if(fromIndex >= length)
			return -1;

		for(int i = fromIndex; i < length; i++)
			if(characters[i] == ch)
				return i;
		return -1;
	}

	/**
	 * Returns the length of string
	 * @return
	 */
	public int length() {
		return length;
	}

	public void setAt(int index, char ch) {
		if(index < 0)
			throw new StringIndexOutOfBoundsException(index);
		if(index > length)
			throw new StringIndexOutOfBoundsException(index);
		characters[index] = ch;
	}

	public MyString subString(int low, int high) {
		if(low < 0) {
			// System.out.println(length);
			// System.out.println(low);
			low = length + low;
			// System.out.println(low);
			high+=low;
			// System.out.println(high);
			if(high > length -1) {
				high=length-1;
				// System.out.println(high);
			}
		}
		if(low < 0)
			throw new StringIndexOutOfBoundsException(low);
		if(high > length)
			throw new StringIndexOutOfBoundsException(high);
		if(low > high)
			throw new StringIndexOutOfBoundsException(high - low);

		MyString result = new MyString();
		result.length = high - low + 1;
		result.characters = new char[result.length];

		for(int i = 0; i < result.length; i++)
			result.characters[i] = this.characters[low + i];

		return result;
	}

	public MyString subString(int low) {
		if(low < 0)
			low = length + low;
		int high = length-1;
		if(low < 0)
			throw new StringIndexOutOfBoundsException(low);
		if(low > high)
			throw new StringIndexOutOfBoundsException(high - low);
		MyString result = new MyString();
		result.length = high - low + 1;
		result.characters = new char[result.length];
		for(int i = 0; i < result.length; i++)
			result.characters[i] = this.characters[low + i];

		return result;
	}

	public char[] toCharArray() {
		return characters;
	}
}
