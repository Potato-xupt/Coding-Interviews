package question20;

/**
 * ��ʾ��ֵ���ַ���
 * 
 * ��Ŀ����
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ�� ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 * 
 * ����˼·��
 * �����ֵ���ʽ�ܽ�Ϊ��(A.B E/e A) ,��˳������жϣ�A���������������B������������������
 * 
 * or������ʽ�ⷨ��return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
 * 
 * @author Potato
 *
 */
public class IsNumeric {

	public boolean isNumeric(char[] str) {
		/**
		 * �߽�����
		 */
		if(str ==null || str.length == 0) {
			return false;
		}
		/**
		 * ������һ������Ϊһ��������Ϊ�±�ı�־����Ϊ�����int�Ļ����������������еľ���ֵ�������鴫��������ã����Կɸı�
		 */
		int [] index = new int [1];
		index[0] = 0;
		
		/**
		 * ���ж�С����֮ǰ�Ĳ����Ƿ������
		 */
		boolean isNumeric;
		isNumeric = isInteger(str,index);
		
		/**
		 * �����С���㣬���ж�С����֮��Ĳ���
		 */
		if(index[0] < str.length && str[index[0]] == '.') {
			index[0]++;
			isNumeric = isUnsignedInteger(str, index) || isNumeric;
		}
		
		/**
		 * �����ָ�������ж�ָ����־E|| e ֮��Ĳ���
		 */
		if(index[0] <str.length && (str[index[0]] == 'e' || str[index[0]] == 'E') ) {
			index[0]++;
			isNumeric = isInteger(str, index) && isNumeric;
		}
		
		/**
		 * �����Ƿ�����Լ��Ƿ�����ȫ��
		 */
		if(isNumeric && index[0] == str.length) {
			return true;
		}
		return false;
	}

	private boolean isInteger(char[] str, int[] index) {
		/**
		 * ���������ţ��ж��޷�������
		 */
		if(index[0]<str.length && (str[index[0]] == '+' || str[index[0]] == '-') ) {
			index[0]++;
		}
		return isUnsignedInteger(str, index);
	}

	private boolean isUnsignedInteger(char[] str, int[] index) {
		/**
		 * �ж��Ƿ���������Ĳ���
		 */
		int start = index[0];
		while(index[0] < str.length && (str[index[0]] >= '0' && str[index[0]] <= '9') ) {
			index[0]++;
		}
		if(index[0] > start) {
			return true;
		}
		return false;
	}
}
