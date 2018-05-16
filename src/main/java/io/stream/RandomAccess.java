package io.stream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomAccess {

	private final static String filename = "13366687.jpeg";

	/**
	 * 字节转换为16进制, 8位二进制 -> 2位16进制
	 * @param b
	 * @return
	 */
	public static String toHex(byte b) {
		// Integer为32位, 生成的16进制会有8位
		// byte为8位, 生成的16进制应该为2位
		if(b >= 16) {
			return Integer.toHexString(b);
		} else if (b >= 0 && b <16)
			return "0" + Integer.toHexString(b);
		else {
			return Integer.toHexString(b).substring(6);
		}
	}


	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile(filename, "rw");
		RandomAccessFile binary = new RandomAccessFile("二进制.jpeg", "rw");

		while(true) {
			binary.writeByte(file.readByte());
		}

	}


}
