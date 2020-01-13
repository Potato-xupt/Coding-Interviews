package question17;

/**
 * ��ӡ��1������nλ��
 * ��Ŀ����
 * ��������n����˳���ӡ����1����nλʮ����������������3�����ӡ��1��2��3һֱ������3λ����999��
 * ����˼·��
 *     ������ת��Ϊ�������еĽⷨ��ʹ�õݹ����ʹ���������ˡ�
 *     ������������е�����ǰ�油0�Ļ����ͻᷢ��nλ���е�ʮ��������ʵ����n����0��9��ȫ���С�
 *     Ҳ����˵�����ǰ����ֵ�ÿһλ����0��9����һ�飬�͵õ������е�ʮ��������
 *     �ڴ�ӡʱ����������ǰ���0����ӡ��
 *     ȫ���еݹ�ʵ�������ס����ֵ�ÿһλ��������0��9��һ������Ȼ��������һλ��
 *     �ݹ�������������������Ѿ����������ֵ����һλ��

 */
public class PrintToMaxOfDigits {
	public void printToMaxOfDigits(int n){
		/**
		 * �߽�����
		 */
		if(n <= 0) {
			return;
		}
		/**
		 * ��ʼ������
		 */
		char [] number = new char [n];
		for (int i = 0; i < n; i++) {
			number[i] = '0';
		}
		/**
		 * ��һλѭ���ӣ������λ���ݹ�
		 */
		for (int i = 0; i < 10; i++) {
			number[0] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, n, 0);
		}
	}
	
	private void printToMaxOfNDigitsRecursively(char [] number, int n, int index) {
		/**
		 * ��������һλ����ʼ��ӡ
		 */
		if(index == n-1) {
			printNumber(number);
			return;
		}
		/**
		 * ѭ�������һλ���ּ�һ��
		 */
		for (int i = 0; i < 10; i++) {
			number[index + 1] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, n, index + 1);
		}

	}
	
	/**
	 * ��ӡ����
	 * @param number
	 */
	private void printNumber(char [] number) {
		boolean isBeginning0 = true;
		for (int i = 0; i < number.length; i++) {
			/**
			 * �ӵ�һ����Ϊ������ֿ�ʼ��ӡ����ǰ���0�����Ե�
			 */
			if(isBeginning0 && number[i]!='0'){
				isBeginning0 = false;
			}
			if(!isBeginning0){
				System.out.print(number[i]);
			}

		}
		System.out.println();

	}
	

}
