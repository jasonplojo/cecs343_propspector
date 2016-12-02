//Eric Downie
package propspector;
	//because these are default hardcoded values, no mutators
public enum defaultIntCon{ //For storing default interior conditions - if we decide to keep those
	PaintPeeling("The paint is peeling.", true), //first value is user-friendly string, second is damage
	WallsHoles("Some walls have holes in them", true),
	CeilingDamaged("The ceiling is damaged.", true),
	CeilingLeaking("The ceiling is leaking.", true),
	CeilingPopcorn("The ceiling has popcorn.", false),
	ElectricalDanger("The electrical is dangerously miswired.", true),
	MissingOutlet("An outlet is missing.", true),
	DamagedOutlet("An outlet is damaged.", true),
	PlumbingLeak("The plumbing in the wall is leaking.", true),
	BrokenWindows("Some windows are broken.", true);
	
	private String description;
	private boolean isDamage;
	defaultIntCon(String description, boolean isDamage){ //constructor which gives each condition a user-friendly string.
		this.description = description;
		this.isDamage = isDamage;
	}
	
	public String getDesc(){
		return description;
	}
	
	public boolean isDamage(){
		return isDamage;
	}
	
	 @Override
	    public String toString() {
	        return this.description;
	    }
	
}
//use toString for user friendly string for 
//use a static call of defaultIntCon.values() to get all enumeration values