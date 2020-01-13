package question02;

public class Singleton {
	private static Singleton INSTANCE = null;
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static Singleton getInstance() {
		if(null == INSTANCE) {
			synchronized (INSTANCE) {
				if(null == INSTANCE) {
					INSTANCE = new Singleton();
				}
			}
		}
		return INSTANCE;
	}

}
