/**
 * Class to run the dining philosophers
 * 
 * @author Harris Borawski
 *
 */
public class Driver {
	
	public static void main(String[] args){
		int np = Integer.parseInt(args[0]);
		int nt = Integer.parseInt(args[1]);
		int tm = Integer.parseInt(args[2]);
		int em = Integer.parseInt(args[3]);
		
		Philosopher p = new Philosopher(1,new Fork(), new Fork(),true,2,(long)500, (long)500);
		p.run();
	}
}
