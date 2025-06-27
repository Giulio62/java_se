package day08.robot;

public class RobotSimulatorTest {

	//static int posx=0;
	// static int posy=0;
			
	public static void main(String[] args) {
		   Robot_Simulator.posx=30;
		   Robot_Simulator.posy=10;
           Robot_Simulator.mappa(Robot_Simulator.posx, Robot_Simulator.posy);
           Robot_Simulator.vai(Robot_Simulator.dir, "RAALAL");
	}

}
