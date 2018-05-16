package exception;

public class ExceptionMessage {

	public static void main(String[] args) {
		try {
			throw new Exception("My exception");
		} catch (Exception e) {
			System.out.println("getMessage() : " +
					e.getMessage());

			System.out.println("getLocalizedMessage() : " +
					e.getLocalizedMessage());

			System.out.println("toString() : " + e);

			System.out.print("printStackTrace() : ");
			e.printStackTrace(System.out);
		}
	}

}
