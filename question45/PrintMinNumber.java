package question45;

import java.util.Arrays;
/**
 * �������ų���С����
 * ��Ŀ����
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * 
 * ����˼·��
 * �������������д������򼴿ɣ�
 * �ڱȽ������ַ��� S1 �� S2 �Ĵ�Сʱ��Ӧ�ñȽϵ��� S1+S2 �� S2+S1 �Ĵ�С��
 * ��� S1+S2 < S2+S1����ôӦ�ð� S1 ����ǰ�棬����Ӧ�ð� S2 ����ǰ�档
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
    	/**
    	 * �жϱ߽�����
    	 */
    	if(numbers == null || numbers.length <= 0) {
    		return "";
    	}
    	/**
    	 * ����һ���µ����飬�Ը�String��������Զ���������Ϊint�����޷��Զ�������
    	 */
    	String [] nums = new String[numbers.length];
    	/**
    	 * ��ԭ�����Ԫ��ȫ������������
    	 */
    	for (int i = 0; i < numbers.length; i++) {
			nums[i] = String.valueOf(numbers[i]);
		}
    	/**
    	 * �����������o1+o2 > o2+o1����ôo2+o1��ǰ������01+02��ǰ
    	 */
    	Arrays.sort(nums, (o1,o2) -> (o1+o2).compareTo(o2+o1) );
    	/**
    	 * ʹ���ַ���ƴ�ӣ����ó����������
    	 */
    	StringBuilder s = new StringBuilder();
    	for (int i = 0; i < nums.length; i++) {
			s.append(nums[i]);
		}
    	return s.toString();
    }

}
