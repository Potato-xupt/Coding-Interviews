package question57;

import java.util.ArrayList;
/**
 * 和为S的两个数字
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * 解题思路：
 * 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 * 如果两个指针指向元素的和 add == sum，那么得到要求的结果；
 * 如果 add > sum，移动较大的元素，使 add 变小一些；
 * 如果 add < sum，移动较小的元素，使 add 变大一些。
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class FindNumbersWithSum {
	
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    	/**
    	 *边界条件的判断
    	 */
        if(array == null || array.length <= 0) {
        	return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        /**
         * 定义分别指向大小两个指针
         */
        int left = 0;
        int right = array.length - 1;
        
        while(left < right) {
        	/**
        	 * 求和
        	 */
        	int add = array[left] + array[right];
        	/**
        	 * 如果与sum相等，就返回
        	 */
        	if(add == sum) {
        		result.add(array[left]);
        		result.add(array[right]);
        		return result;
        	}
        	if(add < sum) {
        		/**
        		 * 如果 add < sum，移动较小的元素，使 add 变大一些。
        		 */
        		left++;
        	}else {
        		/**
        		 * 如果 add > sum，移动较大的元素，使 add 变小一些；
        		 */
        		right--;
        	}
        }
        return result;
    }

}
