package question02;

/**
 * ����ʽ����ģʽ
 * ��ͬ�ڶ���ʽ��ֻ���ڵ���getInstance��ʱ�򣬲Żᴴ��ʵ��
 * @author Potato
 *
 */
public final class Singleton2 {
	private Singleton2() {}
	
	private static Singleton2 instance;
	
	public static Singleton2 getInstance() {
		/**
		 * ��һ�η��ʵ�ʱ�򣬷���û��instance��ʵ����������ʵ����һ������
		 */
		if(null == instance) {
			instance = new Singleton2();
		}
		return instance;
	}
}
