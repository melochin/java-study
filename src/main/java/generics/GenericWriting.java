package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {

	static <T> void writeExact(List<T> list, T item) {
		list.add(item);
	}

	static List<Fruit> fruits = new ArrayList<Fruit>();

	static void f1() {
		writeExact(fruits, new Apple());
	}

}
