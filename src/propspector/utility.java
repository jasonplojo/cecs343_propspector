package propspector;

public class utility extends room{
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 4472292275581321804L;
	boolean waterHeater; //room has water heater?
	boolean furnace; //room has furnace for heating rooms?
	boolean airCon; //room has HVAC unit?

	public utility() {
		roomName = "Utility";
		waterHeater = true;
		furnace = false;
		airCon = false;
		sqFoot = 20;
	}
	
	public utility(boolean wh, boolean furnace, boolean aircon) {
		waterHeater = wh;
		this.furnace = furnace;
		this.airCon = aircon;
		sqFoot = 20;
	}
	
	public boolean hasWaterHeater(){
		return waterHeater;
	}
	
	public boolean setWaterHeater(boolean wh){
		waterHeater = wh;
		return waterHeater;
	}
	
	public boolean hasFurnace(){
		return furnace;
	}
	
	public boolean setFurnace(boolean furnace){
		this.furnace = furnace;
		return furnace;
	}

	public boolean hasAirCon(){
		return airCon;
	}
	
	public boolean setAirCon(boolean ac){
		airCon = ac;
		return airCon;
	}
	
	public String subCount() {
		return (sqFoot+" sq ft, "+outletCount+" outlets, "+windowCount+" windows, "
				+(waterHeater ? "Has a water Heater. " : "No water heater. ")
				+(furnace ? "Has a furnace. " : "No furnace. ")+(airCon ? "Has A/C. " : "No A/C. ")
				+conditions.size()+" conditions.");
	}
	
	public String Summarize() {
		String sum = (roomName +": " +sqFoot+" sq ft, "+outletCount+" outlets, "+windowCount+" windows, "
				+(waterHeater ? "Has a water Heater. " : "No water heater. ")
				+(furnace ? "Has a furnace. " : "No furnace. ")+(airCon ? "Has A/C. " : "No A/C. ")
				+listConditions());
		return sum;
	}
	
	public String toString() {
		return(roomName+": "+subCount());
	}
	
}


