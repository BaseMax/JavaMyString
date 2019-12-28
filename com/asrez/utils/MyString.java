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
class MyString {
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

	public int indexOf(int ch, int fromIndex) {
		if(fromIndex < 0)
			fromIndex = 0;
		else if(fromIndex >= length)
			return -1;

		for(int i = fromIndex; i < length; i++)
			if(array[i] == ch)
				return i;
		return -1;
	}

	public int indexOf(int ch) {
		return indexOf(ch, 0);
	}

	public boolean contains(String value) {
		return contains(new MyString(value));
	}

	public boolean contains(char[] value) {
		return contains(new MyString(value));
	}

	public boolean contains(MyString value) {
		if(indexOf(value) != -1) {
			return true;
		}
		return false;
	}

	public int indexOf(MyString str) {
		return indexOf(str, 0);
	}

	public int indexOf(char[] str, int fromIndex) {
		return indexOf(new MyString(str), fromIndex);
	}

	public int indexOf(MyString str, int fromIndex) {
		if(fromIndex < 0)
			fromIndex = 0;
		else if(fromIndex >= length)
			return -1;

		for(int i = fromIndex; i < length; i++) {
			if(array[i] == str.charAt(0)) {
				if(str.length() == 1)
					return i;
				int offset = 1; 
				while(offset < str.length()
					  &&
					 ((i + offset) < length)
					  &&
					 ((str.charAt(offset)) ==(array[i + offset])))
				{
					if(offset == str.length() - 1)
						return i;
					offset++;
				}
			}
		}
		return -1;
	}

	public int indexOf(String str) {
		return indexOf(str, 0);
	}

	public int indexOf(String str, int fromIndex) {
		if(fromIndex < 0)
			fromIndex = 0;
		else if(fromIndex >= length)
			return -1;

		for(int i = fromIndex; i < length; i++)
		{
			if(array[i] == str.charAt(0)) {
				if(str.length() == 1)
					return i;
				int offset = 1; 
				while(offset < str.length()
					  &&
					 ((i + offset) < length)
					  &&
					 ((str.charAt(offset)) ==(array[i + offset])))
				{
					if(offset == str.length() - 1)
						return i;
					offset++;
				}
			}
		}
		return -1;
	}

	public int lastIndexOf(int ch) {
		return lastIndexOf(ch, length - 1);
	}

	public int lastIndexOf(int ch, int fromIndex) {
		
		if(fromIndex >= length)
			fromIndex = length -1;
		
		for(int i = fromIndex; i >= 0; i--)
			if(array[i] == ch)
				return i;
		return -1;
	}

	public int lastIndexOf(String str) {
		return lastIndexOf(str, length - 1);
	}

	public int lastIndexOf(String str, int fromIndex) {
		if(fromIndex >= length)
			fromIndex = length -1;

		for(int i = fromIndex ; i >= 0; i--)
		{
			if(array[i] == str.charAt(0)) {
				if(str.length() == 1)
					return i;
				int offset = 1; 
				while(offset < str.length()
					  &&
					 ((i + offset) < length)
					  &&
					 ((str.charAt(offset)) ==(array[i + offset]))) {
					if(offset == str.length() - 1)
						return i;
					offset++;
				}
			}
		}
		return -1;
	}

	public boolean equalsIgnoreCase(MyString other) {
		if(this.length != other.length)
			return false;
			
		int i = 0;
		char thisTemp,otherTemp;
		 
		while(i < this.length) {
			if(this.array[i] >= 'A' && this.array[i] <= 'Z')
				thisTemp =(char)(this.array[i] - 'A' + 'a');
			else
				thisTemp = this.array[i];
				
			if(other.array[i] >= 'A' && other.array[i] <= 'Z')
				otherTemp =(char)(other.array[i] - 'A' + 'a');
			else
				otherTemp = other.array[i];
		
			if(thisTemp != otherTemp)
				return false;
				
			i++;
		}
		
		return true;		
	}

