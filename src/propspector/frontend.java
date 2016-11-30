package propspector;

import propspector.gui.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frontend {
	
	// Frame and panel properties
	private static final int FRAME_WIDTH = 1024;
	private static final int FRAME_HEIGHT = 768;
	
	public static void main(String[] args) {
		
		// Initialize frame
		JFrame frame = new JFrame("Propspector");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initialize Top Menu Bar
		JMenuBar menuBar = new JMenuBar();
		
		menuBar.add(new pFileMenu());
		menuBar.add(new pEditMenu());
		menuBar.add(new pHelpMenu());
		
		frame.setJMenuBar(menuBar);
		
		// Initialize main panel
		System.out.print("Initializing main panel...");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		frame.add(mainPanel);
		System.out.println("done!");
		
		JPanel panel = null;
		GridBagConstraints constraints = null;
		
		////////////////
		// LIST PANEL //
		////////////////
		
		// Add List Panel
		System.out.print("Initializing list panel...");
		panel = new pListPane();
		panel.setMinimumSize(new Dimension(200, 700));
		panel.setBorder(new LineBorder(Color.BLACK, 2)); // For debugging
		
		// Set constraints for list panel
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.BOTH;
		
		mainPanel.add(panel, constraints);
		System.out.println("done!");
		
		//////////////////
		// BUTTON PANEL //
		//////////////////
		
		// Add Button Panel
		// TODO: Implement button panel functionality

		System.out.print("Initializing button panel...");
		panel = new JPanel();
		panel.setMinimumSize(new Dimension(100,600));
		panel.setBorder(new LineBorder(Color.BLACK, 2));
		
		constraints = new GridBagConstraints();
		constraints.weightx = 0.5;
		constraints.weighty = 0.5;
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.BOTH;
		
		mainPanel.add(panel, constraints);
		System.out.println("done!");
		
		//////////////////
		// DETAIL PANEL //
		//////////////////
		
		// Add Detail Panel
		// TODO: Implement detail panel functionality

		System.out.print("Initializing detail panel...");
		panel = new JPanel();
		panel.setMinimumSize(new Dimension(100,100));
		panel.setBorder(new LineBorder(Color.BLACK, 2));

		constraints = new GridBagConstraints();
		constraints.weightx = 0.5;
		constraints.weighty	= 0.5;
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.BOTH;

		mainPanel.add(panel, constraints);
		System.out.println("done!");
		
		////////////////////
		// OPTION 1 PANEL //
		////////////////////
		
		// Add Option 1 Panel
		// TODO: Implement option 1 panel functionality
		System.out.print("Initializing option 1...");
		panel = new JPanel();
		panel.setMinimumSize(new Dimension(100,100));
		panel.setBorder(new LineBorder(Color.BLACK, 2));

		constraints = new GridBagConstraints();
		constraints.weightx = 0.5;
		constraints.weighty = 0.5;
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.BOTH;

		mainPanel.add(panel, constraints);
		System.out.println("done!");
		
		////////////////////
		// OPTION 2 PANEL //
		////////////////////
		
		// Add Option 2 Panel
		// TODO: Implement option 2 panel functionality
		System.out.print("Initializing option 2...");
		panel = new JPanel();
		panel.setMinimumSize(new Dimension(100, 100));
		panel.setBorder(new LineBorder(Color.BLACK, 2));

		constraints = new GridBagConstraints();
		constraints.weightx = 0.5;
		constraints.weighty = 0.5;
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.BOTH;

		mainPanel.add(panel, constraints);
		System.out.println("done!");

		frame.setVisible(true);
	}
}