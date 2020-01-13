package question12;

/**
 * 矩阵中的路径
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 *  例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 *  因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *  
 *  解题思路：
 *  回溯法：
 *  
 * @author Potato
 *
 */

public class HasPath {
	
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
		/**
		 * 边界条件
		 */
		if(matrix == null || str == null || rows <= 0 || cols <= 0 || matrix.length <= 0 || str.length <= 0){
			return false;
		}
		
		/**
		 * Boolean数组用来记录是否走过，pathLength记录有已走路径长度
		 */
		boolean [] visited = new boolean [rows*cols];
		int pathLength = 0;
		
		/**
		 * 从头开始遍历二位数组
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
		 * 如果已走长度和目标长度一样，则算一条成功的路径
		 */
		if(pathLength == str.length) {
			return true;
		}
		
		boolean hasPath = false;
		/**
		 * 如果当前节点符合要求，则遍历其周围的数组
		 */
		if(row >= 0 && row < rows && col >= 0 && col < cols && matrix[row*cols + col] == str[pathLength] && !visited[row*cols + col] ) {
			pathLength++;
			
			visited[row*cols + col] = true;
			
			hasPath = hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited) || 
					  hasPathCore(matrix, rows, cols, row-1, col, str, pathLength, visited) ||
					  hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visited) ||
					  hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visited);
			
			/**
			 * 遍历后所有的路径都走不通，就把当前节点置为没走过，路径长度减一，回溯到上一个节点
			 */
			if(!hasPath) {
				pathLength--;
				visited[row*cols + col] = false;
			}
			
		}
		return hasPath;

	}

}
