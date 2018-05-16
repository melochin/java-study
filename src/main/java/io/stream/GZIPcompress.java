package io.stream;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {

	private final static String filename = "二进制.txt";

	private final static String outfile = "gzip.txt";

	/**
	 * 将文件进行gzip压缩
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedInputStream input = new BufferedInputStream(
				new FileInputStream(filename));

		BufferedOutputStream output = new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream(outfile)));

		try{
			while (true) {
				byte[] btyes = new byte[1024*1024*100];
				int count = input.read(btyes);
				if(count == -1) break;
				output.write(btyes, 0, count);
			}
		} catch (EOFException e) {

		} finally {
			input.close();
			output.close();
		}
	}

}
