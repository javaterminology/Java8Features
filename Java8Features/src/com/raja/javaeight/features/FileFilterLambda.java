package com.raja.javaeight.features;

import java.io.File;
import java.io.FileFilter;

public class FileFilterLambda {

	public static void main(String[] args) {

		//using anonymous class
		/*
		 * FileFilter filter = new FileFilter() {
		 * 
		 * @Override public boolean accept(File file) { return
		 * file.getName().endsWith(".java"); } };
		 */
		
		//using Lambda
		FileFilter fileFilterLambda = (f) -> f.getName().endsWith(".java");
		
		File fileDir = new File("D:\\Projects\\Hazelcast\\Java8Features\\src\\com\\raja\\javaeight\\features");
		
		File[] files = fileDir.listFiles(fileFilterLambda);
		
		for(File file : files) {
			
			System.out.println(file.getName());
			
		}
	}
	
	

	
}
