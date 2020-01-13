package question62;
/**
 * 圆圈中最后剩下的数字
 * 题目描述
 * 0，1，...，n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 
 * 解题思路：
 * 约瑟夫环公式：
 * f(n, m) = 0           (n = 1) 
 * f(n, m) = [f(n-1, m) +m] % n  (n > 1)
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class LastRemaining_Solution {
	
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m<1) {
        	return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
        return last;
    }

}
