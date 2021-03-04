package org.example.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.example.files.FileHandler;
import org.example.input.InputHandler;

public class FileScreen extends Menu {
	
	
	public FileScreen() {
		data = new ArrayList<String>(Arrays.asList("File Screen" 
												   ));
		
		options = new ArrayList<String>(Arrays.asList("(Press 2) Get files in order",
													  "(Press 3) Add/Delete/Search Files",
													  "(Press 4) Return"));
	}
	
	public void getOptions() {
		super.showData();
		System.out.println("Options");
		options.forEach(System.out::println);
	}
	
	public void showData() {
		super.showData();
		data.forEach(System.out::println);
		super.getOptions();
		
	}
	
	@Override
	public void selectOptions(int option) {
		switch(option) {
			case(2):
				System.out.println(FileHandler.getFiles());
				MenuStack.update();
				break;
			case(3):
				System.out.print("(Press 2) Add File\n(Press 3) Delete File\n(Press 4) Search File\nInput Command: ");
				Scanner sc1 = new Scanner(System.in);
				switch(sc1.nextInt()) {
					case(2):
						if(FileHandler.addFile() == 1)
							System.out.println("File not added");
						else 
							System.out.println("File added successfully");
						break;
					case(3):
						if (FileHandler.deleteFile() ==1)
							System.out.println("Deletion failed");
						break;
					case(4):
						int result = FileHandler.searchFile();
						if ( result < 0)
							System.out.println("Not found");
						else
							System.out.println("Found: " + FileHandler.getFiles().get(result));
						break;
					default: 
						System.out.println("Invalid Command");
						break;
				}
				break;
			case(4):
				MenuStack.backTrack();
				break;
			default:
				System.out.println("Invalid command");
				break;
		}
	}
}
