package question67;

/**
 * 把字符串转换成整数
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 
 * 解题思路：
 * 常规遍历即可，超出int范围返回0
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class StrToInt {
	
    public int StrToInt(String str) {
    	/**
    	 * 判断边界条件
    	 */
    	 if(str == null || str.length() <= 0) {
    		 return 0;
    	 }
    	 /**
    	  * 用long类型记录结果，放置溢出
    	  */
    	 long result = 0;
    	 /**
    	  * 记录是否为负数
    	  */
    	 boolean isNegative = (str.charAt(0)=='-');
    	 
    	 /**
    	  * 遍历字符串
    	  */
    	 for (int i = 0; i < str.length(); i++) {
    		char c = str.charAt(i);
    		/**
    		 * 如果是首字符且为符号位，则跳过
    		 */
			if(i == 0 && (c == '-' || c == '+') ) {
				continue;
			}
			/**
			 * 如果非首字符且非数字，非法输入，返回0
			 */
			if(c > '9' || c < '0') {
				return 0;
			}
			/**
			 * 记录结果
			 */
			result = result*10 + (c-'0');
			/**
			 * 判断是否越界，越阶返回0
			 */
			if( (isNegative && result > (long)Integer.MAX_VALUE+1) || (!isNegative && result > Integer.MAX_VALUE) ) {
				return 0;
			}
		}
    	 /**
    	  * 如果是负数就加上符号
    	  */
    	 return isNegative ? (int)-result : (int)result;
    }

}
