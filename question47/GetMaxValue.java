package question47;
/**
 * ���������ֵ
 * ��Ŀ����
 * ��һ��m��n�����̵�ÿһ�񶼷���һ�����ÿ�����ﶼ��һ���ļ�ֵ����ֵ����0����
 * ����Դ����̵����Ͻǿ�ʼ�ø�����������ÿ�����һ��������ƶ�һ��ֱ���������̵����½ǡ�
 * ����һ�����̼������������������������õ����ټ�ֵ�����
 * 
 * ����˼·����̬�滮
 * ����f(i,j)Ϊ����(i,j)λ�ø���ʱ���õ��������ܺ͵����ֵ�����У�f(i,j)=max{f(i,j),f(i,j)}+values(i,j)��
 * �������鲻�ú�m*n�Ķ�ά����һ����ֻ��Ҫ������һ������ֵ�Ϳ��ԡ�������ʹ�ó���Ϊ����n��һλ������Ϊ��������
 * @author Potato
 *
 */
public class GetMaxValue {
    public int getMaxValue(int[][] grid) {
    	/**
    	 * �߽������ж�
    	 */
        if(grid == null || grid.length <= 0 || grid[0].length <= 0) {
        	return 0;
        }
        /**
         * ��һ����Ϊ��������������һ���еĲ������ݺ���һ���еĲ�������
         * j������ǵ�i�е����֣���0��j-1������ֵ
         * j�Լ�j���ұ���i-1�е����֣���j��cols-1������ֵ
         */
        int [] maxValues= new int [grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				/**
				 * left�ǵ�ǰ������ߵ�����ֵ
				 * up�������ϱߵ�����ֵ
				 */
				int left = j>0 ? maxValues[j-1] : 0;
				int up = i>0 ? maxValues[j] : 0;
				/**
				 * �������ߺ��ϱ߽ϴ���Ǹ���Ȼ������Լ�������ֵ���ŵ����������
				 * ���ǽ�ֹ���������λ�õ�����ֵ
				 */
				maxValues[j] = Math.max(left, up)+grid[i][j];
			}
		}
        /**
         * ֱ�����������鶼���꣬�������½ǵ����֡�
         */
        return maxValues[grid[0].length-1];
    }
}