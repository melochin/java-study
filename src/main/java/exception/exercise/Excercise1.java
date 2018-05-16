package exception.exercise;

public class Excercise1 {


	public static void main(String[] args) {

		try{
			throw new RuntimeException("exception");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finally");
		}

	}


}
