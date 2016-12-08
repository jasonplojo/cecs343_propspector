package propspector;

import propspector.gui.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

public class frontend {

	public static void main(String[] args) {
		new frontend();
	}

	// Frame and panel properties
	private static final int FRAME_WIDTH = 1024;
	private static final int FRAME_HEIGHT = 768;

	private static final int FRAME_PADDING = 20;

	private JFrame frame;

	private JPanel mainPanel;
	private JPanel lPanel;
	private JPanel rPanel;

	private pListPane listPanel;
	private pButtonPane buttonPanel;
	private pModifyPane modifyPanel;

	private enum displayState { PROPERTY, BUILDING, FLOOR, ROOM }

	private ArrayList<property> properties;
	private property cProperty;
	private building cBuilding;
	private floor cFloor;

	displayState state;

	public frontend()
	{
		setupFrame();
		setupListPanel();
		setupButtonPanel();
		setupDetailPanel();
		setupModifyPanel();
		setupConditionPanel();

		properties = new ArrayList<property>();

		state = displayState.PROPERTY;

		frame.setVisible(true);
	}

	///////////////
	// FUNCTIONS //
	///////////////
	private void setupFrame()
	{
		// Initialize frame
		frame = new JFrame("Propspector");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initialize Top Menu Bar
		JMenuBar menuBar = new JMenuBar();

		pFileMenu fileMenu = new pFileMenu();
		fileMenu.getExportProperty().addActionListener(new lExportProperty());
		fileMenu.getImportProperty().addActionListener(new lImportProperty());

		menuBar.add(fileMenu);
		menuBar.add(new pEditMenu());
		menuBar.add(new pHelpMenu());

		frame.setJMenuBar(menuBar);

		// Initialize main panel
		System.out.print("Initializing main panel...");
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(FRAME_PADDING, FRAME_PADDING, FRAME_PADDING, FRAME_PADDING));

		frame.add(mainPanel);
		System.out.println("done!");

		GridBagConstraints constraints = null;

		///////////////////
		// LAYOUT PANELS //
		///////////////////

		// Add left layout panel to main panel
		System.out.print("Initializing layout panels...");
		lPanel = new JPanel();
		lPanel.setLayout(new GridBagLayout());
		//lPanel.setBorder(new LineBorder(Color.BLACK, 2));

		// Set constraints for left layout panel
		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;

		constraints.fill = GridBagConstraints.BOTH;

		mainPanel.add(lPanel, constraints);

		// Add right layout panel to main panel
		rPanel = new JPanel();
		rPanel.setLayout(new GridBagLayout());
		//rPanel.setBorder(new LineBorder(Color.BLACK, 2));

		// Set constraints for right layout panel
		constraints = new GridBagConstraints();

		constraints.gridx = 1;
		constraints.gridy = 0;

		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.BOTH;

