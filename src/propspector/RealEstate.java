//Eric Downie
package propspector;
		//all buildings, rooms, 
public interface RealEstate {
		int squareFootage(); //returns the square footage (area) of the selected item
		String getName();	//return name of item
		String setName(String str); //change the name
		String Summarize(); //list it's conditions and number of subitems - summarize them too
		void setcond(String cond)	;//i.e. Building 1: Damaged chimney, 2 floors - floor 1: 3 rooms - bathroom 1: damaged tile etc.
		String getcond();
		String listConditions(); //list conditions only
		String subCount(); //list subcount only i.e. Buidling 1: 4 rooms
		String toString(); //what the item will print out when set as a string
		
}
