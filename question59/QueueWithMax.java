package question59;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * �붨��һ�����в�ʵ�ֺ���max�õ�����������ֵ��Ҫ����max��push_back��pop_front��ʱ�临�Ӷȶ���O(1)��
 * 
 * �ⷨͬ��һ��һ��
 * @author Potato
 *
 */
public class QueueWithMax {
	
	List<Integer> index = new LinkedList<Integer>();
    ArrayList<Integer> data = new ArrayList<Integer>();
    
	public void push_back(int num){
		/**
		 * ����·�������ִ��ڶ���β�������֣���ô�Ͱ�β�������бȵ�ǰ����С�Ķ��Ӷ���ɾ��
		 */
		while(!index.isEmpty() && num >= data.get(index.get(index.size()-1))) {
			index.remove(index.size()-1);
		}
		/**
		 * �����ַ���������
		 * �±����index
		 */
		data.add(num);
		index.add(data.size()-1);
	}
	
	/**
	 * �Ƴ�ʱ��Ҫ��index�е������±��һ
	 * ����������ǵ�һ������ô�±걾��Ϊ0����popʱ��Ҫ�����ģ���Ϊ-1�ˣ����԰�index�е�Ϊ-1��Ԫ��ɾ��
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
		 * ���û�����־ͷ���-1
		 */
		if(data.isEmpty()) {
			return -1;
		}
		/**
		 * ���ص�һ������
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
