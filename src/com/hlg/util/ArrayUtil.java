package com.hlg.util;

public class ArrayUtil {
	// 静态方法
	public static String array2String(Object[] array, String split) {
		// array={1,2,3};
		// split=",";
		// ===> 结果：1,2,3
		if (array.length == 0) {
			return "";
		}
		// StringBuffer类也用来代表字符串，StringBuffer在进行字符串处理时，不生成新的对象，在内存使用上要优于String类。
		// 所以在实际使用时，如果经常需要对一个字符串进行修改，例如插入、删除等操作，使用StringBuffer要更加适合一些
		StringBuffer buffer = new StringBuffer();

		buffer.append(array[0]);// append方法用来累积字符串的,
		// buffer.append(split);
		for (int i = 1; i < array.length; i++) {
			buffer.append(split);
			buffer.append(array[i]);
		}
		return new String(buffer);
	}
}
