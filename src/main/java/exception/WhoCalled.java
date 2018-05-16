package exception;

public class WhoCalled {

	public static void frame1() throws Exception {
		throw new Exception();
	}

	public static void frame2() throws Exception {
		frame1();
	}

	public static void frame3() throws Exception {
		frame2();
	}

	public static void printTraceInfo(StackTraceElement element) {
		System.out.println("trace method : " + element.getMethodName());
		System.out.println("trace element : " + element);
	}


	public static void main(String[] args) {
		try {
			frame3();
		} catch (Exception e) {
			for(StackTraceElement element : e.getStackTrace()) {
				printTraceInfo(element);
			}
		}

		try {
			frame2();
		} catch (Exception e) {
			for(StackTraceElement element : e.getStackTrace()) {
				printTraceInfo(element);
			}
		}
	}

}
