package propspector.gui;

import javax.swing.*;
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
        dropList.addItemListener(
        		new ItemListener(){
        			public void itemStateChanged(ItemEvent event) {
        				if(event.getStateChange()==ItemEvent.SELECTED){
        					
        				}
        					
        			}
        		}
    );
        		
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
      options.add("The paint is peeling.");
  	options.add("Some walls have holes in them");
  	options.add("The ceiling is damaged.");
  	options.add("The ceiling is leaking.");
  	options.add("The ceiling has popcorn.");
  	options.add("The electrical is dangerously miswired.");
  	options.add("An outlet is missing.");
  	options.add("An outlet is damaged.");
  	options.add("The plumbing in the wall is leaking.");
  	options.add("Some windows are broken.");
  	
  	
  	dropList=new JComboBox(options.toArray());
  	dropList.setSelectedIndex(0);
  	dropList.addItemListener(
      		new ItemListener(){
      			public void itemStateChanged(ItemEvent event) {
      				if(event.getStateChange()==ItemEvent.SELECTED){
      					
      					intCon=options.get(dropList.getSelectedIndex());
      				}
      					
      			}
      		}
  );
  	

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
          
      	
        options.add("The paint is peeling.");
      	options.add("The Foundation is cracked.");
      	options.add("The stucco is damaged.");
      	options.add("The building has stucco.");
      	options.add("The building has siding.");
      	options.add("The siding is damaged.");
      	options.add("Some walls have holes in them.");
      	dropList=new JComboBox(options.toArray());
      	dropList.setSelectedIndex(0);
      	 dropList.addItemListener(
         		new ItemListener(){
         			public void itemStateChanged(ItemEvent event) {
         				if(event.getStateChange()==ItemEvent.SELECTED){
         					
         					extCon=options.get(dropList.getSelectedIndex());
         				}
         					
         			}
         		}
     );

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
  
   
    
    public String getExterior(){
    	return extCon;
    }
    
    public String getInterior(){
    	return intCon;
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
