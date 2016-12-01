package propspector.gui.res;

import sun.java2d.loops.GeneralRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class pModifyPane extends JPanel{

    public pModifyPane()
    {
        this.setLayout(new GridBagLayout());

        JLabel label = new JLabel("Room Type");

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;

        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(label, constraints);

        ArrayList<String> room = new ArrayList<String>();

        room.add("VEC 105");
        room.add("Bed Room");
        room.add("Man Cave");

        JComboBox dropList = new JComboBox(room.toArray());
        dropList.setSelectedIndex(0);

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
}
