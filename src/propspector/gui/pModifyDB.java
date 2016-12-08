package propspector.gui;

import javax.swing.*;

import propspector.defaultExtCon;
import propspector.defaultIntCon;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class pModifyDB extends JPanel{

    private JComboBox dropList;
    private JLabel label;
    private int level;
    private String extCon=null;
    private String intCon=null;
    ArrayList<String> options= new ArrayList<String>();
    defaultExtCon extTest[]; 
    defaultIntCon intTest[];
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

  public void setIntDB(){
	  this.setLayout(new GridBagLayout());

      label = new JLabel();

      GridBagConstraints constraints = new GridBagConstraints();

      constraints.gridx = 0;
      constraints.gridy = 0;

      constraints.anchor = GridBagConstraints.FIRST_LINE_START;
      this.add(label, constraints);
    intTest = defaultIntCon.values();

  	
  		dropList=new JComboBox(intTest);
  	
  	

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
    	  this.setLayout(new GridBagLayout());

          label = new JLabel();

          GridBagConstraints constraints = new GridBagConstraints();

          constraints.gridx = 0;
          constraints.gridy = 0;

          constraints.anchor = GridBagConstraints.FIRST_LINE_START;
          this.add(label, constraints);
          
          		extTest = defaultExtCon.values();
        
      	dropList=new JComboBox(extTest);
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
  
   
    
    private JComboBox getdropList() {
	return dropList;
		
	}


    public JComboBox getDropList()
    {
        return dropList;
    }

    public void setTitle(String title)
    {
        label.setText(title);
    }
    
    public ArrayList<String> getOptions()
    {
		return options;
     }

public defaultExtCon[] getExteriorCon(){
	return extTest;
}
public defaultIntCon[] getInteriorCon(){
	return intTest;
}
}
