package question57;

import java.util.ArrayList;
/**
 * 和为S的连续正数序列
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8。
 * 
 * 解题思路：
 * 使用两个指针，一个samll指针指向连续正数序列的最小值，一个big指针指向连续整数序列的最大值
 * 然后判断当前序列的的和与sum的大小关系
 * 如果当前序列的和大于sum，small指针往前移一位，这样序列中就减去了一位小的数字
 * 如果当前序列的和小于sum，big指针往前移一位，这样序列中就加上了一位大的数字
 * 如果当前序列的和等于sum，，那么从small到big之间的数字数字序列就是一组结果
 * 然后small和big指针同时往前移一位，继续寻找下一个符合要求的序列
 * 因为要求序列至少还有两个数字， 所以要求big指针的值小于sum
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	/**
    	 * 因为序列从1、2开始的，所以最小值为3，当sum小于3时，没有符合要求的序列，直接返回一个空的序列集合
    	 */
    	if(sum < 3) {
    		return new ArrayList<ArrayList<Integer>>();
    	}
    	
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	int small = 1;
    	int big = 2;
    	/**
    	 * curSum记录当前序列的和
    	 */
    	int curSum = 3;
    	
    	while(big < sum) {
    		/**
    		 * 如果序列的和小于sum
    		 * 那么big指针向前走一步，这样序列中就加上了一位大的数字
    		 */
    		if(curSum < sum) {
    			big++;
    			curSum += big;
    		}else if(curSum > sum) {
    			/**
        		 * 如果序列的大小于sum
        		 * 那么是small指针向前走一步，这样序列中就减去了一位小的数字
        		 */
    			curSum -= small;
    			small ++;
    		}else{
    			/**
    			 * 如果当前序列的和等于sum，，那么从small到big之间的数字数字序列就是一组结果
    			 * 记录下来放到集合中
    			 */
    			ArrayList<Integer> res = new ArrayList<Integer>(big-small+1);
    			for (int i = small; i <= big; i++) {
					res.add(i);
				}
    			result.add(res);
    			/**
    			 * small和big指针同时向前走一步
    			 * 同时序列和也把small指针的值减去，加上big指针的值
    			 */
    			curSum -= small;
    			small ++;
    			big++;
    			curSum += big;
    		}
    	}
    	return result;
    	
    }

}
