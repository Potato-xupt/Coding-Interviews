package question40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * ��С��K������O(n)ʱ�临�ӶȽⷨ���ʺ�ֻ�е������޸�����Ԫ��ʱ�ſ���ʹ�ã�
 * ��Ŀ����
 * ����n���������ҳ�������С��K������
 * ��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 * 
 * ����˼·��
 * ��������� partition() �������᷵��һ������ j ʹ�� a[l..j-1] С�ڵ��� a[j]���� a[j+1..h] ���ڵ��� a[j]��
 * ��ʱ a[j] ��������ĵ� j ��Ԫ�ء�
 * ����������������ҳ�����ĵ� K ��Ԫ�أ������ҵ� K ��Ԫ�ص��㷨��Ϊ����ѡ���㷨��
 * 
 * @author Potato
 *
 */
public class GetLeastNumbers_SolutionByOn {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		/**
		 * �߽������ж�
		 */
		if(input == null || input.length <= 0 || k > input.length || k <= 0) {
			return new ArrayList<Integer>();
		}
		/**
		 * left��right�ֱ�������Ŀ�ʼ�±�ͽ����±�
		 */
		int start=0;
        int end=input.length-1;
        /**
		 * ͨ��partition��������Ԫ��Ϊλ�ã��õ���index����ǰmiddle�������
		 */
        int index=Partition(input,start,end);
        
        while(index!=k-1){
        	/**
			 * ���index��k��ȣ���ô����Ҫ�Ľ��
			 * ���index��k����ô����ǰindex������������ǰk�������
			 */
            if(index>k-1){
                end=index-1;
                index=Partition(input,start,end);
            }else{
                start=index+1;
                index=Partition(input,start,end);
            }
            System.out.println(Arrays.toString(input));
        }
		/**
		 * ����ķ������������Ԫ�غ�ǰk�����־�����С��K����
		 * ����result�м���
		 */
		for (int i = 0; i < k; i++) {
			result.add(input[i]);
		}
		Collections.sort(result);
		return result;
    }

	private int Partition(int[] input, int start, int end) {
		/**
		 * �ѵ�һ�����ִ�������Ϊ��׼���֣�����С���Ƶ���ߣ���������Ƶ��ұ�
		 */
		int pivot=input[start];
        while(start < end){
        	/**
			 * ����������ң����ұȻ�׼����С������
			 */
            while(start < end && input[end] >= pivot){
            	--end; 	
            }
            input[start]=input[end];            
            /**
    		* ������ǰ���ң����ұȻ�׼���ִ������
    		*/
            while(start < end && input[start] <= pivot){
            	++start;           	
            }                
            input[end] = input[start];
        }
        input[end] = pivot;
        return end;
	}
}
