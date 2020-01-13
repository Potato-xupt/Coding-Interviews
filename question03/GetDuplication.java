package question03;

/**
 * 不修改数组找出重复的数字
 * 分治法  二分
 * 把1~n的数字从中间数字m分成两部分，若前一半1~m的数字数目超过m个，说明重复数字在前一半区间，否则，在后半区间m+1~n。每次在区间中都一分为二，知道找到重复数字。
 * 
 * @author Potato
 *
 */
public class GetDuplication {
	
	public int getDuplication(int [] numbers,int length) {
		/**
		 * 边界条件判断
		 */
		if(numbers == null || length <= 0) {
			return -1;
		}
		
		int start = 1;
		int end = length - 1;
	
		while(end >= start) {
			/**
			 * 取中间值，采用位运算更快。
			 * >> 1 为除 2
			 * << 1 为乘 2
			 */
			int middle = ((end - start) >> 1) + start;
			int count = countRange(numbers,length,start,middle);
			
			if(end == start) {
				/**
				 * 如果end == start相等，而且期间范围内的数字大于一个，则肯定有重复数字
				 * 否则肯定没有重复数字
				 */
				if(count > 1) {
					return start;
				}else {
					break;
				}
			}
			/**
			 * 如果start和end的范围内的数字个数大于他的范围，则重复数字在前半段
			 * 否则重复数字在后半段
			 */
			if(count > (middle - start + 1)) {
				end = middle;
			}else {
				start = middle + 1;
			}
		}
		
		return -1;
	}
	
	public int countRange(int [] numbers,int length,int start,int end) {
		
		int count = 0;
		/**
		 * 遍历整个数组，计数在start和end的范围内的数字有多少个
		 */
		for(int i = 0;i<length;++i) {
			if(numbers[i] >= start && numbers[i] <= end){
				count++;
			}
		}
		return count;
	}
	
	
	// ==================================测试代码==================================
    /**
     *数组为null
     */
    public void test1() {
        System.out.print("test1：");
        int[] a = null;
        int dup = getDuplication(a,0);
        System.out.println(dup);
    }
 
    /**
     *数组数字越界
     */
    public void test2() {
        System.out.print("test2：");
        int[] a = { 1, 2, 3, 4 };
        int dup = getDuplication(a,a.length);
        System.out.println(dup);
    }
 
    /**
     *数组带重复数字
     */
    /**
     * 
     */
    public void test3() {
        System.out.print("test3：");
        int[] a = { 1, 2, 3, 2, 4 };
        int dup = getDuplication(a,a.length);
        if (dup >= 0)
            System.out.println("重复数字为：" + dup);
    }
 
    public static void main(String[] args) {
    	GetDuplication f2 = new GetDuplication();
        f2.test1();
        f2.test2();
        f2.test3();
    }
}
