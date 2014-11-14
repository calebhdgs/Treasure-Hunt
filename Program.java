import java.io.File;
public class Program {
public static File file;
	public Program(){

	}
	
	public static void main (String[] args) {
		file = new File(args[0]);
		//File file = new File("/Users/calebhodges/Documents/Workspace/Lab02/src/Map1");
		//My program worked fine when I hard-coded the location of the file, 
		//but it broke when I entered the same thing as an argument.
		//This is why I  used a static variable, though the rubric says not to.
		TreasureHunt hunt = new TreasureHunt();
		Reader read = new Reader();
		read.printGreeting();
		while (hunt.quit == false){
			hunt.printMap();
			hunt.makeMove();
			hunt.areYouFinished();	
		}
	}
}
