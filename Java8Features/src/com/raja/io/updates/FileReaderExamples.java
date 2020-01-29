package com.raja.io.updates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderExamples {

	public static void main(String[] args) {
		
		try(BufferedReader br = new BufferedReader(new FileReader("d://Rajasekhar//Raja.txt"))){
			
			Stream<String> stream = br.lines();
			
			stream.filter(line -> line.contains("SEKHAR"))
			.findFirst()
			.ifPresent(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//Reading files more easier using Files.lines() method without bufferedReader/file reader
		//try with resources and use of Paths
		Path path = Paths.get("d:", "Rajasekhar","Raja.txt");
		//Stream implements AutoCloseable, and will close underlying file
		try(Stream<String> stream = Files.lines(path)){
			stream.filter(line -> line.contains("REDDY"))
			.findFirst()
			.ifPresent(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Reading directory entries
		Path path1 = Paths.get("d:", "Rajasekhar");
		try(Stream<Path> stream = Files.list(path1)){
			stream.filter(path2 -> path2.toFile().isDirectory())
			.forEach(System.out::println);
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------------");
		//To visit whole subtree use Files.walk(path) method
		//Files.walk(path,2(depth of directory))
				Path path2 = Paths.get("d:", "Rajasekhar");
				try(Stream<Path> stream = Files.walk(path2,2)){
					stream.filter(path3 -> path3.toFile().isDirectory())
					.forEach(System.out::println);
				}catch(IOException e) {
					e.printStackTrace();
				}

		
		
	}

}
