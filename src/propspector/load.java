package propspector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class load {
	public static Object loadProperty(String fileName){
		try{
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(System.getProperty("user.home")+"/Propspector/"+fileName+".dat"));
			try{
				property prop = (property) in.readObject();
				in.close();
				return prop;
			}
			catch(ClassNotFoundException cnfe){
				System.out.println("Class not found! The property may not have been written correctly.");
				in.close();
				return null;
			}
		}
		catch (FileNotFoundException fnf){
			System.out.println("File not found!");
			return null;
		}
		catch(IOException ioe){
			System.out.println("IO exception!");
			System.out.println(ioe.getStackTrace());
			return null;
		}
	}
	
	public static Object loadPropertyAs(String fileName, String path){
		try{
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(path+fileName+".dat"));
			try{
				property prop = (property) in.readObject();
				in.close();
				return prop;
			}
			catch(ClassNotFoundException cnfe){
				System.out.println("Class not found! The property may not have been written correctly.");
				in.close();
				return null;
			}
		}
		catch (FileNotFoundException fnf){
			System.out.println("File not found!");
			return null;
		}
		catch(IOException ioe){
			System.out.println("IO exception!");
			System.out.println(ioe.getStackTrace());
			return null;
		}
	}
	
	public static Object loadPropertyPicker(String path){
		try{
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(path));
			try{
				property prop = (property) in.readObject();
				in.close();
				return prop;
			}
			catch(ClassNotFoundException cnfe){
				System.out.println("Class not found! The property wasn't serialized correctly.");
				in.close();
				return null;
			}
		}
		catch (FileNotFoundException fnf){
			System.out.println("File not found!");
			return null;
		}
		catch(IOException ioe){
			System.out.println("IO exception!");
			System.out.println(ioe.getStackTrace());
			return null;
		}
	}
}
//If the file doesn't load correctly, will return NULL - caller must check for this