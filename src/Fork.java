/**
 * Class to represent a fork
 * 
 * @author Harris Borawski
 *
 */
public class Fork implements IFork{
	private boolean allocated;
	public Fork(){
		this.allocated = false;
	}
	/*
     * A philosopher (attempts to) acquire the fork.
     */
    public synchronized void acquire(){
    	this.allocated = true;
    }

    /*
     * A philosopher releases the fork.
     */
    public synchronized void release(){
    	this.allocated = false;
    }
    
    public boolean isAllocated(){
    	return allocated;
    }
}
