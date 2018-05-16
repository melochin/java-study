package exception.exercise;

public class Excercise3 {

	public static void main(String[] args) {
		int[] ints = new int[1];
		try {
			ints[1] = 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace(System.out);
		}
	}

}
