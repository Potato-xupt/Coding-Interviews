package question12;

/**
 * �����е�·��
 * ��Ŀ����
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ�
 *  ���� a b c e s f c s a d e e ������3 X 4 �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·����
 *  ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 *  
 *  ����˼·��
 *  ���ݷ���
 *  
 * @author Potato
 *
 */

public class HasPath {
	
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
		/**
		 * �߽�����
		 */
		if(matrix == null || str == null || rows <= 0 || cols <= 0 || matrix.length <= 0 || str.length <= 0){
			return false;
		}
		
		/**
		 * Boolean����������¼�Ƿ��߹���pathLength��¼������·������
		 */
		boolean [] visited = new boolean [rows*cols];
		int pathLength = 0;
		
		/**
		 * ��ͷ��ʼ������λ����
		 */
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if(hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean [] visited) {
		/**
		 * ������߳��Ⱥ�Ŀ�곤��һ��������һ���ɹ���·��
		 */
		if(pathLength == str.length) {
			return true;
		}
		
		boolean hasPath = false;
		/**
		 * �����ǰ�ڵ����Ҫ�����������Χ������
		 */
		if(row >= 0 && row < rows && col >= 0 && col < cols && matrix[row*cols + col] == str[pathLength] && !visited[row*cols + col] ) {
			pathLength++;
			
			visited[row*cols + col] = true;
			
			hasPath = hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited) || 
					  hasPathCore(matrix, rows, cols, row-1, col, str, pathLength, visited) ||
					  hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visited) ||
					  hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visited);
			
			/**
			 * ���������е�·�����߲�ͨ���Ͱѵ�ǰ�ڵ���Ϊû�߹���·�����ȼ�һ�����ݵ���һ���ڵ�
			 */
			if(!hasPath) {
				pathLength--;
				visited[row*cols + col] = false;
			}
			
		}
		return hasPath;

	}

}
