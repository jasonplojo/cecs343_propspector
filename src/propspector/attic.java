package propspector;

public class attic extends room{
	private boolean isFinished;
	
	public attic(){
		isFinished = false;
		roomName = "attic";
	}
	
	public attic(boolean finished) {
		isFinished = finished;
	}
	
	public attic(String name, boolean finished, int sqft){
		isFinished = finished;
		roomName = name;
		sqFoot = sqft;
	}
	
	public attic(String name){
		roomName = name;
		isFinished = false;
	}
	
	public String Summarize() {
		String sum = (roomName + ": "+(isFinished ? "Finished, " : "Unfinished, ")+sqFoot+" sq ft, "+outletCount+" outlets, "+windowCount+" windows - "+listConditions());
		return sum;
	}
}
