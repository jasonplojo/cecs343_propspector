package propspector;

import propspector.gui.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frontend {
	
	// Frame and panel properties
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	
	public static void main(String[] args) {
		
		// Initialize frame
		JFrame frame = new JFrame("Propspector");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		// Initialize Top Menu Bar
		JMenuBar menuBar = new JMenuBar();
		
		menuBar.add(new pFileMenu());
		menuBar.add(new pEditMenu());
		menuBar.add(new pHelpMenu());
		
		frame.setJMenuBar(menuBar);
		
		// Initialize main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		frame.add(mainPanel);
		frame.setVisible(true);
		
		JPanel panel = null;
		GridBagConstraints constraints = null;
		
		////////////////
		// LIST PANEL //
		////////////////
		
		// Add List Panel
		panel = new pListPane();
		panel.setPreferredSize(new Dimension(100, 600));
		//panel.setBorder(new LineBorder(Color.BLACK, 2)); // For debugging
		
		// Set constraints for list panel
		constraints = new GridBagConstraints();
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		
		mainPanel.add(panel, constraints);
		
		//////////////////
		// BUTTON PANEL //
		//////////////////
		
		// Add Button Panel
		// TODO: Implement button panel functionality
		
		//////////////////
		// DETAIL PANEL //
		//////////////////
		
		// Add Detail Panel
		// TODO: Implement detail panel functionality
		
		////////////////////
		// OPTION 1 PANEL //
		////////////////////
		
		// Add Option 1 Panel
		// TODO: Implement option 1 panel functionality
		
		////////////////////
		// OPTION 2 PANEL //
		////////////////////
		
		// Add Option 2 Panel
		// TODO: Implement option 2 panel functionality
	}
}