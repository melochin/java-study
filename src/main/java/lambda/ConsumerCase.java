package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerCase {

	private static Consumer<Integer> print = integer -> {
		System.out.println(integer);
	};

	private static Consumer<Integer> printZero = integer -> {
		if(integer % 2 == 0) {
			System.out.println(0);
		}
	};

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

		System.out.println("first consumer");
		list.forEach(print);

		System.out.println("second consumer");
		list.forEach(print.andThen(printZero));
	}


}
