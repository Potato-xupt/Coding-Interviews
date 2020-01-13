package question15;

/**
 * LeetCode 231. 2的幂
 * 题目描述：
 *  给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 解题思路：如果是2的幂次方，那么2进制数中就只有一个1，所以判断2进制数中就是否只有一个1
 * @author Potato
 *
 */


public class IsPowerOfTwo {
	
	public boolean isPowerOfTwo(int n) {
		if(n <= 0) {
			return false;
		}
        if((n&(n-1)) == 0) {
        	return true;
        }
        return false;
    }
}
