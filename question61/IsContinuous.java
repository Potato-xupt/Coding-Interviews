package question61;

import java.util.Arrays;

/**
 * 扑克牌顺子
 * 题目描述
 * 随机抽取扑克牌中的5张牌，判断是不是顺子，即这5张牌是不是连续的。其中A看成1，J看成11，Q看成12，K看成13，大小王可以看成任何需要的数字。
 * 
 * 解题思路：
 * 先对数组进行排序，使用sort函数排序，sort函数的速度是O（Nlogn）
 * 因为元素的范围是0-13这14个数字，而且数组中只有五个数字，所以最快的桶排序O（N）的速度和O（Nlogn）的速度差异可以忽略不计
 * 排序后统计出0的的个数，然后用0去填充有间隔的位置
 * 例如排序完的数组是：01345，间隔是2，所以用0去填充2的位置，就是顺子
 * 最后看0的个数够不够，不够就不是顺子
 * @author Potato
 *
 */
public class IsContinuous {
	
	    public boolean isContinuous(int [] numbers) {
	    	/**
	    	 * 判断边界条件
	    	 */
	    	if(numbers == null || numbers.length <= 0) {
	    		return false;
	    	}
	    	/**
	    	 * 对数组排序
	    	 */
	    	Arrays.sort(numbers);
	    	
	    	/**
	    	 * 统计0的个数	    	 
	    	 * */
	    	int zeroCount = 0;    	
	    	for (int i = 0; i < numbers.length; i++) {
				if(numbers[i] == 0) {
					zeroCount ++;
				}
			}
	    	
	    	/**
	    	 * 遍历数组 ，用0填充间隔的位置
	    	 * 从第一个不是0的位置开始遍历
	    	 */
	    	int small =  zeroCount;
	    	int big = small+1;
	    	while(big < numbers.length) {
	    		/**
	    		 * 如果遇到相等的数字，那么就肯定不是顺子，因为有对子就不可能是顺子
	    		 */
	    		if(numbers[small] == numbers[big]) {
	    			return false;
	    		}
	    		/**
	    		 * 用0填充间隔
	    		 */
	    		zeroCount -= (numbers[big] - numbers[small] -1);
	    		/**
	    		 * 如果0不够了，那么就不是顺子
	    		 */
	    		if(zeroCount < 0) {
	    			return false;
	    		}
	    		small = big++;
	    	}
	    	return zeroCount>=0;
	    }

}
