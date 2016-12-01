package propspector;
	//because these are default hardcoded values, no mutators
public enum defaultIntCon{ //For storing default interior conditions - if we decide to keep those
	TODO("add these", false);
	
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
// I could also use a bunch of static final strings as default condition descriptions if this is too cumbersome 
	//or another interface...