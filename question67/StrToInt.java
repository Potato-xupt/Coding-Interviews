package question67;

/**
 * ���ַ���ת��������
 * ��Ŀ����
 * ��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�����string����������Ҫ��ʱ����0)��
 * Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
 * 
 * ����˼·��
 * ����������ɣ�����int��Χ����0
 * @author Potato
 *
 */
@SuppressWarnings("all")
public class StrToInt {
	
    public int StrToInt(String str) {
    	/**
    	 * �жϱ߽�����
    	 */
    	 if(str == null || str.length() <= 0) {
    		 return 0;
    	 }
    	 /**
    	  * ��long���ͼ�¼������������
    	  */
    	 long result = 0;
    	 /**
    	  * ��¼�Ƿ�Ϊ����
    	  */
    	 boolean isNegative = (str.charAt(0)=='-');
    	 
    	 /**
    	  * �����ַ���
    	  */
    	 for (int i = 0; i < str.length(); i++) {
    		char c = str.charAt(i);
    		/**
    		 * ��������ַ���Ϊ����λ��������
    		 */
			if(i == 0 && (c == '-' || c == '+') ) {
				continue;
			}
			/**
			 * ��������ַ��ҷ����֣��Ƿ����룬����0
			 */
			if(c > '9' || c < '0') {
				return 0;
			}
			/**
			 * ��¼���
			 */
			result = result*10 + (c-'0');
			/**
			 * �ж��Ƿ�Խ�磬Խ�׷���0
			 */
			if( (isNegative && result > (long)Integer.MAX_VALUE+1) || (!isNegative && result > Integer.MAX_VALUE) ) {
				return 0;
			}
		}
    	 /**
    	  * ����Ǹ����ͼ��Ϸ���
    	  */
    	 return isNegative ? (int)-result : (int)result;
    }

}
