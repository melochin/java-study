package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateCase {

	private static Predicate<Integer> evenFilter = i -> i % 2 == 0;

	private static Predicate<Integer> threeFilter = i -> i % 3 == 0;

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println(
				list.stream()
						.filter(evenFilter)
						.collect(Collectors.toList())
		);

		System.out.println(
				list.stream()
						.filter(evenFilter.and(threeFilter))
						.collect(Collectors.toList())
		);

		System.out.println(
				list.stream()
						.filter(evenFilter.or(threeFilter))
						.collect(Collectors.toList())
		);

		System.out.println(
				list.stream()
						.filter(evenFilter.negate())
						.collect(Collectors.toList())
		);

	}




}
