package question45;

import java.util.Arrays;
/**
 * 把数组排成最小的数
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * 解题思路：
 * 对数组的排序，重写排序规则即可，
 * 在比较两个字符串 S1 和 S2 的大小时，应该比较的是 S1+S2 和 S2+S1 的大小，
 * 如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
    	/**
    	 * 判断边界条件
    	 */
    	if(numbers == null || numbers.length <= 0) {
    		return "";
    	}
    	/**
    	 * 创建一个新的数组，对该String数组进行自定义排序，因为int数组无法自定义排序
    	 */
    	String [] nums = new String[numbers.length];
    	/**
    	 * 把原数组的元素全部放入新数组
    	 */
    	for (int i = 0; i < numbers.length; i++) {
			nums[i] = String.valueOf(numbers[i]);
		}
    	/**
    	 * 定义排序规则：o1+o2 > o2+o1，那么o2+o1在前，否则01+02在前
    	 */
    	Arrays.sort(nums, (o1,o2) -> (o1+o2).compareTo(o2+o1) );
    	/**
    	 * 使用字符串拼接，放置超过最大数字
    	 */
    	StringBuilder s = new StringBuilder();
    	for (int i = 0; i < nums.length; i++) {
			s.append(nums[i]);
		}
    	return s.toString();
    }

}
