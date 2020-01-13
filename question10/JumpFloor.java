package question10;

/**
 * 跳台阶
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 解题思路：
 *斐波那契额数列，正向求和
 * @author Potato
 *
 */
public class JumpFloor {
	public int jumpFloor(int target) {
		if(target < 2) {
			return target;
		}
		int one = 1;
		int two = 1;
		int result = 0;
		for (int i = 2; i < target+1; i++) {
			result = one + two;
			two = one;
			one = result;
		}
		
		return result;
    }
}
