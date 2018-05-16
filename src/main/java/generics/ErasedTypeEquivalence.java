package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErasedTypeEquivalence {

	public static void main(String[] args) {

		List<String> stringList = new ArrayList<>();
		List<Integer> integerList = new ArrayList<>();

		System.out.println(stringList.getClass().equals(integerList.getClass()));
		System.out.println(stringList.getClass());
		System.out.println(Arrays.toString(stringList.getClass().getTypeParameters()));
	}

}
