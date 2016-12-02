package propspector.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class pHelpMenu extends JMenu{
	
	public pHelpMenu(){
		
		ActionListener listener = null;
		JMenuItem item = null;
		
		// Generate menu items
		this.setText("Help");
		
		// TODO: Create the rest of the menu items for Help
		
		// Create Generate Summary
		item = new JMenuItem("You Are On Your Own");

		this.add(item);

		item = new JMenuItem("About");
		listener = new lAbout();
		item.addActionListener(listener);
		this.add(item);
	}
	
	///////////////
	// LISTENERS //
	///////////////
	
	// TODO: Create the listener that corresponds to menu items added
	
	/**
	 * Listener for Generate Summary menu item
	 */
	private class lAbout implements ActionListener{
		
		// TODO: Implement task...
		@Override
		public void actionPerformed(ActionEvent event){
			System.out.println("About has been clicked");
			JOptionPane pane = new JOptionPane("Eric Downie\nCarl Jason Plojo\nTyren V\n, Aaron");
		}
		
	}
}
