package io.stream;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class StreamTest {

	public static void main(String[] args) throws IOException {

		String content = "222";
		String result = pipedOutAndIn(content);
		System.out.println(result);

		System.out.println(readFromFile("pom.xml"));
		System.out.println(sequenceConvert());
	}

	private static String pipedOutAndIn(String content) throws IOException {
		PipedOutputStream out = new PipedOutputStream();
		PipedInputStream in = new PipedInputStream(out);
		out.write(content.getBytes());

		byte[] bytes = new byte[1024];
		in.read(bytes);

		return new String(bytes);
	}

	private static String readFromFile(String name) throws IOException {
		FileInputStream inputStream = new FileInputStream(name);
		StringInputStream stringInputStream = new StringInputStream(inputStream);
		return stringInputStream.read();
	}

	public static String sequenceConvert() throws IOException {
		SequenceInputStream inputStream = new SequenceInputStream(
				new FileInputStream("pom.xml"), new FileInputStream("thinkinginjava.iml"));
		return new StringInputStream(inputStream).read();
	}


}

