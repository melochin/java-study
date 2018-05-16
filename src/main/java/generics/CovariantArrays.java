package generics;

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Banana extends Fruit {
}


public class CovariantArrays {

	public static void main(String[] args) {
		// 编译时检查正常
		// 因为apple[] 数组是Fruit类型，因此 Apple Jonathan Banana都是其子类，应该都可以赋值
		// 运行时异常
		// 因为运行时发现apple[]真正的数据类型是Apple，因此只有Apple的子类可以赋值
		Fruit[] apple = new Apple[10];
		apple[0] = new Apple();
		apple[1] = new Jonathan();
		try {
			apple[2] = new Fruit();
		} catch (ArrayStoreException e) {
			e.printStackTrace();
		}
		try {
			apple[3] = new Banana();
		} catch (ArrayStoreException e) {
			e.printStackTrace();
		}
	}

}
