package generics;

public class ArrayMaker<T> {

	private Class<T> kind;

	public ArrayMaker(Class<T> kind) {
		System.out.println(kind.getName());
		this.kind = kind;
	}

	T create()  {
		try {
			return kind.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		ArrayMaker arrayMaker = new ArrayMaker(String.class);
		System.out.println(arrayMaker.create().getClass());
	}

}
