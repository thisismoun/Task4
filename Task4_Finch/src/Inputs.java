
public class Inputs {
int userSec;
int finchLen;

	public void parameterCheck(int userSec, int finchLen) {
		if (finchLen < 30 || finchLen > 80) {
			//error in GUI
		}
		if (userSec < 2 || userSec > 10) {
			//error in GUI
		}
		if (userSec%2 != 0) {
			//error in GUI
		}
	}

}
