package propspector.gui;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;

import java.util.ArrayList;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;

public class pListPane extends JPanel {

	public pListPane()
	{
		Box padding = null;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Setup label
		JLabel label = new JLabel("Property");
		label.setAlignmentX(LEFT_ALIGNMENT);
		label.setAlignmentY(TOP_ALIGNMENT);
		
		this.add(label);
		
		// Create padding between Label component and List component
		padding = new Box(BoxLayout.Y_AXIS);
		this.add(padding.createRigidArea(new Dimension(0,10)));
		
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
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(20);
		list.setFixedCellHeight(25);
		list.setModel(listModel);
		list.setBorder(new LineBorder(Color.BLACK, 2));
		
		// Create scroll pane for list
		JScrollPane scroll = new JScrollPane(list);
		scroll.setAlignmentX(LEFT_ALIGNMENT);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setMinimumSize(new Dimension(200,700));
		
		this.add(scroll);
		
		// Create padding between List component and main panel padding
		padding = new Box(BoxLayout.Y_AXIS);
		this.add(padding.createRigidArea(new Dimension(0,50)));
	}
	
	// TODO: Add appropriate listeners for list
}
