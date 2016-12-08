package propspector;

public class kitchen extends room {
		/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 8305658952769383391L;
		int rangeCount;
		int sinkCount;
		String counterType;
		boolean vent;
		
	public kitchen(){
		roomName = "Kitchen";
		sinkCount = 1;
		rangeCount = 1;
		counterType = "wood";
		vent = true;
	}
	
	public kitchen(String str, int sc, int rc, String ct, boolean vt, int sqft){
		roomName = str;
		sinkCount = sc;
		rangeCount = rc;
		counterType = ct;
		sqFoot = sqft;
		vent = vt;
	}
	
	public kitchen(int sc, int rc) {
		roomName = "Kitchen";
		sinkCount = sc;
		rangeCount = rc;
		vent = false;
		counterType = "wood";
	}
	
	public int getRangeCount(){
		return rangeCount;
	}
	 public int setRangeCount(int rc) {
		 rangeCount = rc;
		 return rangeCount;
	 }
	 
	 public int getSinkCount(){
		 return sinkCount;
	 }
	 
	 public int setSinkCount(int sc){
		 sinkCount = sc;
		 return sinkCount;
	 }
	 
	 public boolean getVent(){
		 return vent;
	 }
	 
	 public boolean setVent(boolean vt){
		 vent = vt;
		 return vent;
	 }
	 
	 public String getCounter(){
		 return counterType;
	 }
	 
	 public String setCounter(String str) {
		 counterType = str;
		 return counterType;
	 }
	 
	//Since we've axed the generate summary feature, I have not included Summarize();
	 
	 public String toString(){
		 return(roomName+": "+subCount());
	 }
	 
	 public String subCount() {
		 return(sqFoot+" sq ft, "+sinkCount+" sinks, "+rangeCount+" ranges, "+counterType+" counters, "
					+outletCount+" outlets, "+windowCount+" windows, "+conditions.size()+" conditions.");
	 }
	 
	
}
