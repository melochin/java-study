package io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TreeInfo {

	private List<File> flies = new ArrayList<>();

	private List<File> dirs = new ArrayList<>();

	public void addAll(TreeInfo info) {
		this.flies.addAll(info.getFlies());
		this.dirs.addAll(info.getDirs());
	}

	public List<File> getFlies() {
		return flies;
	}

	public void setFlies(List<File> flies) {
		this.flies = flies;
	}

	public List<File> getDirs() {
		return dirs;
	}

	public void setDirs(List<File> dirs) {
		this.dirs = dirs;
	}

	public static TreeInfo recur(File startDir, String regex) {
		TreeInfo treeInfo = new TreeInfo();
		for(File file : startDir.listFiles()) {
			if (file.isDirectory()) {
				treeInfo.getDirs().add(file);
				treeInfo.addAll(recur(file, regex));
			} else if (file.getName().matches(regex)){
				treeInfo.getFlies().add(file);
			}
		}
		return treeInfo;
	}

	@Override
	public String toString() {
		return "TreeInfo{" +
				"flies=" + flies +
				", dirs=" + dirs +
				'}';
	}

	public static void main(String[] args) {
		System.out.println(TreeInfo.recur(new File("."), ".*"));
	}

}
