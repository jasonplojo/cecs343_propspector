//Eric Downie
package propspector;

import java.util.ArrayList;

public class room implements RealEstate {
private String roomName = new String();
private int sqFoot;
private int windowCount;
private int outletCount;

ArrayList<InteriorCondition> conditions = new ArrayList<InteriorCondition>();

	public room(){
		sqFoot = 100;
		roomName = "Room";
		windowCount = 0;
		outletCount = 0;
	}
	
	public room(String name){
		sqFoot = 100;
		roomName = name;
		windowCount = 0;
		outletCount = 0;
	}
	
	public room(String name, int sqF, int winC, int outC){
		roomName = name;
		sqFoot = sqF;
		windowCount = winC;
		outletCount = outC;
	}


	public int squareFootage() {
		return sqFoot;
	}

	public String getName() {
		return roomName;
	}

	public String Summarize() {
		String sum = (roomName + ": "+sqFoot+" sq ft, "+outletCount+" outlets, "+windowCount+" windows - "+listConditions());
		return sum;
	}

	public String listConditions() {
		
		return conditions.toString();
	}

	public String subCount() {
		return (sqFoot+" sq ft, "+outletCount+" outlets, "+windowCount+" windows, "+conditions.size()+" conditions.");
	}
	
	public String toString() {
		return(roomName+": "+subCount());
	}
}
