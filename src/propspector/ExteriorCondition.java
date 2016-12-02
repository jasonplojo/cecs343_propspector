//Eric Downie
package propspector;

public class ExteriorCondition implements condition{
	String description;
	boolean isDamage;
	
	public ExteriorCondition(String desc){
		description = desc;
		isDamage = false;
	}
	
	public ExteriorCondition(String desc, boolean dam){
		description = desc;
		isDamage = dam;
	}
	
	public ExteriorCondition(boolean dam){
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