	public boolean equalsIgnoreCase(String other) {
		if(this.length != other.length())
			return false;
			
		int i = 0;
		char thisTemp,otherTemp;
		 
		while(i < this.length) {
			if(this.array[i] >= 'A' && this.array[i] <= 'Z')
				thisTemp =(char)(this.array[i] - 'A' + 'a');
			else
				thisTemp = this.array[i];
				
			if(other.charAt(i) >= 'A' && other.charAt(i) <= 'Z')
				otherTemp =(char)(other.charAt(i) - 'A' + 'a');
			else
				otherTemp = other.charAt(i);
		
				
			if(thisTemp != otherTemp)
				return false;
				
			i++;
		}
		
		return true;		
	}

	public MyString toLowerCase() {
		MyString temp = new MyString(); 
		temp.length = this.length;
		temp.array = new char [this.length];
		
		for(int i = 0; i < this.length; i++)
		{
			if((this.array[i] >= 'A') &&(this.array[i] <= 'Z'))
				temp.array[i] =(char)(this.array[i] + 32);
			else
				temp.array[i] = this.array[i];
		}
		return temp;
	}

	public MyString toLowerCaseAndUpdate() {
		MyString temp = toLowerCase();
		this.length=temp.length;
		this.array=temp.array;
		return this;
	}

	public MyString toUpperCase() {
		MyString temp = new MyString(); 
		temp.length = this.length;
		temp.array = new char [this.length];
		
		for(int i = 0; i < this.length; i++)
		{
			if((this.array[i] >= 'a') &&(this.array[i] <= 'z'))
				temp.array[i] =(char)(this.array[i] - 32);
			else
				temp.array[i] = this.array[i];
		}
		return temp;
	}

	public MyString toUpperCaseAndUpdate() {
		MyString temp = toUpperCase();
		this.length=temp.length;
		this.array=temp.array;
		return this;
	}

	public int compareTo(MyString value) {
		if(this.length != value.length)
			return this.length - value.length;

		for(int i = 0; i < length; i++)
			if(this.array[i] != value.array[i])
				return this.array[i] - value.array[i];
		
		return 0;
	}

	public int compareToIgnoreCase(MyString value) {
		return this.toLowerCase().compareTo(value.toLowerCase());
	}

	public MyString trim() {
		int frontSpaces = 0;
		int backSpaces = 0;
		int i = 0;// from first
		while((i < length) &&(array[i++] == ' ')) 
			frontSpaces++;
		i = length - 1;// from last
		while((i >= frontSpaces) &&(array[i--] == ' '))  
			backSpaces++;
		MyString result = new MyString();
		if((frontSpaces + backSpaces) <= length) {
			result.length = this.length - frontSpaces - backSpaces;
			result.array = new char [result.length];
			for(i = 0; i < result.length; i++)
				result.array[i] = this.array[i + frontSpaces];
		}
		return result;
	}

	public MyString trimAndUpdate() {
		MyString temp = trim();
		this.length=temp.length;
		this.array=temp.array;
		return this;
	}

	public static MyString valueOf(boolean b) {
		if(b) 
			return new MyString("true");
		else
			return new MyString("false");
	}

	public static String valueOf(Object obj) {
		if(obj == null)
			return "null";
		return obj.toString();
	}

