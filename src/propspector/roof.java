package propspector;

public class roof {
	int lifeSpan;
	int age;
	String roofType; //typically shingle, tile, metal, or concrete
	
	public roof(){
		lifeSpan = 15;
		age = 7;
		roofType = "shingled";
	}
	
	public roof(int ls, int a, String rt){
		lifeSpan = ls;
		age = a;
		roofType = rt;
	}
	
	public int getLifeSpan(){
		return lifeSpan;
	}
	
	public int setLifeSpan(int ls){
		lifeSpan = ls;
		return lifeSpan;
	}
	
	public int getAge(){
		return age;
	}
	
	public int setAge(int a){
		age = a;
		return age;
	}
	
	public String getRoof(){
		return roofType;
	}
	
	public String setRoof(String r){
		roofType = r;
		return roofType;
	}
	
	public String toString(){
		return (roofType+" roof. Rated for "+lifeSpan+" years. "+age+" years old.");
	}
	
}
