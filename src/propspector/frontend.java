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
		
		frame.setVisible(true);
	}
}