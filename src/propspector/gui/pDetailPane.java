package propspector.gui;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;




public class pDetailPane extends JPanel {
	
	private String cState="property";
	ImageIcon i;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(cState.equals("property")){
		  i= new ImageIcon("C:\\Users\\tyren\\workspace\\cecs343_propspector\\src\\propspector\\gui\\res\\house.p.png");
		}
		else if(cState.equals("building")){
		  i= new ImageIcon("C:\\Users\\tyren\\workspace\\cecs343_propspector\\src\\propspector\\gui\\res\\house.o.png");
		}
		else if(cState.equals("floor")){
		  i= new ImageIcon("C:\\Users\\tyren\\workspace\\cecs343_propspector\\src\\propspector\\gui\\res\\house.f.png");
		}
		else if(cState.equals("room")){
			  i= new ImageIcon("C:\\Users\\tyren\\workspace\\cecs343_propspector\\src\\propspector\\gui\\res\\house.r.png");
		}
		i.paintIcon(this, g, 1275,0);
	}
	
	public void setState(String s){
		cState=s;
		
	this.repaint();
	}

	
	
}
