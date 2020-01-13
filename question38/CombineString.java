package question38;

import java.util.ArrayList;
/**
 * �ַ������
 * ��Ŀ��{a,b,c}Ҫ�����{a,b,c,ab,ac,bc,abc}��
 * ����˼·��
 * ��Ϊ������⣬����3��Ԫ�ص���Ͼ���2^3-1�֣����Բ��������ǽ��б�ţ�
 * ������������⣬��a����abcһ�α��Ϊ 001����111��1�ʹ����λ�ó����ַ���
 * ���磺001->c,010->b,101->ac......������ԭ�����Ҫ�����"001"-"111"��2^n-1����϶�Ӧ���ַ�����
 * @author Potato
 *
 */
public class CombineString {
	
	public ArrayList<String> combineString(String s){
		ArrayList<String> result = new ArrayList<>();
		/**
		 * �жϱ߽�����
		 */
		if(s == null || s.length() <= 0) {
			return result;
		}
		int len = s.length();
		/**
		 * ��������ж��������
		 */
		int count = 1 << len;
		/**
		 *��001��ʼһֱ��111..
		 */
		for (int i = 1; i < count; i++) {
			String temp = "";
			/**
			 * �����������
			 */
			String str = Integer.toBinaryString(i);
			/**
			 * �Ѷ�����ǰ���λ����0
			 */
			while(str.length() < len) {
				str = "0" + str;
			}
			/**
			 * ����������Ķ������ַ���
			 */
			for (int j = 0; j < str.length(); j++) {
				/**
				 * ����1�Ͱ����ϳ��´�
				 */
				if(str.charAt(j) == '1') {
					temp += s.charAt(j);
				}
			}
			result.add(temp);
		}
		return result;
	
	}
}
