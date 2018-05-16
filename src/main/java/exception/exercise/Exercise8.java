package exception.exercise;

public class Exercise8 {

	public static void throwException () throws Exception {
		Object object = null;
		object.getClass();
	}


	public static void main(String[] args) {
		try {
			throwException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
