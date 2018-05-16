package lambda;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class SuppilerCase {


	public static void main(String[] args) {
		Random random = new Random(1);

		System.out.println(Collectors.toCollection(() -> Arrays.asList(1, 2, 3, 4)));

	}

}
