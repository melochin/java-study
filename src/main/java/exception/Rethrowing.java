package exception;

public class Rethrowing {

	public static void frame1() throws Exception {
		throw new Exception();
	}

	public static void frame2WithFill() throws Exception {
		try {
			frame1();
		} catch (Exception e) {
			e.fillInStackTrace();
			throw e;
		}
	}

	public static void frame2() throws Exception {
		try {
			frame1();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void main(String[] args) {
		try {
			frame2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			frame2WithFill();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			throw new RuntimeException();
		} finally {
			return;
		}
	}

}
