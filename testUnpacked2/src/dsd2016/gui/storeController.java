package dsd2016.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class storeController {

	private static File file = new File("src/dsd2016/account.txt");
	
    private storeController(){}
    
	public static String getFilePath(){
		return file.getPath();
	}
	public static void setFilePath(String path){
		file = new File(path);
	}
	
	public static void storeRelation(String username, String password, String IDcode) {
		try{
			PrintWriter	output = new PrintWriter(new FileWriter(file,true));
			output.println(username + "," + password + "," + IDcode);
			output.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		} 
		
	}


	public static boolean userExist(String username){
		try(BufferedReader in = new BufferedReader(new FileReader(file));){
			String line = null;
			while((line = in.readLine()) != null){
				String[] args = line.split(",");
				if(args[0].equals(username))
					return true;
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public static  boolean passwordInvalid(){
		return false;
	}
	
	public static int returnID(String username, String password, StringBuilder IDcode){
		try(BufferedReader in = new BufferedReader(new FileReader(file));)
		{
			String line = null;
			while((line = in.readLine()) != null){
				String[] args = line.split(",");
				if(args[0].equals(username) && 
						!args[1].equals(password)){
					return -2;
				}
				if(args[0].equals(username) && 
						args[1].equals(password)){
					IDcode.append(args[2]);
					return 1;
				}
			}	
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		return -1;	
	}
	
	

}
class UsernameExistException extends Exception{
	
	private static final long serialVersionUID = 2L;

	public UsernameExistException(){}
}

class NullInputException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NullInputException(){}
}