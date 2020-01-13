package question21;

/**
 * ��������˳��ʹ����λ��ż��ǰ��
 * ��Ŀ����
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * 
 * ����˼·��
 * Ϊ��֤������������ż����ż��֮������λ�ò��䣬����ֻ�ܴ�ͷ��ʼ����������һ��ż����Ȼ�����������ҵ�һ��������
 * Ȼ������ż��������֮�����е���������ƶ�һλ������������ŵ��ճ����ģ�֮ǰż������λ�ã��Դ����λ�ñ��ֲ��䡣
 * @author Potato
 *
 */
public class ReOrderArrayByOrder {
	public void reOrderArray(int [] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		int start = 0;
		while(start < array.length) {
			/**
			 * *���ȣ�start�������ұ������ҵ���һ��ż���� 
			 */
			while(start < array.length && !isEven(array[start])) {
				start++;
			}
			/**
			 *  Ȼ��from��start+1��ʼ����ң�ֱ���ҵ���һ�������� 
			 */
			int end = start+1;
			while(end < array.length && isEven(array[end])) {
				end++;
			}
			/**
			 * ���ţ���[start,��,end-1]��Ԫ���������һλ�� 
			 * ����ҵ�����������startλ�ã�Ȼ��start++��**
			 */
			if(end < array.length) {
				int temp = array[end];
				for(int i = end-1;i>=start;i--) {
					array[i+1] = array[i];
				}
				array[start] = temp;
			}else {
				break;
			}
		}
		
	}

	private boolean isEven(int num) {
		return (num & 1) == 0;
	}
}
