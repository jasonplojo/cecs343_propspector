package propspector.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class pEditMenu extends JMenu{
	
	public pEditMenu(){
		
		ActionListener listener = null;
		JMenuItem item = null;
		
		// Generate menu items
		this.setText("Edit");
		
		// TODO: Create the rest of the menu items for Edit
		
		// Create Generate Summary
		item = new JMenuItem("Place Holder");
		listener = new generateSummary();
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
	private class generateSummary implements ActionListener{
		
		// TODO: Implement task...
		@Override
		public void actionPerformed(ActionEvent event){
			System.out.println("Place Holder has been clicked");
		}
		
	}
}
