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
	private char[] array;
	private int length;

	public MyString() {
		length = DEFAULT_ARRAY_SIZE;
		array = new char[length];
	}

	public MyString(char c) {
		length = DEFAULT_ARRAY_SIZE;
		array = new char[length];
		array[0] = c;
	}

	public MyString(char c[]) {
		length = c.length;
		array = new char[length];
		for(int i = 0; i < length; i++)
			array[i] = c[i];
	}

	public MyString(MyString value) {
		length = value.length();
		array = new char[length];
		for(int i = 0; i < length; i++)
			array[i] = value.charAt(i);
	}

	public MyString(String value) {
		length = value.length();
		array = new char[length];
		for(int i = 0; i < length; i++)
			array[i] = value.charAt(i);
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
			if(this.array[i] != other.array[i])
				return false;
			// same
			i++;
		}
		return true;
	}

	static public void printf(char[] format, Object... arguments) {
		MyString mystr=new MyString(format);
		printf(mystr, arguments);
	}

	static public void printf(String format, Object... arguments) {
		char[] formats=format.toCharArray();
		MyString mystr=new MyString(formats);
		printf(mystr, arguments);
	}

	static public void printf(MyString format, Object... arguments) {
		int argumentIndex=0;
		for(int i = 0; i < format.array.length; i++) {
			if(format.array[i] == '%') {
				if(format.array.length > i+1 && format.array[i+1] == '%') {
					System.out.print(format.array[i]);
					i++;
				}
				else {
					i++;
					switch(format.array[i]) {
						case 'd': {
							if(arguments.length <= argumentIndex)
								throw new StringIndexOutOfBoundsException(argumentIndex);
							try {
								System.out.print((Integer) arguments[argumentIndex]);
							} catch (ArrayIndexOutOfBoundsException exception) {
								throw new StringIndexOutOfBoundsException(argumentIndex);
							}
							argumentIndex++;
						}
						break;
						case 'f': {
							if(arguments.length <= argumentIndex)
								throw new StringIndexOutOfBoundsException(argumentIndex);
							try {
								System.out.print((Double) arguments[argumentIndex]);
							} catch (ArrayIndexOutOfBoundsException exception) {
								throw new StringIndexOutOfBoundsException(argumentIndex);
							}
							argumentIndex++;
						}
						break;
						case 'l': {
							if(arguments.length <= argumentIndex)
								throw new StringIndexOutOfBoundsException(argumentIndex);
							try {
								System.out.print((Long) arguments[argumentIndex]);
							} catch (ArrayIndexOutOfBoundsException exception) {
								throw new StringIndexOutOfBoundsException(argumentIndex);
							}
							argumentIndex++;
						}
						break;
						case 'c': {
							if(arguments.length <= argumentIndex)
								throw new StringIndexOutOfBoundsException(argumentIndex);
							try {
								System.out.print((char) arguments[argumentIndex]);
							} catch (ArrayIndexOutOfBoundsException exception) {
								throw new StringIndexOutOfBoundsException(argumentIndex);
							}
							argumentIndex++;
						}
						break;
						case 's': {
							if(arguments.length <= argumentIndex)
								throw new StringIndexOutOfBoundsException(argumentIndex);
							try {
								System.out.print((String) arguments[argumentIndex]);
							} catch (ArrayIndexOutOfBoundsException exception) {
								throw new StringIndexOutOfBoundsException(argumentIndex);
							}
							argumentIndex++;
						}
						break;
					}
				}
			}
			else {
				System.out.print(format.array[i]);
			}
		}
	}

	public char charAt(int index) {
		if((index < 0) || (index >= array.length))
			throw new StringIndexOutOfBoundsException(index);
		return array[index];
	}

	public MyString concat(MyString value) {
		int length = this.array.length + value.array.length;

		char[] temp = new char[length];

		for(int i = 0; i < this.array.length; i++)
			temp[i] = this.array[i];

		for(int i = 0; i < value.array.length; i++)
			temp[this.array.length + i] = value.array[i];

		return new MyString(temp);
	}

	public void display() {

		System.out.println(array);
		// for(int i = 0; i < this.array.length; i++) {
		// 	if(array[i] == '\n') {
		// 		break;
		// 	} else {
		// 		System.out.format("%c", array[i]);
		// 	}
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
			if(array[i] == ch)
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

	public void setAt(int index, char c) {
		if(index < 0)
			throw new StringIndexOutOfBoundsException(index);
		if(index > length)
			throw new StringIndexOutOfBoundsException(index);
		array[index] = c;
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
		result.array = new char[result.length];

		for(int i = 0; i < result.length; i++)
			result.array[i] = this.array[low + i];

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
		result.array = new char[result.length];
		for(int i = 0; i < result.length; i++)
			result.array[i] = this.array[low + i];

		return result;
	}

	public char[] toCharArray() {
		return array;
	}
}
