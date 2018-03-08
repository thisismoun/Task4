import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchMovement {
static Finch finchRobot = new Finch();


	public static double timeCalculator(int finchLen) { //this method converts the length required into milliseconds for the finch to recognize
		double x;
		x = ((finchLen/13.3) * 1000);
		return (x);
	}

	public static void forwardMovement (int finchLen, int userSec) { //main method for movement 
		double moveMinD = timeCalculator(finchLen);
		int moveMin = (int)moveMinD;
		int finchSec;
		int finchTurn = 1; //sets the initial turn to 1 so that program can recognize odd sections from even sections
		for(int i=0; i < userSec; i++){ //loops the movement for a maximum of 10 (max number of sections)
			if (finchTurn%2 != 0) {
				finchRobot.setLED(0,100,0);
				finchRobot.buzz(750,moveMin);
				finchRobot.setWheelVelocities(100,102,moveMin); 
				finchRobot.setLED(0,0,0);
			}
				finchRobot.setWheelVelocities(0,100, 1550); //turn left
					finchTurn = finchTurn + 1; //adds +1 to finchTurn variable
			if (finchTurn%2 ==0) {
				finchRobot.setLED(100,0,0);
				finchRobot.buzz(1500,moveMin);
				finchRobot.setWheelVelocities(100,102,moveMin);
				finchRobot.setLED(0,0,0);
			}
					finchSec = finchTurn +1;
			if (finchSec >= userSec) { //checks to see if sections completed by finch = sections put forth by user. If yes, it breaks and ends the run. If not, it continues the loop.
				break;
			}
				finchRobot.setWheelVelocities(100,0, 1500); //turn right
					finchTurn = finchTurn + 1; //adds +1 to finchTurn variable. Will only happen if after every 2 sections, the check for finchSec = userSec is false. 
		}
	}
	public static void retraceMovement (int finchLen, int userSec) { //method for the retrace process. Same as movement, just reversed and with new ret variables instead of finch variables. 
		double moveMinD = timeCalculator(finchLen);
		int moveMin = (int)moveMinD;
		int retSec;
		int retTurn = 1;
				finchRobot.setWheelVelocities(-100,100, 1600); //180 turn
		for(int i=0; i < 10; i++){
			if (retTurn%2 != 0) {
				finchRobot.setLED(100,0,0);
				finchRobot.buzz(1500,moveMin);
				finchRobot.setWheelVelocities(100,102,moveMin);
				finchRobot.setLED(0,0,0);
			}
				finchRobot.setWheelVelocities(100,0, 1550);
					retTurn = retTurn + 1;
			if (retTurn%2 ==0) {
				finchRobot.setLED(0,100,0);
				finchRobot.buzz(750,moveMin);
				finchRobot.setWheelVelocities(100,102,moveMin);
				finchRobot.setLED(0,0,0);
			}
					retSec = retTurn +1;
			if (retSec >= userSec) {
				break;
			}
				finchRobot.setWheelVelocities(0,100, 1500);
					retTurn = retTurn + 1;
		}
	}
	public static void zig_Zag(int finchLen,int userSec) {
		FinchMovement.forwardMovement(finchLen, userSec);
		FinchMovement.retraceMovement(finchLen, userSec);
		
	}
}

