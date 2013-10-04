import java.util.*;
/**
 * Class to simulate a philosopher
 * 
 * @author Harris Borawski
 *
 */
public class Philosopher extends Thread{
	private int id;
	private Fork left;
	private Fork right;
	private boolean rHanded;
	private int nTimes;
	private long thinkMillis;
	private long eatMillis;
	private Random random;
	
	public Philosopher(int id, Fork left, Fork right, boolean rHanded,int nTimes, long thinkMillis, long eatMillis){
		this.id = id;
		this.left = left;
		this.right = right;
		this.rHanded = rHanded;
		this.nTimes = nTimes;
		this.thinkMillis = thinkMillis;
		this.eatMillis = eatMillis;
		this.random = new Random();
	}
	
	public void run(){
		for(int i = 0; i < nTimes; i++){
			long think = getTime(thinkMillis);
			System.out.println("Philosopher "+id+" thinks for "+think+" time units.");
			sleepCatch(think);
			if(rHanded){
				System.out.println("Philosopher "+id+" goes for the right fork.");
				right.acquire(); // Get right fork
				System.out.println("Philosopher "+id+" has the right fork.");
				Thread.yield();  // Yield to another thread
				System.out.println("Philosopher "+id+" goes for the left fork.");
				left.acquire();  // Get left fork
				System.out.println("Philosopher "+id+" has the left fork.");
				Thread.yield();  // Yield to another thread
			}else{
				System.out.println("Philosopher "+id+" goes for the left fork.");
				left.acquire();  // Get left fork
				System.out.println("Philosopher "+id+" has the left fork.");
				Thread.yield();  // Yield to another thread
				System.out.println("Philosopher "+id+" goes for the right fork.");
				right.acquire(); // Get right fork
				System.out.println("Philosopher "+id+" has the right fork.");
				Thread.yield();  // Yield to another thread			
			}
			long eat = getTime(eatMillis);
			System.out.println("Philosopher "+id+" eats for "+eat+" time units.");
			right.release(); // Release right fork
			left.release();  // Release left fork
		}
	}
	
	/**
	 * Returns a random long in the given range
	 * @param millis the upper end of the range
	 * @return random long
	 */
	private long getTime(long millis){
		int r = random.nextInt((int)millis);
		return (long)r;
	}
	
	/**
	 * Method to encapsulate Thread.sleep to catch interrupted exceptions
	 * 
	 * @param millis how long to sleep for
	 */
	public void sleepCatch(long millis){
		try{
			Thread.sleep(millis);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
