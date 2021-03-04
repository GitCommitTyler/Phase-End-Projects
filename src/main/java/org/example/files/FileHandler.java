package org.example.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.example.Exceptions.InvalidFileNameException;


public class FileHandler {
	
	
	private static String path ;
	private static File dir;

	static{
		
		path = "Example";
		dir = new File(path);
		try {
		if (!dir.exists() && !dir.mkdirs()) throw new IOException("Could not create directory " + dir);
		}catch(IOException i) {
			i.getMessage();
		}
		
		
	}
	
	public static List<String> getFiles() {
		List<String> list = Arrays.asList(dir.list());
		Collections.sort(list);
		return list;
	}
	
	public static int addFile() throws InvalidFileNameException {
		System.out.println("Name file: ");
		String name = new Scanner(System.in).nextLine();
		 final String regex = "[\\w]+[.][\\w]+";
	        final String string = name;
	        

	        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
	        final Matcher matcher = pattern.matcher(string);


	        final boolean result = matcher.find();
	       
		try {
			if(result)
				new File(path+ "\\" + name).createNewFile();
			else 
				throw new InvalidFileNameException(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}catch (InvalidFileNameException ine) {
			System.err.println(ine.getMessage());
			return 1;
		}
		
		return 0;
		
	}
	
	public static int deleteFile() {
		System.out.println("Delete which file: ");
		String name = new Scanner(System.in).nextLine();
		File del = new File(path+ "\\" + name);
		if (del.exists() && del.delete()) System.out.println("File Deleted"); 
		else {
			System.out.println("File not Found");
			return 1;
			}
		return 0;
	}
	
	public static int searchFile() {
		System.out.println("Search for which file?: ");
		List<String> list = Arrays.asList(dir.list());
		Collections.sort(list);
		String name = new Scanner(System.in).nextLine();
		int result = Collections.binarySearch(list, name);
		return result;
		
	}
}
