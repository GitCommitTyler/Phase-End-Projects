package org.example.menu;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

import org.example.files.FileHandler;

public class WelcomeScreen extends Menu{
	public WelcomeScreen() {
		data = new ArrayList<String>(Arrays.asList("Home Screen", 
												   "Welcome to Virtual Key", 
												   "Developed by Tyler"
												   ));
		
		options = new ArrayList<String>(Arrays.asList("(Press 2) Get files in order",
													  "(Press 3) Manipulate Files",
													  "(Press 4) Exit"));
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
				MenuStack.changeScreen(new FileScreen());
				break;
			case(4):
				System.out.println("Exiting");
				System.exit(0);
			default:
				System.out.println("Invalid command");
				break;
		}
	}
}
