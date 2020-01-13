package question13;

/**
 * 机器人的运动范围
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *  例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *  
 *  解题思路：回溯法
 *  回溯法计数，先判断当前格子是否可以走，可以走就计数，然后递归到上下左右的其他格子，计算出总数。
 *  
 * @author Potato
 *
 */
public class MovingCount {
	
	public int movingCount(int threshold, int rows, int cols){
		/**
		 * 判断边界条件
		 */
		if(threshold < 0 || rows <= 0|| cols <= 0) {
			return 0;
		}
		/**
		 * 用于记录该格子是否走过
		 */
		boolean [] visited = new boolean [rows*cols];
		int count = movingCountCore(threshold,rows,cols,0,0,visited);
		return count;
	}
	
	private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean [] visited) {
		int count = 0;
		/**
		 * 先判断当前格子是否可以走，然后再递归到周围的格子
		 */
		if(check(threshold,rows,cols,row,col,visited)) {
			/**
			 * 标记当前格子为已走过
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
	 * 判断该格子是否可以走
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
	 * 计算数字和
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
