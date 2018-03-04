
public class Testing {
	static double finchLen = 30;
	public static double timeCalculator(double finchLen) {
		double x;
		x = ((finchLen/14) * 1000);
		return (x);
	}
	
	public static void main (String[] args) {
		double moveMinD = timeCalculator(finchLen);
		int moveMin = (int)moveMinD;
		System.out.println(moveMin);
	}
}
