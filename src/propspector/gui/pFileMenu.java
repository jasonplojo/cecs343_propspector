package propspector.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class pFileMenu extends JMenu{

	private JMenuItem generateSummary;
	private JMenuItem importProperty;
	private JMenuItem exportProperty;
	private JMenuItem closeProperty;
	private JMenuItem exitApp;

	public pFileMenu(){
		
		// Generate menu items
		this.setText("File");

		generateSummary = new JMenuItem("Generate Summary");
		importProperty = new JMenuItem("Import Property...");
		exportProperty = new JMenuItem("Export Property...");
		//closeProperty = new JMenuItem("Close Property");
		exitApp = new JMenuItem("Exit");

		generateSummary.addActionListener(new lGenerateSummary());
		exitApp.addActionListener(new lExitApp());

		this.add(generateSummary);
		this.add(importProperty);
		this.add(exportProperty);
		//this.add(closeProperty);
		this.add(exitApp);
	}

	public JMenuItem getImportProperty()
	{
		return importProperty;
	}

	public JMenuItem getExportProperty()
	{
		return exportProperty;
	}

	///////////////
	// LISTENERS //
	///////////////

	/**
	 * Listener for Generate Summary menu item
	 */
	private class lGenerateSummary implements ActionListener{

		String dlc = "Pre-order the Generate Summary DLC!" +
				"\n20% off if purchased in the year 2016!";
		@Override
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(null, dlc, "Feature Coming Soon", JOptionPane.PLAIN_MESSAGE);
			System.out.println("here");
		}
		
	}
	
	/**
	 * Listener for Exit menu item
	 */
	private class lExitApp implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event){
			System.out.println("Exit has been clicked");
			
			System.exit(0);
		}
		
	}
}
