package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {

	public static void main(String[] args) {

		List<Fruit> flist = new ArrayList<>();
		flist.add(new Apple());


		/*List<? extends Fruit> flist = new ArrayList<Apple>();

		flist.add(new Fruit());*/

	}


}
