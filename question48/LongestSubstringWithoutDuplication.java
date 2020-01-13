package question48;
/**
 * ������ظ��ַ������ַ���
 * ��Ŀ����
 * ����ַ������ҳ�һ����Ĳ������ظ��ַ������ַ��������������ַ����ĳ��ȡ�
 * �����ַ�����ֻ�����ӡ�a������z�����ַ���
 * 
 * ����˼·��
 * ��̬�滮����f(i)��ʾ��i���ַ���β�������ظ����ַ���������ȣ���������ɨ
 * 1������i���ַ���֮ǰû���ֹ����� f(i) = f(i-1) + 1;
 * 2������i���ַ���֮ǰ���ֹ���
 * �����i���ַ������ϴγ���֮��ľ���Ϊd
 * (a)��d <= f(i-1)����˵����i���ַ��ϴγ�����f(i-1)��Ӧ�Ĳ��ظ��ַ���֮�ڣ���ô��ʱ����� f(i) = d
 * (b)��d > f(i-1)������Ӱ��,f(i) = f(i-1) + 1
 * @author Potato
 *
 */
public class LongestSubstringWithoutDuplication {
	
    public int longestSubstringWithoutDuplication(String s) {
    	/**
    	 * �жϱ߽�����
    	 */
    	if(s == null || s.length() <= 0) {
    		return 0;
    	}
    	/**
    	 * ��ǰ���Ⱥ���󳤶�
    	 */
    	int curLength = 0;
    	int maxLength = 0;
    	/**
    	 * ��һ����Ϊ26�����飬���ÿ���ַ��ϴγ������ַ�����λ�õ��±�
    	 */
    	int position [] = new int [26];
    	for (int i = 0; i < position.length; i++) {
    		position[i] = -1;
		}
    	int len = s.length();
    	for (int i = 0; i < len; i++) {
    		/**
    		 * preIndex �ϴγ������ַ�����λ�õ��±�
    		 */
			int preIndex = position[s.charAt(i)-'a'];
			/**
			 * ���Ϊ������-1������֮ǰû�г��ֹ�
			 * ����ϴγ��ֵ�λ���뵱ǰi�Ĳ�ֵ���ڵ�ǰ�ַ����ĳ��ȣ������δ�ڵ�ǰ������Χ�ڵ��ַ������֣����Բ��õ���
			 * ������������ַ������ȼ�һ����
			 */
			if(preIndex < 0 || i - preIndex > curLength) {
				curLength++;
			}else {
				/**
				 * �������ظ����ַ�ʱ�������ǰ���ַ����ȴ�����󳤶ȣ��Ͱ��丳����󳤶�
				 */
				if(curLength > maxLength) {
					maxLength = curLength;
				}
				/**
				 * ������������Ϊ��i���ַ������ϴγ���֮��ľ���
				 * ���ǰ�ǰ���ظ����Ǹ��ַ�֮ǰ�Ĳ��ֲõ�
				 */
				curLength = i - preIndex;
			}
			/**
			 * ��¼���ֵ�λ��
			 */
			position[s.charAt(i)-'a'] = i;
		}
    	return maxLength > curLength ? maxLength : curLength;
        
    }
}
