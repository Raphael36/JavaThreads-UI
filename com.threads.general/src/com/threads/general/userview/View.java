package com.threads.general.userview;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Counts implements Runnable {

	@Override
	public void run() {
		
		for(int i = 0; i <= 1000; i++) {
			
			if(i == 0) {
				View.statusLabel.setText("Task Started!!");
				View.startButton.setEnabled(false);
			}
			
			View.count.setText(i + "");
			
			if(i == 1000) {
				View.statusLabel.setText("Task Completed.");
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			if(i == 1000) {
				View.startButton.setEnabled(true);
			}
			
		}
	}

}

public class View extends JFrame{

	static JLabel count = new JLabel("0");
	static JLabel statusLabel = new JLabel("Task not completed.");
	static JButton startButton = new JButton("Start");
	
	public View(String title) {
		super(title);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		add(count, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		add(statusLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		add(startButton, gc);
		
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ExecutorService executor = Executors.newSingleThreadExecutor();
				executor.execute(new Counts());
				}
			
		});
		
		setSize(200, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		}
		
}
