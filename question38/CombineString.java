package question38;

import java.util.ArrayList;
/**
 * 字符串组合
 * 题目：{a,b,c}要求输出{a,b,c,ab,ac,bc,abc}。
 * 解题思路：
 * 因为组合问题，比如3个元素的组合就有2^3-1种，所以不妨给他们进行编号，
 * 就像上面的问题，从a——abc一次编号为 001——111。1就代表该位置出现字符。
 * 例如：001->c,010->b,101->ac......，所以原题就是要求输出"001"-"111"这2^n-1个组合对应的字符串。
 * @author Potato
 *
 */
public class CombineString {
	
	public ArrayList<String> combineString(String s){
		ArrayList<String> result = new ArrayList<>();
		/**
		 * 判断边界条件
		 */
		if(s == null || s.length() <= 0) {
			return result;
		}
		int len = s.length();
		/**
		 * 计算出共有多少种情况
		 */
		int count = 1 << len;
		/**
		 *从001开始一直到111..
		 */
		for (int i = 1; i < count; i++) {
			String temp = "";
			/**
			 * 计算出二进制
			 */
			String str = Integer.toBinaryString(i);
			/**
			 * 把二进制前面的位数补0
			 */
			while(str.length() < len) {
				str = "0" + str;
			}
			/**
			 * 遍历计算出的二进制字符串
			 */
			for (int j = 0; j < str.length(); j++) {
				/**
				 * 遇到1就把他合称新串
				 */
				if(str.charAt(j) == '1') {
					temp += s.charAt(j);
				}
			}
			result.add(temp);
		}
		return result;
	
	}
}
