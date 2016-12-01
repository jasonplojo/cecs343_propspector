package propspector;

public class InteriorCondition implements condition {
	String description;
	boolean isDamage;
	
	public InteriorCondition(String desc){
		description = desc;
		isDamage = false;
	}
	
	public InteriorCondition(String desc, boolean dam){
		description = desc;
		isDamage = dam;
	}
	
	public InteriorCondition(boolean dam){
		isDamage = dam;
		if(dam){
			description = "Something is damaged.";
		} else {
			description = "Something needs to be addressed.";
		}
			
	}

	public String getDesc() {
		return description;
	}

	public String setDesc(String str) {
		description = str;
		return description;
	}

	public boolean isDamage() {
		return isDamage;
	}

	public boolean setDamage(boolean dam) {
		isDamage = dam;
		return isDamage;
	}
}