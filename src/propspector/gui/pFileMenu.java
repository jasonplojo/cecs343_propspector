package propspector.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class pFileMenu extends JMenu{
	
	public pFileMenu(){
		
		ActionListener listener = null;
		JMenuItem item = null;
		
		// Generate menu items
		this.setText("File");
				
		// Create Generate Summary
		item = new JMenuItem("Generate Summary");
		listener = new generateSummary();
		item.addActionListener(listener);
		this.add(item);
				
		// Create Import Property...
		item = new JMenuItem("Import Property...");
		listener = new importProperty();
		item.addActionListener(listener);
		this.add(item);
		
		// Create Export Property...
		item = new JMenuItem("Export Property...");
		listener = new exportProperty();
		item.addActionListener(listener);
		this.add(item);
		 
		// Create Close Property
		item = new JMenuItem("Close Property");
		listener = new closeProperty();
		item.addActionListener(listener);
		this.add(item);
		
		// Create Exit
		item = new JMenuItem("Exit");
		listener = new exitApp();
		item.addActionListener(listener);
		this.add(item);
	}
	
	///////////////
	// LISTENERS //
	///////////////
	
	/**
	 * Listener for Generate Summary menu item
	 */
	private class generateSummary implements ActionListener{
		
		// TODO: Implement task to generate summary
		@Override
		public void actionPerformed(ActionEvent event){
			System.out.println("Generate Summary has been clicked");
		}
		
	}
	
	/**
	 * Listener for Import Property menu item
	 */
	private class importProperty implements ActionListener{
		
		// TODO: Implement task to import property
		@Override
		public void actionPerformed(ActionEvent event){
			System.out.println("Import Property has been clicked");
		}
		
	}
	
	/**
	 * Listener for Export Property menu item
	 */
	private class exportProperty implements ActionListener{
		
		// TODO: Implement task to generate summary
		@Override
		public void actionPerformed(ActionEvent event){
			System.out.println("Export Property has been clicked");
		}
		
	}
	
	/**
	 * Listener for Close Property menu item
	 */
	private class closeProperty implements ActionListener{
		
		// TODO: Implement task to generate summary
		@Override
		public void actionPerformed(ActionEvent event){
			System.out.println("Close Property has been clicked");
		}
		
	}
	
	/**
	 * Listener for Exit menu item
	 */
	private class exitApp implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event){
			System.out.println("Exit has been clicked");
			
			System.exit(0);
		}
		
	}
}
