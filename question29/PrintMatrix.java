package question29;

import java.util.ArrayList;
/**
 * ˳ʱ���ӡ����
 * ��Ŀ����
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * ����˼·��
 * ��1���������ң��϶��У�
 * ��2�����ϵ��£�������������Ϊ2��������ֹ�кű��������ʼ�кţ����ﲻ���Ե���Ŷ�����������������Ͻǵ�Ԫ���ظ����ӡһ�Σ���
 * ��3���������󣺾�������Ϊ�������У�������ֹ�кű��������ʼ�кţ�������ֹ�кű��������ʼ�кţ�ͬ���������Ե��ڣ�����������½ǵ�Ԫ�ػ���ӡһ�Σ���
 * ��4�����µ��ϣ���������Ϊ�������У�������ֹ�кű������ʼ�кŴ�2��������ֹ�кű��������ʼ�кţ�ͬ���������Ե��ڣ������������½Ǻ����Ͻ�Ԫ�ض��ӡһ�Σ�
 * 
 * @author Potato
 *
 */
public class PrintMatrix {

	public ArrayList<Integer> printMatrix(int [][] matrix) {
		/**
		 * �߽������ж�
		 */
		if(matrix == null ) {
			return null;			
		}
		ArrayList<Integer> result = new ArrayList<>(matrix.length);
		if(matrix.length <= 0 || matrix[0].length <= 0) {
			return result;
		}
		/**
		 * start�Ǵ�ÿһȦ�����Ͻǿ�ʼ��
		 */
		int start = 0;
		/**
		 * ����������������ȷ��ÿһȦ�ھ����ڣ��ж�while��ѭ������
		 * ��Ϊcolumns > start*2 && rows > start*2
		 */
		int columns = matrix[0].length;
		int rows = matrix.length;
		while(columns > start*2 && rows > start*2) {
			/**
			 * ������һȦ�ı߽�ֵ
			 */
			int endX = columns - 1 - start;
			int endY = rows - 1 - start;
			/**
			 * �������ң��϶���
			 */
			for (int i = start; i <= endX ; i++) {
				result.add(matrix[start][i]);
			}
			
			/**
			 * ���ϵ��£�������������Ϊ2��������ֹ�кű��������ʼ�кţ����ﲻ���Ե���Ŷ�����������������Ͻǵ�Ԫ���ظ����ӡһ�Σ�
			 */
			if(start < endY) {
				for (int i = start + 1; i <= endY ; i++) {
					result.add(matrix[i][endX]);
				}
			}
			/**
			 * �������󣺾�������Ϊ�������У�������ֹ�кű��������ʼ�кţ�������ֹ�кű��������ʼ�кţ�ͬ���������Ե��ڣ�����������½ǵ�Ԫ�ػ���ӡһ�Σ�
			 */
			if(start < endX && start < endY) {
				for (int i = endX - 1; i >= start ; i--) {
					result.add(matrix[endY][i]);
				}
			}
			/**
			 * ���µ��ϣ���������Ϊ�������У�������ֹ�кű������ʼ�кŴ�2��������ֹ�кű��������ʼ�кţ�ͬ���������Ե��ڣ������������½Ǻ����Ͻ�Ԫ�ض��ӡһ�Σ�
			 */
			if(start < endX && start < endY - 1) {
				for (int i = endY - 1; i >= start + 1; i--) {
					result.add(matrix[i][start]);
				}
			}
			/**
			 * ���м���СһȦ
			 */
			start++;
		}
		
		return result;
	       
    }

}
