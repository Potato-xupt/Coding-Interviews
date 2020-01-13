package question20;

/**
 * 表示数值的字符串
 * 
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 
 * 解题思路：
 * 将数字的形式总结为：(A.B E/e A) ,按顺序进行判断（A代表带符号整数，B代表不带符号整数）。
 * 
 * or正则表达式解法：return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
 * 
 * @author Potato
 *
 */
public class IsNumeric {

	public boolean isNumeric(char[] str) {
		/**
		 * 边界条件
		 */
		if(str ==null || str.length == 0) {
			return false;
		}
		/**
		 * 这里用一个长度为一的数组作为下标的标志，因为如果用int的话，传入其他方法中的就是值，而数组传入的是引用，所以可改变
		 */
		int [] index = new int [1];
		index[0] = 0;
		
		/**
		 * 先判断小数点之前的部分是否非整数
		 */
		boolean isNumeric;
		isNumeric = isInteger(str,index);
		
		/**
		 * 如果有小数点，则判断小数点之后的部分
		 */
		if(index[0] < str.length && str[index[0]] == '.') {
			index[0]++;
			isNumeric = isUnsignedInteger(str, index) || isNumeric;
		}
		
		/**
		 * 如果有指数，则判断指数标志E|| e 之后的部分
		 */
		if(index[0] <str.length && (str[index[0]] == 'e' || str[index[0]] == 'E') ) {
			index[0]++;
			isNumeric = isInteger(str, index) && isNumeric;
		}
		
		/**
		 * 条件是否成立以及是否走完全长
		 */
		if(isNumeric && index[0] == str.length) {
			return true;
		}
		return false;
	}

	private boolean isInteger(char[] str, int[] index) {
		/**
		 * 跳过正负号，判断无符号整数
		 */
		if(index[0]<str.length && (str[index[0]] == '+' || str[index[0]] == '-') ) {
			index[0]++;
		}
		return isUnsignedInteger(str, index);
	}

	private boolean isUnsignedInteger(char[] str, int[] index) {
		/**
		 * 判断是否存在整数的部分
		 */
		int start = index[0];
		while(index[0] < str.length && (str[index[0]] >= '0' && str[index[0]] <= '9') ) {
			index[0]++;
		}
		if(index[0] > start) {
			return true;
		}
		return false;
	}
}
