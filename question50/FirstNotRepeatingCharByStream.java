package question50;

import java.util.BitSet;
/**
 * 字符流中第一个不重复的字符
 * 
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * 
 * 解题思路：
 * 同字符串的解法一样
 * @author Potato
 *
 */
public class FirstNotRepeatingCharByStream {
	BitSet bit1 = new BitSet(256);
    BitSet bit2 = new BitSet(256);
    /**
     * 用一个字符串来储存字符流
     */
    StringBuilder s = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch){
    	/**
    	 * 如果是00，就把bit1置为1，变成01，代表出现一次
    	 */
    	if(!bit1.get(ch) && !bit2.get(ch)) {
			bit1.set(ch);			
		}else if(bit1.get(ch) && !bit2.get(ch)) {
			/**
			 * 如果是01，就把bit2置为11，代表出现超过一次
			 */
			bit2.set(ch);
		}
    	/**
    	 * 把字符拼接到字符串后面
    	 */
    	s.append(ch);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
    	for (int i = 0; i < s.length(); i++) {
        	/**
        	 * 遍历字符串每个字符，在bit中相对应的字符下标出对比出现次数
        	 * 遇到第一个出现一次的字符，返回其下标
        	 */
			if(bit1.get(s.charAt(i)) && !bit2.get(s.charAt(i))) {
				return s.charAt(i);
			}
    	}
    	return '#';
    }
}
