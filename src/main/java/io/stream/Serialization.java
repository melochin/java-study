package io.stream;

import java.io.*;

public class Serialization {

	private static final String outfile = "serialize-out.txt";

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Person person = new Person();
		person.setName("test");

		// 输出流——序列化到文件（持久化）
		ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream(outfile));
		output.writeObject(person);
		output.close();

		// 输入流——从文件读取反序列
		ObjectInputStream input = new ObjectInputStream(
				new FileInputStream(outfile));
		Person converPerson = (Person) input.readObject();
		input.close();
		System.out.println(converPerson);
	}

}

class Person implements Serializable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}
}
