package question57;

import java.util.ArrayList;
/**
 * ��ΪS����������
 * ��Ŀ����
 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 * 
 * ����˼·��
 * ʹ��˫ָ�룬һ��ָ��ָ��Ԫ�ؽ�С��ֵ��һ��ָ��ָ��Ԫ�ؽϴ��ֵ��ָ���СԪ�ص�ָ���ͷ��β������ָ��ϴ�Ԫ�ص�ָ���β��ͷ������
 * �������ָ��ָ��Ԫ�صĺ� add == sum����ô�õ�Ҫ��Ľ����
 * ��� add > sum���ƶ��ϴ��Ԫ�أ�ʹ add ��СһЩ��
 * ��� add < sum���ƶ���С��Ԫ�أ�ʹ add ���һЩ��
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class FindNumbersWithSum {
	
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    	/**
    	 *�߽��������ж�
    	 */
        if(array == null || array.length <= 0) {
        	return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        /**
         * ����ֱ�ָ���С����ָ��
         */
        int left = 0;
        int right = array.length - 1;
        
        while(left < right) {
        	/**
        	 * ���
        	 */
        	int add = array[left] + array[right];
        	/**
        	 * �����sum��ȣ��ͷ���
        	 */
        	if(add == sum) {
        		result.add(array[left]);
        		result.add(array[right]);
        		return result;
        	}
        	if(add < sum) {
        		/**
        		 * ��� add < sum���ƶ���С��Ԫ�أ�ʹ add ���һЩ��
        		 */
        		left++;
        	}else {
        		/**
        		 * ��� add > sum���ƶ��ϴ��Ԫ�أ�ʹ add ��СһЩ��
        		 */
        		right--;
        	}
        }
        return result;
    }

}
