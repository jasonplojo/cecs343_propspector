package propspector.gui;

import javax.swing.*;
import java.awt.*;

public class pModifyPane extends JPanel{

    private JComboBox dropList;
    private JLabel label;
    private JButton button;

    public pModifyPane()
    {
        this.setLayout(new GridBagLayout());

        label = new JLabel();
        button = new JButton();

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;

        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(label, constraints);

        dropList = new JComboBox();

        constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 1;

        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.add(dropList, constraints);
    }

    public JComboBox getDropList()
    {
        return dropList;
    }

    public JButton getButton()
    {
        return button;
    }

    public void setTitle(String title)
    {
        label.setText(title);
    }

    
}
