package question41;

import java.util.PriorityQueue;
/**
 * 数据流中的中位数
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 
 * 解题思路：
 * 使用两个堆：大顶堆和小顶堆，分别存放左边的数据和右边的数据，
 * 大顶堆的堆顶就是左边的最大值，小顶堆的堆顶就是右边的最小值
 * 当插入的时候，判单当前总有数据量是奇数还是偶数，偶数就插入右边最小堆，奇数插入左边最大堆
 * 这样在取出数据时，当总有数据量是奇数时直接拿右边最小堆堆顶的数字，当是偶数时直接拿拿做左边和右边堆顶的数字求和除二返回
 * 
 * 
 * @author Potato
 *
 */
public class Median {

	/**
	 * 最大堆和最小堆
	 */
	PriorityQueue<Integer> max = new PriorityQueue<Integer>((o1,o2) -> o2-o1 );
	PriorityQueue<Integer> min = new PriorityQueue<Integer>();
	/**
	 * 记录当前数据量
	 */
	int N = 0;
    public void Insert(Integer num) {
    	/**
    	 * N 为偶数的情况下插入到右半边。
    	 * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
    	 * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边
    	 */
        if((N&1) == 0) {
        	max.add(num);
        	min.add(max.poll());
        }else {
        	/**
        	 * N 为奇数的情况下插入到左半边。
        	 * 因为左半边元素都要小于右半边，但是新插入的元素不一定比右半边元素来的小，
        	 * 因此需要先将元素插入右半边，然后利用右半边为小顶堆的特点，取出堆顶元素即为最小元素，此时插入左半边
        	 */
        	min.add(num);
        	max.add(min.poll());
        }
        
        N++;
    }

    public Double GetMedian() {
    	/**
    	 * 当数据量为偶数时，取出最大堆和最小堆堆顶元素求和除二
    	 */
        if((N&1) == 0) {
        	return (max.peek() + min.peek())/2.0;
        }else {
        	/**
        	 * 当数据量为偶数时，取出最小堆堆顶元素即可
        	 */
        	return (double)min.peek();
        }
    }
}
