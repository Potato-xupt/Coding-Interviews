package question02;
/**
 * 饿汉式 单例模式
 * @author Potato
 *
 */
public final class Singleton1 {
	/**
	 * 私有化构造方法，使得该类无法在内部通过 new 进行实例化
	 */
	private Singleton1() {}
	
	/**
	 * 准备一个类属性，指向一个实例化对象。因为类是属性，所以只有一个。
	 */
	private static Singleton1 instance = new Singleton1();
	
	/**
	 * public static方法，提供给调用者获取12行定义的对象。
	 * @return
	 */
	public static Singleton1 getInstance() {
		return instance;
	}
	
}
