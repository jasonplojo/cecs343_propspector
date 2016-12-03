package propspector;

import java.util.ArrayList;

public class floor implements RealEstate{
	public String floorName;
	public int level;
	public int sqFoot;
	

ArrayList<room> rooms = new ArrayList<room>();	

	public floor()
	{
		floorName = "Floor " + 1;
		level = 1;
		sqFoot = 100;
	}
	
	public floor(String level)
	{
		floorName = "Floor " + level;
		this.level = Integer.parseInt(level);
	}	
	
	

	public int squareFootage() {
		int i;
		int total = 0;
		for(i=0; i < rooms.size(); i++)
		{
			total += rooms.get(i).sqFoot;
		}
		return total; //going to each room of the array and add it to the total.
	}

	public String getName() {
		return null;
	}

	public String setName(String str) {
		return null;
	}
	
	public int getLevel() {
		return level;
	}

	public int setLevel(int lvl) {
		level = lvl;
		return level;
	}

	public String Summarize() {
		String sum = (floorName + " has " + rooms.size()+ "room");
		return sum;
	}

	public String listConditions() {

		return rooms.toString();
	}

	public String subCount() {

		return (rooms.size() + "room count");
	}

	public String addCount(String str) {
		rooms.add(new room(str));
		return str;
	}
	
	public String toString() {
		return(floorName +": "+subCount());
	}

	@Override
	public void setcond(String cond) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getcond() {
		// TODO Auto-generated method stub
		return null;
	}
	
}