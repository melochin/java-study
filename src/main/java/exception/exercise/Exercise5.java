package exception.exercise;

public class Exercise5 {

	private static int count = 0;

	public static void main(String[] args) {

		try {
			doJob();
		} catch (RuntimeException e) {
			while(true) {
				try {
					recover();
					break;
				} catch (RuntimeException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	public static void doJob() {
		throw new RuntimeException();
	}

	public static void recover() {
		count++;
		if(count < 4) throw new RuntimeException("恢复异常失败");
	}


}
