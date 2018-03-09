import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchMovement {
static Finch finchRobot = new Finch();

	//this method converts the length required into milliseconds for the finch setWheelVelocity to recognize
	public static double timeCalculator(int finchLen) { 
		double x;
		x = ((finchLen/13.3) * 1000);
		return (x);
	}
	//main method for movement 
	public static void forwardMovement (int finchLen, int userSec) { 
		double moveMinD = timeCalculator(finchLen);
		int moveMin = (int)moveMinD;
		int finchSec;
		//sets the initial turn to 1 so that program can recognize odd sections from even sections
		int finchTurn = 1; 
		 //loops the movement for number of userSections. 
		for(int i=0; i < userSec; i++){
			//if statements to divide each section. Odd numbers as one section, even as the others. 
			//Speed of specifically 102 for right wheel is used to make sure finch travels straight as at 100, it turns ever so slightly to the right. It is intentional. 
			if (finchTurn%2 != 0) {
				finchRobot.setLED(0,100,0);
				finchRobot.buzz(750,moveMin);
				finchRobot.setWheelVelocities(100,102,moveMin); 
				finchRobot.setLED(0,0,0);
			}
				//turn left
				finchRobot.setWheelVelocities(0,100, 1550); 
					//adds +1 to finchTurn variable
					finchTurn = finchTurn + 1;
			if (finchTurn%2 ==0) {
				finchRobot.setLED(100,0,0);
				finchRobot.buzz(1500,moveMin);
				finchRobot.setWheelVelocities(100,102,moveMin);
				finchRobot.setLED(0,0,0);
			}
					//calculates finchSec as number of turns + 1 
					finchSec = finchTurn +1;
			//checks to see if sections completed by finch = sections put forth by user. If yes, it breaks and ends the run. If not, it continues the loop. Makes sure the finch doesn't turn once again at the end of the run
			if (finchSec >= userSec) { 
				break;
			}
				//turn right
				finchRobot.setWheelVelocities(100,0, 1500); 
					//adds +1 to finchTurn variable if the loop does not break. 
					finchTurn = finchTurn + 1; 
		}
	}
	//method for the retrace process. Same logic as movement, just reversed and with new ret variables instead of finch variables. 
	public static void retraceMovement (int finchLen, int userSec) { 
		double moveMinD = timeCalculator(finchLen);
		int moveMin = (int)moveMinD;
		int retSec;
		int retTurn = 1;
				finchRobot.setWheelVelocities(-100,100, 1600); //180 turn
		for(int i=0; i < userSec; i++){
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
	//constructor that calls both of the previous methods. With movement first and then retrace.
	public static void zig_Zag(int finchLen,int userSec) {
		FinchMovement.forwardMovement(finchLen, userSec);
		FinchMovement.retraceMovement(finchLen, userSec);
		
	}
}

