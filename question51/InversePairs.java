package question51;
/**
 * 数组中的逆序对
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 
 * 示例1
 * 输入1,2,3,4,5,6,7,0
 * 输出7
 * 
 * 解题思路
 * 归并排序的思想
 * 过程：先把数组分割成子数组，先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。
 * 在统计逆序对的过程中，还需要对数组进行排序。
 * (a) 把长度为4的数组分解成两个长度为2的子数组；
 * (b) 把长度为2的数组分解成两个成都为1的子数组；
 * (c) 把长度为1的子数组 合并、排序并统计逆序对 ；
 * (d) 把长度为2的子数组合并、排序，并统计逆序对；
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class InversePairs {
	
    public int InversePairs(int [] array) {
    	/**
    	 * 边界条件判断
    	 */
        if(array == null || array.length <= 0) {
        	return 0;
        }
        /**
         *	 创建辅助数组，并且拷贝，用来后面比较大小
         */
        int [] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        
        return count%1000000007;
    }

	private int InversePairsCore(int[] data, int[] copy, int start, int end) {
		/**
		 * 	数组大小分割为1，不存在比较，
		 */
		if(start == end) {
			copy[start] = data[start];
			return 0;
		}
		/**
		 * 	二分数组
		 */
		int length = (end - start) >> 1;
        /**
         * 	先统计出子数组内部的逆序对的数目	
         */
		int left = InversePairsCore(copy, data, start, start+length)%1000000007;
		int right = InversePairsCore(copy, data, start+length+1, end)%1000000007;
		
		//前半段最后一个数字的下标
		int i = start+length;
		//后半段最后一个数字的下标
		int j = end;
		//拷贝到copy数组中的下标
		int indexCopy = end;
		int count = 0;
		
		while(i >= start && j >= start+length+1) {
			//如果前半段的数字大于后半段，那么他就大于后半段 从j到后半段开头的全部
			if(data[i] > data[j]) {
				copy[indexCopy--] = data[i--];
				count += j - start -length;
				if(count>=1000000007){
					count%=1000000007;	//数值过大求余	
				}
			}else {
				copy[indexCopy--] = data[j--];
			}
		}
		//把前半段或者后半段未复制完的部分复制到copy中
		for (; i >= start; i--) {
			copy[indexCopy--] = data[i];
		}
		for (; j >= start+length+1; j--) {
			copy[indexCopy--] = data[j];
		}
		return count + left + right;
	}
}
