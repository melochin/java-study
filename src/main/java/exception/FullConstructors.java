package exception;

import javax.swing.plaf.synth.SynthOptionPaneUI;

class MyException extends Exception {

	public MyException() {
		super();
	}

	public MyException(String msg) {
		super(msg);
	}

}

public class FullConstructors {

	public static void throwWithNoMsg() throws MyException {
		throw new MyException();
	}

	public static void throwWithMsg(String msg) throws MyException {
		throw new MyException(msg);
	}

	public static void main(String[] args) {
		try {
			throwWithNoMsg();
		} catch (MyException e) {
			e.printStackTrace(System.err);
		}
		try {
			throwWithMsg("throw exception");
		} catch (MyException e) {
			e.printStackTrace(System.err);
		}
	}

}
