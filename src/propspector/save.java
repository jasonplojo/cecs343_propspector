package propspector;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class save {
	public static boolean saveProperty(property obj, String fileName){
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(System.getProperty("user.home")+"/Propspector/"+fileName+".dat"));
			out.writeObject(obj);
			out.close();
			return true;
		}
			catch(FileNotFoundException fnf){
				System.out.println("File not found!");
				return false;
			}
			catch (IOException ioe){
				System.out.println("IO exception!");
				System.out.println(ioe.getStackTrace());
				return false;
			}
		}
	
	public static boolean savePropertyAs(Object obj, String fileName, String path){
		//could probably use a filePicker API to do this better - path must end in a '\'
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(path+fileName+".dat"));
			out.writeObject(obj);
			out.close();
			return true;
		}
			catch(FileNotFoundException fnf){
				System.out.println("File not found!");
				return false;
			}
			catch (IOException ioe){
				System.out.println("IO exception!");
				System.out.println(ioe.getStackTrace());
				return false;
			}
		}
	
	public static boolean savePropertyPicker(Object obj, String path){ 
		//for use with file picker, assumes string has file name and type already in it "/home/eric/prop/ye.dat"
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(path));
			out.writeObject(obj);
			out.close();
			return true;
		}
			catch(FileNotFoundException fnf){
				System.out.println("File not found!");
				return false;
			}
			catch (IOException ioe){
				System.out.println("IO exception!");
				System.out.println(ioe.getStackTrace());
				return false;
			}
	}
}
