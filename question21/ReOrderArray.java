package question21;

/**
 * ��������˳��ʹ����λ��ż��ǰ��
 * ��Ŀ����
 * ����һ���������飬ʵ��һ�������������������е����ֵ�˳��ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֣�ϣ��ʱ�临�ӶȾ���С��
 * 
 * ����˼·��
 * ��βָ�룬��ָ��Ѱ��ż����βָ��Ѱ���������ҵ��󽻻����ɡ�
 * ���������ж��Ƿ���ż�ԣ���������ԣ����������Ķ�
 * @author Potato
 *
 */
public class ReOrderArray {
	
	public void reOrderArray(int [] array) {
        if(array == null || array.length <= 1) {
        	return ;
        }
        /**
         *   ������βָ��
         */
        int start = 0;
        int end = array.length - 1;
        while(start < end) {
        	/**
        	 * ��ָ��Ѱ��ż��
        	 */
        	while(start < end && !isEven(array[start])) {
        		start++;
        	}
        	/**
        	 * βָ��Ѱ������
        	 */
        	while(start < end && isEven(array[end])) {
        		end--;
        	}
        	/**
        	 * �ҵ��󽻻�
        	 */
        	if(start < end) {
        		int num = array[start];
        		array[start] = array[end];
        		array[end] = num;
        	}
        }
    }
	/**
	 * ���������ж��Ƿ���ż�ԣ���������ԣ����������Ķ�
	 * @param num
	 * @return
	 */
	private boolean isEven(int num) {
		return (num & 1) == 0;
	}
}
