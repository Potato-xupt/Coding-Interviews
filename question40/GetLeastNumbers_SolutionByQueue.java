package question40;

import java.util.ArrayList;
import java.util.PriorityQueue;
/**
 *最小的K个数（O(NlogK)时间复杂度解法，适合处理海量数据）
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * 解题思路：
 * 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
 * @author Potato
 *
 */
public class GetLeastNumbers_SolutionByQueue {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		/**
		 * 判断边界条件
		 */
		if(input == null || input.length <= 0 || k > input.length || k <= 0) {
			return new ArrayList<Integer>();
		}
		/**
		 * 创建优先队列作为大顶堆
		 */
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		/**
		 * 挨个遍历数组中的元素
		 */
		for (int i = 0; i < input.length; i++) {
			/**
			 * 把元素添加到大顶堆中
			 */
			maxHeap.add(input[i]);
			/**
			 * 如果大顶堆中的元素数量超过k，就把最大的元素移除掉
			 */
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return new ArrayList<Integer>(maxHeap);
		
    }
}
