package question58;

/**
 * ����ת�ַ���
 * �ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
 * �붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ�
 * ���������ַ���"abcdefg"������2���ú�������������ת2λ�õ��Ľ��"cdefgab"��
 * 
 * ����˼·��
 * ����nΪ���ȣ����ַ�������Ϊǰ�������֣�����������ӣ�����Ϊab��cdefg������
 * Ȼ����������ֱַ�ת�����Ϊ��bagfedc
 * Ȼ��������ַ�����ת���������Ľ����cdefgab
 * 
 * ͬ�����Ҫ������ת�ַ���
 * ���Ȱ������ַ�����ת��Ȼ��ֱ�ת�������־�����
 * 
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class LeftRotateString {
	
    public String LeftRotateString(String str,int n) {
    	/**
    	 * �߽������ж�
    	 */
        if(str == null || str.length() <= 0 || n <= 0 || n >=str.length()) {
        	return str;
        }
        /**
         * �ַ���תΪ����
         */
        char [] s = str.toCharArray();
        /**
         * ��תǰ�벿��
         */
        Reverse(s,0,n-1);
        /**
         * ��ת��벿��
         */
        Reverse(s,n,s.length-1);
        /**
         * ��תȫ��
         */
        Reverse(s,0,s.length-1);
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
