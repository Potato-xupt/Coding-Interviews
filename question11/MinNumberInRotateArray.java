package question11;

/**
 * ��ת�������С����
 * ��Ŀ����
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 *  ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
 *   ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 *NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 *
 *����˼·��
 *���жϱ߽���������������ö��ַ���˫ָ��ָ����λ��/
 *�����λ���м��ֵ����һ���Ļ�����ô���ַ���Ч���ͱ�������Ѱ����Сֵ
 *�����ж��м�ֵ�Ƿ���ڵ�����ֵ�������������Сֵ���ں�벿�֣����Խ��м�ֵ������ֵ��������ǰ�벿�֣����м�ֵ����βֵ�����Ž��м�������֡�
 *ֱ����βֵ���ڣ�βֵ��Ϊ��Сֵ�����ؼ��ɡ�
 * @author Potato
 *
 */
public class MinNumberInRotateArray {
	 public int minNumberInRotateArray(int [] array) {
		 /**
		  * ���жϱ߽�����
		  */
		 if(array == null || array.length <= 0) {
			 return 0;
		 }
		    int start = 0;
		    int end = array.length - 1;
		    /**
		     *�м�ֵĬ��Ϊ��ֵ����ֹδ�ƶ���
		     */
		    int mid = start;
		    
		    while(array[start] >= array[end]) {
		    	/**
		    	 * ֱ����βֵ���ڣ�βֵ��Ϊ��Сֵ�����ؼ��ɡ�
		    	 */
		    	 if(end - start == 1) {
		    		 return array[end];
		    	 }
		    	 
		    	 mid = (start + end) / 2;
		    	 /**
		    	  * �����λ���м��ֵ����һ���Ļ�����ô���ַ���Ч���ͱ�������Ѱ����Сֵ
		    	  */
		    	 if(array[start] == array[end] && array[start] == array[mid]) {
		    		
		    			int result = array[start];
		    			for(int i = start;i<=end;i++) {
		    				if(array[i] < result) {
		    					result = array[i];
		    				}
		    			} 
		    			return result;
		    		 
		    	 }
		    	 /**
		    	  * �ж��м�ֵ�Ƿ���ڵ�����ֵ�������������Сֵ���ں�벿�֣����Խ��м�ֵ������ֵ��������ǰ�벿�֣����м�ֵ����βֵ
		    	  */
		    	 if(array[start] <= array[mid]) {
		    		 start = mid;
		    	 }else {
		    		 end = mid;
		    	 }
		    }
		    return array[mid];
	 }
}
