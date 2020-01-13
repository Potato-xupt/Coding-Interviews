package question47;
/**
 * 礼物的最大价值
 * 题目描述
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 * 
 * 解题思路：动态规划
 * 定义f(i,j)为到达(i,j)位置格子时能拿到的礼物总和的最大值，则有：f(i,j)=max{f(i,j),f(i,j)}+values(i,j)。
 * 辅助数组不用和m*n的二维数组一样大，只需要保存上一层的最大值就可以。代码中使用长度为列数n的一位数组作为辅助数组
 * @author Potato
 *
 */
public class GetMaxValue {
    public int getMaxValue(int[][] grid) {
    	/**
    	 * 边界条件判断
    	 */
        if(grid == null || grid.length <= 0 || grid[0].length <= 0) {
        	return 0;
        }
        /**
         * 用一个长为列数的数组存放这一行中的部分数据和上一行中的部分数据
         * j的左边是第i行的数字，从0到j-1的最大价值
         * j以及j的右边是i-1行的数字，从j到cols-1的最大价值
         */
        int [] maxValues= new int [grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				/**
				 * left是当前坐标左边的最大价值
				 * up是坐标上边的最大价值
				 */
				int left = j>0 ? maxValues[j-1] : 0;
				int up = i>0 ? maxValues[j] : 0;
				/**
				 * 计算出左边和上边较大的那个，然后加上自己本身的值，放到这个坐标上
				 * 就是截止到这个坐标位置的最大价值
				 */
				maxValues[j] = Math.max(left, up)+grid[i][j];
			}
		}
        /**
         * 直到把整个数组都走完，返回右下角的数字。
         */
        return maxValues[grid[0].length-1];
    }
}
