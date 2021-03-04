package org.example.menu;

import java.util.Stack;

import org.example.input.InputHandler;



public class MenuStack {
	public static Stack<Menu> menuStack = new Stack<Menu>();
	public static Menu currentScreen = new WelcomeScreen();
	

	public static void changeScreen(Menu menu ) {
		menuStack.push(currentScreen);
		currentScreen = menu;
		update();
	}
	
	public static void backTrack() {
		
		currentScreen = menuStack.pop();
		update();
	}
	
	public static void update() {
		System.out.println("----------------------------------------------------------------------------------------");
		currentScreen.showData();
		InputHandler.takeInput();
	}
}
