package question63;
/**
 * ��Ʊ���������
 * ��Ŀ����
 * �����ĳ��Ʊ�ļ۸���ʱ���Ⱥ�˳��洢�������У��������� һ�� �ù�Ʊ���ܻ�õ������Ƕ��٣�
 * ����һֻ��Ʊ��ĳЩʱ��ڵ�ļ۸�Ϊ[9, 11, 8, 5, 7, 12, 16, 14]��
 * ����������ڼ۸�Ϊ5��ʱ�����벢�ڼ۸�Ϊ16ʱ�����������ջ���������11��
 * 
 *  ����˼·��
 *  �������飬��¼��i֮ǰ����Сֵ��Ȼ������֪��i������ֵ����
 * @author Potato
 *
 */
public class MaxDiff {
	
    public int maxDiff(int[] nums) {
    	/**
    	 * �߽�����
    	 */
        if(nums == null || nums.length <= 0) {
        	return 0;
        }
        /**
         * �ֱ��¼i֮ǰ����Сֵ��ֱ��i���������
         */
        int min = nums[0];
        int maxProfile = 0;
        
        for (int i = 1; i < nums.length; i++) {
        	/**
        	 * ���i��i֮ǰ����Сֵ��С�����������µ���Сֵ
        	 */
			min = Math.min(min, nums[i]);
			/**
			 * �õ�ǰ��ֵ��ȥ֮ǰ����Сֵ���������Ĳ�ֵ��Ҳ�����������
			 */
			maxProfile = Math.max(maxProfile, nums[i] - min);
		}
        return maxProfile;
    }

}
