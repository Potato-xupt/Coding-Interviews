package question13;

/**
 * �����˵��˶���Χ
 * ��Ŀ����
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 *  ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 *  
 *  ����˼·�����ݷ�
 *  ���ݷ����������жϵ�ǰ�����Ƿ�����ߣ������߾ͼ�����Ȼ��ݹ鵽�������ҵ��������ӣ������������
 *  
 * @author Potato
 *
 */
public class MovingCount {
	
	public int movingCount(int threshold, int rows, int cols){
		/**
		 * �жϱ߽�����
		 */
		if(threshold < 0 || rows <= 0|| cols <= 0) {
			return 0;
		}
		/**
		 * ���ڼ�¼�ø����Ƿ��߹�
		 */
		boolean [] visited = new boolean [rows*cols];
		int count = movingCountCore(threshold,rows,cols,0,0,visited);
		return count;
	}
	
	private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean [] visited) {
		int count = 0;
		/**
		 * ���жϵ�ǰ�����Ƿ�����ߣ�Ȼ���ٵݹ鵽��Χ�ĸ���
		 */
		if(check(threshold,rows,cols,row,col,visited)) {
			/**
			 * ��ǵ�ǰ����Ϊ���߹�
			 */
			visited[row * cols + col] = true;
			count = 1 + movingCountCore(threshold,rows,cols,row-1,col,visited) +
					movingCountCore(threshold,rows,cols,row+1,col,visited) +
					movingCountCore(threshold,rows,cols,row,col+1,visited) +
					movingCountCore(threshold,rows,cols,row,col-1,visited) ;		
		}
		return count;
	}
	
	/**
	 * �жϸø����Ƿ������
	 * @param threshold
	 * @param rows
	 * @param cols
	 * @param row
	 * @param col
	 * @param visited
	 * @return
	 */
	private boolean check(int threshold, int rows, int cols, int row, int col, boolean [] visited) {
		if(row >=0 && row < rows && col >= 0 && col < cols && (getDigitSum(row) + getDigitSum(col)) <= threshold && !visited[row * cols + col]) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * �������ֺ�
	 * @param num
	 * @return
	 */
	private int getDigitSum(int num) {
		int sum = 0;
		while(num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;

	}
}
