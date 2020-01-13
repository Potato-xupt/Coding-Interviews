package question15;

/**
 * 输入两个整数m和n,计算m需要改变多少位才能得到n？
 * 
 * 解题思路：
 * 先求异或，再计算1的数量
 * @author Potato
 *
 */
public class HowPeerMToN {

	public int howPeerMToN(int m,int n) {
		int count = 0;
		int c = m^n;
		while(c != 0) {
			count ++;
			c = (c-1) & c;
		}
		return count;
	}
}
