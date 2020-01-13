package question21;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 题目描述
 * 输入一个整型数组，实现一个函数来调整该数组中的数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分，希望时间复杂度尽量小。
 * 
 * 解题思路：
 * 首尾指针，首指针寻找偶数，尾指针寻找奇数，找到后交换即可。
 * 建立函数判断是否奇偶性，降低耦合性，便于条件改动
 * @author Potato
 *
 */
public class ReOrderArray {
	
	public void reOrderArray(int [] array) {
        if(array == null || array.length <= 1) {
        	return ;
        }
        /**
         *   建立首尾指针
         */
        int start = 0;
        int end = array.length - 1;
        while(start < end) {
        	/**
        	 * 首指针寻找偶数
        	 */
        	while(start < end && !isEven(array[start])) {
        		start++;
        	}
        	/**
        	 * 尾指针寻找奇数
        	 */
        	while(start < end && isEven(array[end])) {
        		end--;
        	}
        	/**
        	 * 找到后交换
        	 */
        	if(start < end) {
        		int num = array[start];
        		array[start] = array[end];
        		array[end] = num;
        	}
        }
    }
	/**
	 * 建立函数判断是否奇偶性，降低耦合性，便于条件改动
	 * @param num
	 * @return
	 */
	private boolean isEven(int num) {
		return (num & 1) == 0;
	}
}
