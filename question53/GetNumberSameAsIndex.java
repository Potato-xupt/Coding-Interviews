package question53;
/**
 * ��������ֵ���±���ȵ�Ԫ��
 * ����һ�������������������ÿ��Ԫ�ض�������������Ψһ�ġ�
 * ����ʵ��һ�������ҳ�����������һ����ֵ�������±��Ԫ�ء�
 * ���磬������[-3, -1, 1, 3, 5]�У�����3�������±���ȡ�
 * 
 * ����˼·��
 * ���ַ�
 * �����ǰ�±����±��ϵ�������ȣ���ôֱ�ӷ��ظ����ּ���
 * �����ǰ�±�С���±��ϵ����֣���ô��ֵ���±���ȵ�Ԫ�ؿ϶����Ұ벿�֣����Ұ벿����
 * �����ǰ�±�����±��ϵ����֣���ô��ֵ���±���ȵ�Ԫ�ؿ϶�����벿�֣�����벿����
 * @author Potato
 *
 */
public class GetNumberSameAsIndex {
    public int getNumberSameAsIndex(int[] nums) {
        if(nums == null || nums.length <= 0) {
        	return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
        	int middle = (left+right) >> 1;
        	if(middle == nums[middle]) {
        		return middle;
        	}
        	if(middle > nums[middle]) {
        		left = middle+1;
        	}else{
        		right = middle-1;
        	}
        }
        return -1;
    }
}
