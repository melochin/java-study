package generics;

import java.util.ArrayList;
import java.util.List;

public class NonCovariantGenerics {

	// 编译异常： 类型不兼容
	// Fruit的List不仅能装Fruit而且还有其子类
	// 并不是单单的Apple子类
	// 因此两者不等价，即使Apple是Fruit的子类
	// List<Fruit> flist = new ArrayList<Apple>();

}
