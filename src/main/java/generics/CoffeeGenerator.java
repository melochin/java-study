package generics;

import java.util.Iterator;
import java.util.Random;

class Coffe {

	private static int counter = 0;
	private final int id = counter++;

	@Override
	public String toString() {
		return getClass().getName() + " : " + id;
	}
}

class Latte extends Coffe {}

class Mocha extends Coffe {}

class Breve extends Coffe {}

public class CoffeeGenerator implements Generator<Coffe>, Iterable<Coffe> {

	private Class[] types = {Latte.class, Mocha.class, Breve.class};

	private Random random = new Random(40);

	private int size = 0;

	public CoffeeGenerator() {}

	public CoffeeGenerator(int size) {
		this.size = size;
	}

	@Override
	public Coffe next() {
		int index = random.nextInt(types.length);
		try {
			return (Coffe) types[index].newInstance();
		} catch (Exception e) {
			// 抛出异常就不需要返回值了
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterator<Coffe> iterator() {
		return new Iterator<Coffe>() {

			int count = CoffeeGenerator.this.size;

			@Override
			public boolean hasNext() {
				return count > 0;
			}

			@Override
			public Coffe next() {
				count--;
				return CoffeeGenerator.this.next();
			}
		};
	}

	public static void main(String[] args) {
		CoffeeGenerator generator = new CoffeeGenerator(5);
		for(Coffe coffe : generator) {
			System.out.println(coffe);
		}
	}

}
