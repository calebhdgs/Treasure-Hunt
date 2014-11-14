//Some nice import statements
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

//creates variables, scanners, initializes array
public class Reader {
	public static File file;
	Scanner input;
	Scanner scan;
	public String order;
	int[][]box = new int[11][11];
	//File file = new File("/Users/calebhodges/Documents/Workspace/Lab02/src/Map1");
	//My program worked fine when I hard-coded the location of the file, 
	//but it broke when I entered the same thing as an argument.
	
	
	// constructor initializes the input scanner
	// and scans the .txt file into a 2D array
	public Reader(){
		input = new Scanner(System.in);
		scanMap();
}
	
	//prints the greeting to the game
	public void printGreeting(){
		System.out.println("Welcome to the Treasure Hunter Game.");
		System.out.println("Type left, right, up, or down to move in that direction.");
		System.out.println("The number you are standing on tells you how many spaces you will move.");
		System.out.println("The object is to get to any of the four corners. Good Luck!");
	}
	
	//scans the map into a 2D array
		public int[][] scanMap(){
			try{
				scan = new Scanner(file);
				while(scan.hasNextInt()){
				for (int i=0;i<box.length;i++){
					for (int j=0;j<box[i].length;j++){
							box[i][j] = scan.nextInt();
					}
				}
				closeFile();
			}
			}catch(IOException ex){
				System.out.println("Error 404; File Not Found");
			}
			return box;
		}
		
	
	//returns orders as a string
	public String getInput(){
		order = input.toString();
		return order;
	}
	
	//close file after running
	public void closeFile(){
		scan.close();
	}
}


	