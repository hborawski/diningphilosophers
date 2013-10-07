/**
 * Class to run the dining philosophers
 * 
 * @author Harris Borawski
 *
 */
import java.util.ArrayList;
public class Driver {
	
	public static void main(String[] args){
		int np;
		int nt;
		int tm;
		int em;
		if(args.length ==4){
			np = Integer.parseInt(args[0]);
			nt = Integer.parseInt(args[1]);
			tm = Integer.parseInt(args[2]);
			em = Integer.parseInt(args[3]);
		} else if(args.length == 5) {
			np = Integer.parseInt(args[1]);
			nt = Integer.parseInt(args[2]);
			tm = Integer.parseInt(args[3]);
			em = Integer.parseInt(args[4]);
		}else{
			np = 4;
			nt = 10;
			tm = 0;
			em = 0;
		}
		
		ArrayList<Philosopher> Phil = new ArrayList<Philosopher>();
		Philosopher singlePhil;
		
		Fork[] forks = new Fork[np];
		for(int f = 0; f < np; f++){
			forks[f] = new Fork();
		}
		
		for(int i = 0; i < np; i++){
			if(args.length != 5 || ((i%2) == 0)){
				singlePhil = new Philosopher(i,forks[i], forks[(np+i-1)%np],true,nt,tm,em);
			} else {
				singlePhil = new Philosopher(i,forks[i], forks[(np+i-1)%np],false,nt,tm,em);
			}
			Phil.add(singlePhil);
		}
		
		for(Philosopher P : Phil){
			P.start();
		}
	}
}
