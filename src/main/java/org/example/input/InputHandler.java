package org.example.input;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.example.menu.FileScreen;
import org.example.menu.MenuStack;

public class InputHandler {
	public static void takeInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input Command: ");
		try {
			int in = sc.nextInt();
			if(in == 1) {
				MenuStack.currentScreen.getOptions();
			}
			else {
				MenuStack.currentScreen.selectOptions(in);
			}
			takeInput();
		}
        catch(InputMismatchException ime) {
        	System.out.println("Input a number");
        	System.out.println("----------------------------------------------------------------------------------------");
            //ime.printStackTrace();
        	MenuStack.update();
        	takeInput();	
        }
		
	}
	
	public static void manipulateFiles() {
		MenuStack.changeScreen(new FileScreen());
	}
	

}
