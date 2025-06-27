package day08.robot;

/** Instructions Write a robot simulator.
  * A robot factory's test facility needs a program to verify robot movements.
  * The robots have three possible movements:      turn right     turn left     advance
  * Robots are placed on a hypothetical infinite grid, facing a particular direction (north, east, south, or west) at a set of {x,y} coordinates, e.g., {3,8}, with coordinates increasing to the north and east.
  * The robot then receives a number of instructions, at which point the testing facility verifies the robot's new position, and in which direction it is pointing.
  *   The letter-string "RAALAL" means: Turn right Advance twice Turn left Advance once Turn left yet again
  *  Say a robot starts at {7, 3} facing north. Then running this stream of instructions should leave it at {9, 4} facing west.
  */
 public class Robot_Simulator {
	 
		static int posx=0;
		static int posy=0;
		static char dir='N'; // Nord Est Ovest Sud
		
		static int[][] strada = new int[1][100]; // ultime 100 posizioni 
		//static int[] straday = new int[100];
		static int stradai =0;
		
		public void Robot() {
			
		}
 
		
	public static boolean verificaStrada(int x, int y)	{
		boolean boolret=false;
		for (int ii=0;ii<100;ii++) {
			if ((x==strada[0][ii]) && (y==strada[1][ii]) ) {
				boolret= true;
			} else {
				boolret= false;
			}	
		}
		return boolret;
	}
		
	public static void mappa(int x, int y) {
		// disegnare un cerchio "O" in posizione x,y e un "." nelle altre parti.
		PuliziaSchermo.main(null);;
		system("clear");
		for (int i=1;i<20;i++) {
			for (int j=1;j<70;j++) {
				if ((i==y) && (j==x)) {
					if (verificaStrada(x,y)) {
						System.out.print("x");
					}
					
					System.out.print("O");
													
					
				}
			  System.out.print(".");
			}		
			System.out.println(".");
		}
		System.out.println("x="+x+" y="+y+ " Dir:"+dir);
	}
	
	private static void system(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void MovA() {
		
	}
	
	public static void vai1step(char dirr, char mv) {
	
		if ((dirr=='N') && (mv=='R')) { dirr='E'; }
		if ((dirr=='N') && (mv=='L')) { dirr='O'; }
		if ((dirr=='N') && (mv=='A')) { posy=posy-1;}
		if ((dirr=='S') && (mv=='R')) { dirr='O'; }
		if ((dirr=='S') && (mv=='L')) { dirr='E'; }
		if ((dirr=='S') && (mv=='A')) { posy=posy+1;}
		if ((dirr=='E') && (mv=='R')) { dirr='S'; }
		if ((dirr=='E') && (mv=='L')) { dirr='N'; }
		if ((dirr=='E') && (mv=='A')) { posx=posx+1;}
		if ((dirr=='O') && (mv=='R')) { dirr='N'; }
		if ((dirr=='O') && (mv=='L')) { dirr='S'; }
		if ((dirr=='O') && (mv=='A')) { posy=posy-1;}
		if (mv=='A') {
			
			strada[0][stradai] =posx;
			strada[1][stradai] =posy;
			
			//straday[stradai] =posy;
			stradai++;
			
		}
		
		
	 }
	
	public static void vai(char dirr, String movimenti) {
		mappa(posx,posy);
		for (int i=0; i<movimenti.length();i++) {
			vai1step(dirr, movimenti.charAt(i));
		}
		mappa(posx,posy);
	}
	
	
	public static void main(String[] args) {
		//mappa(20,5);
	}

}
