package generics;

public class LinkedStack<T> {

	private class Node<U> {
		U item;
		Node<U> next;
		Node() {
			item = null;
			next = null;
		}
		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}

		boolean end() {
			return this.item == null && this.next == null;
		}
	}

	private Node<T> top = new Node<T>();

	public void push(T item) {
		top = new Node<T>(item, top);
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