	public String toString() {
		return new String(array);
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

	public static void printf(char[] format, Object... arguments) {
		MyString mystr=new MyString(format);
		printf(mystr, arguments);
	}

	public static void printf(String format, Object... arguments) {
		char[] formats=format.toCharArray();
		MyString mystr=new MyString(formats);
		printf(mystr, arguments);
	}

	public static void printf(MyString format, Object... arguments) {
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
							}catch (ArrayIndexOutOfBoundsException exception) {
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
							}catch (ArrayIndexOutOfBoundsException exception) {
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
							}catch (ArrayIndexOutOfBoundsException exception) {
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
							}catch (ArrayIndexOutOfBoundsException exception) {
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
							}catch (ArrayIndexOutOfBoundsException exception) {
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
		// 	}else {
		// 		System.out.format("%c", array[i]);
		// 	}
		// }
		// System.out.println("");
	}

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

	public boolean startsWith(MyString prefix) {
		return startsWith(prefix, 0);
	}

	public boolean startsWith(String prefix) {
		return startsWith(new MyString(prefix), 0);
	}

	public boolean startsWith(String prefix, int offset) {
		return startsWith(new MyString(prefix), offset);
	}

	public boolean startsWith(MyString prefix, int offset) {
		int to = offset;
		char pa[] = prefix.toCharArray();
		int po = 0;
		int pc = prefix.length();
		if((offset < 0) || (offset > length() - pc)) {
			return false;
		}
		while(--pc >= 0) {
			if (array[to++] != pa[po++]) {
				return false;
			}
		}
		return true;
	}

	// public boolean endsWith(String suffix, index offset) {
	public boolean endsWith(String suffix) {
		int start = length() - suffix.length();
		if(start >= 0) {
			return indexOf(suffix, start) >= 0;
		}
		return false;
	}

	public boolean endsWith(char[] search) {
		return endsWith(String.copyValueOf(search));
	}

	//count: second string is in the first
	public int count(char[] search) {
		return count(new MyString(search));
	}

	public int count(String search) {
		return count(search.toCharArray());
	}

	public int count(MyString search) {
		int counter=0;
		int i=-1;
		i=indexOf(search, i+1);
		while(i!=-1) {
			i=indexOf(search, i+1);
			counter++;
		}
		return counter;
	}

	public MyString replaceAndUpdate(String search, String replace) {
		return replaceAndUpdate(new MyString(search), new MyString(replace));
	}

	public MyString replaceAndUpdate(MyString search, MyString replace) {
		MyString temp=replace(search, replace);
		this.array=temp.array;
		this.length=temp.length;
		return temp;
	}

	public MyString replace(String search, String replace) {
		return replace(new MyString(search), new MyString(replace));
	}

	public MyString replace(MyString search, MyString replace) {
		return replace(search, replace, 0);
	}

	public MyString replace(String search, String replace, int limit) {
		return replace(new MyString(search), new MyString(replace), limit);
	}

	public MyString replaceFirst(MyString search, MyString replace) {
		return replace(search, replace, 1);
	}

	public MyString replaceFirst(String search, String replace) {
		return replace(new MyString(search), new MyString(replace), 1);
	}

	public MyString replace(MyString search, MyString replace, int limit) {
		// char[] searchArr = search.toCharArray();
		// char[] replaceArr = replace.toCharArray();
		// int numTimes = count(searchArr);
		// // System.out.println(numTimes);
		// char[] strResult = new char[length + Math.abs(numTimes*(replaceArr.length-searchArr.length))];
		// System.arraycopy(array, 0, strResult, 0, array.length);
		// MyString temp = new MyString(strResult);
		// temp.display();
		// return temp;

		StringBuilder sb = null;
		int start = 0;
		int did=0;
		for(int i; (i = indexOf(search, start)) != -1; ) {
			if(sb == null)
				sb = new StringBuilder();
			sb.append(new String(this.array), start, i);
			sb.append(replace);
			start = i + search.length();
			did++;
			if(did == limit) {
				break;
			}
		}
		if(sb == null)
			return this;
		sb.append(new String(this.array), start, length);
		return new MyString(sb.toString());
		// MyString temp = new MyString(sb.toString());
		// return temp;
	}

	public MyString replaceAndUpdate(char oldChar, char newChar) {
		MyString s=new MyString(replace(oldChar, newChar));
		this.array=s.array;
		this.length=s.length;
		return this;
	}

	public MyString replace(char oldChar, char newChar) {
		if(oldChar != newChar) {
			int len = length;
			int i = -1;
			while(++i < len) {
				if(array[i] == oldChar) {
					break;
				}
			}
			if(i < len) {
				char buf[] = new char[len];
				for(int j = 0; j < i; j++) {
				   buf[j] = array[j];
				}
				while(i < len) {
					char c = array[i];
					buf[i] = (c == oldChar) ? newChar : c;
					i++;
				}
				MyString s=new MyString(buf);
				return s;
			}
		}
		return this;
	}
}
