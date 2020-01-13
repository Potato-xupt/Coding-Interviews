package question58;
/**
 * ��ת����˳����
 * ��Ŀ����
 * ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣
 * Ϊ������������ź���ͨ��ĸһ������
 * ���������ַ���"I am a student."�������"student. a am I"��
 * 
 * ����˼·��
 * �ȷ�ת�������ӣ�Ȼ���ٷ�תÿ������
 * ��ĿӦ����һ���������������ǲ����ö���Ŀռ䡣
 * ��Ȼ Java ����Ŀ�������Ϊ String ���ͣ���Ҫ�ȴ���һ���ַ�����ʹ�ÿռ临�Ӷ�Ϊ O(N)��
 * ������ȷ�Ĳ�������Ӧ�ú�ԭ��һ����Ϊ�ַ����飬����ֻ��ʹ�ø��ַ�����Ŀռ䡣
 * �κ�ʹ���˶���ռ�Ľⷨ������ʱ�������ۿۣ������ݹ�ⷨ��
 * 
 * ��ת���Ӽ򵥣�������λ�ַ�����λ��
 * ��η�ת���ʾ����ҵ����ʵ���λλ�ã���ת����
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class ReverseSentence {

	
    public String ReverseSentence(String str) {
    	/**
    	 * �߽������ж�
    	 */
    	if(str == null || str.length() <= 0) {
    		return str;
    	}
    	/**
    	 * ���ַ��ַ�������ת��Ϊ�ַ����飬��Ϊ����Ӧ�����ַ�����ģ�����ţ�����ṩ�����ַ������Ͱ���ת������ͺ���
    	 */
    	char [] s = str.toCharArray();
    	/**
    	 * ��ת�����ַ�����
    	 */
    	Reverse(s,0,str.length()-1);

    	/**
    	 * Ȼ��ʼ��ת����
    	 */
    	int start = 0;
    	int end = 0;
    	while(end <= s.length) {
    		/**
    		 * ���end�����ո�����ߵ��������һ��λ�ã�����end�ߵ��˵��ʵĽ���
    		 * �Ͱ�������ʷ�תһ��
    		 */
    		if(end == s.length || s[end] == ' ') {
    			/**
    			 * ��ת�������
    			 */
    			Reverse(s,start,end-1);
    		/**
    		 * Ȼ��end++�͵�����һ�����ʵĵ�һλ��start����֮���ͣ����
    		 */
    			end++;
    			start = end;    			
    		}else {
    			/**
    			 * end�������ҵ��ʽ�����λ��
    			 */
    			end++;
    		}
    	}
    	/**
    	 * ���ַ�����ת��Ϊ�ַ�������
    	 */
    	return new String(s);
        
    }

	private void Reverse(char [] s, int start, int end) {
		/**
		 * ���Ͻ�����λ�ַ���λ�þ�����
		 */
		while(start < end) {
			char temp = s[start];
			s[start++] =s[end];
			s[end--] = temp;		
		}
		
	}
}
