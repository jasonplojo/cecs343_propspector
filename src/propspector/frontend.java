package propspector;

import propspector.gui.*;
import propspector.gui.res.pModifyPane;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frontend {

	// Frame and panel properties
	private static final int FRAME_WIDTH = 1024;
	private static final int FRAME_HEIGHT = 768;

	private static final int FRAME_PADDING = 20;

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
		mainPanel.setBorder(BorderFactory.createEmptyBorder(FRAME_PADDING, FRAME_PADDING, FRAME_PADDING, FRAME_PADDING));
		
		frame.add(mainPanel);
		System.out.println("done!");

		GridBagConstraints constraints = null;

		///////////////////
		// LAYOUT PANELS //
		///////////////////

		// Add left layout panel to main panel
		System.out.print("Initializing layout panels...");
		JPanel lPanel = new JPanel();
		lPanel.setLayout(new GridBagLayout());
		lPanel.setBorder(new LineBorder(Color.BLACK, 2));

		// Set constraints for left layout panel
		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;

		constraints.fill = GridBagConstraints.BOTH;

		mainPanel.add(lPanel, constraints);

		// Add right layout panel to main panel
		JPanel rPanel = new JPanel();
		rPanel.setLayout(new GridBagLayout());
		rPanel.setBorder(new LineBorder(Color.BLACK, 2));

		// Set constraints for right layout panel
		constraints = new GridBagConstraints();

		constraints.gridx = 1;
		constraints.gridy = 0;

		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.BOTH;

		mainPanel.add(rPanel, constraints);
		System.out.println("done!");

		////////////////
		// LIST PANEL //
		////////////////

		// Add List Panel
		System.out.print("Initializing list panel...");
		pListPane listPanel = new pListPane();
		listPanel.setBorder(new LineBorder(Color.ORANGE, 2)); // For debugging
		
		// Set constraints for list panel
		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;

		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.BOTH;
		
		lPanel.add(listPanel, constraints);
		System.out.println("done!");
		
		//////////////////
		// BUTTON PANEL //
		//////////////////
		
		// Add Button Panel
		// TODO: Implement button panel functionality

		System.out.print("Initializing button panel...");
		pButtonPane buttonPanel = new pButtonPane();
		buttonPanel.setBorder(new LineBorder(Color.ORANGE, 2));

		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;

		constraints.fill = GridBagConstraints.BOTH;

		// Setup button panel listeners
		buttonPanel.getBackButton().addActionListener(new lBackButton());
		buttonPanel.getCreateButton().addActionListener(new lCreateButton());
		buttonPanel.getDeleteButton().addActionListener(new lDeleteButton());
		buttonPanel.getModifyButton().addActionListener(new lModifyButton());

		rPanel.add(buttonPanel, constraints);
		System.out.println("done!");
		
		//////////////////
		// DETAIL PANEL //
		//////////////////
		
		// Add Detail Panel
		// TODO: Implement detail panel functionality

		System.out.print("Initializing detail panel...");
		JPanel detailPanel = new JPanel();
		detailPanel.setBorder(new LineBorder(Color.ORANGE, 2));

		constraints = new GridBagConstraints();

		constraints.gridx = 1;
		constraints.gridy = 0;

		constraints.fill = GridBagConstraints.BOTH;

		rPanel.add(detailPanel, constraints);
		System.out.println("done!");
		
		//////////////////
		// MODIFY PANEL //
		//////////////////

		// Add Modify Panel
		// TODO: Implement option 1 panel functionality
		System.out.print("Initializing Modify panel...");
		JPanel modifyPanel = new pModifyPane();
		modifyPanel.setBorder(new LineBorder(Color.ORANGE, 2));

		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 1;

		constraints.fill = GridBagConstraints.BOTH;

		rPanel.add(modifyPanel, constraints);
		System.out.println("done!");
		
		////////////////////
		// OPTION 2 PANEL //
		////////////////////
		
		// Add Option 2 Panel
		// TODO: Implement option 2 panel functionality
		System.out.print("Initializing option 2...");
		JPanel conditionPanel = new JPanel();
		conditionPanel.setBorder(new LineBorder(Color.ORANGE, 2));

		constraints = new GridBagConstraints();

		constraints.gridx = 1;
		constraints.gridy = 1;

		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.BOTH;

		rPanel.add(conditionPanel, constraints);
		System.out.println("done!");

		frame.setVisible(true);
	}

	///////////////
	// LISTENERS //
	///////////////

	private static class lBackButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Back button pressed");
		}
	}

	private static class lCreateButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Create button pressed");
		}
	}

	private static class lDeleteButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Delete button pressed");
		}
	}

	private static class lModifyButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Modify button pressed");
		}
	}

}