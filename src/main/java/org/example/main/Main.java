package org.example.main;
import org.example.files.FileHandler;
import org.example.input.InputHandler;
import org.example.menu.*;

public class Main {
	public static void main(String[] args) {
		new FileHandler();
		MenuStack.update();
		InputHandler.takeInput();
	}
}
