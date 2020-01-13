package question53;
/**
 * 0��n-1��ȱʧ������
 * ��Ŀ����
 * һ������Ϊn-1�ĵ������������е��������ֶ���Ψһ�ģ�����ÿ�����ֶ��ڷ�Χ0��n-1֮�ڡ�
 * �ڷ�Χ0��n-1��n������������ֻ��һ�����ֲ��ڸ������У����ҳ�������֡�
 * 
 * ����˼·��
 * �������m�Լ�m֮ǰ���������ֶ��������У���ôm���±����m
 * ���m���������У���ôm+1�������±�Ϊm��λ��
 * �Դ����ƣ��ҵ���һ�������ֲ����Լ��±���ȵ��±꣬����ȱʧ������
 * @author Potato
 *
 */
public class GetMissingNumber {
    public int getMissingNumber(int[] nums) {
    	/**
    	 * �߽������ж�
    	 */
        if(nums == null || nums.length <= 0) {
        	return 0;
        }
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right) {
        	/**
        	 * ʹ�ö��ַ�
        	 */
        	int middle = (left+right) >> 1;
        /**
         *	����������±겻һ��
         */
        	if(middle != nums[middle]) {
        		/**
        		 * ����ǵ�һλ����ǰһλ���Լ��±���ȣ���ô��һλ���ǵ�һ���±겻�ȵ�Ԫ�أ���������±꣬����ȱʧ��Ԫ��
        		 */
        		if(middle == 0 ||(middle > 0 && nums[middle-1] == middle-1) ) {
        			return middle;
        		}else {
        			/**
        			 * �����ǰ�벿����
        			 */
        			right = middle -1 ;
        		}
        	}else {
        		/**
        		 * ����������±�һ�£��Ӻ�벿����
        		 */
        		left = middle + 1;
        	}
        }
      /**
       * 	�����鲻ȱʧ����ʱ,������鳤��
       */
        if(left == nums.length) {
        	return left;
        }
        /**
         * 	��Ч�����飬�������������
         */
        return -1;
    }
}
