package com.threads.general.main;

import javax.swing.SwingUtilities;

import com.threads.general.userview.View;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new View("Increament Demo");
			}
			
		});
	}
}
