package question15;

/**
 * 二进制中1的个数
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * 解题思路：
 * 把一个数n减去1与其本身做与运算，直到n等于零。
 * 例如：n = 1100
 * n-1 = 1011， n = (n-1) & n = 1000;
 *  n-1 = 0111, n = (n-1) & n = 0;
 *  所以有两个1
 * @author Potato
 *
 */
public class NumberOf1 {
	public int numberOf1(int n) {
        int count = 0;
        while(n != 0) {
        	count++;
        	n = (n-1)&n;
        }
        return count;
    }
}
