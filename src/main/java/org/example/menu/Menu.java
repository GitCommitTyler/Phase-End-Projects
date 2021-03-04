package org.example.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class Menu {
	
	List<String> data;
	List<String> options;
	
	public void getOptions() {
		System.out.println("Press (1) for options");
	}
	
	public void showData() {
		System.out.print("Currrently showing: ");
	}
	
	public abstract void selectOptions(int option);
	
	public void returnToMain() {
		
	}
}
