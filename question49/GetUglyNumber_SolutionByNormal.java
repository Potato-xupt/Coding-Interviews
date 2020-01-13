package question49;
/**
 * ����
 * ��дһ�������жϸ��������Ƿ�Ϊ������
 * ��������ֻ���������� 2, 3, 5 ����������
 * 
 * ����˼·��
 * ע�⣺�ýֻⷨ�������ж��Ƿ�Ϊ��������ֹ�ø÷������n����������Ϊ�÷���ʱ��Ч�ʼ��ͣ����س�ʱ��
 * ����ʹ��ע�͵��ķ��������������ֻ���ṩһ��˼·���ѣ�Ч�ʼ���
 * 
 * ���һ�������ǳ�������ô������2��3��5������������Ľ��һ����1
 * @author Potato
 *
 */
public class GetUglyNumber_SolutionByNormal {
	/**
	 * �÷�����Ϊ�����˴������ǳ��������֣�Ч�ʼ���!���س�ʱ!������ʹ��!
	 * @param index
	 * @return
	 */
    public int GetUglyNumber_Solution(int index) {
    	/**
    	 * 1-6ÿ�����ֶ��ǳ���
    	 */
        if(index <= 6) {
        	return index;
        }
        int number = 0;
        int uglyFound = 0;
        /**
         * uglyFound ��¼��������
         */
        while(uglyFound < index) {
        	/**
        	 * �ж�ÿ������
        	 */
        	++number;
        	/**
        	 * ���������Ϊ������������һ��ֱ���ҵ���index������Ϊֹ
        	 */
        	if(isUgly(number)) {
        		uglyFound++;
        	}
        }
        return number;
        
    }

	private boolean isUgly(int number) {
		/**
		 * �����С�ڵ���0�����֣���ô�϶����ǳ���
		 */
		if(number <= 0){
            return false;
        }
		/**
		 * 1-6ÿ�������ǳ���
		 */
        if(number <= 6){
            return true;
        }
        /**
         * ����ܱ�2����������������2��ֱ����������Ϊֹ
         */
		while(number % 2 == 0) {
			number/= 2;
		}
		/**
         * ����ܱ�3����������������3��ֱ����������Ϊֹ
         */
		while(number % 3 == 0) {
			number /= 3;
		}
		/**
         * ����ܱ�5����������������5��ֱ����������Ϊֹ
         */
		while(number % 5 == 0) {
			number /= 5;
		}
		/**
		 * ���Ľ����1�Ļ����ǳ���
		 */
		return number == 1;
		
	}
}
