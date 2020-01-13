package question59;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
/**
 * 滑动窗口的最大值
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *  针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *  
 *  解题思路：
 *  使用双端队列，用来保存可能是滑动窗口最大值的数字的下标
 *  每次循环时，把队列尾部所有比当前值小的数字全部移出去，然后把当前值的下标放入，这样每次从队列头部拿到的值就是最大值
 *  
 * @author Potato
 *
 */
public class MaxInWindows {
	
    public ArrayList<Integer> maxInWindows(int [] num, int size){
    	/**
    	 * 判断边界条件
    	 */
        if(num == null || num.length <= 0 || size > num.length || size < 1) {
        	return new ArrayList<Integer>();
        }
        /**
         * 	一个双端队列存储最大值
         * 	一个集合存放结果
         */
        Deque<Integer> index = new LinkedList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        /**
         * 	先走滑动窗口的长度，把size长度内的最大值和其后可能用到的最大值都存入双端队列
         */
        for (int i = 0; i < size; i++) {
        	/**
        	 * 如果当前数字大于队列尾部的数字，那么就把尾部的所有比当前数字小的都从队列删除
        	 */
			while(!index.isEmpty() && num[i] >= num[index.peekLast()]) {
				index.removeLast();
			}
			/**
			 * 然后把当前数字放入队列尾部
			 */
			index.addLast(i);
		}
        
        /**
         * 	正式开始遍历
         */
        for (int i = size; i < num.length; i++) {
        	/**
        	 * 因为上一步已经把size长度的滑动窗口最大值放入队列首部了，
        	 * 所以这里直接把队列首部的值就是当前窗口的最大值，放入结果集合中
        	 */
			result.add(num[index.peek()]);
			
			/**
			 * 如果当前数字大于队列尾部的数字，那么就把尾部的所有比当前数字小的都从队列删除
			 */
			while(!index.isEmpty() && num[i] >= num[index.peekLast()] ) {
				index.removeLast();
			}
			/**
			 * 如果队列首部的数字已经不在当前滑动窗口了，所以把它从队列中删除
			 */
			if(!index.isEmpty() && index.peekFirst() <= i-size) {
				index.removeFirst();
			}
			/**
			 * 然后把当前数字放入队列尾部
			 */
			index.addLast(i);
		}
        
        /**
         * 	把最后一个滑动窗口的最大值放入结果集合
         */
        result.add(num[index.peek()]);
        
        return result;
    }
}
