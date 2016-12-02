package propspector;

import jdk.nashorn.internal.scripts.JO;
import propspector.gui.*;
import propspector.gui.res.pModifyPane;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class frontend {

	public static void main(String[] args) {
		frontend mainApp = new frontend();
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

	private ArrayList<property> properties;

	public frontend()
	{
		setupFrame();
		setupListPanel();
		setupButtonPanel();
		setupDetailPanel();
		setupModifyPanel();
		setupConditionPanel();

		properties = new ArrayList<property>();

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

		menuBar.add(new pFileMenu());
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
		lPanel.setBorder(new LineBorder(Color.BLACK, 2));

		// Set constraints for left layout panel
		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;

		constraints.fill = GridBagConstraints.BOTH;

		mainPanel.add(lPanel, constraints);

		// Add right layout panel to main panel
		rPanel = new JPanel();
		rPanel.setLayout(new GridBagLayout());
		rPanel.setBorder(new LineBorder(Color.BLACK, 2));

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
		listPanel.setBorder(new LineBorder(Color.ORANGE, 2)); // For debugging

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
		// TODO: Implement button panel functionality

		System.out.print("Initializing button panel...");
		buttonPanel = new pButtonPane();
		buttonPanel.setBorder(new LineBorder(Color.ORANGE, 2));

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;

		constraints.fill = GridBagConstraints.BOTH;

		// Setup button panel listeners
		buttonPanel.getBackButton().addActionListener(new lBackButton());
		buttonPanel.getCreateButton().addActionListener(new lCreateButton());
		buttonPanel.getDeleteButton().addActionListener(new lDeleteButton());
		buttonPanel.getModifyButton().addActionListener(new lModifyButton());

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
		detailPanel.setBorder(new LineBorder(Color.ORANGE, 2));

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
		// TODO: Implement option 1 panel functionality
		System.out.print("Initializing Modify panel...");
		modifyPanel = new pModifyPane();
		modifyPanel.setBorder(new LineBorder(Color.ORANGE, 2));

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 1;

		constraints.fill = GridBagConstraints.BOTH;

		rPanel.add(modifyPanel, constraints);
		System.out.println("done!");
	}

	private void setupConditionPanel()
	{
		// TODO: Implement option 2 panel functionality
		System.out.print("Initializing option 2...");
		JPanel conditionPanel = new JPanel();
		conditionPanel.setBorder(new LineBorder(Color.ORANGE, 2));

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.gridx = 1;
		constraints.gridy = 1;

		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		constraints.fill = GridBagConstraints.BOTH;

		rPanel.add(conditionPanel, constraints);
		System.out.println("done!");
	}

	private void updateList()
	{
		JList list = listPanel.getList();

		DefaultListModel model = new DefaultListModel();

		for (property element : properties)
			model.addElement(element.getName());

		list.setModel(model);
	}

	///////////////
	// LISTENERS //
	///////////////

	private class lBackButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JList list = listPanel.getList();

			ArrayList<String> newList = new ArrayList<String>();
			newList.add("Property 1");
			newList.add("Property 2");
			newList.add("All your base are belong to us.");

			DefaultListModel model = new DefaultListModel();

			for (String element : newList)
				model.addElement(element);

			list.setModel(model);
		}
	}

	private class lCreateButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {

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
									Integer.parseInt(sqFoot.getText())
									));
			}

			updateList();

		}
	}

	private class lDeleteButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selection = listPanel.getList().getSelectedIndex();

			if (selection >= 0)
			{
				properties.remove(selection);
				updateList();
			}
		}
	}

	private class lModifyButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}
}