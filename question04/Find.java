package question04;
/**
 * ��Ŀ����
   *��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
   *����˼·��
   *�����Ͻǿ�ʼ���ң����target���ڸ������򷵻�true��С�ڸ���������һ�м������ң����ڸ���������һ�м������ҡ�
 * @author Potato
 *
 */
public class Find {
	 public boolean find(int target, int [][] array) {
		 /**
		  * �жϱ߽�����
		  */
		 if(array == null || array.length<= 0 || array[0].length<=0){
			 return false;
		 }
		 /**
		  * �����Ͻǿ�ʼ
		  */
		 int rows = 0;
		 int column = array[0].length - 1;
		 
		 while(rows < array.length && column >= 0) {
			 /**
			  * �����ȣ�ֱ�ӷ���true
			  */
			 if(array[rows][column] == target) {
				 return true;
			 }else if(array[rows][column] > target) {
				 /**
				  * �������target��������һ�м�������
				  */
				 column--;
			 }else {
				 /**
				  * ���С��target��������һ�м�������
				  */
				 rows++;
			 }
		 }
		 return false;
	 }
}
