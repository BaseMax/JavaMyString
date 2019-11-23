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
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.Arrays;
public class MyString {
   private char[] value;
   private int count;
   private int offset;
   public MyString() {
       this.offset = 0;
       this.count = 0;
       this.value = new char[0];
   }
   public MyString(char value[]) {
       // String s = new String(a);
       this.offset = 0;
       // Note: We will use this variable two times...
       int size = value.length;
       this.count = size;
       this.value = Arrays.copyOf(value, size);
   }
   public MyString(String value) {
       // String s = new String("hi");
       this.offset = 0;
       this.count = value.length();
       this.value = value.toCharArray();
   }
   public MyString(char value[], int offset, int count) {
       // String s = new String(a, 2, 4);
       if(offset < 0) {
           throw new StringIndexOutOfBoundsException(offset);
       }
       if(count < 0) {
           throw new StringIndexOutOfBoundsException(count);
       }
       if(offset > value.length - count) {
           throw new StringIndexOutOfBoundsException(offset + count);
       }
       this.offset = 0;
       this.count = count;
       this.value = Arrays.copyOfRange(value, offset, offset+count);
   }
//    public MyString(int offset, int count, char value[]) {
//        this.offset = offset;
//        this.count = count;
//        this.value = value;
//    }
   public int getLength() {
       return this.count;
   }
   public char[] getValue() {
       if(this.offset == 0) {
           return this.value;
       }
       return Arrays.copyOfRange(this.value, this.offset, this.count);
   }
   public MyString subString(int beginIndex){
       if(beginIndex < 0) {
           throw new StringIndexOutOfBoundsException(beginIndex);
//            beginIndex=this.size - beginIndex;
           }
       char[] temp = new char[this.value.length-beginIndex];
       for(int i = beginIndex; i < this.value.length; i++){
           temp[i-beginIndex] = this.value[beginIndex];
       }
       return new MyString(temp);
   }
   public MyString subString(int beginIndex, int endIndex) {
       if(beginIndex < 0) {
           throw new StringIndexOutOfBoundsException(beginIndex);
       }
       if(endIndex > count) {
           throw new StringIndexOutOfBoundsException(endIndex);
       }
       if(beginIndex > endIndex) {
           throw new StringIndexOutOfBoundsException(endIndex - beginIndex);
       }
       if((beginIndex == 0) && (endIndex == count)) {
           return this;
       }
       return new MyString(value, this.offset + beginIndex, endIndex - beginIndex);
   }
//    public MyString subString2(int beginIndex) {
//        int endIndex=this.size;
//        if(beginIndex < 0) {
//              // beginIndex
//            throw new StringIndexOutOfBoundsException();
//        }
//        if(endIndex > count) {
//             // endIndex
//            throw new StringIndexOutOfBoundsException();
//        }
//        if(beginIndex > endIndex) {
//            // endIndex - beginIndex
//            throw new StringIndexOutOfBoundsException();
//        }
//        return ((beginIndex == 0) && (endIndex == count)) ? this :
//            new MyString(this.offset + beginIndex, endIndex - beginIndex, value);
//        }
//    }
}
