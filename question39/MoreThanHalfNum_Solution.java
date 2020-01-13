package question39;
/**
 * 组中出现次数超过一半的数字
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * 解题思路：
 * 
 * 以数组的第一个数字为基准，遍历数组，每当遇到相等的数字就次数加一，遇到不相等的数字就次数减一。
 * 当次数为零的时候把基准赋给当前的数字
 * 最后遍历一遍数组，计出这个基准数字出现的次数，如果超过一半那么就是他，如果没有超过一半，那就没有出现次数超过一半的数字，返回0。
 * @author Potato
 *
 */

@SuppressWarnings("all")
public class MoreThanHalfNum_Solution {
	
    public int MoreThanHalfNum_Solution(int [] array) {
    	/**
    	 * 边界条件判断
    	 */
        if(array == null || array.length <= 0) {
        	return 0;
        }
        /**
         * 以数组第一个数字为基准数字
         * 第一次出现，所以出现次数赋为1
         */
        int result = array[0];
        int time = 1;
        /**
         * 从数组的第二个数字开始遍历数组
         */
        for (int i = 1; i < array.length; i++) {
			/**
			 * 如果遇到相等的就出现次数+1
			 * 遇到不相等的就出现次数-1
			 */
			if(result == array[i]){
				time++;
			}else {
				time--;
			}
			/**
			 * 当出现次数减为0的时候，把基准数字变为当前的数字
			 */
			if(time == 0) {
				result = array[i];
				time = 1;
			}
			
		}
        /**
         * 最后从头开始遍历一次数组，统计基准数字出现过的次数
         */
        time = 0;
        for (int i = 0; i < array.length; i++) {
			if(array[i] == result) {
				time ++;
			}
		}
        /**
         * 如果基准数字出现过的次数超过数组长度的一半，那么就返回基准数字，否则就没有基准数字，返回0
         */
        return time > array.length >> 1 ? result:0;
    }

}
