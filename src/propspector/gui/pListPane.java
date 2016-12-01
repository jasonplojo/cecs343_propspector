package propspector.gui;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.ArrayList;

public class pListPane extends JPanel {

	private JList pList;

	public pListPane() {

		this.setLayout(new GridBagLayout());

		GridBagConstraints constraints = null;
		
		// Setup label
		JLabel label = new JLabel("Properties");
		label.setAlignmentX(LEFT_ALIGNMENT);
		label.setAlignmentY(TOP_ALIGNMENT);

		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;

		constraints.ipadx = 0;
		constraints.ipady = 15;

		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		this.add(label, constraints);
		
		// Initialize items for list
		
		// TODO: Re-implement to reading from property, currently a place holder
		ArrayList<String> listItems = new ArrayList<String>();
		listItems.add("Property 1");
		listItems.add("Property 2");
		listItems.add("All your base are belong to us.");
		
		// Add items to list model
		DefaultListModel listModel = new DefaultListModel();
		
		for (String e : listItems)
			listModel.addElement(e);
		
		// Create list and populate with items from list model
		pList = new JList();
		pList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pList.setLayoutOrientation(JList.VERTICAL);
		pList.setVisibleRowCount(20);
		pList.setFixedCellHeight(25);
		pList.setModel(listModel);
		pList.setBorder(new LineBorder(Color.BLACK, 2));
		
		// Create scroll pane for list
		JScrollPane scroll = new JScrollPane(pList);
		scroll.setAlignmentX(LEFT_ALIGNMENT);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//scroll.setMinimumSize(new Dimension(200,700));

		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 1;

		constraints.ipadx = 0;
		constraints.ipady = 15;

		constraints.weightx = 0.0;
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.VERTICAL;

		this.add(scroll, constraints);
	}

	public void updateList(ArrayList<String> list)
	{
		DefaultListModel listModel = new DefaultListModel();

		for (String e : list)
			listModel.addElement(e);

		pList.setModel(listModel);
	}
	
	// TODO: Add appropriate listeners for list
}
