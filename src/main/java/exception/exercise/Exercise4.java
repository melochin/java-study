package exception.exercise;


class MyException extends Exception {

	private String message;

	MyException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}


public class Exercise4 {

	public static void main(String[] args) {
		try {
			throw new MyException("my exception");
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}
}
