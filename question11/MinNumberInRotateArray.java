package question11;

/**
 * 旋转数组的最小数字
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 *   例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 *解题思路：
 *先判断边界条件。满足则采用二分法，双指针指向首位。/
 *如果首位和中间的值三者一样的话，那么二分法无效，就遍历数组寻找最小值
 *否则判断中间值是否大于等于首值，如果成立，最小值就在后半部分，所以将中间值赋给首值；否则在前半部分，将中间值赋给尾值。接着将中间继续二分。
 *直到首尾值相邻，尾值则为最小值。返回即可。
 * @author Potato
 *
 */
public class MinNumberInRotateArray {
	 public int minNumberInRotateArray(int [] array) {
		 /**
		  * 先判断边界条件
		  */
		 if(array == null || array.length <= 0) {
			 return 0;
		 }
		    int start = 0;
		    int end = array.length - 1;
		    /**
		     *中间值默认为首值，防止未移动。
		     */
		    int mid = start;
		    
		    while(array[start] >= array[end]) {
		    	/**
		    	 * 直到首尾值相邻，尾值则为最小值。返回即可。
		    	 */
		    	 if(end - start == 1) {
		    		 return array[end];
		    	 }
		    	 
		    	 mid = (start + end) / 2;
		    	 /**
		    	  * 如果首位和中间的值三者一样的话，那么二分法无效，就遍历数组寻找最小值
		    	  */
		    	 if(array[start] == array[end] && array[start] == array[mid]) {
		    		
		    			int result = array[start];
		    			for(int i = start;i<=end;i++) {
		    				if(array[i] < result) {
		    					result = array[i];
		    				}
		    			} 
		    			return result;
		    		 
		    	 }
		    	 /**
		    	  * 判断中间值是否大于等于首值，如果成立，最小值就在后半部分，所以将中间值赋给首值；否则在前半部分，将中间值赋给尾值
		    	  */
		    	 if(array[start] <= array[mid]) {
		    		 start = mid;
		    	 }else {
		    		 end = mid;
		    	 }
		    }
		    return array[mid];
	 }
}
