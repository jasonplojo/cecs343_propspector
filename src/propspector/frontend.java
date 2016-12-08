package propspector;

import propspector.gui.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
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
	private pModifyDB modifyDB;
	private pDetailPane detailPanel;

	private enum displayState {PROPERTY, BUILDING, FLOOR, ROOM}

	private ArrayList<property> properties;
	private property cProperty;
	private building cBuilding;
	private floor cFloor;
	private room cRoom = new room();
	private displayState state;
	private JComboBox dropList;

	public frontend() {
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
	private void setupFrame() {
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

		pHelpMenu helpMenu = new pHelpMenu();
		helpMenu.getAbout().addActionListener(new lAbout());

		menuBar.add(helpMenu);

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

	private void setupListPanel() {
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

	private void setupButtonPanel() {
		// Add Button Panel
		System.out.print("Initializing button panel...");
		buttonPanel = new pButtonPane();

		buttonPanel.setMinimumSize(new Dimension(500, 300));
		buttonPanel.setPreferredSize(new Dimension(500, 300));
		buttonPanel.setMaximumSize(new Dimension(500, 300));

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

	private void setupDetailPanel() {
		//////////////////
		// DETAIL PANEL //
		//////////////////

		// Add Detail Panel
		System.out.print("Initializing detail panel...");

		detailPanel = new pDetailPane();

		detailPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		detailPanel.setMinimumSize(new Dimension(240, 400));
		detailPanel.setPreferredSize(new Dimension(240, 400));
		detailPanel.setMaximumSize(new Dimension(240, 400));

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 1;
		constraints.gridy = 0;

		constraints.anchor = GridBagConstraints.FIRST_LINE_END;

		constraints.fill = GridBagConstraints.VERTICAL;

		rPanel.add(detailPanel, constraints);
		System.out.println("done!");
	}

	private void updateDetailPanel() {

		if (state == displayState.PROPERTY) {
			detailPanel.setState("property");
		} else if (state == displayState.BUILDING) {
			detailPanel.setState("building");
		} else if (state == displayState.FLOOR) {
			detailPanel.setState("floor");
		} else if (state == displayState.ROOM) {
			detailPanel.setState("room");
		}
	}

	private void setupModifyPanel() {
		// Add Modify Panel
		System.out.print("Initializing Modify panel...");
		modifyPanel = new pModifyPane();

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 1;

		constraints.fill = GridBagConstraints.BOTH;

		modifyPanel.getDropList().setVisible(false);
		modifyPanel.setTitle("");
		rPanel.add(modifyPanel, constraints);
		System.out.println("done!");
	}

	private void setupConditionPanel() {
		System.out.print("Initializing option 2...");
		modifyDB = new pModifyDB();

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 1;
		constraints.gridy = 1;

		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.BOTH;
		modifyDB.getDropList().setVisible(false);
		modifyDB.setTitle("");
		rPanel.add(modifyDB, constraints);
		System.out.println("done!");
	}

	private void updateConditionPanel() {
		modifyDB.getDropList().setVisible(false);
		modifyDB.setTitle("");
		if (state == displayState.BUILDING) {
			modifyDB.setExDB();
			modifyDB.getDropList().setVisible(true);
			modifyDB.setTitle("Exterior Conditions");
			dropList = modifyDB.getDropList();
			dropList.addItemListener(
					new ItemListener() {
						public void itemStateChanged(ItemEvent event) {
							if (event.getStateChange() == ItemEvent.SELECTED) {

								String exCon = dropList.getSelectedItem().toString();
								ExteriorCondition temp = new ExteriorCondition(exCon);
								cBuilding.exConditions.add(temp);

							}

						}
					}

			);


		} else if (state == displayState.ROOM) {
			modifyDB.setIntDB();
			modifyDB.getDropList().setVisible(true);
			modifyDB.setTitle("Interior Conditions");
			dropList = modifyDB.getDropList();
			dropList.addItemListener(
					new ItemListener() {
						public void itemStateChanged(ItemEvent event) {
							if (event.getStateChange() == ItemEvent.SELECTED) {

								String inCon = dropList.getSelectedItem().toString();
								InteriorCondition temp2 = new InteriorCondition(inCon);
								cRoom.conditions.add(temp2);
							}

						}
					}
			);
		}
	}

	private void updateProperty() {
		JList list = listPanel.getList();

		DefaultListModel model = new DefaultListModel();

		for (property element : properties)
			model.addElement(element.getName());

		list.setModel(model);

		buttonPanel.getBackButton().setVisible(false);
	}

	private void updateBuilding() {
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
		modifyPanel.setTitle("Building Options");
	}

	private void updateFloor() {
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

	private void updateRoom() {
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
		type.add("Kitchen");
		type.add("Utility");

		dropBox.setModel(new DefaultComboBoxModel(type.toArray()));
		dropBox.setVisible(true);

		listPanel.setFloor(cFloor.getLevel());
		modifyPanel.setTitle("Room Type");
	}

	///////////////
	// LISTENERS //
	///////////////

	private class lExportProperty implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".dat", "dat");

			chooser.setFileFilter(filter);

			int result = chooser.showSaveDialog(null);
			property prop = null;

			if (result == JFileChooser.APPROVE_OPTION) {
				if (state == displayState.PROPERTY)
					prop = properties.get(listPanel.getList().getSelectedIndex());
				else
					prop = cProperty;

				save.savePropertyPicker(prop, chooser.getSelectedFile().getAbsoluteFile().toString() + ".dat");
			}

			System.out.println(prop.toString());
		}

	}

	private class lImportProperty implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".dat", "dat");

			chooser.setFileFilter(filter);

			int result = chooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION)
				properties.add((property) load.loadPropertyPicker(chooser.getSelectedFile().getAbsoluteFile().toString()));

			System.out.println(properties.size());

			for (int i = 0; i < properties.size(); i++)
				properties.get(i).getName();

			updateProperty();
		}
	}

	private class lBackButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			switch (state) {
				case BUILDING:
					state = displayState.PROPERTY;
					updateProperty();
					updateConditionPanel();
					updateDetailPanel();
					listPanel.setProperty("Not Selected");
					modifyPanel.getDropList().setVisible(false);
					modifyPanel.setTitle("");
					break;

				case FLOOR:
					state = displayState.BUILDING;
					updateBuilding();
					updateConditionPanel();
					updateDetailPanel();
					listPanel.setBuilding("Not Selected");
					break;

				case ROOM:
					state = displayState.FLOOR;
					updateFloor();
					updateConditionPanel();
					updateDetailPanel();
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

		private void createProperty() {
			JTextField ownerName = new JTextField();
			JTextField address = new JTextField();
			JTextField propertyName = new JTextField();
			JTextField sqFoot = new JTextField();

			Object[] prompt = {"Owner Name: ", ownerName,
					"Address: ", address,
					"Property Name: ", propertyName,
					"Square Foot: ", sqFoot};

			int option = JOptionPane.showConfirmDialog(null, prompt, "Create Property", JOptionPane.OK_CANCEL_OPTION);

			if (option == JOptionPane.OK_OPTION) {
				properties.add(new property(ownerName.getText(),
						address.getText(),
						propertyName.getText(),
						Integer.parseInt(sqFoot.getText())));
			}

			updateProperty();
		}

		private void createBuilding() {
			JTextField name = new JTextField();
			JTextField sqFoot = new JTextField();

			Object[] prompt = {"Building Name: ", name,
					"Square Foot: ", sqFoot};

			int option = JOptionPane.showConfirmDialog(null, prompt, "Create Building", JOptionPane.OK_CANCEL_OPTION);

			if (option == JOptionPane.OK_OPTION) {
				cProperty.buildings.add(new building(name.getText(), Integer.parseInt(sqFoot.getText())));
				updateBuilding();
			}
		}

		private void createFloor() {
			JTextField level = new JTextField();

			Object[] prompt = {"Floor Level: ", level};

			int option = JOptionPane.showConfirmDialog(null, prompt, "Create Floor", JOptionPane.OK_CANCEL_OPTION);

			if (option == JOptionPane.OK_OPTION) {
				cBuilding.floors.add(new floor(level.getText()));
				updateFloor();
			}
		}

		private void createRoom() {
			String roomSelection = modifyPanel.getDropList().getSelectedItem().toString();

			if (roomSelection.equals("Attic")) {
				JTextField roomName = new JTextField();
				JCheckBox finished = new JCheckBox();
				JTextField sqft = new JTextField();

				Object[] prompt = {"Room Name: ", roomName,
						"Is Finished: ", finished,
						"Square Foot: ", sqft};

				int option = JOptionPane.showConfirmDialog(null, prompt, "Create Attic", JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION) {
					cFloor.rooms.add(new attic(roomName.getText(),
							finished.isSelected(),
							Integer.parseInt(sqft.getText())));
				}
			} else if (roomSelection.equals("Bathroom")) {
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

				if (option == JOptionPane.OK_OPTION) {
					cFloor.rooms.add(new bathroom(roomName.getText(),
							Integer.parseInt(sinkCount.getText()),
							shower.isSelected(),
							tub.isSelected(),
							Integer.parseInt(sqft.getText())));
				}
			} else if (roomSelection.equals("Bedroom")) {
				JTextField roomName = new JTextField();
				JTextField sqf = new JTextField();
				JCheckBox walkIn = new JCheckBox();
				JTextField closetSqFoot = new JTextField();

				Object[] prompt = {"Room Name: ", roomName,
						"Square Foot: ", sqf,
						"Walk in Closet: ", walkIn,
						"Closet Square Foot: ", closetSqFoot};

				int option = JOptionPane.showConfirmDialog(null, prompt, "Create Bedroom", JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION) {
					cFloor.rooms.add(new bedroom(roomName.getText(),
							Integer.parseInt(sqf.getText()),
							walkIn.isSelected(),
							Integer.parseInt(closetSqFoot.getText())));
				}
			} else if (roomSelection.equals("Kitchen")) {
				JTextField roomName = new JTextField();
				JTextField sinkCount = new JTextField();
				JTextField rangeCount = new JTextField();
				JTextField counterType = new JTextField();
				JCheckBox vent = new JCheckBox();
				JTextField squareFoot = new JTextField();

				Object[] prompt = {"Room Name: ", roomName,
						"Sink Count: ", sinkCount,
						"Stove Count: ", rangeCount,
						"Counter Type: ", counterType,
						"Vent: ", vent,
						"Square Foot: ", squareFoot};

				int option = JOptionPane.showConfirmDialog(null, prompt, "Create Kitchen", JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION) {
					cFloor.rooms.add(new kitchen(roomName.getText(),
							Integer.parseInt(sinkCount.getText()),
							Integer.parseInt(rangeCount.getText()),
							counterType.getText(),
							vent.isSelected(),
							Integer.parseInt(squareFoot.getText())));
				}

			} else if (roomSelection.equals("Utility")) {
				JCheckBox waterHeater = new JCheckBox();
				JCheckBox furnace = new JCheckBox();
				JCheckBox airCon = new JCheckBox();

				Object[] prompt = {"Has Water Heater: ", waterHeater,
						"Has Furnace: ", furnace,
						"Has Air Conditioner: ", airCon};

				int option = JOptionPane.showConfirmDialog(null, prompt, "Create Utility Room", JOptionPane.OK_CANCEL_OPTION);

				if (option == JOptionPane.OK_OPTION) {
					cFloor.rooms.add(new utility(waterHeater.isSelected(),
							furnace.isSelected(),
							airCon.isSelected()));
				}
			} else if (roomSelection.equals("Default")) {
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

			if (selection >= 0) {
				switch (state) {
					case PROPERTY:
						properties.remove(selection);
						updateProperty();
						updateConditionPanel();
						updateDetailPanel();
						break;

					case BUILDING:
						cProperty.buildings.remove(selection);
						updateBuilding();
						updateConditionPanel();
						updateDetailPanel();
						break;

					case FLOOR:
						cBuilding.floors.remove(selection);
						updateFloor();
						updateConditionPanel();
						updateDetailPanel();
						break;

					case ROOM:
						cFloor.rooms.remove(selection);
						updateRoom();
						updateConditionPanel();
						updateDetailPanel();
						break;
				}
			}
		}
	}

	private class lModifyButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			int selection = listPanel.getList().getSelectedIndex();

			if (selection >= 0) {
				switch (state) {
					case PROPERTY:
						cProperty = properties.get(selection);
						updateBuilding();
						updateConditionPanel();

						state = displayState.BUILDING;
						updateDetailPanel();
						break;

					case BUILDING:
						cBuilding = cProperty.buildings.get(selection);
						updateFloor();
						updateConditionPanel();
						updateDetailPanel();
						state = displayState.FLOOR;

						break;

					case FLOOR:
						cFloor = cBuilding.floors.get(selection);
						updateRoom();
						updateConditionPanel();
						updateDetailPanel();
						state = displayState.ROOM;
						break;
					case ROOM:
						updateConditionPanel();
						updateDetailPanel();
				}
			}
		}
	}


	///////////////
	// LISTENERS //
	///////////////

	private class lAbout implements ActionListener {

		String credit = "Orange Canyon Software\n\n" +
				"Eric Downie\n" +
				"Yixuan Leng\n" +
				"Carl Jason Plojo\n" +
				"Tyren Villanueva";

		@Override
		public void actionPerformed(ActionEvent event) {

			JOptionPane.showMessageDialog(null, credit, "About", JOptionPane.PLAIN_MESSAGE);
			System.out.println("here");
		}
	}
}