package question53;
/**
 * ���������������г��ֵĴ���
 * ��Ŀ����
 * ͳ��һ�����������������г��ֵĴ�����
 * 
 * ����˼·��
 * ͨ���ҵ�k�ĵ�һ����������һ������ķ���
 * ��Ϊ����ʱ����ģ����Ե�һʱ���뵽���Ƕ��ַ���
 * ������Ϊ��ͳ�Ƴ��ֵĴ��������Կ��Լ���ͨ�����ַ��ҵ�k�ĵ�һ�����ֵ��±�����һ�����ֵ��±�
 * ��һ�����ֵ��±�����һ�����ֵ��±�Ĳ�ֵ��һ���ǳ��ֵĴ���
 * @author Potato
 *
 */
public class GetNumberOfKByFirstKAndLastK {
	
    public int GetNumberOfK(int [] array , int k) {
    	/**
    	 * �߽������ж�
    	 */
        if(array == null || array.length <= 0) {
        	return 0;
        }
        /**
         * 	�ֱ��ҵ���һ�γ��ֵ�λ�ú����һ�γ��ֵ�λ��
         */
        int first = GetFirstK(array, k, 0, array.length-1);
        int last = GetLastK(array, k, 0, array.length-1);
       
        /**
         * 	���ų�û�г��ֵĿ���
         * 	���û�г��־ͷ���0
         */
        if(first > -1 && last > -1) {
        	return last- first +1;
        }else {
        	return 0;
        }
        
    }


	private int GetFirstK(int[] array, int k, int start, int end) {
		/**
		 * �߽������жϣ�Ҳ���ж��п���û����
		 */
		if(start > end) {
			return -1;
		}
		/**
		 * ���ַ����ҵ��м���������Ӧ������
		 */
		int middleIndex = (end+start) >> 1;
		int middleData = array[middleIndex];
		 /**
		  *  ���������ֺ�kһ��
		  */
		if(middleData == k) {
			/**
			 *  �������������ȷ����ǰ�±���ǵ�һ�γ��ֵ�λ��
			 *  1����ǰ�����������һ��
			 *  2����ǰ����ǰ���Ԫ�ز���k
			 */
			if(middleIndex == 0 || (middleIndex > 0 && array[middleIndex - 1] != k) ) {
				return middleIndex;
			}else {
				/**
				 * �����ǵ�һ�γ��ֵ�λ�ã�
				 *  �������֣�������ǰ�벿����
				 */
				end = middleIndex -1 ;
			}
		}else if(middleData > k) {
			/**
			 * ����м�λ�õ����ִ���k����ôk�϶�������ǰ�벿�֣�������ǰ�벿����
			 */
			end = middleIndex -1 ;
		}else {
			/**
			 * ����м�λ�õ�����С��k����ôk�϶��������벿�֣��������벿����
			 */
			start = middleIndex + 1;
		}
		return GetFirstK(array,k,start,end);
	}
	
	private int GetLastK(int[] array, int k, int start, int end) {
		/**
		 * �߽������жϣ�Ҳ���ж��п���û����
		 */
		if(start > end) {
			return -1;
		}
		/**
		 * ���ַ����ҵ��м���������Ӧ������
		 */
		int middleIndex = (end + start) >> 1;
		int middleData = array[middleIndex];
		/**
		 *  �������������ȷ����ǰ�±�������һ�γ��ֵ�λ��
		 *  1����ǰ�������������һ��
		 *  2����ǰ��������Ԫ�ز���k
		 */
		if(middleData == k) {
			if(middleIndex == array.length - 1 || (middleIndex < array.length -1) && array[middleIndex + 1] !=k ) {
				return middleIndex;
			}else {
				/**
				 * ���������һ�γ��ֵ�λ�ã�
				 *  �������֣��������벿����
				 */
				start = middleIndex + 1;
			}						
		}else if(middleData > k) {
			/**
			 * ����м�λ�õ����ִ���k����ôk�϶�������ǰ�벿�֣�������ǰ�벿����
			 */
			end = middleIndex - 1;
		}else {
			/**
			 * ����м�λ�õ�����С��k����ôk�϶��������벿�֣��������벿����
			 */
			start = middleIndex + 1;
		}
		return GetLastK(array,k,start,end);
	}
}
