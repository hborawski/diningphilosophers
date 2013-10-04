/**
 * Class to run the dining philosophers
 * 
 * @author Harris Borawski
 *
 */
public class Driver {
	
	public static void main(String[] args){
		Philosopher p = new Philosopher(1,new Fork(), new Fork(),true,2,(long)500, (long)500);
		p.run();
	}
}
