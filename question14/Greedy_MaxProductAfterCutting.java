package question14;

/**
 *  剪绳子（贪婪算法解法
 * 题目描述
 * 给你一根长度为 n 绳子，请把绳子剪成 m 段（m、n 都是整数，2≤n≤58 并且 m≥2）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]k[1] … k[m] 可能的最大乘积是多少？
 * 例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
 * 
 * 解题思路：
 * 尽量多剪长度为3的绳子，如果最后剩下长度1，则少剪一个3，最后剪一个4.
 * @author Potato
 *
 */
public class Greedy_MaxProductAfterCutting {
	public int maxProductAfterCutting(int length){
		if(length < 2) {
			return 0;
		}
		if(length == 2) {
			return 1;
		}
		if(length == 3) {
			return 2;
		}
		
		int timeOf3 = length / 3;
		
		if(length%3 == 1) {
			timeOf3 -= 1;
		}
		int timeOf2 = (length - timeOf3*3) /2;
		
		return (int) (Math.pow(3, timeOf3)*Math.pow(2, timeOf2));
	}
}
