package question50;

import java.util.BitSet;
/**
 * 第一个只出现一次的字符
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 
 * 解题思路：
 * 最直观的解法是使用 HashMap 对出现次数进行统计，但是考虑到要统计的字符范围有限，因此可以使用整型数组代替 HashMap，从而将空间复杂度由 O(N) 降低为 O(1)。
 * 以上实现的空间复杂度还不是最优的。考虑到只需要找到只出现一次的字符，那么需要统计的次数信息只有 0,1,更大，使用两个比特位就能存储这些信息。
 * 使用bit1和bit2来代表一个二进制数，bit1和bit2都是0就是00，代表一次都没有出现
 * bit1为1，bit2为零就是01，代表出现过一次。
 * bit1和bit2都是1就是11，代表出现多次。
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
    	/**
    	 * 边界条件判断
    	 */
        if(str == null || str.length() <= 0) {
        	return -1;
        }
        BitSet bit1 = new BitSet(256);
        BitSet bit2 = new BitSet(256);
        int len = str.length();
        for (int i = 0; i < len; i++) {
        	/**
        	 * 遍历字符串，把字符串中每个字符的出现次数统计到bit1和bit2中
        	 * 如果是00，就把bit1置为1，变成01，代表出现一次
        	 */
			if(!bit1.get(str.charAt(i)) && !bit2.get(str.charAt(i))) {
				bit1.set(str.charAt(i));
				
			}else if(bit1.get(str.charAt(i)) && !bit2.get(str.charAt(i))) {
				/**
				 * 如果是01，就把bit2置为11，代表出现超过一次
				 */
				bit2.set(str.charAt(i));
			}
		}
        for (int i = 0; i < len; i++) {
        	/**
        	 * 再次遍历字符串每个字符，在bit中相对应的字符下标出对比出现次数
        	 * 遇到第一个出现一次的字符，返回其下标
        	 */
			if(bit1.get(str.charAt(i)) && !bit2.get(str.charAt(i))) {
				return i;
			}
		}
        /**
         * 找不到的情况下返回-1
         */
        return -1;
    }
}
