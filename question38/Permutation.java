package question38;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 字符串的排列
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 
 * 解题思路：
 * 字符串全排列可以把字符串看成两个部分，第一个部分为它的一个字符，第二部分是后面的字符。
 * 分两步完成：首先求所有可能出现在第一个位置的字符，即把第一个字符与后面的所有字符交换。
 * 第二步固定第一个字符，求后面所有字符的排列。从中可以看出是典型的递归思路。 
 * 如果给的字符中出现重复，即{a,b,c,c}这种情况，可以判断当前准备交换的字符，如果当前准备交换的字符已经在当前坐标前面的字符中出现过了，就跳过，否则就交换
 * 
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class Permutation {

	private ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() <= 0) {
        	return result;
        }
        Permutation(str.toCharArray(),0);
        /**
         * 字典序打印排序
         */
        Collections.sort(result);
        return result;
    }
	private void Permutation(char [] str, int begin) {
		/**
		 * 排列完一次就把他放到result中
		 */
		if(begin == str.length) {
			result.add(String.valueOf(str));
		}else {
			for (int i =begin; i < str.length; i++) {
				/**
				 * 先判断是否重复
				 */
				if(istExit(str,begin,i)) {
					/**
					 * 把第一个字符与后面的所有字符交换
					 */
					char temp = str[i];
					str[i] = str[begin];
					str[begin] = temp;
					/**
					 * 固定第一个字符，求后面所有字符的排列
					 */
					Permutation(str,begin + 1);
					temp = str[i];
					str[i] = str[begin];
					str[begin] = temp;
				}
			}
		}
		
	}
	/**
	 * 如果当前准备交换的字符已经在i前面的字符中出现过了，就跳过，否则就交换
	 * @param str
	 * @param begin
	 * @param i
	 * @return
	 */
	private boolean istExit(char[] str, int begin, int i) {
		for (int j = begin; j < i; j++) {
			if(str[j] == str[i]) {
				return false;
			}
		}
		return true;
	}
}
