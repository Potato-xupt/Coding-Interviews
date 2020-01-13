package question44;
/**
 * 数字序列中的某一位数字
 * 题目描述
 * 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位。
 * 
 * 解题思路：
 * 以第1001位数字7为例
 * 步骤1：首先确定该数字是属于几位数的;
 * 如果是一位数，n<9;如果是两位数，n<9+90*2=189;如果是三位数，n<189+900*3=2889;说明是三位数。
 * 步骤2：确定该数字属于哪个数。
 * 100+(1001-190)/3= 370。
 * 步骤3：确定是该数中哪一位。
 * 1001-190-(370-100)*3 = 1,所以位于“370”的下标为1的位置，即数字7。

 * @author Potato
 *
 */
public class DigitAtIndex {
    public int digitAtIndex(int index) {
    	/**
    	 * 边界条件判断
    	 */
        if(index < 0) {
        	return -1;
        }
        /**
         * 0-9位全部都是一位数，直接返回对应数字即可
         */
        if(index < 10) {
        	return index;
        }
        /**
         * digits代表位数，一位数上面已经判断过，从两位数字开始判断
         */
        int digits = 2;
        /**
         * 先把0-9这十个数字减去
         */
        index -= 10;
        while(true) {
        	/**
        	 * 得到digits位数字共有多少个
        	 * 2位数则是10的1次方乘9 = 90
        	 * 3位数则是10的2次方乘9 = 900
        	 * 4位数则是10的3次方乘9 = 9000        	 
        	 * 
        	 */
        	long numbers = 9*beginNumber(digits);
        	/**
        	 * 如果第 index位不在在范围内则进入范围查找，否则index减去不在范围内的数字，位数+1
        	 */
        	if(index < numbers*digits) {
        		return digitAtIndex(index,digits);
        	}else {
        		index -= numbers*digits;   		
        		digits++;
        	}
        }
    }

    /**
     * 返回digits位数字的第一个数字
     * 2 -> 10
     * 3 -> 100
     * 4 -> 1000
     * @param digits
     * @return
     */
	private long beginNumber(int digits) {
		return (long) Math.pow(10, digits-1);
	}
	

	private int digitAtIndex(int index, int digits) {
		/**
		 * 找到index坐标所在的数字
		 */
		long number = beginNumber(digits) + (index / digits);
		/**
		 * 从这个数字里找相对应的坐标
		 */
		int indexFromRight = digits - (index % digits);
		for (int i = 1; i < indexFromRight; i++) {
			number/=10;
		}
		return (int)number%10;
	}

}
