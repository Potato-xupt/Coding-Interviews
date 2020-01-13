package question61;

import java.util.Arrays;

/**
 * �˿���˳��
 * ��Ŀ����
 * �����ȡ�˿����е�5���ƣ��ж��ǲ���˳�ӣ�����5�����ǲ��������ġ�����A����1��J����11��Q����12��K����13����С�����Կ����κ���Ҫ�����֡�
 * 
 * ����˼·��
 * �ȶ������������ʹ��sort��������sort�������ٶ���O��Nlogn��
 * ��ΪԪ�صķ�Χ��0-13��14�����֣�����������ֻ��������֣���������Ͱ����O��N�����ٶȺ�O��Nlogn�����ٶȲ�����Ժ��Բ���
 * �����ͳ�Ƴ�0�ĵĸ�����Ȼ����0ȥ����м����λ��
 * ����������������ǣ�01345�������2��������0ȥ���2��λ�ã�����˳��
 * ���0�ĸ����������������Ͳ���˳��
 * @author Potato
 *
 */
public class IsContinuous {
	
	    public boolean isContinuous(int [] numbers) {
	    	/**
	    	 * �жϱ߽�����
	    	 */
	    	if(numbers == null || numbers.length <= 0) {
	    		return false;
	    	}
	    	/**
	    	 * ����������
	    	 */
	    	Arrays.sort(numbers);
	    	
	    	/**
	    	 * ͳ��0�ĸ���	    	 
	    	 * */
	    	int zeroCount = 0;    	
	    	for (int i = 0; i < numbers.length; i++) {
				if(numbers[i] == 0) {
					zeroCount ++;
				}
			}
	    	
	    	/**
	    	 * �������� ����0�������λ��
	    	 * �ӵ�һ������0��λ�ÿ�ʼ����
	    	 */
	    	int small =  zeroCount;
	    	int big = small+1;
	    	while(big < numbers.length) {
	    		/**
	    		 * ���������ȵ����֣���ô�Ϳ϶�����˳�ӣ���Ϊ�ж��ӾͲ�������˳��
	    		 */
	    		if(numbers[small] == numbers[big]) {
	    			return false;
	    		}
	    		/**
	    		 * ��0�����
	    		 */
	    		zeroCount -= (numbers[big] - numbers[small] -1);
	    		/**
	    		 * ���0�����ˣ���ô�Ͳ���˳��
	    		 */
	    		if(zeroCount < 0) {
	    			return false;
	    		}
	    		small = big++;
	    	}
	    	return zeroCount>=0;
	    }

}
