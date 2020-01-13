package question57;

import java.util.ArrayList;
/**
 * ��ΪS��������������
 * ����һ������s����ӡ�����к�Ϊs�������������У����ٺ�������������
 * ��������15������1+2+3+4+5=4+5+6=7+8=15�����Խ����ӡ��3����������1��5��4��6��7��8��
 * 
 * ����˼·��
 * ʹ������ָ�룬һ��samllָ��ָ�������������е���Сֵ��һ��bigָ��ָ�������������е����ֵ
 * Ȼ���жϵ�ǰ���еĵĺ���sum�Ĵ�С��ϵ
 * �����ǰ���еĺʹ���sum��smallָ����ǰ��һλ�����������оͼ�ȥ��һλС������
 * �����ǰ���еĺ�С��sum��bigָ����ǰ��һλ�����������оͼ�����һλ�������
 * �����ǰ���еĺ͵���sum������ô��small��big֮��������������о���һ����
 * Ȼ��small��bigָ��ͬʱ��ǰ��һλ������Ѱ����һ������Ҫ�������
 * ��ΪҪ���������ٻ����������֣� ����Ҫ��bigָ���ֵС��sum
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	/**
    	 * ��Ϊ���д�1��2��ʼ�ģ�������СֵΪ3����sumС��3ʱ��û�з���Ҫ������У�ֱ�ӷ���һ���յ����м���
    	 */
    	if(sum < 3) {
    		return new ArrayList<ArrayList<Integer>>();
    	}
    	
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	int small = 1;
    	int big = 2;
    	/**
    	 * curSum��¼��ǰ���еĺ�
    	 */
    	int curSum = 3;
    	
    	while(big < sum) {
    		/**
    		 * ������еĺ�С��sum
    		 * ��ôbigָ����ǰ��һ�������������оͼ�����һλ�������
    		 */
    		if(curSum < sum) {
    			big++;
    			curSum += big;
    		}else if(curSum > sum) {
    			/**
        		 * ������еĴ�С��sum
        		 * ��ô��smallָ����ǰ��һ�������������оͼ�ȥ��һλС������
        		 */
    			curSum -= small;
    			small ++;
    		}else{
    			/**
    			 * �����ǰ���еĺ͵���sum������ô��small��big֮��������������о���һ����
    			 * ��¼�����ŵ�������
    			 */
    			ArrayList<Integer> res = new ArrayList<Integer>(big-small+1);
    			for (int i = small; i <= big; i++) {
					res.add(i);
				}
    			result.add(res);
    			/**
    			 * small��bigָ��ͬʱ��ǰ��һ��
    			 * ͬʱ���к�Ҳ��smallָ���ֵ��ȥ������bigָ���ֵ
    			 */
    			curSum -= small;
    			small ++;
    			big++;
    			curSum += big;
    		}
    	}
    	return result;
    	
    }

}
