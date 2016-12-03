package propspector.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class pModifyDB extends JPanel{

    private JComboBox dropList;
    private JLabel label;

    public pModifyDB()
    {
        this.setLayout(new GridBagLayout());

        label = new JLabel();

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;

        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(label, constraints);
        ArrayList<String> options= new ArrayList<String>();
    	options.add("Damaged Stucco");
    	options.add("Cracked Foundation");
    	options.add("Roof Needs Replacing");
    	options.add("Needs New Paint");
    	options.add("Perfect Condition");
    	options.add("Other");
        dropList=new JComboBox(options.toArray());
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

    
    public void setExDB(){
    	ArrayList<String> options= new ArrayList<String>();
    	options.add("Damaged Stucco");
    	options.add("Cracked Foundation");
    	options.add("Roof Needs Replacing");
    	options.add("Needs New Paint");
    	options.add("Perfect Condition");
    	options.add("Other");
    	dropList=new JComboBox(options.toArray());
    	dropList.setSelectedIndex(0);
    }
    public JComboBox getDropList()
    {
        return dropList;
    }

    public void setTitle(String title)
    {
        label.setText(title);
    }

    
}
