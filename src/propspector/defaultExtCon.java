//Eric Downie
package propspector;

import java.util.Enumeration;

//because these are default hardcoded values, no mutators
public enum defaultExtCon{ //For storing default exterior conditions - if we decide to keep those
	PaintPeeling("The paint is peeling.", true), //first value is user-friendly string, second is damage
	FoundationCracked("The Foundation is cracked.", true),
	StuccoDamaged("The stucco is damaged.", true),
	HasStucco("The building has stucco.", false),
	HasSiding("The building has siding.", false),
	SidingDamaged("The siding is damaged.", true),
	WallsHoles("Some walls have holes in them", true);
	
	private String description;
	private boolean isDamage;
	defaultExtCon(String description, boolean isDamage){ //constructor which gives each condition a user-friendly string.
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
//Use a static call of defaultExtCon.values() to get all enumeration values.