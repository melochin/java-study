package io.stream;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class StringInputStream {

	private InputStream inputStream;

	public StringInputStream(InputStream fileInputStream) {
		this.inputStream = fileInputStream;
	}

	public String read() throws IOException {
		StringBuilder result = new StringBuilder();

		BufferedInputStream input = new BufferedInputStream(
				inputStream, 1024 * 1024);

		while(true) {
			byte[] bytes = new byte[1024];
			int size = input.read(bytes, 0, 1024);
			if(size == -1) break;
			result.append(new String(Arrays.copyOf(bytes, size)));
		}

		return result.toString();
	}

}
