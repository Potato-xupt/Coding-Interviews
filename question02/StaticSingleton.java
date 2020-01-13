package question02;

public class StaticSingleton {
	private StaticSingleton() {
		System.out.println("Creating");
	}
	
	private static class SingletonHolder{
		private static StaticSingleton instance = new StaticSingleton();
	} 
	
	public static StaticSingleton getInstance() {
		return SingletonHolder.instance;
	}

}
