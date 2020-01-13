package question49;
/**
 * 丑数
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * 解题思路：
 * 三指针法
 * 先考虑丑数如何得到，肯定是由某个丑数乘2或乘3或乘5得到的
 * 因此只要知道上一个乘2得到的丑数位置，上一个乘3得到的丑数位置，上一个乘5得到的丑数位置，这三个指针的位置
 * 然后当前丑数就是他们三个指针分别继续乘2、乘3或乘5这三个数字的最小值，
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class GetUglyNumber_Solution {
	
    public int GetUglyNumber_Solution(int index) {
    	/**
    	 * 边界条件判断
    	 */
        if(index <= 0) {
        	return 0;
        }
        /**
         * 1-6每个数字都是丑数
         */
        if(index <= 6) {
        	return index;
        }
        /**
         * 建立一个index大小的数组，放置index个丑数
         */
        int [] uglyNumbers = new int [index];
        /**
         * 第一个丑数就是1
         */
        uglyNumbers[0] = 1;
       /**
        * 三个指针
        * p2之前的数字乘2都会小于当前最大的丑数，p2之后的数字乘2都会大于当前最大的丑数，p3和p5同理
        */
        int p2;
		int p3;
		int p5 = p3 = p2 = 0;
        
		for (int i = 1; i < index; i++) {
			/**
			 * 统计p2*2，p3*3，p5*5
			 */
			int next2 = uglyNumbers[p2]*2;
			int next3 = uglyNumbers[p3]*3;
			int next5 = uglyNumbers[p5]*5;
			/**
			 * 当前位置要放的丑数就是他们的最小值
			 */
			uglyNumbers[i] = Math.min(next2, Math.min(next3, next5));
			/**
			 * 因为有新的最大值刚刚放入，所以指针要后移，确保p2之前的数字乘2都会小于当前最大的丑数，p2之后的数字乘2都会大于当前最大的丑数，p3和p5同理
			 */
			if(uglyNumbers[i] >= next2) {
				p2++;
			}
			if(uglyNumbers[i] >= next3) {
				p3++;
			}
			if(uglyNumbers[i] >= next5) {
				p5++;
			}
		}
		return uglyNumbers[index -1];
    }

}
