package question02;
/**
 * ����ʽ ����ģʽ
 * @author Potato
 *
 */
public final class Singleton1 {
	/**
	 * ˽�л����췽����ʹ�ø����޷����ڲ�ͨ�� new ����ʵ����
	 */
	private Singleton1() {}
	
	/**
	 * ׼��һ�������ԣ�ָ��һ��ʵ����������Ϊ�������ԣ�����ֻ��һ����
	 */
	private static Singleton1 instance = new Singleton1();
	
	/**
	 * public static�������ṩ�������߻�ȡ12�ж���Ķ���
	 * @return
	 */
	public static Singleton1 getInstance() {
		return instance;
	}
	
}
