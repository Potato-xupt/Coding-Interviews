	package question05;
	/**
	 *�滻�ո�
	 *��Ŀ����
	 *��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
	 *����˼·��
	 *�����ַ������������ж��ٸ��ո�*2 + ԭ���� �ó��滻��ĳ���
	 *���ַ������ݣ����ҴӺ���ǰ������˫ָ�룬p1ָ��ԭ�ַ���β����p2ָ���滻���ַ������ȵ�β��λ�á�
	 *p1 p2ͬʱ��ǰ�ƶ��������ǿո�Ͱ�p1λ�õ��ַ��ƶ���p2λ�á������ո��p2�滻Ϊ"%20"��ֱ��p1 p2�������� p1����0
	 * @author Potato
	 *
	 */

public class ReplaceSpace {
	 public String replaceSpace(StringBuffer str) {
		 /**
		  * ʹ��java���÷����ⷨ��
		  * return str.toString().replaceAll(" ", "%20");
		  */
		 
		 /**
		  * �жϱ߽�����
		  */
		 if(str == null || str.length() < 0){
	            return null;
	        }
		 if(str.length() == 0){
	            return "";
	     }
	     
		 /**
		  * �Կո����
		  */
	     int len = str.length();
	     int numberOfBlank = 0;
	     for(int i = 0;i<len;i++){
	    	 
	    	 if(str.charAt(i) == ' '){
	    		 numberOfBlank++;
	         }
	    	 
	     }
	        

	     /**
	      * �������ݺ�Ĵ�С��������
	      *
	      */
	     int afterLen = len + numberOfBlank*2;
	     str.setLength(afterLen);
	     int p1 = len-1;
	     int p2 = afterLen-1;
	     
	     /**
	      * �����ַ�����p1 p2ͬʱ��ǰ�ƶ��������ǿո�Ͱ�p1λ�õ��ַ��ƶ���p2λ�á������ո��p2�滻Ϊ"%20"��ֱ��p1 p2�������� p1����0
	      */
	     while( p1>=0 && p2>p1){
	         if(str.charAt(p1) == ' '){
	             str.setCharAt(p2--,'0');
	             str.setCharAt(p2--,'2');
	             str.setCharAt(p2--,'%');
	             p1--;
	         }else{
	             str.setCharAt(p2--,str.charAt(p1--));
	         }
	     }
	     return str.toString();
	    	
	 }
}
