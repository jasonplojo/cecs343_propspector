package propspector;

import java.util.ArrayList;

public class building implements RealEstate{
	public String buildingName = new String();
	public int sqFoot;
	public roof roof;

ArrayList<floor> floors = new ArrayList<floor>();	
ArrayList<ExteriorCondition> exConditions = new ArrayList<ExteriorCondition>();
	
	public building()
	{
		buildingName = "Building";
		sqFoot = 10000;
	}
	
	public building(String str)
	{
		buildingName = str;
		sqFoot = 10000;
	}

	public building(String name, int sqF)
	{
		buildingName = name;
		sqFoot = sqF;
	}

	public int squareFootage() {
		return sqFoot;
	}


	public String getName() {
		return buildingName;
	}


	public String setName(String str) {
		buildingName = str;
		return buildingName;
	}

	public String Summarize() {
		String sum = (buildingName + " is " + sqFoot + " sq ft, has " + floors.size() + " floors,  has " + exConditions.size()+ " conditions.");
		return sum;
	}

	public String listConditions() {
		return exConditions.toString();
	}

	public String subCount() {
		return (sqFoot + "sq ft" + floors.size() + "floor count" );
	}

	public String addFloor(String str) {
		floors.add(new floor(str));
		return str;
	}
	
	public void setRoof(int lifeSpan, int age, String roofType){
		roof = new roof(lifeSpan, age, roofType);
	}
	
	public String getRoof(){
		return roof.toString();
	}
	
	public String addCondition(String str){
		exConditions.add(new ExteriorCondition(str));
		return str;
	}
	
	public String toString() {
		return(buildingName +": "+subCount());
	}
	
	
}
