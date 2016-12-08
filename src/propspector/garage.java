package propspector;

public class garage extends room {
	int carCapacity;
	boolean hasWorkshop;
	
	public garage(){
		carCapacity = 1;
		hasWorkshop = false;
	}
	
	public garage(int cc){
		carCapacity = cc;
		hasWorkshop = false;
	}
	
	public garage(int cc, boolean ws, int sqft){
		carCapacity = cc;
		hasWorkshop = ws;
		sqFoot = sqft;
	}
	
	public int getCapacity(){
		return carCapacity;
	}
	public int setCapacity(int cc){
		carCapacity = cc;
		return carCapacity;
	}
	
	public boolean getWorkshop(){
		return hasWorkshop;
	}
	
	public boolean setWorkshop(boolean ws){
		hasWorkshop = ws;
		return hasWorkshop;
	}
	
	public String toString(){
		return (roomName+": "+carCapacity+" car, "+(hasWorkshop ? "workshop." : "no workshop."));
	}
	
	public String Summarize(){
		return (roomName + ": "+carCapacity+" car, "+(hasWorkshop ? "workshop." : "no workshop."+sqFoot+" sq ft, "
				+outletCount+" outlets, "+windowCount+" windows - "+listConditions()));
	}
	
}
