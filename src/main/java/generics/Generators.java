package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Generators {

	public static <T> Collection<T> fill(
			Collection<T> collection, Generator<T> generator, int size) {
		for(int i=0; i<size; i++) {
			collection.add(generator.next());
		}
		return collection;
	}

	public static <T> Collection<T> fill(
			Collection<T> collection) {
		return collection;
	}

	public static void main(String[] args) {
		Generators.fill(new ArrayList<>(), new CoffeeGenerator(), 10)
				.forEach((coffe -> System.out.println(coffe)));
	}

}
