package io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {

	public static void main(String[] args) {
		File path = new File(".");
		String[] list = path.list(
				(dir, name) -> Pattern.matches("\\w*[.]\\w+", name));
		System.out.println(Arrays.asList(list));
	}

}
