package question02;

/**
 * 懒汉式单例模式
 * 不同于饿汉式，只有在调用getInstance的时候，才会创建实例
 * @author Potato
 *
 */
public final class Singleton2 {
	private Singleton2() {}
	
	private static Singleton2 instance;
	
	public static Singleton2 getInstance() {
		/**
		 * 第一次访问的时候，发现没有instance的实例对象，所以实例化一个对象。
		 */
		if(null == instance) {
			instance = new Singleton2();
		}
		return instance;
	}
}
