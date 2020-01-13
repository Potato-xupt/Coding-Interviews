package question40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * 最小的K个数（O(n)时间复杂度解法，适合只有当允许修改数组元素时才可以使用）
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * 解题思路：
 * 快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，
 * 此时 a[j] 就是数组的第 j 大元素。
 * 可以利用这个特性找出数组的第 K 个元素，这种找第 K 个元素的算法称为快速选择算法。
 * 
 * @author Potato
 *
 */
public class GetLeastNumbers_SolutionByOn {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		/**
		 * 边界条件判断
		 */
		if(input == null || input.length <= 0 || k > input.length || k <= 0) {
			return new ArrayList<Integer>();
		}
		/**
		 * left和right分别是数组的开始下标和结束下标
		 */
		int start=0;
        int end=input.length-1;
        /**
		 * 通过partition方法调整元素为位置，得到的index就是前middle大的数字
		 */
        int index=Partition(input,start,end);
        
        while(index!=k-1){
        	/**
			 * 如果index与k相等，那么就是要的结果
			 * 如果index比k大，那么就在前index个数字里面找前k大的数字
			 */
            if(index>k-1){
                end=index-1;
                index=Partition(input,start,end);
            }else{
                start=index+1;
                index=Partition(input,start,end);
            }
            System.out.println(Arrays.toString(input));
        }
		/**
		 * 上面的方法调整数组的元素后，前k的数字就是最小的K个数
		 * 放入result中即可
		 */
		for (int i = 0; i < k; i++) {
			result.add(input[i]);
		}
		Collections.sort(result);
		return result;
    }

	private int Partition(int[] input, int start, int end) {
		/**
		 * 把第一个数字存下来作为基准数字，比它小的移到左边，比它大的移到右边
		 */
		int pivot=input[start];
        while(start < end){
        	/**
			 * 从数组后面找，查找比基准数字小的数字
			 */
            while(start < end && input[end] >= pivot){
            	--end; 	
            }
            input[start]=input[end];            
            /**
    		* 从数组前面找，查找比基准数字大的数字
    		*/
            while(start < end && input[start] <= pivot){
            	++start;           	
            }                
            input[end] = input[start];
        }
        input[end] = pivot;
        return end;
	}
}
