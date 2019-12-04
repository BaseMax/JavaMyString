# JavaMyString

A tiny implementation of **String** class in java as final project.

# Java MyString

## Features

- Tiny code (Suitable to learn from it)
- Own class
- Suitable performance
- Support `printf` with variable arguments (Varargs)

## Structure

```java
public MyString();
public MyString(char c);
public MyString(char c[]);
public MyString(MyString value);
public MyString(String value);
public int indexOf(int ch, int fromIndex);
public int indexOf(int ch);
public int indexOf(MyString str);
public int indexOf(MyString str, int fromIndex);
public int indexOf(String str);
public int indexOf(String str, int fromIndex);
public int lastIndexOf(int ch);
public int lastIndexOf(int ch, int fromIndex);
public int lastIndexOf(String str);
public int lastIndexOf(String str, int fromIndex);
public boolean equalsIgnoreCase(MyString other);
public boolean equalsIgnoreCase(String other);
public MyString toLowerCase();
public MyString toUpperCase();
public int compareTo(MyString value);
public int compareToIgnoreCase(MyString value);
public MyString trim();
public static MyString valueOf(boolean b);
public static String valueOf(Object obj);
public String toString();
public boolean equals(Object o);
public static void printf(char[] format, Object... arguments);
public static void printf(String format, Object... arguments);
public static void printf(MyString format, Object... arguments);
public char charAt(int index);
public MyString concat(MyString value);
public void display();
public int indexOf(char ch);
public int length();
public void setAt(int index, char c);
public MyString subString(int low, int high);
public MyString subString(int low);
public char[] toCharArray();
```

## Build

```bash
$ javac com/asrez/main.java
$ java com.asrez.main
```

---------

# Max Base

My nickname is Max, Programming language developer, Full-stack programmer. I love computer scientists, researchers, and compilers.

## Asrez Team

A team includes some programmer, developer, designer, researcher(s) especially Max Base.

[Asrez Team](https://www.asrez.com/)
