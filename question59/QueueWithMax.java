package question59;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 请定义一个队列并实现函数max得到队列里的最大值，要求函数max、push_back和pop_front的时间复杂度都是O(1)。
 * 
 * 解法同上一题一样
 * @author Potato
 *
 */
public class QueueWithMax {
	
	List<Integer> index = new LinkedList<Integer>();
    ArrayList<Integer> data = new ArrayList<Integer>();
    
	public void push_back(int num){
		/**
		 * 如果新放入的数字大于队列尾部的数字，那么就把尾部的所有比当前数字小的都从队列删除
		 */
		while(!index.isEmpty() && num >= data.get(index.get(index.size()-1))) {
			index.remove(index.size()-1);
		}
		/**
		 * 新数字放入数据域
		 * 下标放入index
		 */
		data.add(num);
		index.add(data.size()-1);
	}
	
	/**
	 * 移除时，要把index中的所有下标减一
	 * 如果本来就是第一个，那么下标本来为0，在pop时就要弹出的，因为-1了，所以把index中的为-1的元素删除
	 * @return
	 */
	public int pop_front(){
		for (int i = 0; i < index.size(); i++) {
			int t = index.get(i);
			index.set(i, t-1);
		}
		Iterator<Integer> i = index.iterator();
		while(i.hasNext()) {
			if(i.next() == -1) {
				i.remove();
			}
		}
		/**
		 * 如果没有数字就返回-1
		 */
		if(data.isEmpty()) {
			return -1;
		}
		/**
		 * 返回第一个数字
		 */
		return data.remove(0);
	}
	
	public int max() {
		if(index.isEmpty()) {
			return -1;
		}
		return data.get(index.get(0));
	}
	

}
