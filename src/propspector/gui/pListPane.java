package propspector.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class pListPane extends JPanel {

	private static final int LIST_WIDTH = 200;
	private static final int LIST_HEIGHT = 500;

	private JList pList;
	private JScrollPane scroll;

	private JLabel lProperty;
	private JLabel lBuilding;
	private JLabel lFloor;

	public pListPane() {

		this.setLayout(new GridBagLayout());

		GridBagConstraints constraints = null;
		
		// Setup label
		lProperty = new JLabel();

		setProperty("Not Selected");
		lProperty.setHorizontalAlignment(SwingConstants.LEFT);
		lProperty.setVerticalAlignment(SwingConstants.TOP);
		lProperty.setMinimumSize(new Dimension(LIST_WIDTH, 20));
		lProperty.setPreferredSize(new Dimension(LIST_WIDTH, 20));
		lProperty.setMaximumSize(new Dimension(LIST_WIDTH, 20));

		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;

		constraints.anchor = GridBagConstraints.FIRST_LINE_START;

		this.add(lProperty, constraints);

		// Setup label
		lBuilding = new JLabel();

		setBuilding("Not Selected");
		lBuilding.setHorizontalAlignment(SwingConstants.LEFT);
		lBuilding.setVerticalAlignment(SwingConstants.TOP);
		lBuilding.setMinimumSize(new Dimension(LIST_WIDTH, 20));
		lBuilding.setPreferredSize(new Dimension(LIST_WIDTH, 20));
		lBuilding.setMaximumSize(new Dimension(LIST_WIDTH, 20));

		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 1;

		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		
		this.add(lBuilding, constraints);

		// Setup label
		lFloor = new JLabel();

		setFloor(0);
		lFloor.setHorizontalAlignment(SwingConstants.LEFT);
		lFloor.setVerticalAlignment(SwingConstants.TOP);
		lFloor.setMinimumSize(new Dimension(LIST_WIDTH, 20));
		lFloor.setPreferredSize(new Dimension(LIST_WIDTH, 20));
		lFloor.setMaximumSize(new Dimension(LIST_WIDTH, 20));

		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 2;

		constraints.anchor = GridBagConstraints.FIRST_LINE_START;

		this.add(lFloor, constraints);

		// Add items to list model
		DefaultListModel listModel = new DefaultListModel();
		
		// Create list and populate with items from list model
		pList = new JList();
		pList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pList.setLayoutOrientation(JList.VERTICAL);
		pList.setVisibleRowCount(20);
		pList.setFixedCellHeight(25);
		pList.setModel(listModel);
		pList.setBorder(new LineBorder(Color.BLACK, 2));
		
		// Create scroll pane for list
		scroll = new JScrollPane(pList);
		scroll.setMinimumSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
		scroll.setPreferredSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
		scroll.setMaximumSize(new Dimension(LIST_WIDTH, LIST_HEIGHT));
		scroll.setAlignmentX(LEFT_ALIGNMENT);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 3;

		constraints.weightx = 0.0;
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.VERTICAL;

		this.add(scroll, constraints);
	}

	/**
	 * Gets the list
	 * @return The list
	 */
	public JList getList()
	{
		return pList;
	}

	public void setProperty(String property)
	{
		lProperty.setText("Property: " + property);
	}

	public void setBuilding(String building)
	{
		lBuilding.setText("Building: " + building);
	}

	public void setFloor(int floor)
	{
		lFloor.setText("Floor: " + floor);
	}
	
	// TODO: Add appropriate listeners for list
}
