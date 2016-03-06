package tutorial.java.test;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Welcome");
		int result = addition(1, 2);
		System.out.println(result);
		
		Geocoder geo = new Geocoder();
		String info = geo.call("Brussels");
		
		System.out.println(info);
	}

	public static int addition(int num, int num2) {
		return num + num2;
	}

}
