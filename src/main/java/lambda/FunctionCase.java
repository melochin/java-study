package lambda;

import java.util.function.Function;

public class FunctionCase {

	private Function<Integer, String> integerToString =
			i -> String.valueOf(i);

	private Function<String, Integer> stringToInteger =
			s -> Integer.valueOf(s);

	public String toString(Integer integer) {
		// Integer -> String
		return integerToString.apply(integer);
	}

	public String toString(String string) {
		// String -> Integer -> String
		return integerToString.compose(stringToInteger).apply(string);
	}

	public Integer toInteger(String string) {
		// String -> String
		return stringToInteger.apply(string);
	}

	public Integer toInteger(Integer integer) {
		// Integer -> String -> Integer
		return integerToString.andThen(stringToInteger).apply(integer);
	}

	public static void main(String[] args) {

		FunctionCase functionCase = new FunctionCase();

		System.out.println(functionCase.toInteger(new String("1")));
		System.out.println(functionCase.toInteger(new Integer("1")));

		System.out.println(functionCase.toString(new Integer(1)));
		System.out.println(functionCase.toString(new String("1")));

	}

}
