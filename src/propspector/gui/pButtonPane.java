package propspector.gui;

import javax.swing.*;
import java.awt.*;

public class pButtonPane extends JPanel{

    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 35;
    private static final int BUTTON_PADDING = 5;
    private static final int BUTTON_PADDING_TOP = 15;
    private static final int BUTTON_TEXT_GAP = 5;

    private JButton backButton;
    private JButton createButton;
    private JButton deleteButton;
    private JButton modifyButton;

    public pButtonPane() {

        this.setLayout(new GridBagLayout());

        backButton = setupBackButton();
        createButton = setupCreateButton();
        deleteButton = setupDeleteButton();
        modifyButton = setupModifyButton();
    }

    ///////////////////
    // BUTTON SETUPS //
    ///////////////////

    /**
     * Sets up the back button
     * @return The back button
     */
    private JButton setupBackButton()
    {
        JButton button = new JButton();

        // Set button attributes
        button.setText("Back");
        button.setMinimumSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        button.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        button.setHorizontalAlignment(SwingConstants.LEFT);

        // Set button appearance
        button.setIconTextGap(BUTTON_TEXT_GAP);
        button.setContentAreaFilled(false);
        button.setIcon(new ImageIcon(getClass().getResource("res/back.png")));

        GridBagConstraints constraints = new GridBagConstraints();

        // Set the constraints for layout
        constraints.gridx = 0;
        constraints.gridy = 0;

        constraints.insets = new Insets(0,0,BUTTON_PADDING,0);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;

        // Attach listener, add to the panel, and return button
        this.add(button, constraints);
        return button;
    }

    /**
     * Sets up create button
     * @return The create button
     */
    private JButton setupCreateButton()
    {
        JButton button = new JButton();

        // Set button attributes
        button.setText("Create");
        button.setMinimumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        button.setHorizontalAlignment(SwingConstants.LEFT);

        // Set button appearance
        button.setIconTextGap(BUTTON_TEXT_GAP);
        button.setContentAreaFilled(false);
        button.setIcon(new ImageIcon(getClass().getResource("res/create.png")));

        GridBagConstraints constraints = new GridBagConstraints();

        // Set the constraints for layout
        constraints.gridx = 0;
        constraints.gridy = 1;

        constraints.insets = new Insets(0,0,BUTTON_PADDING,0);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;

        // Add to the panel, and return button
        this.add(button, constraints);
        return button;
    }

    /**
     * Sets up the delete button
     * @return The delete button
     */
    private JButton setupDeleteButton()
    {
        JButton button = new JButton();

        // Set button attributes
        button.setText("Delete");
        button.setMinimumSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        button.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        button.setHorizontalAlignment(SwingConstants.LEFT);

        // Set button appearance
        button.setIconTextGap(BUTTON_TEXT_GAP);
        button.setContentAreaFilled(false);
        button.setIcon(new ImageIcon(getClass().getResource("res/delete.png")));

        GridBagConstraints constraints = new GridBagConstraints();

        // Set the constraints for layout
        constraints.gridx = 0;
        constraints.gridy = 2;

        constraints.insets = new Insets(0,0,BUTTON_PADDING,0);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;

        // Attach listener, add to the panel, and return button
        this.add(button, constraints);
        return button;
    }

    /**
     * Sets up modify button
     * @return The modify button
     */
    private JButton setupModifyButton()
    {
        JButton button = new JButton();

        // Set button attributes
        button.setText("Modify");
        button.setMinimumSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        button.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
        button.setHorizontalAlignment(SwingConstants.LEFT);

        // Set button appearance
        button.setIconTextGap(BUTTON_TEXT_GAP);
        button.setContentAreaFilled(false);
        button.setIcon(new ImageIcon(getClass().getResource("res/modify.png")));

        GridBagConstraints constraints = new GridBagConstraints();

        // Set the constraints for layout
        constraints.gridx = 0;
        constraints.gridy = 3;

        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        constraints.insets = new Insets(BUTTON_PADDING_TOP,0,BUTTON_PADDING,0);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;

        // Attach listener, add to the panel, and return button
        this.add(button, constraints);
        return button;
    }

    /////////////
    // GETTERS //
    /////////////
    public JButton getBackButton()
    {
        return backButton;
    }

    public JButton getCreateButton() { return createButton; }

    public JButton getDeleteButton() { return  deleteButton; }

    public JButton getModifyButton() { return modifyButton; }
}
