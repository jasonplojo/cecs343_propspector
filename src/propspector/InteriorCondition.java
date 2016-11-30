package propspector;

public class InteriorCondition {
	String description;
	boolean isDamage;
	
	public InteriorCondition(String desc){
		description = desc;
		isDamage = false;
	}
	
	public InteriorCondition(boolean dam){
		isDamage = dam;
		if(dam){
			description = "Something is damaged.";
		} else {
			description = "Something needs to be addressed.";
		}
			
	}
}