package propspector.gui;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class pDetailPane extends JPanel {
	
	private String cState="property";
	private ImageIcon i;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(cState.equals("property")){
		  i= new ImageIcon(getClass().getResource("res/house.p.png"));
		}
		else if(cState.equals("building")){
		  i= new ImageIcon(getClass().getResource("res/house.o.png"));
		}
		else if(cState.equals("floor")){
		  i= new ImageIcon(getClass().getResource("res/house.f.png"));
		}
		else if(cState.equals("room")){
			  i= new ImageIcon(getClass().getResource("res/house.r.png"));
		}
		i.paintIcon(this, g, 0,0);
	}
	
	public void setState(String s){
		cState=s;

		System.out.println("Updating");
		
	this.repaint();
	}

	
	
}
