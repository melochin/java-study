package generics.exercise5;

public class LinkedStack<T> {

	private class Node {
		T item;
		Node next;
		Node() {
			item = null;
			next = null;
		}
		Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			return this.item == null && this.next == null;
		}
	}

	private Node top = new Node();

	public void push(T item) {
		top = new Node(item, top);
	}

	public T pop() {
		T result = top.item;
		if(!top.end()) {
			top	= top.next;
		}
		return result;
	}

	public static void main(String[] args){

		LinkedStack<String> stack = new LinkedStack<String>();

		for(String str : "1 2 3 4 5 6".split(" ")) {
			stack.push(str);
		}

		String temp = null;
		while((temp = stack.pop()) != null) {
			System.out.println(temp);
		}

	}
}
