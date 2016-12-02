//Aaron(yixuan Leng)
package propspector;

import java.util.ArrayList;

public class property implements RealEstate
{
	private String ownerName = new String();
	private String propertyName = new String();
	private String address = new String();
	private int sqFoot;
	
ArrayList<building> buildings = new ArrayList<building>();
	
	public property()
	{
		ownerName = "Owner";
		address = "Address";
		propertyName = "Property";
		sqFoot = 100000;
	}	

	public property(String ownName, String addre, String name, int sqF, int buildc)
	{
		ownerName = ownName;
		address = addre;
		propertyName = name;
		sqFoot = sqF;
	}
	
	public int squareFootage() {
		return sqFoot; 
	}
	
	public String setOwnerName(String on)
	{
		ownerName = on;
		return ownerName;
	}
	
	public String setName(String str)
	{
		propertyName = str;
		return propertyName;
	}
	
	public String setAddress(String ad)
	{
		address = ad;
		return address;
	}
	
	public String getOwnerName() 
	{
		return ownerName;
	}
	
	public String getName() 
	{
		return propertyName;
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public String Summarize() 
	{
		String sum = (propertyName + " own by "+ ownerName + " has " + sqFoot + " sq ft, in " + buildings.size());
		return sum;
	}

	public String listConditions() {
		return ""; //property do not have conditions
	}

	public String subCount() {
		return (buildings.size() + "buidling count" + sqFoot + "sq ft");
	}

	public String addCount(String str) {
		buildings.add(new building(str));
		return str;
	}
	
	public String toString() {
		return(propertyName +": "+subCount());
	}
	//make a method to return the reference to the building array,same for building and floor,
}