package question10;

/**
 * 斐波那契数列
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * 解题思路：
 * 递归效率极低，因为会多次计算重复的值。所以使用正向计算，有第0项和第1项求得第2项，接着求得第3项...
 * @author Potato
 *
 */
public class Fibonacci {
	
	public int fibonacci(int n) {
		if(n < 2) {
			return n;
		}
		int one = 1;
		int two = 0;
		int result = 0;
		for (int i = 2; i < n+1; i++) {
			result = one + two;
			two = one;
			one = result;
		}
		
		return result;
		
    }

}
