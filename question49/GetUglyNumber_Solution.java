package question49;
/**
 * ����
 * ��Ŀ����
 * ��ֻ����������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ������������7�� ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * 
 * ����˼·��
 * ��ָ�뷨
 * �ȿ��ǳ�����εõ����϶�����ĳ��������2���3���5�õ���
 * ���ֻҪ֪����һ����2�õ��ĳ���λ�ã���һ����3�õ��ĳ���λ�ã���һ����5�õ��ĳ���λ�ã�������ָ���λ��
 * Ȼ��ǰ����������������ָ��ֱ������2����3���5���������ֵ���Сֵ��
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class GetUglyNumber_Solution {
	
    public int GetUglyNumber_Solution(int index) {
    	/**
    	 * �߽������ж�
    	 */
        if(index <= 0) {
        	return 0;
        }
        /**
         * 1-6ÿ�����ֶ��ǳ���
         */
        if(index <= 6) {
        	return index;
        }
        /**
         * ����һ��index��С�����飬����index������
         */
        int [] uglyNumbers = new int [index];
        /**
         * ��һ����������1
         */
        uglyNumbers[0] = 1;
       /**
        * ����ָ��
        * p2֮ǰ�����ֳ�2����С�ڵ�ǰ���ĳ�����p2֮������ֳ�2������ڵ�ǰ���ĳ�����p3��p5ͬ��
        */
        int p2;
		int p3;
		int p5 = p3 = p2 = 0;
        
		for (int i = 1; i < index; i++) {
			/**
			 * ͳ��p2*2��p3*3��p5*5
			 */
			int next2 = uglyNumbers[p2]*2;
			int next3 = uglyNumbers[p3]*3;
			int next5 = uglyNumbers[p5]*5;
			/**
			 * ��ǰλ��Ҫ�ŵĳ����������ǵ���Сֵ
			 */
			uglyNumbers[i] = Math.min(next2, Math.min(next3, next5));
			/**
			 * ��Ϊ���µ����ֵ�ոշ��룬����ָ��Ҫ���ƣ�ȷ��p2֮ǰ�����ֳ�2����С�ڵ�ǰ���ĳ�����p2֮������ֳ�2������ڵ�ǰ���ĳ�����p3��p5ͬ��
			 */
			if(uglyNumbers[i] >= next2) {
				p2++;
			}
			if(uglyNumbers[i] >= next3) {
				p3++;
			}
			if(uglyNumbers[i] >= next5) {
				p5++;
			}
		}
		return uglyNumbers[index -1];
    }

}
