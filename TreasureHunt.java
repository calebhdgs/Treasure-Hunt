import java.io.File;

public class TreasureHunt {
public static File file;
int [][] map;
boolean quit = false;
int x;
int y;
int heldValue;
Reader read;

//constructor initializes variables and scans the map.
	public TreasureHunt(){
		x=5;
		y=5;
		heldValue=3;
		Reader read = new Reader();
		map=read.box;
	}
	
	// prints the map.
			public void printMap(){
				System.out.println("");
						for (int i=0; i<map.length;i++){
							for (int c=0; c<map[i].length; c++){
								if (x==c&&y==i)
									System.out.print("*"+map[i][c]);
								else
									System.out.print(" "+map[i][c]);
							}
							System.out.println("");
						}
			}
	
	// takes input from keyboard if, and only if, it is a key word.
	public String Directions(){
		String order=null;
		boolean done =false;
		System.out.println("Please enter a direction to move");
		while(!done){
			order = read.input.next();
			if (order.equals("left")||order.equals("right")||order.equals("up")||order.equals("down")||order.equals("quit"))
				done=true;
			else
				System.out.println("Invalid command. Please enter again");	
		}
		return order;
	}
	
	// uses key word to move position or quit
	public void makeMove(){
		String temp = Directions();
		if (temp.equals("up")){
			if (y-heldValue<0)
				System.out.println("Cannot go that way");
			else{
				y -= heldValue;
				heldValue = map[y][x];
			}
		}
		else if (temp.equals("down")){
			if (y+heldValue>10)
				System.out.println("Cannot go that way");
			else {
				y+=heldValue;
				heldValue = map[y][x];
			}
		}
		else if (temp.equals("left")){
			if (x-heldValue<0)
				System.out.println("Cannot go that way");
			else {
				x-=heldValue;
				heldValue=map[y][x];
			}
		}
		else if (temp.equals("right")){
			if (x+heldValue>10)
				System.out.println("Cannot go that way");
			else {
				x+=heldValue;
				heldValue = map[y][x];
			}
		}
		else if (temp.equals("quit")){
			quit = true;
		}
		
	}
	
	//Will print a win message and quit the game
	public void areYouFinished(){
		if (x==0 && y==0||x==0&&y==10||x==10&&y==0||x==10&&y==10){
			System.out.println("Congratulations! you found the treasure!");
			quit = true;
		}
	}
}
