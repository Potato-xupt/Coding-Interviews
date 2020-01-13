package question53;
/**
 * ���������������г��ֵĴ���
 * ��Ŀ����
 * ͳ��һ�����������������г��ֵĴ�����
 * 
 * ����˼·��
 * ���ֲ��� ���ҵ�k��һ�γ��ֵ������k+1��һ�γ��ֵ��±�
 * ������ǳ��ִ���
 * @author Potato
 *
 */
public class GetNumberOfKByFirstKAndFirstKadd1 {

	public int GetNumberOfK(int[] nums, int K) {
		if(nums == null || nums.length <= 0) {
			return 0;
		}
		/**
		 * �ֱ���k��k+1��һ�γ��ֵ��±�
		 */
	    int first = binarySearch(nums, K);
	    int last = binarySearch(nums, K + 1);
	    /**
	     * ���k�����ڣ��򷵻�0
	     */
	    return (first == nums.length || nums[first] != K) ? 0 : last - first;
	}
	 /**
	  * ���ֲ���
	  * @param nums
	  * @param K
	  * @return
	  */
	private int binarySearch(int[] nums, int K) {
	    int l = 0, h = nums.length;
	    while (l < h) {
	    	/**
	    	 *  ���������м�λ���±�
	    	 */
	        int m = (l + h) >>1;
	    /**
	     * �м�λ���������k����ǰ��ο�ʼ��
	     * ����Ӻ��ο�ʼ��
	     * �����Ļ�������������û��������֣���ô��󷵻ص�l��������ĳ��ȣ���l = nums.length;
	     */
	        if (nums[m] >= K)
	            h = m;
	        else
	            l = m + 1;
	    }
	    return l;
	}
}
