
package question56;

/**
 * 数组中唯一只出现一次的数字（可以拓展到只有一个数字出现一次，其他都出现奇数次的情况。
 * 题目描述
 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。
 * 请找出那个只出现一次的数字。
 * 你可以假设满足条件的数字一定存在。
 * 
 * 解题思路：
 * 如果一个数字出现三次，那么它的二进制表示的每一位（ 0 或者 1 ）也出现三次。如果把所有出现三次的数字的二进制表示的每一位都分别加起来，那么每一位的和都能被 3 整除
 *把数组中所有数字的二进制表示的每一位都加起来。如果某一位的和能被 3 整除，那么那个只出现一次的数字二进制表示中对应的那一位是 0 ；否则就是 1
 * @author Potato
 *
 */

public class FindNumberAppearingOnce {
	
    public int findNumberAppearingOnce(int[] nums) {
    	/**
    	 * 边界条件判断
    	 */
        if(nums == null || nums.length < 0) {
        	return -1;
        }
        /**
         * 32位数组存放二进制数的每一位
         */
        int [] bit = new int [32];
        /**
         * 	遍历数组每个数字
         */
        for (int num : nums) {
        	/**
        	 * 转化为二进制数
        	 */
        	String s = Integer.toBinaryString(num);
        	/**
        	 * 高位补0
        	 */
        	while(s.length() < 32) {
        		s = '0'+s;
        	}
        	/**
        	 * 放入32位数组中
        	 */
			for (int i = 0; i < bit.length; i++) {
				bit[i] += Integer.valueOf(s.charAt(i));
			}
		}
        int result = 0;
        /***
         * 	遍历32位数组
         */
        for (int num : bit) {
        	/**
        	 * 每次循环乘2，等于二进制转10进制
        	 */
			result = result << 1 ;
			result += num%3;
		}
        return result;
         
    }

}
