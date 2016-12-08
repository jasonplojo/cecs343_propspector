package propspector.gui;

import java.awt.event.ActionListener;

import javax.swing.*;

public class pHelpMenu extends JMenu{

	private JMenuItem about;
	
	public pHelpMenu(){
		
		ActionListener listener = null;
		JMenuItem item = null;
		
		// Generate menu items
		this.setText("Help");
		
		// TODO: Create the rest of the menu items for Help
		
		// Create Generate Summary
		item = new JMenuItem("You Are On Your Own");

		this.add(item);

		about = new JMenuItem("About");
		this.add(about);
	}

	public JMenuItem getAbout()
	{
		return about;
	}

}
