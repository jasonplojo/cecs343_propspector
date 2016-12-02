//Eric Downie
package propspector;
	//since all bathrooms must have at least a toilet and a sink I wont bother with toilet count. Sink count starts at 1
public class bathroom extends room {
	private int sinkCount;
	private boolean shower;
	private boolean tub;
	
	public bathroom(){ //"public bathroom" heh
		roomName = "bathroom";
		sinkCount = 1;
		shower = false;
		tub = false;
		sqFoot = 25;
	}
	
	public bathroom(String name){
		roomName = name;
		sinkCount = 1;
		shower = false;
		tub = false;
		sqFoot = 25;
	}
	
	public bathroom(String name, int sinkCount, boolean shower, boolean tub, int sqft){
		roomName = name;
		this.sinkCount = sinkCount;
		this.shower = shower;
		this.tub = tub;
		sqFoot = sqft;
	}
	
	public int getSinkCount(){
		return sinkCount;
	}
	
	public int setSinkCount(int count){
		sinkCount = count;
		return sinkCount;
	}
	
	public boolean hasShower(){
		return shower;
	}
	
	public boolean setShower(boolean shower){
		this.shower = shower;
		return shower;
	}
	
	public boolean hasTub(){
		return tub;
	}
	
	public boolean setTub(boolean tub){
		this.tub = tub;
		return tub;
	}
	
	public String subCount() {
		return (sqFoot+" sq ft, "+sinkCount+" sinks. "+(shower ? "Has a shower. " : "No Shower. ")+(tub ? "Has a tub. " : "No tub. ")
				+outletCount+" outlets, "+windowCount+" windows, "+conditions.size()+" conditions.");
	}
	
	public String Summarize() {
		String sum = (roomName + ": "+sqFoot+" sq ft, "+(shower ? "Has a shower. " : "No Shower. ")+(tub ? "Has a tub. " : "No tub. ")
				+outletCount+" outlets, "+windowCount+" windows - "+listConditions());
		return sum;
	}
}