		mainPanel.add(rPanel, constraints);
		System.out.println("done!");
	}

	private void setupListPanel()
	{
		////////////////
		// LIST PANEL //
		////////////////

		// Add List Panel
		System.out.print("Initializing list panel...");
		listPanel = new pListPane();
		//listPanel.setBorder(new LineBorder(Color.ORANGE, 2)); // For debugging

		// Set constraints for list panel
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;

		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.BOTH;

		lPanel.add(listPanel, constraints);
		System.out.println("done!");
	}

	private void setupButtonPanel()
	{
		// Add Button Panel
		System.out.print("Initializing button panel...");
		buttonPanel = new pButtonPane();

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;

		constraints.fill = GridBagConstraints.BOTH;

		// Setup button panel listeners
		buttonPanel.getBackButton().addActionListener(new lBackButton());
		buttonPanel.getCreateButton().addActionListener(new lCreateButton());
		buttonPanel.getDeleteButton().addActionListener(new lDeleteButton());
		buttonPanel.getModifyButton().addActionListener(new lModifyButton());

		buttonPanel.getBackButton().setVisible(false);
		rPanel.add(buttonPanel, constraints);
		System.out.println("done!");
	}

	private void setupDetailPanel()
	{
		//////////////////
		// DETAIL PANEL //
		//////////////////

		// Add Detail Panel
		// TODO: Implement detail panel functionality

		System.out.print("Initializing detail panel...");
		JPanel detailPanel = new JPanel();
		//detailPanel.setBorder(new LineBorder(Color.ORANGE, 2));

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 1;
		constraints.gridy = 0;

		constraints.fill = GridBagConstraints.BOTH;

		rPanel.add(detailPanel, constraints);
		System.out.println("done!");
	}

	private void setupModifyPanel()
	{
		// Add Modify Panel
		System.out.print("Initializing Modify panel...");
		modifyPanel = new pModifyPane();
		//modifyPanel.setBorder(new LineBorder(Color.ORANGE, 2));

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 1;

		constraints.fill = GridBagConstraints.BOTH;

		modifyPanel.getDropList().setVisible(false);
		modifyPanel.setTitle("");
		rPanel.add(modifyPanel, constraints);
		System.out.println("done!");
	}

	private void setupConditionPanel()
	{
		// TODO: Implement option 2 panel functionality
		System.out.print("Initializing option 2...");
		JPanel conditionPanel = new JPanel();
		//conditionPanel.setBorder(new LineBorder(Color.ORANGE, 2));

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 1;
		constraints.gridy = 1;

		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.BOTH;

		rPanel.add(conditionPanel, constraints);
		System.out.println("done!");
	}

	private void updateProperty()
	{
		JList list = listPanel.getList();

		DefaultListModel model = new DefaultListModel();

		for (property element : properties)
			model.addElement(element.getName());

		list.setModel(model);

		buttonPanel.getBackButton().setVisible(false);
	}

	private void updateBuilding()
	{
		JList list = listPanel.getList();
		JComboBox dropBox = modifyPanel.getDropList();

		DefaultListModel model = new DefaultListModel();

		for (building element : cProperty.buildings)
			model.addElement(element.getName());


		list.setModel(model);

		listPanel.setProperty(cProperty.getName());
		buttonPanel.getBackButton().setVisible(true);

		ArrayList<String> toAdd = new ArrayList<String>();

		for (building element : cProperty.buildings)
			toAdd.add(element.getName());

		dropBox.setModel(new DefaultComboBoxModel(toAdd.toArray()));
		dropBox.setVisible(true);
		modifyPanel.setTitle("Building Name");
	}

	private void updateFloor()
	{
		JList list = listPanel.getList();
		JComboBox dropBox = modifyPanel.getDropList();

		DefaultListModel model = new DefaultListModel();

		for (floor element : cBuilding.floors)
			model.addElement(element.getLevel());

		list.setModel(model);

		dropBox.setVisible(false);
		listPanel.setBuilding(cBuilding.getName());
		modifyPanel.setTitle("");
	}

	private void updateRoom()
	{
		JList list = listPanel.getList();
		JComboBox dropBox = modifyPanel.getDropList();

		DefaultListModel model = new DefaultListModel();

		for (room element : cFloor.rooms)
			model.addElement(element.getName());

		list.setModel(model);

		ArrayList<String> type = new ArrayList<String>();

		type.add("Attic");
		type.add("Bathroom");
		type.add("Bedroom");
		type.add("Default");
		type.add("Utility");

		dropBox.setModel(new DefaultComboBoxModel(type.toArray()));
		dropBox.setVisible(true);

		listPanel.setFloor(cFloor.getLevel());
		modifyPanel.setTitle("Room Type");
	}

	///////////////
	// LISTENERS //
	///////////////

	private class lExportProperty implements ActionListener{

		public void actionPerformed(ActionEvent event){

			property prop = null;

			if (state == displayState.PROPERTY)
				prop = properties.get(listPanel.getList().getSelectedIndex());
			else
				prop = cProperty;

			System.out.println(prop.toString());

			save.saveProperty(prop, prop.getName());
		}

	}

	private class lImportProperty implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("DAT files", "dat");

			chooser.setFileFilter(filter);

			int result = chooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION)
				properties.add((load.loadProperty(chooser.getSelectedFile().getName())));

			System.out.println(properties.size());

			for (int i = 0; i < properties.size(); i++)
				properties.get(i).getName();

			updateProperty();
		}
	}
	private class lBackButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			switch(state)
			{
				case BUILDING:
					state = displayState.PROPERTY;
					updateProperty();
					listPanel.setProperty("Not Selected");
					modifyPanel.getDropList().setVisible(false);
					modifyPanel.setTitle("");
					break;

				case FLOOR:
					state = displayState.BUILDING;
					updateBuilding();
					listPanel.setBuilding("Not Selected");
					break;

				case ROOM:
					state = displayState.FLOOR;
					updateFloor();
					listPanel.setFloor(0);
					break;
			}
		}
	}

	private class lCreateButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			switch (state) {
				case PROPERTY:
					createProperty();
					break;

				case BUILDING:
					createBuilding();
					break;

				case FLOOR:
					createFloor();
					break;

				case ROOM:
					createRoom();
					break;
			}
		}

		private void createProperty()
		{
			JTextField ownerName = new JTextField();
			JTextField address = new JTextField();
			JTextField propertyName = new JTextField();
			JTextField sqFoot = new JTextField();

			Object[] prompt = {"Owner Name: ", ownerName,
					"Address: ", address,
					"Property Name: ", propertyName,
					"Square Foot: ", sqFoot};

			int option = JOptionPane.showConfirmDialog(null, prompt, "Create Property", JOptionPane.OK_CANCEL_OPTION);

			if (option == JOptionPane.OK_OPTION)
			{
				properties.add(new property(ownerName.getText(),
						address.getText(),
						propertyName.getText(),
						Integer.parseInt(sqFoot.getText())));
			}

			updateProperty();
		}

		private void createBuilding()
		{
			JTextField name = new JTextField();
			JTextField sqFoot = new JTextField();

			Object[] prompt = {"Building Name: ", name,
								"Square Foot: ", sqFoot};

			int option = JOptionPane.showConfirmDialog(null, prompt, "Create Building", JOptionPane.OK_CANCEL_OPTION);

			if (option == JOptionPane.OK_OPTION)
			{
				cProperty.buildings.add(new building(name.getText(), Integer.parseInt(sqFoot.getText())));
				updateBuilding();
			}
		}

		private void createFloor()
		{
			JTextField level = new JTextField();

			Object[] prompt = {"Floor Level: ", level};

			int option = JOptionPane.showConfirmDialog(null, prompt, "Create Floor", JOptionPane.OK_CANCEL_OPTION);

			if (option == JOptionPane.OK_OPTION)
			{
				cBuilding.floors.add(new floor(level.getText()));
				updateFloor();
			}
		}

		private void createRoom()
		{
			String roomSelection = modifyPanel.getDropList().getSelectedItem().toString();

			if (roomSelection.equals("Attic"))
			{
				JTextField roomName = new JTextField();
				JCheckBox finished = new JCheckBox();
				JTextField sqft = new JTextField();

				Object[] prompt = {"Room Name: ", roomName,
							"Is Finished: ", finished,
							"Square Foot: ", sqft};

				int option = JOptionPane.showConfirmDialog(null, prompt, "Create Attic", JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION)
				{
					cFloor.rooms.add(new attic(roomName.getText(),
												finished.isSelected(),
												Integer.parseInt(sqft.getText())));
				}
			}
			else if (roomSelection.equals("Bathroom"))
			{
				JTextField roomName = new JTextField();
				JTextField sinkCount = new JTextField();
				JCheckBox shower = new JCheckBox();
				JCheckBox tub = new JCheckBox();
				JTextField sqft = new JTextField();

				Object[] prompt = {"Room Name: ", roomName,
									"Sink Count: ", sinkCount,
									"Has Shower: ", shower,
									"Has Tub: ", tub,
									"Square Foot: ", sqft};

				int option = JOptionPane.showConfirmDialog(null, prompt, "Create Bathroom", JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION)
				{
					cFloor.rooms.add(new bathroom(roomName.getText(),
													Integer.parseInt(sinkCount.getText()),
													shower.isSelected(),
													tub.isSelected(),
													Integer.parseInt(sqft.getText())));
				}
			}
			else if (roomSelection.equals("Bedroom"))
			{
				JTextField roomName = new JTextField();
				JTextField sqf = new JTextField();
				JCheckBox walkIn = new JCheckBox();
				JTextField closetSqFoot = new JTextField();

				Object[] prompt = {"Room Name: ", roomName,
									"Square Foot: ", sqf,
									"Walk in Closet: ", walkIn,
									"Closet Square Foot: ", closetSqFoot};

				int option = JOptionPane.showConfirmDialog(null, prompt, "Create Bedroom", JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION)
				{
					cFloor.rooms.add(new bedroom(roomName.getText(),
									Integer.parseInt(sqf.getText()),
									walkIn.isSelected(),
									Integer.parseInt(closetSqFoot.getText())));
				}
			}
			else if(roomSelection.equals("Utility"))
			{
				JCheckBox waterHeater = new JCheckBox();
				JCheckBox furnace = new JCheckBox();
				JCheckBox airCon = new JCheckBox();

				Object[] prompt = {"Has Water Heater: ", waterHeater,
									"Has Furnace: ", furnace,
									"Has Air Conditioner: ", airCon};

				int option = JOptionPane.showConfirmDialog(null, prompt, "Create Utility Room", JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION)
				{
					cFloor.rooms.add(new utility(waterHeater.isSelected(),
													furnace.isSelected(),
													airCon.isSelected()));
				}
			}
			else if(roomSelection.equals("Default"))
			{
				JTextField roomName = new JTextField();
				JTextField sqFoot = new JTextField();
				JTextField windowCount = new JTextField();
				JTextField outletCount = new JTextField();

				Object[] prompt = {"Room Name: ", roomName,
									"Square Foot: ", sqFoot,
									"Number of Windows: ", windowCount,
									"Number of Outlets: ", outletCount};

				int option = JOptionPane.showConfirmDialog(null, prompt, "Create Room", JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION) {
					cFloor.rooms.add(new room(roomName.getText(),
							Integer.parseInt(sqFoot.getText()),
							Integer.parseInt(windowCount.getText()),
							Integer.parseInt(outletCount.getText())));
				}
			}

				updateRoom();
		}
	}

	private class lDeleteButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selection = listPanel.getList().getSelectedIndex();

			if (selection >= 0)
			{
				switch (state)
				{
					case PROPERTY:
						properties.remove(selection);
						updateProperty();
						break;

					case BUILDING:
						cProperty.buildings.remove(selection);
						updateBuilding();
						break;

					case FLOOR:
						cBuilding.floors.remove(selection);
						updateFloor();
						break;

					case ROOM:
						cFloor.rooms.remove(selection);
						updateRoom();
						break;
				}
			}
		}
	}

	private class lModifyButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selection = listPanel.getList().getSelectedIndex();

			if (selection >= 0)
			{
				switch (state)
				{
					case PROPERTY:
						cProperty = properties.get(selection);
						updateBuilding();
						state = displayState.BUILDING;
						break;

					case BUILDING:
						cBuilding = cProperty.buildings.get(selection);
						updateFloor();
						state = displayState.FLOOR;
						break;

					case FLOOR:
						cFloor = cBuilding.floors.get(selection);
						updateRoom();
						state = displayState.ROOM;
				}
			}
		}
	}
}