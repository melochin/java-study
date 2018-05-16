package exception.exercise;

public class Excericse2 {

	public static void main(String[] args) {

		Object obj = null;
		try {
			obj.getClass();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

}
