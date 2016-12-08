//Eric Downie
package propspector;

import java.io.Serializable;

public class InteriorCondition implements condition, Serializable {
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 7850926496244808554L;
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